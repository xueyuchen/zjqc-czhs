package co.bohc.diet.domain.service.adminuser;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.dozer.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.terasoluna.gfw.common.exception.BusinessException;

import co.bohc.diet.domain.common.Environment;
import co.bohc.diet.domain.common.constants.MessageId;
import co.bohc.diet.domain.common.enums.AdminRoleKbn;
import co.bohc.diet.domain.common.enums.DelFlg;
import co.bohc.diet.domain.common.enums.ImgEnum;
import co.bohc.diet.domain.common.utils.PasswordEncodeUtils;
import co.bohc.diet.domain.common.utils.PropertiesUtils;
import co.bohc.diet.domain.common.utils.UploadImg;
import co.bohc.diet.domain.model.MAdminUser;
import co.bohc.diet.domain.repository.adminuser.AdminUserRepository;
import co.bohc.diet.domain.service.CrudServiceImpl;

/**
 * Created by dhc
 * 2014-12-01
 */
@Service
@Transactional(readOnly = true)
public class AdminUserServiceImpl extends CrudServiceImpl<MAdminUser,Integer,AdminUserRepository> 
								  implements AdminUserService 
	{
	@Inject
	Mapper beanMapper;
	
    @Inject
    private Environment environment;

    @Inject
    public void setRepository(AdminUserRepository repository) {
        super.setRepository(repository);
    }

	@Override
    public MAdminUser findOneByLoginId(String loginId) {
        MAdminUser adminUser = repository.findOneByLoginId(loginId);
        return adminUser;
    }

	@Override
	public Page<AdminUserOutput> findPageAdminUser(Pageable pageable) {
		
		Page<MAdminUser> page = repository.findAllByDelFlg(DelFlg.OFF.getValue(), pageable);
		List<MAdminUser> results = page.getContent();
		
		List<AdminUserOutput> adminUsers = new ArrayList<AdminUserOutput>();
		for(MAdminUser result : results){
			AdminUserOutput adminUser = beanMapper.map(result, AdminUserOutput.class);
			adminUsers.add(adminUser);
		}
		
		Integer total = repository.countAdminUser();
		return new PageImpl<>(adminUsers, pageable, total);
	}

	@Override
	@Transactional
	public MAdminUser updateAdminUser(@Valid @ModelAttribute AdminUserInput adminUserInput) {
		MAdminUser adminUser = findOneById(adminUserInput.getAdminUserId());
		MAdminUser adminInfo = beanMapper.map(adminUserInput, MAdminUser.class);
		if(adminUser == null){
            throw new BusinessException(MessageId.addError(MessageId.E_EX_MM_1014));
		}
		if(adminUserInput.getLoginId() != null){
			MAdminUser info = findOneByLoginId(adminUserInput.getLoginId());
			if(info != null && !info.getAdminUserId().equals(adminUserInput.getAdminUserId())){
	            throw new BusinessException(MessageId.addError(MessageId.E_EX_MM_0004));
			}
		}
		String adminUserPhoto =  UploadImg.saveIMGFile(adminUserInput.getHeaderFile(), 
													   environment, 
													   ImgEnum.ADMIN_FACE.getValue(),
													   adminUser.getAdminUserId());
		if(adminUserPhoto != null){
			adminInfo.setAdminUserPhoto(adminUserPhoto);
		}
		if(adminUserInput.getPassword() != null){
			adminInfo.setPassword(PasswordEncodeUtils.encodePassword(adminUserInput.getPassword(), null));
		}
		PropertiesUtils.copyProperties(adminInfo, adminUser);
		return update(adminUser);
	}
	


	@Override
	@Transactional
	public MAdminUser createAdminUser(@Valid @ModelAttribute AdminUserCreateInput adminUserInput) {
		MAdminUser result = repository.findIsRepeatLoginId(adminUserInput.getLoginId());
		if(result != null){
            throw new BusinessException(MessageId.addError(MessageId.E_EX_MM_0004));
		}
		MAdminUser adminUser = beanMapper.map(adminUserInput, MAdminUser.class);
		adminUser.setPassword(PasswordEncodeUtils.encodePassword(adminUserInput.getPassword(), null));
		adminUser = create(adminUser);
		
		MultipartFile file = adminUserInput.getHeaderFile();
		if(file != null){
			String adminUserPhoto = UploadImg.saveIMGFile(adminUserInput.getHeaderFile(), 
														  environment, 
														  ImgEnum.ADMIN_FACE.getValue(),
														  adminUser.getAdminUserId());
			adminUser.setAdminUserPhoto(adminUserPhoto);
			adminUser = update(adminUser);
		}
		return adminUser;
	}

	@Override
	@Transactional
	public MAdminUser deleteAdminUser(Integer adminUserId) {
		repository.deleteAdminUser(adminUserId);
		repository.dleteAboutAdminUser(adminUserId);
		return repository.findOne(adminUserId);
	}

	@Override
	public MAdminUser findOneById(Integer currentAdminUserId) {

		return repository.findOneById(currentAdminUserId);
	}

    @Override
    public List<AdminUserOutput> findAllByadminRoleKbn(String adminRoleKbn) {
        List<MAdminUser> adminUsers = repository.findAllByadminRoleKbn(adminRoleKbn);
        List<AdminUserOutput> adminUserOutputs = new ArrayList<AdminUserOutput>();
        AdminUserOutput adminUserOutput = null;
        for(MAdminUser user : adminUsers){
            user.setLoginId(null);
            user.setAdminUserPhoto(null);
            adminUserOutput = new AdminUserOutput();
            beanMapper.map(user, adminUserOutput);
            adminUserOutputs.add(adminUserOutput);
        }
        return adminUserOutputs;
    }
    /**
     * @author dcy created at 2014-12-31
     */
    @Override
    public List<AdminUserInfoOutput> findAllDelFlagOffExpert() {
         List<MAdminUser>adminUsers=
                 repository.findAllByadminRoleKbnAndDelFlg(AdminRoleKbn.KE.toString(), 0);
         List<AdminUserInfoOutput>adminUserInfoOutputs=new ArrayList<AdminUserInfoOutput>();
         AdminUserInfoOutput adminUserInfoOutput=null;
         
         for (MAdminUser mAdminUser : adminUsers) {
            adminUserInfoOutput=new AdminUserInfoOutput();
            adminUserInfoOutput.setAdminUserId(mAdminUser.getAdminUserId());
            adminUserInfoOutput.setAdminUserName(mAdminUser.getAdminUserName());
            adminUserInfoOutputs.add(adminUserInfoOutput);
        }
         
         return adminUserInfoOutputs;
    }
}

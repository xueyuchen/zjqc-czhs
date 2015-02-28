package co.bohc.diet.app.admin.api.adminuser;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;

import org.dozer.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.bohc.diet.domain.common.enums.AdminRoleKbn;
import co.bohc.diet.domain.service.adminuser.AdminUserCreateInput;
import co.bohc.diet.domain.service.adminuser.AdminUserInfoOutput;
import co.bohc.diet.domain.service.adminuser.AdminUserInput;
import co.bohc.diet.domain.service.adminuser.AdminUserOutput;
import co.bohc.diet.domain.service.adminuser.AdminUserService;
import co.bohc.diet.domain.service.security.BohSecurityContextHolder;

@Controller
@RequestMapping(value = "adminusers")
public class AdminUserController {

	@Inject
	private AdminUserService adminUserService;

	@Inject
	Mapper beanMapper;

	/**
	 * @page m0012
	 * @author senon
	 */
	@RequestMapping(value="current", method = RequestMethod.GET)
	@ResponseBody
    @RolesAllowed(value = { "ROLE_SU", "ROLE_KE" })
	public UserDetails get(){
		UserDetails userDetails = BohSecurityContextHolder.getCurrentUserDetails();
		if (userDetails != null ){
			return userDetails;
		} else {
			throw new AccessDeniedException("");
		}
 
	}
	
	/**
	 * @page m0032
	 * @param Pageable
	 * @author G_K
	 * @return Page<MAdminUser>
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
    @RolesAllowed(value = { "ROLE_SU", "ROLE_KE" })
	public Page<AdminUserOutput> m0032Get(@PageableDefault Pageable pageable) {
		return adminUserService.findPageAdminUser(pageable);
	}

	/**
	 * @page m0032 delete adminUser
	 * @param adminUserId
	 * @return
	 */
	@RequestMapping(value = "{adminUserId}", method = RequestMethod.DELETE)
	@ResponseBody
    @RolesAllowed(value = { "ROLE_SU", "ROLE_KE" })
	public AdminUserResource m0032Delete(@PathVariable(value = "adminUserId") Integer adminUserId) 
	{
		return beanMapper.map(adminUserService.deleteAdminUser(adminUserId), AdminUserResource.class);
	}
	
	/**
	 * @page m0033 get adminUser
	 * @param adminUserId
	 * @return
	 */
	@RequestMapping(value = "{adminUserId}", method = RequestMethod.GET)
	@ResponseBody
    @RolesAllowed(value = { "ROLE_SU", "ROLE_KE" })
	public AdminUserResource m0033Get(@PathVariable(value = "adminUserId") Integer adminUserId) {
		return beanMapper.map(adminUserService.findOne(adminUserId), AdminUserResource.class);
	}

	/**
	 * @page m0033 update
	 * @param adminUserInput
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
    @RolesAllowed(value = { "ROLE_SU", "ROLE_KE" })
	public AdminUserResource m0033PostUpdate(@ModelAttribute @Valid AdminUserInput adminUserInput,
											@RequestPart(value = "adminUserImg", required = false) MultipartFile adminUserImg) 
	{

		if(adminUserImg != null){
			adminUserInput.setHeaderFile(adminUserImg);
		}
		return beanMapper.map(adminUserService.updateAdminUser(adminUserInput), AdminUserResource.class);
	}

	/**
	 * @page m0033 create
	 * @param adminUserInput
	 * @return
	 */
	@RequestMapping(value = "create", method = RequestMethod.POST)
	@ResponseBody
    @RolesAllowed(value = { "ROLE_SU", "ROLE_KE" })
	public AdminUserResource m0033PostCreate(@ModelAttribute @Valid AdminUserCreateInput adminUserInput,
											 @RequestPart(value = "adminUserImg", required = false) MultipartFile adminUserImg) 
	{
		if(adminUserImg != null){
			adminUserInput.setHeaderFile(adminUserImg);
		}
		return beanMapper.map(adminUserService.createAdminUser(adminUserInput), AdminUserResource.class);
	}
	
	/**
     * @page M0018
     * @return
     */
    @RequestMapping(value = "getallke", method = RequestMethod.GET)
    @ResponseBody
    @RolesAllowed(value = { "ROLE_SU", "ROLE_KE" })
    public List<AdminUserOutput> m0018Get(){
        List<AdminUserOutput> adminUsers = adminUserService.findAllByadminRoleKbn(AdminRoleKbn.KE.toString());
        return adminUsers;
    }
    
    /**
     * @author dcy created at 2014-12-31
     * @return
     */
    @RequestMapping(value="ke",method=RequestMethod.GET)
    @ResponseBody
    @RolesAllowed(value = { "ROLE_SU", "ROLE_KE" })
    public List<AdminUserInfoOutput>m0010Get(){
        return adminUserService.findAllDelFlagOffExpert();
    }
}

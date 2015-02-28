package co.bohc.diet.domain.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.message.ResultMessages;

import co.bohc.diet.domain.common.Environment;
import co.bohc.diet.domain.common.constants.MessageId;
import co.bohc.diet.domain.common.enums.ImgEnum;

public class UploadImg {

    public static String saveIMGFile(MultipartFile file, Environment environment, Integer imgType, Integer... id) 
    {
        if (environment == null || file == null || imgType == null) {
            return null;
        }
        String suffix = "." +  file.getOriginalFilename().split("\\.")[1];
        String fileFormat = suffix.toUpperCase();
		if (".JPG.JPEG.TIFF.RAW.BMP.GIF.PNG".indexOf(fileFormat) < 0){
			 throw new BusinessException(MessageId.addError(MessageId.E_EX_MM_2001));
		}
        try {
        	String folder = "";
        	if(id != null && id.length > 0){
        		folder = ImgEnum.getWholeFolder(imgType, id[0]);
        	}else{
        		folder = ImgEnum.getWholeFolder(imgType);
        	}
            URI driURI = new URI(environment.getFileUploadPath() + "/" + folder);
            Path uploadDir = Files.createDirectories(Paths.get(driURI));
            File dir = uploadDir.toFile();
            String fileName = UUID.randomUUID().toString();
            fileName += suffix;
            file.transferTo(new File(dir, fileName));
            return (folder + fileName);
        } catch (Exception e) {
            ResultMessages message = ResultMessages.error().add(MessageId.E_EX_MM_1041);
            throw new BusinessException(message);
        }
    }

    /**
     * @param imageDatas
     * @param environment
     * @return
     * @author LiuYifan 
     */
    public static List<String> saveImageData(List<String> imageDatas,
            								 Environment environment,
            								 Integer imgType, boolean needDiv) 
	{
        List<String> uploadedFileNames = new ArrayList<>();
        if (imageDatas != null && imageDatas.size() > 0 && environment != null && imgType != null) {
            
            Path uploadDir = null;
            String folder = ImgEnum.getWholeFolder(imgType);
            
            try {
                URI driURI = new URI(environment.getFileUploadPath() + "/" + folder);
                uploadDir = Files.createDirectories(Paths.get(driURI));
                
                FileOutputStream out = null;
                
                for (int i = 0; i < imageDatas.size(); i++) {
                    String imageData = imageDatas.get(i);
                    if (StringUtils.isNotBlank(imageData) && imageData.contains("base64")) {
                        String fileName = UUID.randomUUID().toString();
                        if (i < imageDatas.size()) {
                            String meta = imageData;
                            String image = ""; 
                                    
                            if (needDiv) {
                                image = imageDatas.get(i + 1);
                            } else {
                                image = imageData.split(",")[1];
                            }
                            
                            String suffix = "." + meta.substring(meta.indexOf("/") + 1, meta.indexOf(";"));
                            fileName += suffix;
                            String fileFormat = suffix.toUpperCase();
                    		if (".JPG.JPEG.TIFF.RAW.BMP.GIF.PNG".indexOf(fileFormat) < 0){
                    			 throw new BusinessException(MessageId.addError(MessageId.E_EX_MM_2001));
                    		}
                            byte[] imageByte = Base64.decodeBase64(image);
                            
                            try {
                                out = new FileOutputStream(uploadDir.toString() + File.separator + fileName);
                                out.write(imageByte);
                                out.flush();
                                
                                uploadedFileNames.add(folder + fileName);
                            } catch (IOException e) {
                                throw e;
                            } finally {
                                if (out != null) {
                                    try {
                                        out.close();
                                    } catch (IOException e) {
                                    }
                                }
                            }
                        }
                    }
                }
                
            } catch (IOException | URISyntaxException e) {
                ResultMessages message = ResultMessages.error().add(
                        MessageId.E_EX_MM_1041);
                throw new BusinessException(message);
            }
        }
        
        return uploadedFileNames;
    }
}

package co.bohc.diet.domain.common.enums;

import co.bohc.diet.domain.service.security.BohSecurityContextHolder;


/**
 * @author GUOKAI Jan 4, 2015 1:10:21 PM
 * 
 */
public enum ImgEnum {
	
	
	USER_FACE(0, "user/", null, true),//user 顔写真
	USER_MEAL(1, "user/", "meal/", true),//user食事画像
	USER_PHOTO(2, "user/", "photo/", true),//user 姿写真
	
	ADMIN_FACE(3, "admin/", null, true),//ADMIN
	
	STAMP(4, "stamp/", null, false),//stamp
	BACKGROUND(5, "background", null, false);//background
	
	private int value;
	
	private String deepFolder;
	
	private String folder;
	
	private boolean needId;
    
    private ImgEnum(int value, String folder, String deepFolder, boolean needId) {
        this.value = value;
        this.folder = folder;
        this.deepFolder = deepFolder;
        this.needId = needId;
    }
    
	public boolean isNeedId() {
		return needId;
	}

	public String getFolder() {
		return folder;
	}
	
	public String getDeepFolder(){
		return deepFolder;
	}

	public Integer getValue() {
        return value;
    }

    public static ImgEnum valueOf(int value) {
        for (ImgEnum enums : ImgEnum.values()) {
            if (enums.value == value) {
                return enums;
            }
        }
        throw new IllegalArgumentException(String.valueOf(value));
    }
    
    public static String getWholeFolder(int value, Integer... id) {
        for (ImgEnum enums : ImgEnum.values()) {
            if (enums.value == value) {
            	String folder = enums.getFolder();
            	String deepFolder = enums.getDeepFolder();
            	if(enums.needId){
                	Integer currentId = null;
                	if(id != null && id.length > 0){
                		currentId = id[0];
                	}else{
                		currentId = BohSecurityContextHolder.getCurrentId();
                	}
            		folder = folder + currentId + "/" ;
            	}
            	if(deepFolder != null && !"".equals(deepFolder)){
            		folder = folder + deepFolder;
            	}
            	return folder;
            }
        }
        throw new IllegalArgumentException(String.valueOf(value));
    }
    
}

package co.bohc.diet.domain.common.enums;

public enum MovieUploadFolder {
    FOLDER("movies/media");
    
    private String value;
    
    private MovieUploadFolder(String value){
        this.value = value;
    }
    
    public String getUploadFolder(){
        return this.value;
    }
}

package co.bohc.diet.domain.common.utils;

public class OutNullUtils {
    public static String OutNull(String source){
        if(source == null){
            return "";
        }else{
            return source;
        }
    }
}

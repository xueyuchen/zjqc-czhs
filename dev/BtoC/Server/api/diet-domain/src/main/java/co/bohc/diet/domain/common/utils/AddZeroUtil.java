package co.bohc.diet.domain.common.utils;

public class AddZeroUtil {

    public static String addZero(Integer num, Integer length){
        String NumStr = String.valueOf(num);
        Integer zeroNum = length - NumStr.length();
        for(int i = 0; i < zeroNum; i++){
            NumStr = "0" + NumStr;
        }
        return NumStr;
    }
}

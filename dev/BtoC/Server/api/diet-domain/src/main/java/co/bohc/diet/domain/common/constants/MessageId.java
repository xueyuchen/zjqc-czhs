package co.bohc.diet.domain.common.constants;

import org.terasoluna.gfw.common.message.ResultMessages;

/**
 * Message codes of domain layer message.
 * @author DomainMessageCodesGenerator
 */
public class MessageId {

    private MessageId() {
        // NOP
    }
    
    /** e.ex.mm.0000 = success */
    public static final String E_EX_MM_0000 = "e.ex.mm.0000";
    
    /** e.ex.mm.0002  = This time haven't reservation information about this admin_user*/
    public static final String E_EX_MM_0002 = "e.ex.mm.0002";
    
//    /** e.ex.mm.0003  = There is not eat Information about this user.*/
//    public static final String E_EX_MM_0003 = "e.ex.mm.0003";
    
    /** e.ex.mm.0004  = loginId already exists.*/
    public static final String E_EX_MM_0004 = "e.ex.mm.0004";
    
    /** e.ex.mm.1001  = Username is not found. */
    public static final String E_EX_MM_1001 = "e.ex.mm.1001";
    
    /** e.ex.mm.1002  = The account is disabled. */
    public static final String E_EX_MM_1002 = "e.ex.mm.1002";
    
    /** e.ex.mm.1003  = Bad credentials. */
    public static final String E_EX_MM_1003 = "e.ex.mm.1003";
    
    /** e.ex.mm.1004  = Account status exception. */
    public static final String E_EX_MM_1004 = "e.ex.mm.1004";
    
    /** e.ex.mm.1005  =  Authentication exception. */
    public static final String E_EX_MM_1005 = "e.ex.mm.1005";
    
    /** e.ex.mm.1004  = Please login first. */
    public static final String E_EX_MM_1010 = "e.ex.mm.1010";
    
    /** e.ex.mm.1005  = Access denied. */
    public static final String E_EX_MM_1011 = "e.ex.mm.1011";
    
    /** e.ex.mm.1013  = param error. */
    public static final String E_EX_MM_1013 = "e.ex.mm.1013";
    
    /** e.ex.mm.1014  = not found. */
    public static final String E_EX_MM_1014 = "e.ex.mm.1014";
    
    /** e.ex.mm.1015  = no such user. */
    public static final String E_EX_MM_1015 = "e.ex.mm.1015";
    
    /** e.ex.mm.1016  =  Update failed: record number is 0. */
    public static final String E_EX_MM_1016 = "e.ex.mm.1016";
    
    /** e.ex.mm.1023  = 30個登録されています。これ以上は登録できません*/
    public static final String E_EX_MM_1023 = "e.ex.mm.1023";
    
    /** e.ex.mm.1025  = すでに使用されているメールアドレスです*/
    public static final String E_EX_MM_1025 = "e.ex.mm.1025";
    
    /** e.ex.mm.1026  = send mail error.*/
    public static final String E_EX_MM_1026 = "e.ex.mm.1026";
    
    /** e.ex.mm.1027  = the validation email has expired.*/
    public static final String E_EX_MM_1027 = "e.ex.mm.1027";
    
    /** e.ex.mm.1028  = すでに処理済みです*/
    public static final String E_EX_MM_1028 = "e.ex.mm.1028";
    
    /** e.ex.mm.1029  = 申込み内容を受け付けました。*/
    public static final String E_EX_MM_1029 = "e.ex.mm.1029";
    
    /** e.ex.mm.1030  = 申込み内容を受け付けました。*/
    public static final String E_EX_MM_1030 = "e.ex.mm.1030";

    /** e.ex.mm.1031  = the user have paid for shop*/
    public static final String E_EX_MM_1031 = "e.ex.mm.1031";
    
    /** e.ex.mm.1032  = Please be first to register the diet of theme and start date*/
    public static final String E_EX_MM_1032 = "e.ex.mm.1032";
    
    /** e.ex.mm.1033  = The \u300CKS\u300Dmeal has been uploaded 5 images!!!*/
    public static final String E_EX_MM_1033 = "e.ex.mm.1033";
    
    /** e.ex.mm.1035  = get v_cube_meeting url error.*/
    public static final String E_EX_MM_1035 = "e.ex.mm.1035";
    
    /** e.ex.mm.1036  = invalid token or expireTime*/
    public static final String E_EX_MM_1036 = "e.ex.mm.1036";
    
    /** e.ex.mm.1038  = from date must earlier than to date*/
    public static final String E_EX_MM_1038 = "e.ex.mm.1038";
    
    /** e.ex.mm.1039  = paid error .*/
    public static final String E_EX_MM_1039 = "e.ex.mm.1039";
    
    /** e.ex.mm.1040  = must pay by creditcard or payeasy!!!*/
    public static final String E_EX_MM_1040 = "e.ex.mm.1040";
    
    /** e.ex.mm.1041  = File upload error!!!*/
    public static final String E_EX_MM_1041 = "e.ex.mm.1041";
    
    /** e.ex.mm.1044  = this device type is not supported!! */
    public static final String E_EX_MM_1044 = "e.ex.mm.1044";
    
    /** e.ex.mm.1045  = can not find this img!! */
    public static final String E_EX_MM_1045 = "e.ex.mm.1045";
    
    /** e.ex.mm.1046  = this exam number has exits */
    public static final String E_EX_MM_1046 = "e.ex.mm.1046";

    /** e.ex.mm.1047  = お試し期間のため、記録できません。*/
    public static final String E_EX_MM_1047 = "e.ex.mm.1047";

    /** e.ex.mm.1048  = 投稿数の制限　間食は５つまでしか投稿できません*/
    public static final String E_EX_MM_1048 = "e.ex.mm.1048";
    
    /** e.ex.mm.1049  = 上書き保存の確認　選んだ食事はすでに投稿されていますが、上書きしてよろしいですか？*/
    public static final String E_EX_MM_1049 = "e.ex.mm.1049";

    /** e.ex.mm.1050  = 投稿上限数を超えています*/
    public static final String E_EX_MM_1050 = "e.ex.mm.1050";

    /** e.ex.mm.1052  = reserve already exist */
    public static final String E_EX_MM_1052 = "e.ex.mm.1052";
    
    /** e.ex.mm.1054  = 必須項目が入力されてません　食事の種類と「とらなかった」または画像を入力してください。*/
    public static final String E_EX_MM_1054 = "e.ex.mm.1054";
    
    /** e.ex.mm.1055  = you have finished this enquete. */
    public static final String E_EX_MM_1055 = "e.ex.mm.1055";
    
    /** e.ex.mm.1056  = no VCUBE, can't reserve */
    public static final String E_EX_MM_1056 = "e.ex.mm.1056";
    
    /** e.ex.mm.1057  =  this date can't change reserve。*/
    public static final String E_EX_MM_1057 = "e.ex.mm.1057";
    public static final String E_EX_MM_1058 = "e.ex.mm.1058";
    public static final String E_EX_MM_1059 = "e.ex.mm.1059";
    
    /** e.ex.mm.1062  = Password format is not correct.*/
    public static final String E_EX_MM_1062 = "e.ex.mm.1062";
    
    /** e.ex.mm.1063  = Password reset error*/
    public static final String E_EX_MM_1063 = "e.ex.mm.1063";

    /** e.ex.mm.1060  =  have no such plantype。*/
    public static final String E_EX_MM_1060 = "e.ex.mm.1060";

    /** e.ex.mm.1061  =  you have choose this plantype。*/
    public static final String E_EX_MM_1061 = "e.ex.mm.1061";
    
    /** e.ex.mm.1061  =  すでに予約済みです。再度予約はできません。*/
    public static final String E_EX_MM_1064 = "e.ex.mm.1064";
    
    /** e.ex.mm.1065 = level must be selected */
    public static final String E_EX_MM_1065 = "e.ex.mm.1065";
    
    /** e.ex.mm.1065 = the date must earlier than tomorrow */
    public static final String E_EX_MM_1066 = "e.ex.mm.1066";
    /** e.ex.mm.2001 = 対応していないファイル形式です。*/
    public static final String E_EX_MM_2001 = "e.ex.mm.2001";
    
    public static ResultMessages addError(String mesageCode){
    	ResultMessages message = ResultMessages.error().add(mesageCode);
		return message;
    }
}
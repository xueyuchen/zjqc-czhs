package co.bohc.diet.domain.common;

public final class Environment {

    private int payDurationInDay = 90;

    // private String iconPath;

    private String backgroundImgPath;

    private String shopID;

    private String retURL;

    private String fileUploadPath;

    private long amount;

    private long tax;

    private String receiptsDisp11;

    private String receiptsDisp12;

    private String receiptsDisp13;

    private String passWord;

    private String jobCd;

    private String useCredit;

    private String usePayEasy;

    private String mailP0014To;

    private String mailP0014Subject;

    private String pushJumpBaseURL;

    private String webSitePath;

    private Integer restPwdUrlExpireData;

    private String certificatePath;

    private String certificatePassword;

    private String sendId;

    private String mailP0003Subject;

    private String urlP0005;

    private String mailP0002To;

    private String vCubeRecvMail;

    private String vClubAddReservationUrl;

    private String vClubGetRooms;

    private String vClubLoginUrl;

    public static String imgApi;

    private String emailHappylthUsername;

    private String paymentEmailSubject;

    private String paymentEmailUrlP0008;

    private Integer expirationHour;

    private String encryptSeed;

    private String gmoLink;

    private String urlP0001;

    private String cancelURL;

    private String urlP0010;

    private String gmoCheckStatusUrl;

    private String urlP0013;

    private String p0017Title;

    private String m0005Title;

    private String m0018Title;

    private String p0002Title;

    private String p0006Title;

    private String codeFilePath;

    private String paperFilePath;

    public String getGmoCheckStatusUrl() {
        return gmoCheckStatusUrl;
    }

    public void setGmoCheckStatusUrl(String gmoCheckStatusUrl) {
        this.gmoCheckStatusUrl = gmoCheckStatusUrl;
    }

    public String getP0002Title() {
        return p0002Title;
    }

    public void setP0002Title(String p0002Title) {
        this.p0002Title = p0002Title;
    }

    public String getP0006Title() {
        return p0006Title;
    }

    public void setP0006Title(String p0006Title) {
        this.p0006Title = p0006Title;
    }

    public String getM0018Title() {
        return m0018Title;
    }

    public void setM0018Title(String m0018Title) {
        this.m0018Title = m0018Title;
    }

    public String getM0005Title() {
        return m0005Title;
    }

    public void setM0005Title(String m0005Title) {
        this.m0005Title = m0005Title;
    }

    public String getP0017Title() {
        return p0017Title;
    }

    public void setP0017Title(String p0017Title) {
        this.p0017Title = p0017Title;
    }

    public String getCancelURL() {
        return cancelURL;
    }

    public void setCancelURL(String cancelURL) {
        this.cancelURL = cancelURL;
    }

    public String getGmoLink() {
        return gmoLink;
    }

    public void setGmoLink(String gmoLink) {
        this.gmoLink = gmoLink;
    }

    public String getUrlP0001() {
        return urlP0001;
    }

    public void setUrlP0001(String urlP0001) {
        this.urlP0001 = urlP0001;
    }

    public String getUrlP0010() {
        return urlP0010;
    }

    public void setUrlP0010(String urlP0010) {
        this.urlP0010 = urlP0010;
    }

    public String getUrlP0013() {
        return urlP0013;
    }

    public void setUrlP0013(String urlP0013) {
        this.urlP0013 = urlP0013;
    }

    public String getEncryptSeed() {
        return encryptSeed;
    }

    public void setEncryptSeed(String encryptSeed) {
        this.encryptSeed = encryptSeed;
    }

    public String getEmailHappylthUsername() {
        return emailHappylthUsername;
    }

    public void setEmailHappylthUsername(String emailHappylthUsername) {
        this.emailHappylthUsername = emailHappylthUsername;
    }

    public String getPaymentEmailSubject() {
        return paymentEmailSubject;
    }

    public void setPaymentEmailSubject(String paymentEmailSubject) {
        this.paymentEmailSubject = paymentEmailSubject;
    }

    public String getPaymentEmailUrlP0008() {
        return paymentEmailUrlP0008;
    }

    public void setPaymentEmailUrlP0008(String paymentEmailUrlP0008) {
        this.paymentEmailUrlP0008 = paymentEmailUrlP0008;
    }

    public void setImgApi(String imgApi) {
        if (Environment.imgApi == null || "".equals(Environment.imgApi)) {
            Environment.imgApi = imgApi;
        }
    }

    public String getCertificatePath() {
        return certificatePath;
    }

    public void setCertificatePath(String certificatePath) {
        this.certificatePath = certificatePath;
    }

    public String getCertificatePassword() {
        return certificatePassword;
    }

    public void setCertificatePassword(String certificatePassword) {
        this.certificatePassword = certificatePassword;
    }

    public String getSendId() {
        return sendId;
    }

    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    public String getShopID() {
        return shopID;
    }

    public String getMailP0014To() {
        return mailP0014To;
    }

    public void setMailP0014To(String mailP0014To) {
        this.mailP0014To = mailP0014To;
    }

    public String getMailP0014Subject() {
        return mailP0014Subject;
    }

    public void setMailP0014Subject(String mailP0014Subject) {
        this.mailP0014Subject = mailP0014Subject;
    }

    public void setShopID(String shopID) {
        this.shopID = shopID;
    }

    public String getJobCd() {
        return jobCd;
    }

    public void setJobCd(String jobCd) {
        this.jobCd = jobCd;
    }

    public String getUseCredit() {
        return useCredit;
    }

    public void setUseCredit(String useCredit) {
        this.useCredit = useCredit;
    }

    public String getUsePayEasy() {
        return usePayEasy;
    }

    public void setUsePayEasy(String usePayEasy) {
        this.usePayEasy = usePayEasy;
    }

    public String getRetURL() {
        return retURL;
    }

    public void setRetURL(String retURL) {
        this.retURL = retURL;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getTax() {
        return tax;
    }

    public void setTax(long tax) {
        this.tax = tax;
    }

    public String getReceiptsDisp11() {
        return receiptsDisp11;
    }

    public void setReceiptsDisp11(String receiptsDisp11) {
        this.receiptsDisp11 = receiptsDisp11;
    }

    public String getReceiptsDisp12() {
        return receiptsDisp12;
    }

    public void setReceiptsDisp12(String receiptsDisp12) {
        this.receiptsDisp12 = receiptsDisp12;
    }

    public String getReceiptsDisp13() {
        return receiptsDisp13;
    }

    public void setReceiptsDisp13(String receiptsDisp13) {
        this.receiptsDisp13 = receiptsDisp13;
    }

    public String getPassWord() {
        return passWord;
    }

    private String mailUsername;

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getPayDurationInDay() {
        return payDurationInDay;
    }

    public void setPayDurationInDay(int payDurationInDay) {
        this.payDurationInDay = payDurationInDay;
    }

    // public String getIconPath() {
    // return iconPath;
    // }
    //
    // public void setIconPath(String iconPath) {
    // this.iconPath = iconPath;
    // }

    public String getBackgroundImgPath() {
        return backgroundImgPath;
    }

    public void setBackgroundImgPath(String backgroundImgPath) {
        this.backgroundImgPath = backgroundImgPath;
    }

    public String getMailUsername() {
        return mailUsername;
    }

    public void setMailUsername(String mailUsername) {
        this.mailUsername = mailUsername;
    }

    public String getWebSitePath() {
        return webSitePath;
    }

    public void setWebSitePath(String webSitePath) {
        this.webSitePath = webSitePath;
    }

    public Integer getRestPwdUrlExpireData() {
        return restPwdUrlExpireData;
    }

    public void setRestPwdUrlExpireData(Integer restPwdUrlExpireData) {
        this.restPwdUrlExpireData = restPwdUrlExpireData;
    }

    public String getFileUploadPath() {
        return fileUploadPath;
    }

    public void setFileUploadPath(String fileUploadPath) {
        this.fileUploadPath = fileUploadPath;
    }

    public String getMailP0003Subject() {
        return mailP0003Subject;
    }

    public void setMailP0003Subject(String mailP0003Subject) {
        this.mailP0003Subject = mailP0003Subject;
    }

    public String getUrlP0005() {
        return urlP0005;
    }

    public void setUrlP0005(String urlP0005) {
        this.urlP0005 = urlP0005;
    }

    public String getMailP0002To() {
        return mailP0002To;
    }

    public void setMailP0002To(String mailP0002To) {
        this.mailP0002To = mailP0002To;
    }

    public String getPushJumpBaseURL() {
        return pushJumpBaseURL;
    }

    public void setPushJumpBaseURL(String pushJumpBaseURL) {
        this.pushJumpBaseURL = pushJumpBaseURL;
    }

    public String getvCubeRecvMail() {
        return vCubeRecvMail;
    }

    public void setvCubeRecvMail(String vCubeRecvMail) {
        this.vCubeRecvMail = vCubeRecvMail;
    }

    public String getvClubAddReservationUrl() {
        return vClubAddReservationUrl;
    }

    public void setvClubAddReservationUrl(String vClubAddReservationUrl) {
        this.vClubAddReservationUrl = vClubAddReservationUrl;
    }

    public String getvClubGetRooms() {
        return vClubGetRooms;
    }

    public void setvClubGetRooms(String vClubGetRooms) {
        this.vClubGetRooms = vClubGetRooms;
    }

    public String getvClubLoginUrl() {
        return vClubLoginUrl;
    }

    public void setvClubLoginUrl(String vClubLoginUrl) {
        this.vClubLoginUrl = vClubLoginUrl;
    }

    public Integer getExpirationHour() {
        return expirationHour;
    }

    public void setExpirationHour(Integer expirationHour) {
        this.expirationHour = expirationHour;
    }

    public String getCodeFilePath() {
        return codeFilePath;
    }

    public void setCodeFilePath(String codeFilePath) {
        this.codeFilePath = codeFilePath;
    }

    public String getPaperFilePath() {
        return paperFilePath;
    }

    public void setPaperFilePath(String paperFilePath) {
        this.paperFilePath = paperFilePath;
    }

}

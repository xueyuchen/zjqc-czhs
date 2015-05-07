package co.bohc.diet.domain.service.paper;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PaperOutput implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer paperId;
    private String paperCode;
    private String carLicensePlate;
    private String reportCode;
    private Integer printNum;
    private Integer printSize;
    private Date creDt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone= "CCT")
    private Date entryDt;
    private Date checkDt;
    private String delFlg;
    private Integer countCode;

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getPaperCode() {
        return paperCode;
    }

    public void setPaperCode(String paperCode) {
        this.paperCode = paperCode;
    }

    public String getCarLicensePlate() {
        return carLicensePlate;
    }

    public void setCarLicensePlate(String carLicensePlate) {
        this.carLicensePlate = carLicensePlate;
    }

    public String getReportCode() {
        return reportCode;
    }

    public void setReportCode(String reportCode) {
        this.reportCode = reportCode;
    }

    public Integer getPrintNum() {
        return printNum;
    }

    public void setPrintNum(Integer printNum) {
        this.printNum = printNum;
    }

    public Integer getPrintSize() {
        return printSize;
    }

    public void setPrintSize(Integer printSize) {
        this.printSize = printSize;
    }

    public Date getCreDt() {
        return creDt;
    }

    public void setCreDt(Date creDt) {
        this.creDt = creDt;
    }

    public Date getEntryDt() {
        return entryDt;
    }

    public void setEntryDt(Date entryDt) {
        this.entryDt = entryDt;
    }

    public Date getCheckDt() {
        return checkDt;
    }

    public void setCheckDt(Date checkDt) {
        this.checkDt = checkDt;
    }

    public String getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg;
    }

    public Integer getCountCode() {
        return countCode;
    }

    public void setCountCode(Integer countCode) {
        this.countCode = countCode;
    }

}

package co.bohc.diet.domain.service.code;

import java.io.Serializable;
import java.util.Date;

import co.bohc.diet.domain.service.paper.PaperOutput;
import co.bohc.diet.domain.service.worker.WorkerOutput;

public class CodeOutput implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer codeId;
    private PaperOutput paper;
    private WorkerOutput worker;
    private String codeNum;
    private String local;
    private Date creDt;
    private String codeKbn;
    private Date checkDt;
    private Integer checkNum;
    private String delFlg;

    public Integer getCodeId() {
        return codeId;
    }

    public void setCodeId(Integer codeId) {
        this.codeId = codeId;
    }

    public PaperOutput getPaper() {
        return paper;
    }

    public void setPaper(PaperOutput paper) {
        this.paper = paper;
    }

    public WorkerOutput getWorker() {
        return worker;
    }

    public void setWorker(WorkerOutput worker) {
        this.worker = worker;
    }

    public String getCodeNum() {
        return codeNum;
    }

    public void setCodeNum(String codeNum) {
        this.codeNum = codeNum;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Date getCreDt() {
        return creDt;
    }

    public void setCreDt(Date creDt) {
        this.creDt = creDt;
    }

    public String getCodeKbn() {
        return codeKbn;
    }

    public void setCodeKbn(String codeKbn) {
        this.codeKbn = codeKbn;
    }

    public Date getCheckDt() {
        return checkDt;
    }

    public void setCheckDt(Date checkDt) {
        this.checkDt = checkDt;
    }

    public Integer getCheckNum() {
        return checkNum;
    }

    public void setCheckNum(Integer checkNum) {
        this.checkNum = checkNum;
    }

    public String getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg;
    }

}

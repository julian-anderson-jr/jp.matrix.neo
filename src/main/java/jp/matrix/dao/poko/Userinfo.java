package jp.matrix.dao.poko;

import java.util.Date;

public class Userinfo {
    private String SID;

    private String PWD;

    private Integer GPID;

    private Short LVL;

    private Short LOCKING;

    private Date UPDT;

    private Date CRDT;

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID == null ? null : SID.trim();
    }

    public String getPWD() {
        return PWD;
    }

    public void setPWD(String PWD) {
        this.PWD = PWD == null ? null : PWD.trim();
    }

    public Integer getGPID() {
        return GPID;
    }

    public void setGPID(Integer GPID) {
        this.GPID = GPID;
    }

    public Short getLVL() {
        return LVL;
    }

    public void setLVL(Short LVL) {
        this.LVL = LVL;
    }

    public Short getLOCKING() {
        return LOCKING;
    }

    public void setLOCKING(Short LOCKING) {
        this.LOCKING = LOCKING;
    }

    public Date getUPDT() {
        return UPDT;
    }

    public void setUPDT(Date UPDT) {
        this.UPDT = UPDT;
    }

    public Date getCRDT() {
        return CRDT;
    }

    public void setCRDT(Date CRDT) {
        this.CRDT = CRDT;
    }
}
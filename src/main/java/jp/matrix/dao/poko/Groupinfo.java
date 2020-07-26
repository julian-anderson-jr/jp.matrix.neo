package jp.matrix.dao.poko;

public class Groupinfo {
    private Integer GPID;

    private String GPNAME;

    public Integer getGPID() {
        return GPID;
    }

    public void setGPID(Integer GPID) {
        this.GPID = GPID;
    }

    public String getGPNAME() {
        return GPNAME;
    }

    public void setGPNAME(String GPNAME) {
        this.GPNAME = GPNAME == null ? null : GPNAME.trim();
    }
}
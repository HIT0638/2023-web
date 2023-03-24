package cn.edu.hit.entity;

public class Admin {
    private String uid;
    private String pwd;

    public Admin(String uid, String pwd) {
        this.uid = uid;
        this.pwd = pwd;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}

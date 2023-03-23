package cn.edu.hit.entity;

public class Student {
    private String sid;
    private String sname;
    private String gender;
    private Integer age;
    private String birthday;
    private String mid;
    private String mname;

    public Student(String sid, String sname, String gender, Integer age, String birthday, String mid, String mname) {
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.age = age;
        this.birthday = birthday;
        this.mid = mid;
        this.mname = mname;
    }

    public Student(String sid, String sname, String gender, Integer age, String birthday, String mid) {
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.age = age;
        this.birthday = birthday;
        this.mid = mid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }
}

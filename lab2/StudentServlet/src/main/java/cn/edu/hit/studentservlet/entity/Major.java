package cn.edu.hit.studentservlet.entity;

public class Major {
    private char[] mid;
    private char[] mname;

    public Major(){

    }
    public Major(char[] mid,char[] mname){
        this.mid = mid;
        this.mname = mname;
    }

    public void setMid(char[] mid){
        this.mid = mid;
    }
    public void setMname(char[] mname){
        this.mname = mname;
    }

    public char[] getMid(){
        return mid;
    }
    public char[] getMname(){
        return mname;
    }

}

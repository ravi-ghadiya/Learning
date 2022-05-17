package com.springcore.depInjection;

public class Faculty {
    private int fid;
    private String fname;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Faculty() {
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "fid=" + fid +
                ", fname='" + fname + '\'' +
                '}';
    }
}

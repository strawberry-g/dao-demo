package com.cheer.model;

import java.util.StringJoiner;

public class Emp {
    private Integer empNo;
    private String ename;
    private String job;
    private Integer mgr;
    private String hireDate;
    private Double sal;
    private Double com;
    private Integer deptNo;

    public Emp() {
    }

    public Emp(Integer empNo, String ename, String job, Integer mgr, String hireDate, Double sal, Double com, Integer deptNo) {
        this.empNo = empNo;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hireDate = hireDate;
        this.sal = sal;
        this.com = com;
        this.deptNo = deptNo;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Double getCom() {
        return com;
    }

    public void setCom(Double com) {
        this.com = com;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Emp.class.getSimpleName() + "[", "]")
                .add("empNo=" + empNo)
                .add("ename='" + ename + "'")
                .add("job='" + job + "'")
                .add("mgr=" + mgr)
                .add("hireDate='" + hireDate + "'")
                .add("sal=" + sal)
                .add("com=" + com)
                .add("deptNo=" + deptNo)
                .toString();
    }
}

package com.cheer.dao.impl;

import com.cheer.dao.EmpDao;
import com.cheer.model.Emp;
import org.junit.Test;

public class EmpDaoImplTest {
    @Test
    public void getEmp() {
        EmpDao empDao = new EmpDaoImpl();
        Emp emp = empDao.getEmp(7788);
        System.out.println(emp);
    }

    @Test
    public void getList() {
        EmpDao empDao = new EmpDaoImpl();
        empDao.getEmp();
    }

    @Test
    public void insert() {
        Emp emp = new Emp();
        emp.setEmpNo(9999);
        emp.setEname("james");
        emp.setJob("Clerk");
        emp.setMgr(7799);
        emp.setHireDate("2019-05-15");
        emp.setSal(3000.0);
        emp.setCom(400.0);
        emp.setDeptNo(20);
        EmpDao empDao = new EmpDaoImpl();
        empDao.insert(emp);
        System.out.println(emp);
    }

    @Test
    public void delete() {
        EmpDao empDao = new EmpDaoImpl();
        empDao.delete(9999);
        System.out.println("删除成功");
    }

    @Test
    public void update() {
        EmpDao empDao = new EmpDaoImpl();
        /*Emp emp = new Emp();
        emp.setEmpNo(7799);
        emp.setEname("ZYL");
        emp.setJob(null);
        emp.setMgr(0);
        emp.setHireDate(null);
        emp.setSal(5000.0);
        emp.setCom(0.0);
        emp.setDeptNo(40);
        empDao.update(emp);*/

        Emp emp = empDao.getEmp(7799);
        emp.setCom(900.0);
        empDao.update(emp);
    }
}

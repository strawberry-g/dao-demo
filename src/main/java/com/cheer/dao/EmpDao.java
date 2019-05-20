package com.cheer.dao;

import com.cheer.model.Emp;

import java.util.List;

public interface EmpDao {
    Emp getEmp(Integer empNo);

    List<Emp> getEmp();

    void insert(Emp emp);

    void delete(Integer empNo);

    void update(Emp emp);
}

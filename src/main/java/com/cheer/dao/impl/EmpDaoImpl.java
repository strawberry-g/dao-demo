package com.cheer.dao.impl;

import com.cheer.dao.EmpDao;
import com.cheer.model.Emp;
import com.cheer.util.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    @Override
    public Emp getEmp(Integer empNo) {
        Emp emp = null;
        Connection connection = DbUtils.getInstance().getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from emp where empNo = ?";

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,empNo);
            resultSet = statement.executeQuery();

            if(resultSet.next())
            {
                String ename = resultSet.getString("ename");
                String job = resultSet.getString("job");
                Integer mgr = resultSet.getInt("mgr");
                String hireDate = resultSet.getString("hireDate");
                Double sal = resultSet.getDouble("sal");
                Double com = resultSet.getDouble("com");
                Integer deptNo = resultSet.getInt("deptNo");

                emp = new Emp(empNo,ename,job,mgr,hireDate,sal,com,deptNo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.getInstance().close(connection,statement,resultSet);
        }

        return emp;
    }

    @Override
    public List<Emp> getEmp() {
        Emp emp = null;
        List<Emp> list = new ArrayList<Emp>();
        Connection connection = DbUtils.getInstance().getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from emp";
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                Integer empNo = resultSet.getInt("empNo");
                String ename = resultSet.getString("ename");
                String job = resultSet.getString("job");
                Integer mgr = resultSet.getInt("mgr");
                String hireDate = resultSet.getString("hireDate");
                Double sal = resultSet.getDouble("sal");
                Double com = resultSet.getDouble("com");
                Integer deptNo = resultSet.getInt("deptNo");
                emp = new Emp();
                emp.setEmpNo(empNo);
                emp.setEname(ename);
                emp.setJob(job);
                emp.setMgr(mgr);
                emp.setHireDate(hireDate);
                emp.setSal(sal);
                emp.setCom(com);
                emp.setDeptNo(deptNo);

                list.add(emp);

                for(Emp e:list){
                    System.out.println(e);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.getInstance().close(connection,statement,resultSet);
        }
        return list;
    }

    @Override
    public void insert(Emp emp) {
        Connection connection = DbUtils.getInstance().getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "insert into emp values(?,?,?,?,?,?,?,?)";

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, emp.getEmpNo());
            statement.setString(2, emp.getEname());
            statement.setString(3, emp.getJob());
            statement.setInt(4, emp.getMgr());
            statement.setString(5, emp.getHireDate());
            statement.setDouble(6, emp.getSal());
            statement.setDouble(7, emp.getCom());
            statement.setInt(8, emp.getDeptNo());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.getInstance().close(connection,statement,resultSet);
        }

    }

    @Override
    public void delete(Integer empNo) {
        Connection connection = DbUtils.getInstance().getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "delete from emp where empNo = ?";

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,empNo);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.getInstance().close(connection,statement,resultSet);
        }

    }

    @Override
    public void update(Emp emp) {
        Connection connection = DbUtils.getInstance().getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "update emp set empNo=?,ename =?,job=?,mgr=?,hireDate=?,sal=?,com=?,deptNo=? where empNo=?";

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, emp.getEmpNo());
            statement.setString(2, emp.getEname());
            statement.setString(3, emp.getJob());
            statement.setInt(4, emp.getMgr());
            statement.setString(5, emp.getHireDate());
            statement.setDouble(6, emp.getSal());
            statement.setDouble(7, emp.getCom());
            statement.setInt(8, emp.getDeptNo());
            statement.setInt(9,emp.getEmpNo());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.getInstance().close(connection,statement,resultSet);
        }
    }
}

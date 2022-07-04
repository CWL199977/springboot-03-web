package com.kuang.dao;

import com.kuang.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

//部门dao
@Repository
public class DepartmentDao {
 //模拟数据库中的数据
    private static Map<Integer, Department> departments = null;
    static {
        //创建一个部门表
        departments = new HashMap<Integer,Department>();
        //添加部门表中的数据
        departments.put(1,new Department(101,"教学部"));
        departments.put(2,new Department(102,"市场部"));
        departments.put(3,new Department(103,"财务部"));
        departments.put(4,new Department(104,"行政部"));
        departments.put(5,new Department(105,"开发部"));
    }

    //获得所有部门信息
    public Map<Integer, Department> getDepartments() {
        return departments;
    }
    //根据id获得部门信息
    public Department getDepartment(Integer id) {
        return departments.get(id);
    }
}

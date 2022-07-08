package com.kuang.dao;

import com.kuang.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//部门dao
@Repository
public class DepartmentDao {

    //模拟数据库数据

    private static Map<Integer, Department> departments = null;

    static {
        //创建一个部门表
        departments = new HashMap<Integer, Department>();

        departments.put(101,new Department(101,"教学部"));
        departments.put(102,new Department(102,"市场部"));
        departments.put(103,new Department(103,"教研部"));
        departments.put(104,new Department(104,"运营部"));
        departments.put(105,new Department(105,"后勤部"));
    }

    /**
     * 获取所有部门
     * @return
     */
    public Collection<Department> getAllDepartment(){
        return departments.values();
    }

    /**
     * 根据id得到部门
     * @param id
     * @return
     */
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }
}

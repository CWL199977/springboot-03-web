package com.kuang.dao;

import com.kuang.pojo.Department;
import com.kuang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//员工dao
@Repository
public class EmployeeDao {
 //模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;
    //员工有所属的部门
    @Autowired
    private DepartmentDao departmentDao;
    static {
        //创建一个部门表
        employees = new HashMap<Integer,Employee>();
        //添加部门表中的数据
        employees.put(1001,new Employee(1001,"AA", "A2249598469@qq.com", 0, new Department(101, "教学部")));
        employees.put(1002,new Employee(1002,"BB", "B2249598469@qq.com", 1, new Department(102,  "市场部")));
        employees.put(1003,new Employee(1003,"CC", "C2249598469@qq.com", 0, new Department(103, "财务部")));
        employees.put(1004,new Employee(1004,"DD", "D2249598469@qq.com", 1, new Department(104, "行政部")));
        employees.put(1005,new Employee(1005,"EE", "E2249598469@qq.com", 0, new Department(105, "开发部")));

    }
    //主键自增长
    private static Integer initId = 1006;
    //增加一个员工
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }
    //查询所有员工信息
    public Collection<Employee> getAll() {
        return employees.values();
    }
    //根据id查询员工信息
    public Employee get(Integer id) {
        return employees.get(id);
    }
    //根据id删除员工信息
    public void delete(Integer id) {
        employees.remove(id);
    }

}

package com.kuang.controller;

import com.kuang.dao.DepartmentDao;
import com.kuang.dao.EmployeeDao;
import com.kuang.pojo.Department;
import com.kuang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
 @Autowired
    EmployeeDao employeeDao;
 @Autowired
    DepartmentDao departmentDao;

 @RequestMapping("/emps")
 public String list(Model model){
     Collection<Employee> employees = employeeDao.getAll();
     model.addAttribute("emps",employeeDao.getAll());
     return "/emp/list";
 }
    @GetMapping("/emp")
    public String toAddPage(Model model){
     //查出所有部门的信息
     Collection<Department> departments = departmentDao.getAllDepartment();
     model.addAttribute("departments",departments);
     return "/emp/add";
 }

    @PostMapping("/emp")
    public String add(Employee employee){
        // 添加员工
        employeeDao.save(employee);
        // 跳转到员工列表页
        return "redirect:/emps";
    }
    @GetMapping("update/{id}")

    public String toUpdate( @PathVariable("id") Integer id, Model model){
        // 员工信息
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp", employee);
        // 部门信息
        Collection<Department> departments = departmentDao.getAllDepartment();
        model.addAttribute("departments",departments);

        return "emp/update";
    }

    @PostMapping("updateEmp")
    public String update(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @GetMapping("/del/{id}")
    public String del(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }


}

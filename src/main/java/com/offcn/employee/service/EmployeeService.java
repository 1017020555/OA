package com.offcn.employee.service;

import com.offcn.employee.bean.Employee;
import com.offcn.employee.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public Employee login(Employee employee) {
        return employeeMapper.login(employee);
    }

    public List<Employee> li() {
        return employeeMapper.li();
    }
}

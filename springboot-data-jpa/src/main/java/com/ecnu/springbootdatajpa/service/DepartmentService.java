package com.ecnu.springbootdatajpa.service;

import com.ecnu.springbootdatajpa.entity.Department;

import java.util.List;

/**
 * @program: fresh-java-framework
 * @Date: 2019/4/24 0:49
 * @Author: Ling Chen
 * @Description:
 */
public interface DepartmentService {

    Department addDepartment(Department department);

    List<Department> findAllDepartment();
}

package com.chintan.oops;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EqualsTest {

    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.empId = 1;
        e1.empName = "Emp1";
        e1.company = "C1";
        e1.salary = 100000;

        Employee e2 = new Employee();
        e2.empId = 2;
        e2.empName = "Emp2";
        e2.company = "C2";
        e2.salary = 120000;

        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());

        System.out.println(e1.equals(e2));

    }
}

class Employee {
    int empId;
    String empName;
    String company;
    int salary;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return empId == employee.empId && salary == employee.salary && Objects.equals(empName, employee.empName)
            && Objects.equals(company, employee.company);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
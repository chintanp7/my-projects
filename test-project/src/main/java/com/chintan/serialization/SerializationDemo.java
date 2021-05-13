package com.chintan.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee empObj = new Employee("Shanti", "Prasad", "Sharma", 25, "IT");
        System.out.println("Object before serialization: " + empObj.toString());
        System.out.println("Hashcode: " + empObj.hashCode());
        System.out.println("----------------------------------------------");
        serialize(empObj);
        Employee emp2 = deserialize();
        System.out.println("Object after serialization: " + emp2.toString());
        System.out.println("Hashcode: " + emp2.hashCode());
    }

    private static void serialize(Employee employee) throws IOException {
        try (FileOutputStream fos = new FileOutputStream("employee-data.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(employee);
        }
    }

    private static Employee deserialize() throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream("employee-data.obj");
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (Employee) ois.readObject();
        }
    }
}

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String firstName; // Serialization process do not invoke the constructor but it can assign values to final fields
    private transient String middleName; // transient variables will not be serialized, serialised object holds null
    private String lastName;
    private int age;
    private static String department; // static variables will not be serialized, serialised object holds null

    public Employee(String firstName, String middleName, String lastName, int age, String department) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        Employee.department = department;

        validateAge();
    }

    private void validateAge() {
        System.out.println("Validating age.");

        if (age < 18 || age > 70) {
            throw new IllegalArgumentException("Not a valid age to create an employee");
        }
    }

    @Override
    public String toString() {
        return String.format("Employee {firstName='%s', middleName='%s', lastName='%s', age='%s', department='%s'}", firstName, middleName, lastName, age, department);
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        throw new NotSerializableException("Serialization is not supported on this object!");
    }

}
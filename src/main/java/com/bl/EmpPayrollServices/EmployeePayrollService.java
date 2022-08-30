package com.bl.EmpPayrollServices;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePayrollService{
    private static ArrayList<EmployeePayrollData> employeePayrollList;
    //created a constructor
    public EmployeePayrollService() {

    }

    public static void main(String[] args) {
        // taken the Arraylist
       employeePayrollList = new ArrayList<>();
        //created an object
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        Scanner consoleInputReader = new Scanner(System.in);
        //calling the methods
        employeePayrollService.readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData();


    }
/* created the method to read the employee payroll data*/
    public void readEmployeePayrollData(Scanner consoleInputReader){
        System.out.println("Enter Employee ID: ");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter Employee Name: ");
        String name = consoleInputReader.next();
        System.out.println("Enter Employee Salary: ");
        double salary = consoleInputReader.nextDouble();
        employeePayrollList.add(new EmployeePayrollData(id, name, salary));
    }

    /* created the method to write the employee payroll data*/
    public void writeEmployeePayrollData(){
        System.out.println("\nWriting Employee Payroll Roaster to Console\n" + employeePayrollList);
    }
}

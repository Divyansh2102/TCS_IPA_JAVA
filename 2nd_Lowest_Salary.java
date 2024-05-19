/*
Create a class Employee with below attributes:

employeeId - int
employeeName - String
age - int
gender - char
salary - double

where employeeId is the unique identifier of the employee, employeeName is the name of the employee, age is the age of 
the employee, gender is the gender of the employee and salary is the salary of the employee.

The above attributes should be private, write getters, setters and parameterized constructor as required.

Create class Solution with main method.
Implement two static methods - getEmployeeWithSecondLowestSalary and countEmployeesBasedOnAge in Solution class.

getEmployeeWithSecondLowestSalary method:
This method will take an array of Employee objects as a parameter.
The method will return the Employee object with the second lowest salary in the array of Employee objects.
If there are less than two employees in the array, then the method should return null.

countEmployeesBasedOnAge method:
This method will take two input parameters - array of Employee objects and an integer parameter (for age).
The method will return the count of employees from the array of Employee objects whose age matches with the input 
parameter.
If no employee with the given age is present in the array of Employee objects, then the method should return 0.

Note :

Two employee objects can have the same salary.
All the searches should be case insensitive.

The above mentioned static methods should be called from the main method.

For getEmployeeWithSecondLowestSalary method - The main method should print the employeeId followed by # and employeeName
from the returned Employee object, if the returned value is not null.

If the returned value is null then it should print "Null".

For countEmployeesBasedOnAge method - The main method should print the count of employees as it is, if the returned value
is greater than 0, otherwise it should print "No employee found for the given age".

Before calling these static methods in main, use Scanner to read the number of objects and objects to read the values of 
Employee objects referring attributes in the above mentioned attribute sequence.

Consider below sample input and output:

Input:
-------------
4
101
John
30
M
10000.00
102
Samantha
25
F
15000.00
103
Alex
28
M
12000.00
104
Lisa
30
F
15000.00
30

Output:
----------------
103#Alex
2
*/

import java.util.*;
public class Solution
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();sc.nextLine();
        Employee[] emp = new Employee[n];
            for(int i=0; i<n; i++)
            {
                int a = sc.nextInt();sc.nextLine();
                String b = sc.nextLine();
                int c = sc.nextInt();sc.nextLine();
                char d = sc.next().charAt(0);sc.nextLine();
                double e = sc.nextDouble();sc.nextLine();

                emp[i] = new Employee(a,b,c,d,e);
            }
        int age = sc.nextInt();
        Employee[] ans1 = getEmployeeWithSecondLowestSalary(emp);
        if(ans1!=null)
        {
            for(int i=0; i<ans1.length; i++)
            {
                System.out.println(ans1[i].getId()+"#"+ans1[i].getName());
            }
        }
        else
        {
            System.out.println("Null");
        }
        int ans2 = countEmployeesBasedOnAge(emp,age);
        if(ans2!=0)
        {
            System.out.println(ans2);
        }
        else
        {
            System.out.println("No employee found for the given age");
        }
        sc.close();
    }
    public static Employee[] getEmployeeWithSecondLowestSalary(Employee[] e)
    {
        Employee[] det = new Employee[0];
        if(e.length>1)
        {
            for(int i=0; i<e.length; i++)
            {
                for(int j=i; j<e.length; j++)
                {
                    if(e[i].getSalary()>e[j].getSalary())
                    {
                        Employee k = e[i];
                        e[i] = e[j];
                        e[j] = k;
                    }
                }
            }
            Employee min = e[0];
            for(int i=0; i<e.length; i++)
            {
                if(e[i].getSalary()>e[0].getSalary())
                {
                    det = Arrays.copyOf(det, det.length+1);
                    det[det.length-1] = e[i];
                    break;
                }
            }
            for(int i=0; i<e.length; i++)
            {
                if(det[0].getSalary() == e[i].getSalary() && e[i].getId()!=det[0].getId())
                {
                    det = Arrays.copyOf(det, det.length+1);
                    det[det.length-1] = e[i];
                }
            }
            return det;
        }        
        return null;    
    }
    public static int countEmployeesBasedOnAge(Employee[] e, int a)
    {
        int count = 0;
        for(int i=0; i<e.length; i++)
        {
            if(e[i].getAge()==a)
            {
                count++;
            }
        }
        return count;
    }
}
class Employee
{
    private int id;
    private String name;
    private int age;
    private char gender;
    private double salary;

    public Employee(int id, String name, int age, char gender, double salary)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public int getId()
    {
        return this.id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public int getAge()
    {
        return this.age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public char getGender()
    {
        return this.gender;
    }
    public void setGender(char gender)
    {
        this.gender = gender;
    }
    public double getSalary()
    {
        return this.salary;
    }
    public void setSalary(double salary)
    {
        this.salary = salary;
    }
}
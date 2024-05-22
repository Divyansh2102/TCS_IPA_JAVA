/*
 Create a class called Student with the below attributes:

rollNo - int
name - String
branch - String
score - double
dayScholar - boolean

The above attributes should be private, write getters, setters and parameterized constructor as required.

Create class Solution with main method.
Implement two static methods -findCountOfDayscholarStudents  and findStudentwithSecondHighestScore in Solution 
class.

findCountOfDayscholarStudents:

This method will take an array of Student objects as an input parameter . This method will calculate and return 
the count of Students whose score is greater than 80 and who are all from dayScholar.

If no Student scored greater than 80 and from dayScholar are present in the array of Student objects, then the
method should return 0.

findStudentwithSecondHighestScore:

This method will take an array of Student objects as an input parameter. This method will return the object 
of the second highest score student from the array of Student objects who are not from the dayScholar.

If no Student is a dayScholar  in the array of Student objects, then the method should return null.

Note : All the searches should be case insensitive.

The combination of dayScholar and score for each student is always unique.

The above mentioned static methods should be called from the main method.

For findCountOfDayscholarStudents method - The main method should print the returned count as it is 
if the returned value is greater than 0, else it should print "There are no such dayscholar students".

For findStudentwithSecondHighestScore method - The main method should print the rollNo, name and score 
in the below format from the returned object if the retuned value is not null.

rollNo#name#score

If the returned value is null, then it should print ”There are no student from non day scholar”

Before calling these static methods in main, use Scanner object to read the values of four Student 
objects referring attributes in the above mentioned attribute sequence. 
Consider below sample input and output:

Input:

1001
Ashwa
IT
85
true
1002
Preeti
IT
70
false
1003
Uma
ECE
85
false
1004
Akash
EEE
90
true


Output:
2
1002#Preeti#70.0

 */
import java.util.*;
public class IPA3 {
    public static void main(String[] args) {
        Student[] student = new Student[4];
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<student.length; i++)
        {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble();sc.nextLine();
            boolean e = sc.nextBoolean(); 

            student[i] = new Student(a,b,c,d,e);
        }

        int ans1 = findCountofDayscholarStudents(student);
        if(ans1>0)
        {
            System.out.println(ans1);
        }
        else
        {
            System.out.println("No student found");
        }

        Student ans2 = findStudentWithSecondHighestScore(student);
        if(ans2== null)
        {
            System.out.println("No student found");
        }
        else{
            System.out.println(ans2.getRollNo()+"#"+ans2.getName()+"#"+ans2.getScore());
        }
    }
    public static int findCountofDayscholarStudents(Student[] student)
    {
        int count=0;
        for(int i=0; i<student.length; i++)
        {
            if (student[i].getDayScholar()==true && student[i].getScore()>80)
            {
                count++;
            }
        }
        if(count>0)
        {
            return count;
        }
        return 0;
    }
    public static Student findStudentwithSecondHighestScore(Student[] students) {
        Student highest = null;
        Student secondHighest = null;
    
        for (Student student : students) {
            if (!student.isDayScholar()) {
                if (highest == null || student.getScore() > highest.getScore()) {
                    secondHighest = highest;
                    highest = student;
                } else if (secondHighest == null || student.getScore() > secondHighest.getScore()) {
                    secondHighest = student;
                }
            }
        }
    
        return secondHighest;
    }
    
}
class Student
{
    private int rollNo;
    private String name;
    private String branch;
    private double score;
    private boolean dayScholar;

// constructor   

    public Student(int rollNo, String name, String branch, double score, boolean dayScholar)
    {
        this.rollNo = rollNo;
        this.name = name;
        this.branch = branch;
        this.score = score;
        this.dayScholar = dayScholar;
    }

// getter and setter to access by main method

    public int getRollNo()
    {
        return rollNo;
    }
    public void setRollNo(int rollNo)
    {
        this.rollNo = rollNo;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name= name;
    }
    public String getBranch()
    {
        return branch;
    }
    public void setBranch(String branch)
    {
        this.branch = branch;
    }
    public double getScore()
    {
        return score;
    }
    public void setScore(double score)
    {
        this.score = score;
    }
    public boolean getDayScholar()
    {
        return dayScholar;
    }
    public void setDayScholar(boolean dayScholar)
    {
        this.dayScholar = dayScholar;
    }

}
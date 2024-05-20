/*
create the class Course with the below Attributes.

courseId- int
courseName- String
courseAdmin- String
quiz- int
handson -int

The above methods should be private ,write getter and
setter and parametrized constructor as required.

create class courseProgram with main method.

implement two static methods-
   findAvgOfQuizByAdmin method:this method will take array
of Course objects and a String  value as input parameters.
This method will find out Average (as int) of Quiz questions
for given Course Admin (String parametre passed)
This method will return Average if found.if there is no course
that matches then the method should return 0.

sortCourseByHandsOn method:
This method will take an Array of Course Objects and int
value as input parameters.
This methods should return an Array of Course objects in an
ascending order of their  handson which are less than the
given handson(int parameter passed) value. if there is no
such course then the method should return null.

The above mentioned static methods should be called from
main methods.

for findAvgOfQuizByAdmin method: The main method
should print the average if the returned value is not 0.
if the returned value is 0 then it should print "No Course
found."


for sortCourseByHandsOn method:
                        the  main method should print the name
of the Course from the returned Course object Array if the
returned value is not null.if the returned value is null then
it should print "No Course found with mentioned attribute."

input1:
111
kubernetes
Nisha
40
10
321
cassandra
Roshini
30
15
457
Apache Spark
Nisha
30
12
987
site core
Tirth
50
20
Nisha
17

output1:
35
kubernetes
Apache Spark
cassandra

input2:
111
kubernetes
Nisha
40
10
321
cassandra
Roshini
30
15
457
Apache Spark
Nisha
30
12
987
site core
Tirth
50
20
Shubhamk
5

output 2:
No Course found
No Course found with mentioned attributes.
*/

import java.util.*;
class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		Courses[]c=new Courses[4];
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<4;i++){
		    int a,d,e;
    		String b,cs;
    		a=sc.nextInt();sc.nextLine();
    		b=sc.nextLine();
    		cs=sc.nextLine();
    		d=sc.nextInt();sc.nextLine();
    		e=sc.nextInt();sc.nextLine();
    		c[i]=new Courses(a,b,cs,d,e);
		}
		String admin=sc.nextLine();
		int val=sc.nextInt();
		
		int ans1=findAvgOfQuizByAdmin(c,admin);
		if(ans1==0) System.out.println("No one");
		else    System.out.println(ans1);
		
		Courses[] ans2=sortCourseByHandsOn(c,val);
		if(ans2==null)  System.out.println("Empty");
		else{
		    for(int i=0;i<ans2.length;i++)  System.out.println(ans2[i].getCname());
		}
		sc.close();
	}
	public static int findAvgOfQuizByAdmin(Courses[]c,String admin){
	    int val=0;
	    int cnt=0;
	    for(int i=0;i<c.length;i++){
	        if(c[i].getCadmin().equalsIgnoreCase(admin)){
	            val+=c[i].getQuiz();
	            cnt+=1;
	        }
	    }
	    if(cnt==0)  return 0;
	    return val/cnt;
	}
	
	public static Courses[] sortCourseByHandsOn(Courses[]c,int val){
	    List<Courses>temp=new ArrayList<>();
	    for(int i=0;i<c.length;i++){
	        if(c[i].getHandson()<val) temp.add(c[i]);
	    }
	    temp.sort(Comparator.comparingInt(Courses::getHandson));
	    if(temp.isEmpty())    return null;
	    return temp.toArray(new Courses[0]);
	}
}

class Courses{
    private int courseId;
    private String courseName;
    private String courseAdmin;
    private int quiz;
    private int handson;
    
    public Courses(int courseId,String courseName,String courseAdmin,int quiz,int handson){
        this.courseId=courseId;
        this.courseName=courseName;
        this.courseAdmin=courseAdmin;
        this.quiz=quiz;
        this.handson=handson;
    }
    public int getCid()
	{
		return courseId;
	}
	public void setCid(int courseId)
	{
		this.courseId = courseId;
	}
	public String getCname()
	{
		return courseName;
	}
	public void setCname(String courseName)
	{
		this.courseName = courseName;
	}
	public String getCadmin()
	{
		return courseAdmin;
	}
	public void setCadmin(String courseAdmin)
	{
		this.courseAdmin = courseAdmin;
	}
	public int getQuiz()
	{
		return quiz;
	}
	public void setQuiz(int quiz)
	{
		this.quiz = quiz;
	}
	public int getHandson()
	{
		return handson;
	}
	public void setHandson(int handson)
	{
		this.handson = handson;
	}
}
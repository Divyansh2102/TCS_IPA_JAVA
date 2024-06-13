/*
Create the class RRT(Rapid response team) with the below attributes:

ticketNo-int

raisedBy-String 

assignedTo-String

priority-int

project-String



All attributes should be private,write getters and setters and 

parameterized constructor as required.



Create class MyClass with main method.



Implement a static method-getHighestPriorityTicket in MyClass class.



getHighestPriorityTicket method:

     This method will take an array of RRT objects ,and a String value as parameters.This method will return the RRT object with highest priority
ticket from the array of the RRT objects for the given project(String parameter passed).Highest priority is the one which has lesser value.

for example:1 is considered as high priority and 5 is considered as low priority.

If no RRT with the above condition is present in the array of the RRT objects,then the method should return null.

The main method should print the ticketNo,raisedBy and assignedTo from returned object if the returned object is not null.if the returned object is null then main method should print "No such Ticket". 





input1:
----------------------
123
Velantish
Mani
3
Xperience
234
Sathish
Akshaya
1
AIG
345
John
Jack
2
AIG
456
Bhuvi
Jack
5
AIG
AIG


output1:
------------------
234
Sathish
Akshaya

**************

Input2:
--------------
123
Velantish
Mani
3
Xperience
234
Sathish
Akshaya
1
AIG
345
John
Jack
2
AIG
456
Bhuvi
Jack
5
AIG
Xplore


output2:
--------------
No such ticket.


*/
import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		RRT []rt=new RRT[4];
		for(int i=0;i<rt.length;i++){
		    int a=sc.nextInt();sc.nextLine();
		    String b=sc.nextLine();
		    String c=sc.nextLine();
		    int d=sc.nextInt();sc.nextLine();
		    String e=sc.nextLine();
		    rt[i]=new RRT(a,b,c,d,e);
		}
		String check=sc.nextLine();
		RRT ans=anss(rt,check);
		if(ans!=null)
        {
            System.out.println(ans.getTicketNo());
            System.out.println(ans.getRaisedBy());
            System.out.println(ans.getAssignedTo());
        }
        else
        {
            System.out.println("No such ticket.");
        }
        sc.close();
	}
	
	public static RRT anss(RRT []rt,String check){
	    RRT[]r=new RRT[0];
	    for(int i=0;i<rt.length;i++){
	        if(rt[i].getProject().equalsIgnoreCase(check)){
	            r=Arrays.copyOf(r,r.length+1);
	            r[r.length-1]=rt[i];
	        }
	    }
	    if(r.length==0)  return null;
	    for(int i=0;i<r.length;i++){
	        for(int j=i+1;j<r.length;j++){
	            if(r[i].getPriority()>r[j].getPriority()){
	                RRT max=r[i];
	                r[i]=r[j];
	                r[j]=max;
	            }
	        }
	    }
	    return r[0];
	}
}


class RRT
{
    private int ticketNo, priority;
    private String raisedBy, assignedTo, project;
    public RRT(int ticketNo, String raisedBy, String assignedTo, int priority, String project)
    {
        this.ticketNo = ticketNo;
        this.raisedBy = raisedBy;
        this.assignedTo = assignedTo;
        this.priority = priority;
        this.project = project;
    }
    public int getTicketNo()
    {
        return ticketNo;
    }
    public void setTicketNo(int ticketNo)
    {
        this.ticketNo = ticketNo;
    }
    public String getRaisedBy()
    {
        return raisedBy;
    }
    public void setRaisedBy(String raisedBy)
    {
        this.raisedBy = raisedBy;
    }
    public String getAssignedTo()
    {
        return assignedTo;
    }
    public void setAssignedTo(String assignedTo)
    {
        this.assignedTo = assignedTo;
    }
    public int getPriority()
    {
        return priority;
    }
    public void setPriority(int priority)
    {
        this.priority = priority;
    }
    public String getProject()
    {
        return project;
    }
    public void setProject(String project)
    {
        this.project = project;
    }
}

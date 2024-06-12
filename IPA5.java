/*
Create a class Motel with the below attributes:

motelId - int
motelName - String
dateOfBooking – String (in the format dd-mon-yyyy)
noOfRoomsBooked – int
cabFacility – String
totalBill- double

The above attributes should be private, write getters, setters and parameterized constructor as 
required.
Create class Solution with main method.
Implement one static method – totalNoOfRoomsBooked in Solution class.
totalNoOfRoomsBooked method:
This method will take two input parameter - array of Motel objects and a String parameter.
The method will return the total numbers of rooms booked from array of Motel objects if the cab facility 
attribute matches with the given String parameter(cab facility) and the number of rooms booked is 
greater than 5.
If no rooms are booked with the above criteria in the array of Motel objects, then the method should 
return 0.
Note :
No two Motel object would have the same motelId.
dateOfBooking is stored in the format dd-mon-yyyy(eg. 01-Jan-2022)
The above mentioned static method should be called from the main method.
For totalNoOfRoomsBooked method - The main method should print the total number of booked rooms 
as it is, if the returned value is greater than 0, else it
should print "No such rooms booked"
Before calling these static methods in main, use Scanner object to read the values of four Motel objects 
referring attributes in the above mentioned attribute sequence.
Next, read the value of one String parameter for capturing the cab facility

Input
___________
1001
M&M
01-Dec-2022
5
Yes
30000
1002
BestStay
10-Jan-2022
3
Yes
27000
1003
Novatel
11-Jun-2022
5
Yes
25000
1004
Chola
01-Sep-2022
7
Yes
72000
Yes
___________
OutPut
___________
7
*/

import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Motel[]m=new Motel[4];
		for(int i=0;i<4;i++){
		    int a=sc.nextInt();sc.nextLine();
		    String b=sc.nextLine();
		    String c=sc.nextLine();
		    int d=sc.nextInt();sc.nextLine();
		    String e=sc.nextLine();
		    double f=sc.nextDouble();sc.nextLine();
		    m[i]=new Motel(a,b,c,d,e,f);
		}
		String check=sc.nextLine();
		
		int ans=totalNoOfRoomsBooked(m,check);
		if(ans==0) System.out.print("No Answer");
		else System.out.println(ans);
		
	}
	
	
	public static int totalNoOfRoomsBooked(Motel[]m,String check){
	    int ans=0;
	    for(int i=0;i<m.length;i++){
	        if(m[i].getCabFacility().equalsIgnoreCase(check) && m[i].getNoOfRoomsBooked()>5)
	            ans+=m[i].getNoOfRoomsBooked();
	    }
	    return ans;
	}
}



class Motel{
    private int motelId;
    private String motelName;
    private String dateOfBooking;
    private int noOfRoomsBooked;
    private String  cabFacility;
    private double totalBill;
    
    public Motel(int motelId,String motelName,String dateOfBooking,int noOfRoomsBooked,String cabFacility,double totalBill){
        this.motelId=motelId;
        this.motelName=motelName;
        this.dateOfBooking=dateOfBooking;
        this.noOfRoomsBooked=noOfRoomsBooked;
        this.cabFacility=cabFacility;
        this.totalBill=totalBill;
    }
    
    public int getMotelId()
    {
        return motelId;
    }
    public void setMotelId(int motelId)
    {
        this.motelId = motelId;
    }
    public String getMotelName()
    {
        return motelName;
    }
    public void setMotelName(String motelName)
    {
        this.motelName = motelName;
    }
    public String getDateOfBooking()
    {
        return dateOfBooking;
    }
    public void setDateOfBooking(String dateOfBooking)
    {
        this.dateOfBooking= dateOfBooking;
    }
    public int getNoOfRoomsBooked()
    {
        return noOfRoomsBooked;
    }
    public void setNoOfRoomBooked(int noOfRoomsBooked)
    {
        this.noOfRoomsBooked = noOfRoomsBooked;
    }
    public String getCabFacility()
    {
        return cabFacility;
    }
    public void setCabFacility(String cabFacility)
    {
        this.cabFacility = cabFacility;
    }
    public double getTotalBill()
    {
        return totalBill;
    }
    public void setTotalBill(double totalBill)
    {
        this.totalBill = totalBill;
    } 
    
}

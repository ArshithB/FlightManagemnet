package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.orm.dao.FlightDao;
import com.spring.orm.entities.Flight;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello Passengers!" );
        
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        FlightDao flightdao = context.getBean("flightdao" ,FlightDao.class);
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
    	boolean go = true;
		while (true) {
			System.out.println("PRESS 1 for add new flight");
			System.out.println("PRESS 2 for displaying all data");
			System.out.println("PRESS 3 for displaying single data");
			System.out.println("PRESS 4 for update data");
			System.out.println("PRESS 5 for delete flight data");
			System.out.println("PRESS 6 to end");
			
			try {int input = Integer.parseInt(buf.readLine());
			switch(input) {
			case 1:
				System.out.println("Enter flight ID: ");
				int fId = Integer.parseInt(buf.readLine());
				System.out.println("Enter flight name: ");
				String fName = buf.readLine();
				
				Flight flight = new Flight();
				flight.setfId(fId);
				flight.setfName(fName);
				
				int r = flightdao.insert(flight);
				System.out.println("Fligh ID:"+" "+r+ " "+"DATA ADDED");
				System.out.println(" ");
			break;
			
			//For showing all data:
			case 2:
				List <Flight> allFlight = flightdao.getAllFlight();
				for(Flight st:allFlight) {
				System.out.println("Flight ID: " +st.getfId());
				System.out.println("Flight Name: "+st.getfName());
				}
				System.out.println(" ");
		
				break;
				
			//For showing single data:
			case 3:
				 System.out.println("Enter flight ID:");
		            int fId1 = Integer.parseInt(buf.readLine());
		            Flight fOne=flightdao.getFlight(fId1);
		            System.out.println("Flight ID:"+fOne.getfId());
		            System.out.println("Flighr Name:"+fOne.getfName());
				break;
				
			//For updating:
			case 4:
				System.out.println("Enter flight ID: ");
                int ids = Integer.parseInt(buf.readLine());
                System.out.println("Enter a new flight name: ");
                String fN = buf.readLine();
                flightdao.updateFlight(ids, fN);
                System.out.println("updated successfully ID: " +ids);
				break;
				
			//Delete:
			case 5:
				 System.out.println("Enter ID:");
		          int id=Integer.parseInt(buf.readLine());
		          flightdao.deleteFlight(id);;
		          System.out.println("DELECTED!");
				break;
			case 6:
				go=false;
				break;
			default:
				System.out.println("Invalid Inpit");
			}
		}catch(Exception e) {
	    	System.out.println("Invalid Input, Try with other input");
	    	}		
		}
    }
}

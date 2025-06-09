package com.nit;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nit.Contoller.HospitalContoller;
import com.nit.modelclass.Hospital;

@SpringBootApplication
public class SpringBootMiniProj02HospitalDetailsApp {

	public static void main(String[] args) {
	
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootMiniProj02HospitalDetailsApp.class, args);
		HospitalContoller hs= ctx.getBean("hospitalcontoller",HospitalContoller.class);
		Scanner sc= new Scanner(System.in);
		
		
		try(sc;)
		{
			
			System.out.println("====Hospital Management====");
			
			while(true)
			{
				System.out.println("1.Get All Deatils oF Hospitals \n"+
                         "2.Add Hospital Details \n"+
	                     "3.Update Hospital Details \n"+
                         "4.Delete Hospital Details \n"+
	                     "5.Exit");
                      System.out.println("Select Any option from Below ::");
                      System.out.println("-----------------------------------------------");
                      int option= sc.nextInt();
				switch(option)
				{
				    case 1 : List<Hospital> all = hs.getAllInformation();
					              all.forEach(System.out::println);
					              break;
					              
					              
				    case 2:  System.out.println("Enter the hospital Code :");
				                  int cod=sc.nextInt();
				                  sc.nextLine();
				                  System.out.println("Enter the hospital Specialization :");
				                  String sp=sc.nextLine();
				                  System.out.println("Enter the hospital Name :");
				                  String name=sc.next();
				                  System.out.println("Enter the hospital Location :");
				                  String loc=sc.next();
				                  
				                  Hospital h3= new Hospital();
				                  h3.setCode(cod);
				                  h3.setSpecialization(sp);
				                  h3.setName(name);
				                  h3.setLocation(loc);
				                  
				                  int k = hs.addHospitalDetails(h3);
				                  System.out.println(k);
				                  break;
				                  
				                  
				    case 3:  System.out.println("Enetr the Hospital Code :");
				                  int c= sc.nextInt();
				                  sc.nextLine();
				                  System.out.println("Enetr the new Hospital Specilization :");
				                  String spc=sc.nextLine();
				                  
				                
				                  int update = hs.updateHospitalInformation(c,spc);
				                  if(update>0)
				                  {
				                	  System.out.println("Record updated");
				                  }
				                  else
				                  {
				                	  System.out.println("invalid inputs");
				                  }
				                  
				                  
				                  break;
				                  
				    case 4:  System.out.println("Enetr the Hospital Code :");
	                              int co= sc.nextInt();
	                             
	                              int dele = hs.deleteHospitalInformation(co);
	                              if(dele>0)
				                  {
				                	  System.out.println("Record deleted");
				                  }
				                  else
				                  {
				                	  System.out.println("invalid inputs");
				                  }
	                              
	                              break;
				                  
				    case 5:
	                    System.out.println("Exiting the program.");
	                    System.exit(0);
	                    
	                    default:
	                    System.out.println("Invalid choice. Please try again.");
				}
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		ctx.close();
	}
	

}

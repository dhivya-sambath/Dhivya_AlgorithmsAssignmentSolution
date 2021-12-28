
package com.myprograms.assignment;

import java.util.*;

public class Stockers {
	
	int stockprice_rose =0;
	int stockprice_decline =0;
	
	
	void stock_hikevalues(boolean stock_hike[], int no_companies ) {
		for (int i=0;i<no_companies;i++) {
			if(stock_hike[i] == true)
				stockprice_rose += 1;
			else
				stockprice_decline +=1;
		}
	}
        
	
	public static void main(String args[]) {
		
	    Stockers obj = new Stockers();
	    MergeSort ob = new MergeSort();
 	    Scanner in= new Scanner(System.in);
 	    
 	   System.out.println("enter the no of companies");
       int no_companies = in.nextInt();
       
       double stock_price[] = new double[no_companies];
       boolean stock_hike[] = new boolean[no_companies];
       
       for (int i=0; i<no_companies ;i++) {
    	   System.out.println("Enter current stock price of the company" + (i+1));
    	   stock_price[i] = in.nextDouble();
    	   System.out.println("Whether company's stock price rose today compare to yesterday?");
    	   stock_hike[i] = in.nextBoolean();
       }
       
       double sorted_stock[] = new double[no_companies];
       sorted_stock =ob.sort(stock_price,0,no_companies-1);
       
       obj.stock_hikevalues(stock_hike, no_companies);
       
      int option =0; 
      do {
  	  System.out.println("Enter the operation that you want to perform");
  	  System.out.println("1. Display the companies stock prices in ascending order");
  	  System.out.println("2. Display the companies stock prices in descending order");
  	  System.out.println("3. Display the total no of companies for which stock prices rose today");
  	  System.out.println("4. Display the total no of companies for which stock prices declined today");
  	  System.out.println("5. Search a specific stock price");
  	  System.out.println("6. press 0 to exit");
  	  
      option = in.nextInt(); 
  	  
  	  switch(option) {
  	  case 1:
  		  System.out.println("Stock prices in ascending order are :");
  		  for (int i=0;i<no_companies;i++) {
  			  System.out.println(sorted_stock[i]); 
  		  }
  		  break;
  	  case 2:
  		  System.out.println("Stock prices in descending order are :");
  		for (int i=no_companies-1;i>=0;i--) {
  			System.out.println(sorted_stock[i]); 
		  }
		  break;
  	  case 3:
  		  System.out.println("Total no of companies whose stock price rose today :" + obj.stockprice_rose);
		  break;
  	  case 4:
  		  System.out.println("Total no of companies whose stock price declined today :" + obj.stockprice_decline);
		  break;
  	  case 5:
  		  System.out.println("Enter key");
  		  double key = in.nextDouble();
  		  int flag =0;
  		  for (int i=0 ;i<no_companies;i++) {
  			  if (stock_price[i] == key)
  			  {
  				  System.out.println("Stock of value " + key + " is present");
  				  flag=1;
  			  }
  		  }
  		  if (flag ==0) {
  			  System.out.println("Stock value not present");
  		  }
		  break;
  	  case 0:
  		  System.exit(0);
		  break;
  	  default:
  		  System.out.println("Invalid option");  	  
  	  }

      }while(option !=0);
	}
}

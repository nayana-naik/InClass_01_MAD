package edu.uncc.cci.mobileapps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import java.util.HashMap;

public class MainPart4{
    /*
      Question 4
      You are provided with the Data class that contains an items array (Data.items) which is an array of items in a store. Each element in the array represents a single item record. Each record in the array represents a single item record. Each record is a string formatted as : Name, ID, Price. Also, you are provided with an array called shoppingCart (Data.shoppingCart) which is an array of items’ quantities. Each element in the array represents a single item record. Each record is a string formatted as : ID, quantity. You are asked to perform the following tasks:
      You are provided with the Data class that contains an items array (Data.items) which is an array of items in a store. Each element in the array represents a single item record.
      Each record in the array represents a single item record. Each record is a string formatted as : Name, ID, Price. Also, you are provided with an array called
      shoppingCart (Data.shoppingCart) which is an array of items’ quantities. Each element the array represents a single item record. Each record is a string formatted as : ID,quantity. You are asked to perform the following tasks:
     1. Your implementation for this question should be included in MainPart3.java file.
     2. Create a StoreItem class that should parse all the parameters for each item. Hint: extract each value from a item's record using Java's String.split() method and set the
        delimiter to a comma, see provided code below. Each item record should to be assigned to a StoreItem object.
     3. Create the most efficient data structure that best fit the goal. Hint: The selected data structure should facilitate the retrieval of the item details based on the ID.
     4. The goal is to print out the receipt bill in the following format:
        ID  Name    Quantity    Price * Quantity
        123 Tomatoes 10         $30
        .
        .
        Total Bill: $400
    */

    public static void main(String[] args) {
    	
    	List<String> dataItemsArrayList = new ArrayList<String>(); 
    	
    	List<StoreItem> storeItemsDetailsArrayList=new ArrayList<StoreItem>();
         
        
        for (String str : Data.items) {
            
            dataItemsArrayList=MainPart1.getSplitString(str);
            
            storeItemsDetailsArrayList.add(new StoreItem(dataItemsArrayList.get(0), Integer.parseInt(dataItemsArrayList.get(1)), Double.parseDouble(dataItemsArrayList.get(2))));
            
            
        }
        
        

        
        Map<Integer, Integer> itemQuantityMap=new HashMap<Integer, Integer>();
       
        for (String str : Data.shoppingCart) {
            
            
            dataItemsArrayList=MainPart1.getSplitString(str);
            
           
            itemQuantityMap.put(Integer.parseInt(dataItemsArrayList.get(0)), (Integer.parseInt(dataItemsArrayList.get(1))));
                       
            
        }
        
     
        System.out.printf("%10s %20s %15s %20s", "ID", "Name", "Quantity", "Price*Quantity");
        System.out.println();
        Double cost, totalCost=0.0;
        for (int i = 0; i < storeItemsDetailsArrayList.size(); i++) {

            if ((itemQuantityMap.containsKey(storeItemsDetailsArrayList.get(i).getId()))) {

            	
                storeItemsDetailsArrayList.get(i).setQuantity(itemQuantityMap.get(storeItemsDetailsArrayList.get(i).getId()));
                System.out.printf("%10s",storeItemsDetailsArrayList.get(i).getId());
                System.out.printf("%20s",storeItemsDetailsArrayList.get(i).getName());
                System.out.printf("%15s",storeItemsDetailsArrayList.get(i).getQuantity());
                cost=(storeItemsDetailsArrayList.get(i).getQuantity()*storeItemsDetailsArrayList.get(i).getPrice());
                System.out.printf("%15s%5s","$",cost);
                System.out.println();
                totalCost+=cost;
                
            }
            
        }
        System.out.println("Total Bill: $"+totalCost);
        
       


        
    }
}
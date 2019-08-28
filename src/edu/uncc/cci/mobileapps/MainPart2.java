package edu.uncc.cci.mobileapps;
/*a. Assignment InClass01.
b. File Name- MainPart2.java
c. Full name of the student- Nayana Naik
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainPart2 {
    /*
    * Question 2:
    * - In this question you will use the Data.users array that includes
    * a list of users. Formatted as : firstname,lastname,age,email,gender,city,state
    * - Create a User class that should parse all the parameters for each user.
    * - The goal is to count the number of users living each state.
    * - Print out the list of State, Count order in ascending order by count.
    * */

    public static void main(String[] args) {

       
    	List<String> dataUserStringArrayList = new ArrayList<String>(); 
    	
    	List<User> dataUserArrayList=new ArrayList<User>();
         
        
        for (String str : Data.users) {
            
        	dataUserStringArrayList=MainPart1.getSplitString(str);
            
            dataUserArrayList.add(new User(dataUserStringArrayList.get(0),dataUserStringArrayList.get(6)));
            
        }
        
      //Use of Streams API to perform group-by operation and then sorting in ascending order
        Map<String,Long> userByStateMap = new HashMap<>();
        userByStateMap =  dataUserArrayList
        		.stream()          		
        		.collect(Collectors.groupingBy(User::getState, Collectors.counting()))
        		.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> {throw new IllegalStateException();}, LinkedHashMap::new));
        		
        System.out.println("NUMBER OF USERS LIVING IN EACH STATE SORTED BY ASCENDING ORDER ");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.printf("%7s %5s","STATE CODE","COUNT OF USERS");
        System.out.println();
        for (Map.Entry<String,Long> entry : userByStateMap.entrySet()) {
        	
        	System.out.printf("%7s %10s",entry.getKey(),entry.getValue());
        	System.out.println();
        	
        }  
             
        
        
        

        
        
    }
}
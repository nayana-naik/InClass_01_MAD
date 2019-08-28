package edu.uncc.cci.mobileapps;

/*a. Assignment InClass01.
b. File Name- MainPart1.java
c. Full name of the student- Nayana Naik
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainPart1 {
    /*
    * Question 1:
    * - In this question you will use the Data.users array that includes
    * a list of users. Formatted as : firstname,lastname,age,email,gender,city,state
    * - Create a User class that should parse all the parameters for each user.
    * - Insert each of the users in a list.
    * - Print out the TOP 10 oldest users.
    * */

	public static List<String> getSplitString(String userString){
		String splitParameters[]=userString.split(",");
		return Arrays.asList(splitParameters); 
	}
    public static void main(String[] args) {

    	List<String> dataUserStringArrayList = new ArrayList<String>();
    	
    	List<User> dataUserArrayList=new ArrayList<User>();  
      
    	
       for (String str : Data.users) {
            
                       
            dataUserStringArrayList=getSplitString(str);
            dataUserArrayList.add(new User(dataUserStringArrayList.get(0),dataUserStringArrayList.get(1),dataUserStringArrayList.get(2),dataUserStringArrayList.get(3),dataUserStringArrayList.get(4),dataUserStringArrayList.get(5),dataUserStringArrayList.get(6)));
            
        }

       
       
     Collections.sort( dataUserArrayList, Collections.reverseOrder());
       
     System.out.println("------------------TOP 10 oldest users------------------");

      for(User u :  dataUserArrayList.subList(0, 10))
       {
    	   System.out.printf("%7s",u.getFirstname());
    	   System.out.printf("%7s",u.getAge());
    	   System.out.println();
       }
       
       
       
        
        
        
    }
}
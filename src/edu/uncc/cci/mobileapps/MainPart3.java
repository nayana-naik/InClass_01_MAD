package edu.uncc.cci.mobileapps;
/*a. Assignment InClass01.
b. File Name- MainPart3.java
c. Full name of the student- Nayana Naik
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Comparator;
public class MainPart3 {
    /*
    * Question 3:
    * - In this question you will use the Data.users and Data.otherUsers array that includes
    * a list of users. Formatted as : firstname,lastname,age,email,gender,city,state
    * - Create a User class that should parse all the parameters for each user.
    * - The goal is to print out the users that are exist in both the Data.users and Data.otherUsers.
    * Two users are equal if all their attributes are equal.
    * - Print out the list of users which exist in both Data.users and Data.otherUsers.
    * */

    public static void main(String[] args) {
    	
    	List<String> dataUsersStringArrayList = new ArrayList<String>(); 
    	
    	List<User> dataUserList=new ArrayList<User>();
         
        
        for (String str : Data.users) {

            dataUsersStringArrayList=MainPart1.getSplitString(str);
            
            dataUserList.add(new User(dataUsersStringArrayList.get(0),dataUsersStringArrayList.get(1),dataUsersStringArrayList.get(2),dataUsersStringArrayList.get(3),dataUsersStringArrayList.get(4),dataUsersStringArrayList.get(5),dataUsersStringArrayList.get(6)));
            
        }
        
       
        
        List<User> dataOtherUsersList=new ArrayList<User>();
        for (String str : Data.otherUsers) {
            
        	dataUsersStringArrayList=MainPart1.getSplitString(str);
            
            dataOtherUsersList.add(new User(dataUsersStringArrayList.get(0),dataUsersStringArrayList.get(1),dataUsersStringArrayList.get(2),dataUsersStringArrayList.get(3),dataUsersStringArrayList.get(4),dataUsersStringArrayList.get(5),dataUsersStringArrayList.get(6)));
            
        }
        
              
        
        Set<User> allUsers = new HashSet<>();
        //Use of Streams API to move common users to List named 'duplicateUsersSortedByState', sorted by decreasing order of State name
        List<User> duplicateUsersSortedByState =Stream.concat(dataUserList.stream(), dataOtherUsersList.stream())        		
                .filter(n -> !allUsers.add(n)) //Checks if the user is in 'allUsers' set, if present, moves to list
                .sorted(Comparator.comparing(User::getState).reversed())
                .collect(Collectors.toList());
        
        System.out.println("COMMON USERS BETWEEN DATA.USERS & DATA.OTHERUSERS SORTED BY DECREASING ORDER OF STATES");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.printf("%10s %15s %10s %25s %20s %20s %20s \n","FirstName","LastName","Age", "Email","Gender","City","State");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        
        for(User u : duplicateUsersSortedByState)
        {
        	System.out.printf("%10s",u.getFirstname());
        	System.out.printf("%15s",u.getLastname());
        	System.out.printf("%10s",u.getAge());
        	System.out.printf("%35s",u.getEmail());
        	System.out.printf("%15s",u.getGender());
        	System.out.printf("%20s",u.getCity());
        	System.out.printf("%20s",u.getState());
        	System.out.println();
        	
        	
        }        
       

    }
}
package edu.uncc.cci.mobileapps;

/*a. Assignment InClass01.
b. File Name- User.java
c. Full name of the student- Nayana Naik
*/
import java.util.Objects;

public class User implements Comparable<User>{

		private String firstname;
		private String lastname;
		private String age;
		private String email;
		private String gender;
		private String city;
		private String state;
		
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public User() {
		}
		public User(String firstname, String state) {
			this.firstname=firstname;
			this.state= state;
		}
		public User(String firstname, String lastname, String age, String email, String gender, String city,
				String state) {
			this.firstname = firstname;
			this.lastname = lastname;
			this.age = age;
			this.email = email;
			this.gender = gender;
			this.city = city;
			this.state = state;
		}
		@Override
		public String toString() {
			return "User [firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", email=" + email
				+ ", gender=" + gender + ", city=" + city + ", state=" + state + "]";
			
		}
		@Override
		public int compareTo(User u) {
			
			return (Integer.parseInt(this.age) - Integer.parseInt(u.getAge()));
		}
		
		@Override
		public int hashCode() {
		    return Objects.hash(firstname,lastname,age,email,gender,city,state);
		}
		
		@Override
	    public boolean equals(Object obj) {
	        if(this==obj) return true;
	        if(!(obj instanceof User)) return false;
	        User u=(User) obj;
	        return Objects.equals(getFirstname(), u.getFirstname())
	            && Objects.equals(getLastname(), u.getLastname())
	            && Objects.equals(getAge(), u.getAge())	 
	            && Objects.equals(getEmail(), u.getEmail())
	            && Objects.equals(getGender(), u.getGender())
	            && Objects.equals(getCity(), u.getCity())
	            && Objects.equals(getState(), u.getState());
	    }
		
		

		


}

package edu.uncc.cci.mobileapps;
/*a. Assignment InClass01.
b. File Name- StoreItem.java
c. Full name of the student- Nayana Naik
*/
import java.util.Objects;

public class StoreItem {
	
	private String name;
	private int id;
	private Double price;
	private int quantity;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "StoreItem [name=" + name + ", id=" + id + ", price=" + price + ", quantity=" + quantity + "]";
	}
	public StoreItem(String name, int id, Double price) {
		this.name = name;
		this.id = id;
		this.price = price;
	}
	
	
	@Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(!(obj instanceof StoreItem)) return false;
        StoreItem st=(StoreItem) obj;
        return Objects.equals(getId(), st.getId());
           
    }
	public StoreItem() {
	}

}

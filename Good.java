// A good with data fields
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Good {
	protected String name;
	private String descr, manufacturer, group;
	private boolean isWritten;
	
	public Good(String name, String manufacturer, String descr, int price, int quan, Group group) {
		setName(name);
		setManufacturer(manufacturer);
		setDescr(descr);
		setPrice(price);
		setQuan(quan);
		setGroup(group.getName());
	}
	
	
	// Writes all its data into a file on separate lines
	// Order: 1 - group, 2 - name, 3 - manufacturer, 4 - description, 5 - quantity, 6 - price
	public void writeToFile() {
		//if(!isWritten) {
			try {
				FileWriter fw = new FileWriter(name, false);
				fw.write(getGroup() + "\n" + getName() + "\n" + getManufacturer() + "\n" + getDescr() + "\n" + getQuan() + "\n" + getPrice());
				fw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//setWritten(true);
		//}
	}
	
	
	
	// FOR USE WITH BUTTONS "+" and "-"
	public void incQuan() {
		setQuan(getQuan()+1);
	}
	
	public void decQuan() {
		setQuan(getQuan()-1);
	}
	
	
	public boolean isWritten() {
		return isWritten;
	}
	private void setWritten(boolean isWritten) {
		this.isWritten = isWritten;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuan() {
		return quan;
	}
	public void setQuan(int quan) {
		this.quan = quan;
	}
	private int price, quan;	
	}

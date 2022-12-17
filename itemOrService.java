package UtopiaTechTrade;


public class itemOrService {
	private String name;
	private String description;
	private String descriptionOfWhatUserIsLookingFor = "";
	private double price;
	
	private int userId;
	
	private boolean listed = false;
	private boolean deleted = false;
	
	private int itemOrServiceId;
	
	public itemOrService(String name, double price, int userId, String description) {
		super();
		this.name = name;
		this.price = price;
		this.userId = userId;
		this.description = description;
		this.itemOrServiceId = UtopiaTechTrade.newIORSId();
		this.listed = false;
		this.deleted = false;
		
	}
	
	public boolean isListed() {
		return listed;
	}

	public void setListed(boolean listed) {
		this.listed = listed;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public void displayIOrS() {
		

	} 
	
	public boolean getListStatus() {
		
		return listed;
		
	}
	public void setListStatus( boolean a ) {
		
		this.listed = a;
		
	}
	
	public boolean getDeletedStatus() {
		return deleted;
	}
	
	public void setDeletedStatus(boolean a) {
		
		this.deleted = a;
	}
	
	/*
	public void displayItemOrService(itemOrService a) {
		System.out.println("Item/Service Name: " + a.name + "\nPrice: " + a.price + "\nItem/Service ID: " + a.itemOrServiceId + "\nUserID: " + a.userId + "\nItem/Service Listed: " + a.listed + "\nDescription: " +
	a.description+"\n");
	} 
	*/
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public  double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getItemOrServiceId() {
		return itemOrServiceId;
	}
	public void setItemOrServiceId(int itemOrServiceId) {
		this.itemOrServiceId = itemOrServiceId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescriptionOfWhatUserIsLookingFor() {
		return descriptionOfWhatUserIsLookingFor;
	}

	public void setDescriptionOfWhatUserIsLookingFor(String descriptionOfWhatUserIsLookingFor) {
		this.descriptionOfWhatUserIsLookingFor = descriptionOfWhatUserIsLookingFor;
	}

}	





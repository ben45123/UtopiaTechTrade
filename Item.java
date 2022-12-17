package UtopiaTechTrade;

public class Item extends itemOrService{
	
	private String condition;
	private int itemOrServiceId;
	 
	public Item(String name, double price, int userId, String description, int condition)  { //Constructor method for an Item
	
		super(name, price, userId, description);
		
		this.condition = UtopiaTechTrade.conditions[condition];
		
		int newId = UtopiaTechTrade.newIORSId();
		this.itemOrServiceId = newId;
		UtopiaTechTrade.update();
	}

	public void displayIOrS() {
		
		System.out.println("Type: Item");		
		System.out.println("Name: " + super.getName());
		System.out.println("Description: " + super.getDescription());
		System.out.println("Condition: " + this.condition);
		System.out.println("User is looking for: " + super.getDescriptionOfWhatUserIsLookingFor());
		System.out.println("Price: " + super.getPrice());
		System.out.println("UserID: " + super.getUserId());
		System.out.println("ID: " + super.getItemOrServiceId());
		System.out.print("List Status: "); 
		if(super.getListStatus()) {
			System.out.println("listed");
		}
		else {
			System.out.println("unlisted");
		}
		System.out.println();
	}

	/*public Item(String string, double d, int userId, String string2, int i) {
		// TODO Auto-generated constructor stub
	}*/
	
	//public Item(String name, double price, int userId, String description, int condition) {

 
	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	
}
	
	

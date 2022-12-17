package UtopiaTechTrade;

public class Service extends itemOrService{

	private double serviceTime;
	private int itemOrServiceId;
	
	public Service(String name, double price, int userId, String description, double serviceTime) { //constructor method for a service
		super(name, price, userId, description);
		this.serviceTime = serviceTime;
		int newId = UtopiaTechTrade.newIORSId();
		this.itemOrServiceId = newId;
		UtopiaTechTrade.update();
	}
	
	public void displayIOrS() {
		
		System.out.println("Type: Service");	
		System.out.println("Name: " + super.getName());
		System.out.println("Description: " + super.getDescription());
		System.out.println("User is looking for: " + super.getDescriptionOfWhatUserIsLookingFor());
		System.out.println("Price: " + super.getPrice());
		System.out.println("Service Time: " + this.serviceTime + " hours");
		System.out.println("UserID: " + super.getUserId());
		System.out.println("ID: " + super.getItemOrServiceId());
		System.out.print("List Status: "); 
		if (super.getListStatus()) {
			System.out.println("listed"); 
		}	
			else { 
				System.out.println("unlisted");
		}
		System.out.println();
	} 

	
	public double getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(double serviceTime) {
		this.serviceTime = serviceTime;
	}
}

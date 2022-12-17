package UtopiaTechTrade;
import java.util.ArrayList;

public class UtopiaTechTrade {

	public static ArrayList<User> users = new ArrayList<User>(); //keeps track of all users in the system
	
	public static ArrayList <Integer> ids = new ArrayList<Integer>(); //keeps track of all user ids
	
	public static ArrayList<itemOrService> listOfAllIOrS = new ArrayList<itemOrService>(); //keeps track of all items or services in the system
	
	public static ArrayList <Integer> listOfAllItemOrServiceIds = new ArrayList<Integer>(); //keeps track of all item and service ids in the system used to ensure each one is unique

	public static ArrayList<Offer> offers = new ArrayList<Offer>(); //keeps track of all offers listed in the system
	
	public static String[] conditions = {"For parts or not working", "Used", "Good", "Very Good", "Brand New"};
	
	
	
	public synchronized static ArrayList<User> getUsers(){
		
		return users;

	}
	
	
	
	public void displayUsers() {
		for(int i=0; i<UtopiaTechTrade.users.size(); i++) {
			UtopiaTechTrade.users.get(i).displayUser(UtopiaTechTrade.users.get(i));
		}
	}
	
	public static boolean checkPassword(int userId, String password) {
		
		boolean result = false;
		
		outer:
		for (User user : UtopiaTechTrade.users) {
			if (user.getUserId() == userId){
				if (user.getPassword().equals("password")) {
					result = false;
					break outer;
				}
				else {
					break outer;
				}
			}
		}
				
		return false;
	}
	
	
	public static int newIORSId() {
		
		int output = 0;
		int randomId=(int)(Math.random()*1000000); 
		boolean match=true;
		
		while(match==true) { 
			if(UtopiaTechTrade.listOfAllItemOrServiceIds.size()==0) {
				output=randomId;
				break;
			}
			
			randomId=(int)(Math.random()*1000000);
			
			match=false;  
			if (UtopiaTechTrade.listOfAllItemOrServiceIds.contains(randomId)) {
					match=true;
				}
			
			if(match==false) {
				output=randomId;
				break;
				}
		}
		return output;
	}
	
	
	public static void addNewOffer(Offer offer) {
		offers.add(offer);
		
		User sender = offer.getSender();
		User target = offer.getTarget();
		
		sender.getOutgoingOffers().add(offer);
		target.getIncomingOffers().add(offer);
	}

	public static void removeOffer(Offer offer) {
		offers.remove(offer);
		
		User sender = offer.getSender();
		User target = offer.getTarget();
		
		sender.getOutgoingOffers().remove(offer);
		target.getIncomingOffers().remove(offer);
	}
	
	public static void update() {
		
		
		ids.clear();
		listOfAllIOrS.clear();
		listOfAllItemOrServiceIds.clear();
		offers.clear();
		
		Thread thread1 = new Thread(){
		    public void run(){
		    	
		    	//update the list of all user Ids
				try {
				for (User user: UtopiaTechTrade.getUsers()) {
					ids.add(user.getUserId());
					for(Offer offer : user.getOutgoingOffers()) {
						offers.add(offer);
					}
				}
		    }
				catch (Exception e) {
					
				}
				
		    }
		  };
		  
		
		  Thread thread2 = new Thread(){
			    public void run(){
			    	
					//update the list of all Items or Services and the list of item and service ids
					try {
					for (User user: UtopiaTechTrade.getUsers()) {
						for (itemOrService iors: user.getUserIOrSList()) {
							listOfAllIOrS.add(iors);
							listOfAllItemOrServiceIds.add(iors.getItemOrServiceId());
						}		
					}
					
			    }
		  
			    catch (Exception e) {
			    	
			    	}
			    }
			  };
			  
				  thread1.start();
				  thread2.start();

				
	}
}




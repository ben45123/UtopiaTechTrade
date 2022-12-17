package UtopiaTechTrade;
import java.util.ArrayList;

public class Offer {
	
	
	private int offerId;
	private ArrayList<itemOrService> requestedIOrS = new ArrayList<itemOrService>();
	private ArrayList<itemOrService> offeredIOrS = new ArrayList<itemOrService>();

	public User sender;
	public User target;
	private boolean accepted = false;
	private boolean senderRated = false;
	private boolean targetRated = false;
	
	
	public boolean isAccepted() {
		return accepted;
	}


	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}


	public boolean isSenderRated() {
		return senderRated;
	}


	public void setSenderRated(boolean senderRated) {
		this.senderRated = senderRated;
	}


	public boolean isTargetRated() {
		return targetRated;
	}


	public void setTargetRated(boolean targetRated) {
		this.targetRated = targetRated;
	}


	public Offer(User sender, User target, ArrayList<itemOrService> requestedIOrS, ArrayList<itemOrService> offeredIOrS) { //constructer for an Offer
		
		this.sender = sender;
		this.target = target;
		this.requestedIOrS=requestedIOrS;
		this.offeredIOrS=offeredIOrS;	
		this.offerId = newRandomId(); // temporary placeholder value 0
		//offerId = (int) Integer.valueOf(Integer.toString(sender.getUserId()) + Integer.toString(target.getUserId()));
	}


	public void setRequestedIOrS(ArrayList<itemOrService> requestedIOrS) {
		this.requestedIOrS = requestedIOrS;
	}


	
	// method for displaying offers. Uses display methods found in Item and Service classes. 
	public void displayOffer(Offer offer) {
		ArrayList<itemOrService> offeredStuff = offer.getOfferedIOrS();
		ArrayList<itemOrService> requestedStuff = offer.getRequestedIOrS();
		
		System.out.println("Offer Id: "+offer.getOfferId());
		System.out.println("From User " + offer.sender.getName() + "   (ID: " + offer.sender.getUserId() + ") offers:");
		
		for (itemOrService iors : offeredStuff) {
			iors.displayIOrS();
		}
		
		System.out.println("To user " + offer.target.getName() + "   (ID: " + offer.target.getUserId() + ") in exchange for:");
		for (itemOrService iors : requestedStuff) {
			iors.displayIOrS();
		}
	}

	public int newRandomId() {
		
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


	public ArrayList<itemOrService> getOfferedIOrS() {
		return offeredIOrS;
	}


	public void setOfferedIOrS(ArrayList<itemOrService> offeredIOrS) {
		this.offeredIOrS = offeredIOrS;
	}


	public ArrayList<itemOrService> getRequestedIOrS() {
		return requestedIOrS;
	}

	public boolean getAcceptStatus () {
		return accepted;
	}
	
	public void setAcceptStatus(boolean b) {
		accepted = b;
	}	
	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}


	public User getSender() {
		return sender;
	}


	public void setSender(User sender) {
		this.sender = sender;
	}


	public User getTarget() {
		return target;
	}


	public void setTarget(User target) {
		this.target = target;
	}
}
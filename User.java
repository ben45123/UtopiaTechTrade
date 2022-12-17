package UtopiaTechTrade;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
	
	private String name;
	private int userId; //must be unique
	private int creditCardNumber;
	private double starRating = 0; //only initialized after first rating is given
	private String password;
	private String address;
	private ArrayList<itemOrService> userIOrSList = new ArrayList<itemOrService>();
	private ArrayList<Offer> incomingOffers = new ArrayList<Offer>(); //keeps track of all offers listed in the system
	private ArrayList<Offer> outgoingOffers = new ArrayList<Offer>(); //keeps track of all offers listed in the system
	private ArrayList<Integer> starRatings = new ArrayList<Integer>(); //used to keep track of all ratings given to the user from all other users
	

	public User(String name, int creditCardNumber, String password, String address){ //constuctor for a User
		this.name=name;
		this.creditCardNumber=creditCardNumber;
		this.password=password;
        this.address = address;
		int totalStarRatingValue=0;
		for(int i=0; i<this.starRatings.size(); i++) {
			totalStarRatingValue=totalStarRatingValue+this.starRatings.get(i);
		}
		if(this.starRatings.size()>0) {
			this.starRating=totalStarRatingValue/this.starRatings.size();
		}
		userId = newRandomId();

	}
	
	public void acceptOffer(Offer offer) {
		
		offer.setAcceptStatus(true);
			
		}

	public void addIOrs(itemOrService iors) {
		userIOrSList.add(iors);
	}
	

	public void displayUser(User a) {
		System.out.println("User Info \nUser Name: " + a.name + "\nUser Id: " +a.userId+"\nCredit Card Number: " + a.creditCardNumber+"\nStar Rating: " + a.starRating);
		}
	
	
	public void addIOrSToUserList(itemOrService a) { //adds the items to the User's list and to the systems list of all items, adds the unique itemOrServiceId to the list of all item or service ids
		this.userIOrSList.add(a);

	}
	
	public void removeIOrS(itemOrService a) { //adds the items/services to the User's list and to the systems list of all items/services

		this.userIOrSList.remove(a);
	}
	

	
		
/*	public void addOutgoingOffer1(Offer a) {
		outgoingOffers.add(a);
	}
	*/

	
	public void viewIncomingOffers() {
		for (Offer offer : UtopiaTechTrade.offers) {
			if (userId == offer.target.getUserId()) {
				System.out.println("Offer ID" + offer.getOfferId());
			}
		}
	}
	
	public void viewOutgoingOffers() {
		for (Offer offer : UtopiaTechTrade.offers) {
			if (userId == offer.sender.getUserId()) {
				System.out.println("Offer ID" + offer.getOfferId());
			}
		}
	}
	
	//allows user to rate the exchange and deletes the offer from the system, both user's offer lists, and deletes all of the items from the system

	public int getUserId() {
		return userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(int creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getStarRating() {
		return starRating;
	}

	public void setStarRating(double starRating) {
		this.starRating = starRating;
	}


	public ArrayList<Integer> getStarRatings() {
		return starRatings;
	}
	
	public void addStarRatings(int starRating) {
		this.starRatings.add(starRating);
		double totalStarRatingValue=0;
		for(int i=0; i<this.starRatings.size(); i++) {
			totalStarRatingValue=totalStarRatingValue+this.starRatings.get(i);
		}
		if(this.starRatings.size()>0) {
			this.starRating=(double)totalStarRatingValue/(double)this.starRatings.size();
		}
	}

	public void setStarRatings(ArrayList<Integer> starRatings) {
		this.starRatings = starRatings;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ArrayList<itemOrService> getUserIOrSList() {
		return userIOrSList;
	}

	public void setUserIOrSList(ArrayList<itemOrService> userIOrSList) {
		this.userIOrSList = userIOrSList;
	}

	public ArrayList<Offer> getIncomingOffers() {
		return incomingOffers;
	}

	public void setIncomingOffers(ArrayList<Offer> incomingOffers) {
		this.incomingOffers = incomingOffers;
	}

	public ArrayList<Offer> getOutgoingOffers() {
		return outgoingOffers;
	}

	public void setOutgoingOffers(ArrayList<Offer> outgoingOffers) {
		this.outgoingOffers = outgoingOffers;
	}
	
	//method for generating a new random ID
	public int newRandomId() {
		
		UtopiaTechTrade.update();
		int output = 0;
		int randomId=(int)(Math.random()*1000000); 
		boolean match=true;
		
		while(match==true) { 
			if(UtopiaTechTrade.ids.size()==0) {
				output=randomId;
				break;
			}
			
			randomId=(int)(Math.random()*1000000);
			
			match=false;  
			if (UtopiaTechTrade.ids.contains(randomId)) {
					match=true;
				}
			
			if(match==false) {
				output=randomId;
				break;
				}
		}
		return output;
	}
	
}
	

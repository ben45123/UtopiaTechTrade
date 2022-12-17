package UtopiaTechTrade;

import java.util.ArrayList;

import java.util.Scanner;
import java.util.function.Supplier;

public class UtopiaTechTradeMain {

	public static void main(String[] args) {

		
		//create some users
		UtopiaTechTrade.users.add(new User("Ben",12341234,"abc123", "36 Addison Ave. New York, NY 10032"));
		UtopiaTechTrade.users.add(new User("Jeff",43214321,"xyz123", "6 Lantern St.Bronx, NY 10472"));
		UtopiaTechTrade.users.add(new User("Dan",3232132,"cba321", "424 Woodsman St. Bronx, NY 10469"));
		UtopiaTechTrade.users.add(new User("Sam",6543212,"zyx321", "326 Rockaway Ave.Cambridge, MA 02138"));

		//create some items
		Item item1 = new Item("Samsung Galaxy S22", 799.99,UtopiaTechTrade.users.get(0).getUserId(),"Touch-screen mobile phone released  in 2022", 3); //creates an item assigned to user 1
		Item item2 = new Item("Playstation 5", 649.99, UtopiaTechTrade.users.get(1).getUserId(), "Video game console released in 2020", 4); //creates an item assigned to user 2 of similar value		
		Service service1 = new Service("Phone Battery Replacement", 80.00, UtopiaTechTrade.users.get(0).getUserId(), "Will replace any kind of phone battery.", 2.5);
		Service service2 = new Service("Custom Build PC", 500.00, UtopiaTechTrade.users.get(1).getUserId(), "Will build any pc that you have the components for.", 6);
		BiddingSystem.listItemOrService(item2, "I am looking for a brand new phone.");
		BiddingSystem.listItemOrService(service2, "I would like to package this with my PlayStation.");

		
		Item item3 = new Item("iPhone 12", 599.99,UtopiaTechTrade.users.get(2).getUserId(),"Touch-screen mobile phone released  in 2020", 3); //creates an item assigned to user 1
		Item item4 = new Item("Xbox one with two controllers", 499.99, UtopiaTechTrade.users.get(3).getUserId(), "Video game console released in 2013", 4); //creates an item assigned to user 2 of similar value		
		Service service3 = new Service("iPhone Battery Replacement", 70.00, UtopiaTechTrade.users.get(2).getUserId(), "Will replace any kind of iPhone battery", 2);
		Service service4 = new Service("Xbox or PlayStation Repair", 90.00, UtopiaTechTrade.users.get(3).getUserId(), "Will repair consoles such as xbox or playstation", 6);
		BiddingSystem.listItemOrService(item3, "I have no specific query for what I would like, just something of equal value.");
		BiddingSystem.listItemOrService(service3, "I would like some earbuds or an xbox controller for this service. ");
		
		//added items and services to the users they belong to
		UtopiaTechTrade.users.get(0).addIOrSToUserList(item1);
		UtopiaTechTrade.users.get(1).addIOrSToUserList(item2);
		UtopiaTechTrade.users.get(0).addIOrSToUserList(service1);
		UtopiaTechTrade.users.get(1).addIOrSToUserList(service2);
		
		//added items and services to the users they belong to
		UtopiaTechTrade.users.get(2).addIOrSToUserList(item3);
		UtopiaTechTrade.users.get(3).addIOrSToUserList(item4);
		UtopiaTechTrade.users.get(2).addIOrSToUserList(service3);
		UtopiaTechTrade.users.get(3).addIOrSToUserList(service4);
		
		
		UtopiaTechTrade.update();
		
		//Have a user propose an offer to another user

		//Ben offers Jeff his iphone 13 in exchange for Jeff's playstation 5"
		ArrayList<itemOrService> benOffer = new ArrayList<>();
		benOffer.add(UtopiaTechTrade.users.get(0).getUserIOrSList().get(0));
		benOffer.add(UtopiaTechTrade.users.get(0).getUserIOrSList().get(1));

		
		ArrayList<itemOrService> benRequest = new ArrayList<>();
		benRequest.add(UtopiaTechTrade.users.get(1).getUserIOrSList().get(0));
		benRequest.add(UtopiaTechTrade.users.get(1).getUserIOrSList().get(1));

		
		Offer offer1 = new Offer(UtopiaTechTrade.users.get(0), UtopiaTechTrade.users.get(1), benOffer, benRequest);

		UtopiaTechTrade.addNewOffer(offer1);


		
		UtopiaTechTrade.update();
		
		//Use lambda expression to prompt for another user input
		
		Supplier<String> a = () -> "Enter another option to continue or enter 0 to exit.";
		String askForNextInput = a.get();

		
		System.out.println("Utopia Tech Trade: \nUser Options: ");
		System.out.println("Enter 1 to create an account: ");
		System.out.println("Enter 2 to access a list of all users info: ");
		System.out.println("Enter 3 to access the list of all items and/or services in the system: ");
		System.out.println("Enter 4 to access a list of listed items and/or services of a specific user: ");
		System.out.println("Enter 5 to create an Offer: ");
		System.out.println("Enter 6 to view all incoming Offers: ");
		System.out.println("Enter 7 to view all outgoing Offers: ");
		System.out.println("Enter 8 to accept an incoming Offers: ");
		System.out.println("Enter 9 to remove an offer:");
		System.out.println("Enter 10 to list your item or service: ");
		System.out.println("Enter 11 to add item or service: ");
		System.out.println("Enter 12 to rate your exchange.");
		System.out.println("Enter 13 to access a list of all items and/or services of a specific user.");

		System.out.println("Enter 0 to exit: ");


		
		
		Scanner userInput = new Scanner(System.in);
		int inputEntry = userInput.nextInt();

		while(inputEntry!=0) {
			
			if(inputEntry == 1) {
				System.out.println("Enter your full name (underscore instead of space between first and last): ");
				String name =userInput.next();
				int creditCardNumber;
				System.out.println("Enter your credit card number: ");
				creditCardNumber = userInput.nextInt();
				System.out.println("Enter a password: ");
				String password = userInput.next();
				System.out.println("Enter your address (use underscores instead of spaces): ");
				String address = userInput.next();

				UtopiaTechTrade.users.add(new User(name, creditCardNumber, password, address));
				System.out.println("User created successfully");

				
				Scanner in = new Scanner(System.in);
				System.out.println(askForNextInput);
				inputEntry = in.nextInt();

			}
			else if(inputEntry==2) {
				for(int i=0; i<UtopiaTechTrade.users.size(); i++) {
					UtopiaTechTrade.users.get(i).displayUser(UtopiaTechTrade.users.get(i));
				}
				System.out.println(askForNextInput);
				inputEntry = userInput.nextInt();

			}
			else if(inputEntry==3) {
				int notDeletedSize=0;
				for(int i=0; i<UtopiaTechTrade.listOfAllIOrS.size(); i++) {
					if(UtopiaTechTrade.listOfAllIOrS.get(i).getDeletedStatus()==false) {
						notDeletedSize=notDeletedSize+1;
					}
				}
				
				System.out.println("There are " + notDeletedSize + " total items/services in the system.");
				
				for(int i=0; i<UtopiaTechTrade.listOfAllIOrS.size(); i++) {
					if(UtopiaTechTrade.listOfAllIOrS.get(i).getDeletedStatus()==false) {
						UtopiaTechTrade.listOfAllIOrS.get(i).displayIOrS();
					}
				}
				System.out.println(askForNextInput);
				inputEntry = userInput.nextInt();
			}
			else if(inputEntry==4) {
				System.out.println("Enter the user ID of the user whose list of listed items and/or services you would like to view: ");
				int userId = userInput.nextInt();
				boolean hasUserId=false;
				for(int i=0; i<UtopiaTechTrade.users.size(); i++) {
					if(userId==UtopiaTechTrade.users.get(i).getUserId()) {
						hasUserId=true;
						if(hasUserId==false) {
							System.out.println("No users with that ID in the system.");
						}
						for(int j=0; j<UtopiaTechTrade.users.get(i).getUserIOrSList().size(); j++){
							if(UtopiaTechTrade.users.get(i).getUserIOrSList().get(j).getListStatus()==true) {
								UtopiaTechTrade.users.get(i).getUserIOrSList().get(j).displayIOrS();
								
							}
						}
					
				}
					
				}
				System.out.println(askForNextInput);
				inputEntry = userInput.nextInt();
			}
			else if(inputEntry==5) {
				System.out.println("Create new offer: "); 
				System.out.println("Input sending user ID: ");
				int senderId = userInput.nextInt();
				
				System.out.println("Input target user ID: ");
				int targetId = userInput.nextInt();
				
				User sender = null;
				for (User user : UtopiaTechTrade.users) {
					if (user.getUserId() == senderId) {
						sender = user;
						break;
					}
				}
				User target = null;
				for (User user : UtopiaTechTrade.users) {
					if (user.getUserId() == targetId) {
						target = user;
						break;
					}
				}
				
				ArrayList<itemOrService> offered = new ArrayList<itemOrService>();
				ArrayList<itemOrService> requested = new ArrayList<itemOrService>();
				
				int offeredIOrsID = 1;

				System.out.println("Input an ID for " + sender.getName() + "'s offered item or service: ");
				while(offeredIOrsID!=0) {
					offeredIOrsID = userInput.nextInt();
					itemOrService offeredIOrS = null;
					for (itemOrService iors : UtopiaTechTrade.listOfAllIOrS) {
						if (offeredIOrsID == iors.getItemOrServiceId()) {
							offeredIOrS = iors;
							offered.add(offeredIOrS);
						}
					}
					if(offeredIOrsID!=0) {
						System.out.println("Input another ID for " + sender.getName() + "'s offered item or service or enter 0 to continue: ");
					}
				}
				

				int requestedIOrSID = 1;
				System.out.println("Input an ID for " + sender.getName() + "'s requested item or service: ");
				while(requestedIOrSID!=0) {
					requestedIOrSID = userInput.nextInt();
					itemOrService requestedIOrS = null;
					for (itemOrService iors : UtopiaTechTrade.listOfAllIOrS) {
						if (requestedIOrSID == iors.getItemOrServiceId()) {
							requestedIOrS = iors;
							requested.add(requestedIOrS);

						}
					}
					if(requestedIOrSID!=0) {
						System.out.println("Input another an ID for " + sender.getName() + "'s requested item or service or enter 0 to continue: ");
					}
				}

				Offer newOffer = new Offer(sender, target, offered, requested);
				if(newOffer!=null) {
					System.out.println("Offer created!");
				}
				
				sender.getOutgoingOffers().add(newOffer);
				target.getIncomingOffers().add(newOffer);
				
				UtopiaTechTrade.update();
				
				System.out.println(askForNextInput);
				inputEntry = userInput.nextInt();
			}
			else if(inputEntry==6) {
				System.out.println("Enter the user ID of the user whose list of incoming offers you would like to view: ");
				int userId = userInput.nextInt();
				boolean hasUserId = false;
				boolean hasNoIncomingOffers=true;
				for(int i=0; i<UtopiaTechTrade.users.size(); i++) {
					if(userId==UtopiaTechTrade.users.get(i).getUserId()) {
						hasUserId=true;
						for(int j=0; j<UtopiaTechTrade.users.get(i).getIncomingOffers().size(); j++){
							if(UtopiaTechTrade.users.get(i).getIncomingOffers().get(j).getAcceptStatus()==false) {
								UtopiaTechTrade.users.get(i).getIncomingOffers().get(j).displayOffer(UtopiaTechTrade.users.get(i).getIncomingOffers().get(j));
								hasNoIncomingOffers=false;
							}
						}
						if(hasNoIncomingOffers==true) {
							System.out.println("User has no incoming offers.");
						}
					}
				}
				if(hasUserId==false) {
					System.out.println("Entered user ID does not belong to any users in the system.");
				}
				System.out.println(askForNextInput);
				inputEntry = userInput.nextInt();
			}
			else if(inputEntry==7) {
				System.out.println("Enter the user ID of the user whose list of outgoing offers you would like to view:");
				int userId = userInput.nextInt();
				boolean hasUserId = false;
				boolean hasNoOutgoingOffers=true;
				for(int i=0; i<UtopiaTechTrade.users.size(); i++) {
					if(userId==UtopiaTechTrade.users.get(i).getUserId()) {
						hasUserId=true;
						for(int j=0; j<UtopiaTechTrade.users.get(i).getOutgoingOffers().size(); j++){
							if(UtopiaTechTrade.users.get(i).getOutgoingOffers().get(j).getAcceptStatus()==false) {
								UtopiaTechTrade.users.get(i).getOutgoingOffers().get(j).displayOffer(UtopiaTechTrade.users.get(i).getOutgoingOffers().get(j));
								hasNoOutgoingOffers=false;
							}
						}
						if(hasNoOutgoingOffers==true) {
							System.out.println("User has no outgoing offers.");
						}
	
					}
					
				}
				if(hasUserId==false) {
					System.out.println("Entered user ID does not belong to any users in the system.");
				}
				
				System.out.println(askForNextInput);
				inputEntry = userInput.nextInt();
			}

			else if(inputEntry==8) {
				System.out.println("Enter ID of user who would like to accept an offer. ");
				boolean hasTargetId = false;
				boolean hasCorrectPassword=false;
				boolean hasCorrectOfferId=false;
				boolean successfulOffer=false;
				int targetId = userInput.nextInt();
				for(int i=0; i<UtopiaTechTrade.users.size(); i++) {
					if(UtopiaTechTrade.users.get(i).getUserId()==targetId) {
						hasTargetId=true;
						System.out.println("Enter password:");
						String password = userInput.next();
						if(UtopiaTechTrade.users.get(i).getPassword().equals(password)) {
							hasCorrectPassword=true;
							System.out.println("Enter offer ID to accept: ");
							int offerId = userInput.nextInt();
							for (int j=0; j<UtopiaTechTrade.offers.size(); j++) {
								if (UtopiaTechTrade.offers.get(j).getOfferId() == offerId && UtopiaTechTrade.offers.get(j).getTarget().getUserId()==targetId) {
									hasCorrectOfferId=true;
									UtopiaTechTrade.offers.get(j).setAcceptStatus(true); 
									for (itemOrService iors : UtopiaTechTrade.offers.get(j).getOfferedIOrS()) {
										iors.setDeletedStatus(true);
									}
									for (itemOrService iors : UtopiaTechTrade.offers.get(j).getRequestedIOrS()) {
										iors.setDeletedStatus(true);
									}
									successfulOffer=true;
								}
							}
						}
					}
				}
				if(hasTargetId==false) {
					System.out.println("No users with that user ID exist in the system.");
				}
				else if(hasCorrectPassword==false) {
					System.out.println("Password entered incorrectly. ");
				}
				else if(hasCorrectOfferId==false) {
					System.out.println("User does not have an incoming offer with that offer id.");
				}
				else if(successfulOffer==true) {
					System.out.println("Offer accepted!");
				}
				
				UtopiaTechTrade.update();
				System.out.println(askForNextInput);
				inputEntry = userInput.nextInt();
			}
			else if(inputEntry==9) {
				System.out.println("Enter ID of user who would like to remove an offer. ");
				boolean hasUserId = false;
				boolean hasCorrectPassword=false;
				boolean hasCorrectOfferId=false;
				int senderId = userInput.nextInt();
				for(int i=0; i<UtopiaTechTrade.users.size(); i++) {
					if(UtopiaTechTrade.users.get(i).getUserId()==senderId) {
						hasUserId=true;
						System.out.println("Enter password:");
						String password = userInput.next();
						if(UtopiaTechTrade.users.get(i).getPassword().equals(password)) {
							hasCorrectPassword=true;
							System.out.println("Enter ID of offer to remove: ");
							int offerId = userInput.nextInt();

							Offer offerToRemove = null;  //creates an offer that needs to be removed from all of the lists
							for (Offer offer: UtopiaTechTrade.offers) {
								if (offer.getOfferId() == offerId && offer.getSender().getUserId()==senderId) {
									hasCorrectOfferId=true;
									offerToRemove = offer;
								}
							}

							int targetId = 0;

							for (User user : UtopiaTechTrade.users) { 
								for (Offer offer : user.getIncomingOffers()) {
									if (offerId == offer.getOfferId() && offer.getSender().getUserId()==senderId) {
									//	targetId = user.getUserId();
										targetId= offer.getTarget().getUserId();
										}
								}

						}
						for(int j=0; j<UtopiaTechTrade.offers.size(); j++) { //removes offer from system list of offers
							if(UtopiaTechTrade.offers.get(j).getOfferId()==offerId) {
								UtopiaTechTrade.offers.remove(offerToRemove);
							}
						}

						for (User user : UtopiaTechTrade.users) { //removes offer from sender's list of outgoing offers
							if (user.getUserId() == senderId) {
								user.getOutgoingOffers().remove(offerToRemove);
							}
						}

						for (User user : UtopiaTechTrade.users) { //removes offer from target's list of incoming offers
							if (user.getUserId() == targetId) {
								user.getIncomingOffers().remove(offerToRemove);
							}
						}
						}
						}
				}
				if(hasUserId==false) {
					System.out.println("No users with that user ID exist in the system.");
				}
				else if(hasCorrectPassword==false) {
					System.out.println("Password entered incorrectly. ");
				}
				else if(hasCorrectOfferId==true) {
					System.out.println("Offer has been removed. ");
				}
				else if(hasCorrectOfferId==false) {
					System.out.println("User does not have an outgoing offer with that offer id.");
				}
				
				System.out.println(askForNextInput);
				inputEntry = userInput.nextInt();
			}
			else if (inputEntry == 10) {
				System.out.println("Enter ID of user who would like to list their item or service. ");
				boolean hasUserId = false;
				boolean hasCorrectPassword=false;
				boolean hasCorrectOfferId=false;
				int userId = userInput.nextInt();
				for(int i=0; i<UtopiaTechTrade.users.size(); i++) {
					if(UtopiaTechTrade.users.get(i).getUserId()==userId) {
						hasUserId=true;
						System.out.println("Enter password:");
						String password = userInput.next();
						if(UtopiaTechTrade.users.get(i).getPassword().equals(password)) {
							hasCorrectPassword=true;							
							System.out.println("Enter the ID of the item or service you are looking for: ");
							inputEntry = userInput.nextInt();
							
							boolean found = false;
							int counter = 0;
							for (itemOrService iors : UtopiaTechTrade.listOfAllIOrS) {
								if (iors.getItemOrServiceId() == inputEntry && iors.getUserId()==userId ) {
									found = true;
									break;
								}
								else {
									counter ++;
								}					
							}
							
							if (found) {   System.out.println("Item or service found!");    }
							
							System.out.println("Enter a description of what you are looking for(separate your words using underscores): ");
							String input = userInput.next();
							
							BiddingSystem.listItemOrService(UtopiaTechTrade.listOfAllIOrS.get(counter), input);
							
							System.out.println("Item or Service successfully listed \n");
							
							UtopiaTechTrade.update();
						}
					}
				}
				if(hasUserId==false) {
					System.out.println("No users with that user ID exist in the system.");
				}
				else if(hasCorrectPassword==false) {
					System.out.println("Password entered incorrectly. ");
				}
				
				System.out.println(askForNextInput);
				inputEntry = userInput.nextInt();
			}
			
			else if (inputEntry == 11) {
				System.out.println("Enter ID of user who would like to add an item or service. ");
				boolean hasUserId = false;
				boolean hasCorrectPassword=false;
				int userId = userInput.nextInt();
				for(int i=0; i<UtopiaTechTrade.users.size(); i++) {
					if(UtopiaTechTrade.users.get(i).getUserId()==userId) {
						hasUserId=true;
						System.out.println("Enter password:");
						String password = userInput.next();
						if(UtopiaTechTrade.users.get(i).getPassword().equals(password)) {
							hasCorrectPassword=true;
							System.out.println("Enter 1 if you are adding an item or 2 for a service.");
							int oneOrTwo = userInput.nextInt();
							
						
							
							if (oneOrTwo==1) {
								
								System.out.println("Enter item name(separate words using underscores): ");
								String itemName = userInput.next();
								
								System.out.println("Enter item price: ");
								double itemPrice = userInput.nextDouble();
								
								
								System.out.println("Enter item description(separate words using underscores): ");
								String itemDesrciption = userInput.next();
								
								System.out.println("Enter item condition (from 1 - 5): ");
								int itemCondition = userInput.nextInt();
								
								Item item = new Item(itemName, itemPrice, userId, itemDesrciption, itemCondition);
								UtopiaTechTrade.users.get(i).addIOrs(item);					
	
							
								System.out.println("Item added successfully");	
							}
							
							if (oneOrTwo==2) {
								
								System.out.println("Enter service name(separate words using underscores): ");
								String serviceName = userInput.next();
								
								System.out.println("Enter service price: ");
								double servicePrice = userInput.nextDouble();
								
								
								System.out.println("Enter service description(separate words using underscores): ");
								String serviceDesrciption = userInput.next();
								
								System.out.println("Enter the service time: ");
								double serviceTime = userInput.nextDouble();
								
								Service service = new Service(serviceName, servicePrice, userId, serviceDesrciption, serviceTime);
								UtopiaTechTrade.users.get(i).addIOrs(service);
								System.out.println("Service added successfully");	
								}
							

						}
					}
				}
				if(hasUserId==false) {
					System.out.println("No users with that user ID exist in the system.");
				}
				else if(hasCorrectPassword==false) {
					System.out.println("Password entered incorrectly. ");
				}
					
				System.out.println(askForNextInput);
				inputEntry = userInput.nextInt();
			}
						
					
			else if (inputEntry==12) {
				System.out.println("Enter the ID of the offer you would like to rate: ");
				int offerId = userInput.nextInt();
				boolean hasOfferId=false;
				boolean hasId=false;
				boolean hasCorrectPassword=false;
				boolean hasBeenRated=false;

				for(int i=0; i<UtopiaTechTrade.offers.size(); i++) {
					if(UtopiaTechTrade.offers.get(i).getAcceptStatus()==true && offerId==UtopiaTechTrade.offers.get(i).getOfferId()) {
						hasOfferId=true;
						System.out.println("Enter the ID of the user who would like to rate the exchange: ");
						int userId = userInput.nextInt();
						System.out.println("Is the sender or target rating this exchange?");
						System.out.println("Enter 1 for sender, and 2 for target");
						int senderOrGetter=userInput.nextInt();
						if(userId==UtopiaTechTrade.offers.get(i).getSender().getUserId() && senderOrGetter==1) {
							hasId=true;
							System.out.println("Enter password: ");
							String senderPassword = userInput.next();
							if(UtopiaTechTrade.offers.get(i).getSender().getPassword().equals(senderPassword)) {
								hasCorrectPassword=true;
								System.out.println("Enter the star rating review of your exchange(1-5): ");
								int starRating = userInput.nextInt();
								while(starRating>5|| starRating<1) {
									System.out.println("Incorrect input, enter a number between 1 and 5: ");
									starRating = userInput.nextInt();
								}
								
								for(int k=0; k<UtopiaTechTrade.offers.size();k++) {
									hasBeenRated = UtopiaTechTrade.offers.get(k).isTargetRated();
										if(userId==UtopiaTechTrade.offers.get(k).getSender().getUserId() && hasBeenRated==false) {
											hasBeenRated=true;
											UtopiaTechTrade.offers.get(k).setTargetRated(true);
											UtopiaTechTrade.offers.get(k).getTarget().addStarRatings(starRating);;
											System.out.println("Offer successfully rated!");
										}
										
									}
										
							}
						}
						if(userId==UtopiaTechTrade.offers.get(i).getTarget().getUserId() && senderOrGetter==2) {
							hasId=true;
							System.out.println("Enter password: ");
							String targetPassword = userInput.next();
								if(UtopiaTechTrade.offers.get(i).getTarget().getPassword().equals(targetPassword)) {
									hasCorrectPassword=true;
									System.out.println("Enter the star rating review of your exchange(1-5): ");
									int starRating = userInput.nextInt();
									while(starRating>5 || starRating<1) {
										System.out.println("Incorrect input, enter a number between 1 and 5: ");
										starRating = userInput.nextInt();
									}
									for(int k=0; k<UtopiaTechTrade.offers.size();k++) {
										hasBeenRated = UtopiaTechTrade.offers.get(k).isTargetRated();
										if(userId==UtopiaTechTrade.offers.get(k).getTarget().getUserId() && UtopiaTechTrade.offers.get(k).isSenderRated()==false) {
											hasBeenRated=true;
											UtopiaTechTrade.offers.get(k).setSenderRated(true);
											UtopiaTechTrade.offers.get(k).getSender().addStarRatings(starRating);;
											System.out.println("Offer successfully rated!");
										}
									}
								}
						}
					
					}
				}
				if(hasOfferId==false) {
					System.out.println("No offers with this ID in the system.");
				}
				else if(hasId==false) {
					System.out.println("No users with this ID in the system.");
				}
				else if(hasCorrectPassword==false) {
					System.out.println("Incorrect password.");
				}
				else if(hasBeenRated==true) {
					System.out.println("You have already rated this offer.");
				}
				System.out.println(askForNextInput);
				inputEntry = userInput.nextInt();	
			}
		

		else if(inputEntry==13) {
			System.out.println("Enter the user ID of the user whose list of items and/or services you would like to view: ");
			boolean hasUserId = false;
			boolean hasCorrectPassword=false;
			boolean hasCorrectOfferId=false;
			boolean successfulOffer=false;
			int userId = userInput.nextInt();
			for(int i=0; i<UtopiaTechTrade.users.size(); i++) {
				if(UtopiaTechTrade.users.get(i).getUserId()==userId) {
					hasUserId=true;
					System.out.println("Enter password:");
					String password = userInput.next();
					if(UtopiaTechTrade.users.get(i).getPassword().equals(password)) {
						hasCorrectPassword=true;
						for(int j=0; j<UtopiaTechTrade.users.get(i).getUserIOrSList().size(); j++){
							if(UtopiaTechTrade.users.get(i).getUserIOrSList().get(j).getDeletedStatus()==false) {
							UtopiaTechTrade.users.get(i).getUserIOrSList().get(j).displayIOrS();
							}
						}
					}
				}
			}
			if(hasUserId==false) {
				System.out.println("No users with that user ID exist in the system.");
			}
			else if(hasCorrectPassword==false) {
				System.out.println("Password entered incorrectly. ");
			}
			
			UtopiaTechTrade.update();
			System.out.println(askForNextInput);
			inputEntry = userInput.nextInt();
		}

			
		}
		
	}
}



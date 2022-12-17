package UtopiaTechTrade;

import java.util.ArrayList;

public class BiddingSystem {

	
	public static void listItemOrService(itemOrService iOrS, String description) { 
		iOrS.setListed(true);	
		iOrS.setDescriptionOfWhatUserIsLookingFor(description);
	}
	
	public static void unlistIOrS(itemOrService iOrS) { 
		iOrS.setListed(false);		
	}
	
	public static void removeListedIOrS(itemOrService iOrS) {
		
			iOrS.setListed(false);
			iOrS.setDeleted(true);
			UtopiaTechTrade.update();
		}
		
	}	



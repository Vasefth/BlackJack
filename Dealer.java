import java.util.Random;

public class Dealer {
	Random rand = new Random();
	private int dealercards;
	private int sum;
	private int counter;

	
	public Dealer() {
		dealercards=0;
		sum = 0;
		counter = 0;
	}

	
	//This method is used in order to program the dealer not to hit if his cards' sum is over 16.
	public boolean decisiontostayorhit() {
		 if(sum > 16) {
			 System.out.println("\n");
			 System.out.println("Dealer stays");
			 return true;
		 }
		 return false;
	}

//This method actually "decides" if dealer hits or stays.
public void dlhitorstay() {
//This while loop run if dealer's cards are not over 21.We check this using the method decisiontostayorhit
	while(!decisiontostayorhit()) {
//we call method dlcards in order to "produce" new random cards
		dlcards();
		System.out.println("\n");
		System.out.println("Dealer chooses to hit.");
		System.out.println("He draws a " + dealercards + ".");
		System.out.println("His total is " + sum + ".");
	}

}

//In this method we check if dealer's cards are over 21, or not, in order to see the outcome in this round
public boolean dealerover21() {
	if(sum > 21) {
		return true;
	}
	return false;
}

//This method is used as a random cards generator
public void dlcards() {
	//we have this counter in order to print out each part needed without using any kind of array.Because we know what should be printed and when.
    counter++;
	dealercards = rand.nextInt(11-2)+2;
	add();
//here we say if counter is <= 1 and we refer to the first card he receives(dealercards) without knowing the second card,but this doesn't matter because we don't have to reveal it and we only have to print the first one  
	if(counter<=1) {
		System.out.println("The dealer has a " + dealercards +" showing, and a hidden card.");
	}
}

//We use this method to generate the first two cards of dealer
public void dlfirstcards() {
	for(int i=0;i<2;i++) {
		dlcards();
}
}

//In this method we add the cards that dealer gets  in order to have the sum.We don't have array approach here so we have to use this method each time dealer receives a new card.
public void add() {
	sum += dealercards;
}

//In this method we print the hidden card(the second one) and the sum.We could have created another counter and add the hidden card section to another method but having this method helps us clear thing up.
public void printtotal() {
	System.out.println("His hidden card was " + dealercards +".");
	System.out.println("His total is " + sum +".");
}


//This is just a normal get in order to use dealer's sum in class Main
public int getSum() {
	return sum;
}




}

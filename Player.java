import java.util.Random;
import java.util.Scanner;


public class Player {
	
	Random rand = new Random();
	Scanner in = new Scanner(System.in);
	private int playercards;
	private int sum;
	//we use this counter to keep track of cards in order to help us in printinfo method 
	private int counter;
	
	
	public Player() {
		playercards=0;
		sum = 0;
		counter = 0;
	}
	
	//This method is used in case player's cards are over 21 which means that he lost
	public boolean playerout() {
		if(sum>21) {
			return true;
		}
		return false;
	}

	//This method is used to generate only the first two cards of the player in order not to have a for loop in class Main
	public void plfirstcards() {
		for(int i=0;i<2;i++) {
			plcards();
		}
	}

	//This method is used as a random card generator 
public void plcards() {
	    counter++;
		playercards = rand.nextInt(11-2)+2;
		add();
		if(counter<=2) {
		  printinfo();
		}
	}

//This method is used to add all the cards that player got
public void add() {
	sum += playercards;
}

//This method is used to print the first two cards of the player properly in order not to have to store them in any array alike list
public void printinfo() {
	//if counter<=1 it means that the player has received only his first card so we print that with the phrase that introduces the first card and then we move one to the second one
	if(counter <= 1)
		System.out.print("You get a " + playercards);
	else if(counter == 2) {
		System.out.println(" and " + playercards);
	}
}

//This method is used to print the sum of all cards
public void printtotal() {
	System.out.println("Your total is " + sum);
	playerout();
}

//This method is used to take the answer the player gave and to lead the program depending player's decision 
public boolean questionhitstayandanswer() {
	String answer;
	do {
	System.out.print("\n");
	System.out.print("Would you like to \"hit\" or \"stay\"? ");
	answer = in.nextLine();
	//We make that statement in order to be protected from the chance of running one time this loop in case of a stay answer
 if(!playerout()) {
	if(answer.equals("hit")) {
		plcards();
		System.out.println("You drew a " + playercards);
		printtotal();
	}
 }
}while(answer.equals("hit") && !playerout());
	//this while actually says do this loop while the player answers hit and his cards are not over 21
	//The following commands will be printed in case player answers stay
	if(playerout()) {
		//This if statement is used here in order to cover the chance of player having cards with sum over 21.Else, if player chooses to stay we proceed with the other chance that player stays and dealer plays
		System.out.print("\n");
		System.out.println("Player's cards are over 21 so he lost");
		System.out.println("DEALER WINS!");
		return false;
		}
	else {
		System.out.print("\n");
		System.out.println("OK, dealer is playing.");
		return true;
		//it returns true in case player decides to stay 
	}
}

//This is just a normal get that we will use in the end in order to take player's sum and compare it to dealer's and see who won
public int getSum() {
	return sum;
}

}

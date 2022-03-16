

public class Main {
		
		public static void main(String args[]) {
			Player p = new Player();
			Dealer d = new Dealer();
			
			System.out.println("Welcome to the simplified blackjack game!");
			p.plfirstcards();
			p.printtotal();
			System.out.print("\n\n");
			
			
			d.dlfirstcards();
			System.out.print("\n\n");
			
			
			//This if statement is in case player chooses to stay so it's time for dealer to play
		    if(p.questionhitstayandanswer()) {
		    	d.printtotal();
		    	d.dlhitorstay();
		    	//if dealer's cards aren't over 21 then we proceed with the comparison of dealer and player sum to see who won
		    	if(!d.dealerover21()){
		    System.out.println("\n");
		    System.out.println("Dealer total is " + d.getSum())	;
		    System.out.println("Your total is " + p.getSum());
		    System.out.println("\n");
		    if(d.getSum() > p.getSum()) {
		    	 System.out.println("DEALER WINS!");
		    }
		    else if(p.getSum() > d.getSum()) {
		    	 System.out.println("YOU WIN!");
		    }
		    else if(p.getSum() == d.getSum()) {
		    	System.out.println("DEALER WINS!");
		    }
		    	}
		    	//This else stands for the case of dealer having cards sum over 21,which means that player won 
		   else {
			   System.out.print("\n");
				System.out.println("Dealer's cards are over 21 so he lost");
				System.out.println("YOU WIN!");
		   }
		    }
		}
}

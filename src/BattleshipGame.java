import java.util.Scanner;

public class BattleshipGame {

	Ocean ocean = new Ocean();
	static int shootPerUser = 5;
	public static void main(String[] args) {
		// accepts shoots
		
		//display results
		
		// do you want to play again
		
		//All input and output is here
		Scanner sc = new Scanner(System.in);
		boolean valShoots = true;
		while(valShoots){
			String input = sc.nextLine();
			String[] shoots = input.split(";");
			if(shoots.length == shootPerUser){
				valShoots = false;
			}
		}
		
		
		sc.close();
	}

}

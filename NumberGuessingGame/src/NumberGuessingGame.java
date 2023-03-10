import javax.swing.JOptionPane;

public class NumberGuessingGame {
	public static void main(String[] args) {
		int randomNumber = (int) (Math.random()*100)+1;
		int userNumber = 0;
		System.out.println("The correct guess would be " + randomNumber);
		int count = 1;
		while (userNumber != randomNumber) {
			String response = JOptionPane.showInputDialog(null, "Enter a guess between 1 to 100", "Guessing Game",3);
			userNumber = Integer.parseInt(response);
			JOptionPane.showMessageDialog(null, ""+determineGuess(userNumber, randomNumber, count));
			count++;
		}
	}
	public static String determineGuess(int userNumber, int randomNumber, int count) {
		if (userNumber<=0 || userNumber>100) {
			return "Out of range";
		}
		else if (userNumber == randomNumber) {
			return "Correct Guess in " + count + " attempt";
		}
		else if (userNumber > randomNumber) {
			return "Guess is high \nTried " + count;
		}
		else if (userNumber < randomNumber) {
			return "Guess is low \nTried " + count;
		}
		else {
			return "Incorrect guess \nTried " + count;
		}
		
	}
}

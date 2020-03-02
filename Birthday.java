import javax.swing.JOptionPane;
import java.util.Random;
import java.text.NumberFormat;

public class Birthday {

	public static void main(String[] args) {
		//String variables to pass user inputs into Toy Class
		String childName = null, toyChoice = null, childAge, repeat = null, cardAndBalloon, moreToy;
		//a boolean to determine if the user wants to continue after wrong information or add another gift
		boolean ifContinue = true;
		//Programmer name
		String programmerName = "Hoang Nguyen";
        Toy kidToyChoice = new Toy();
        //an integer to convert string user input for the age of the child
        int childAgeNum;
        //Generate and display order number
        Random rand = new Random();
        int orderNum = rand.nextInt(100000)+10000;
        //A variable to keep track of the total cost of user
        double total = 0;
        //Display the total cost of user in dollar currency format
        NumberFormat totalCost = NumberFormat.getCurrencyInstance();
		JOptionPane.showMessageDialog(null, "Welcome to the Toy Company to choose gifts for young children");
		while (ifContinue == true){
			kidToyChoice.addCost(kidToyChoice.getCost());
			childName = JOptionPane.showInputDialog("Enter the name of the child:");
			childAge = JOptionPane.showInputDialog("How old is the child?");
			childAgeNum = Integer.parseInt(childAge);
			kidToyChoice.setAge(childAgeNum);
			toyChoice = JOptionPane.showInputDialog("Choose a toy: a plushie, blocks, or a book");
			kidToyChoice.setToy(toyChoice);
			//If the user inputs for age or toy choice doesn't match up according to menu
			if (kidToyChoice.ageOK() == false) {
				repeat = JOptionPane.showInputDialog("The age for the toy is not appropriate\n" + "Would you like to enter again or not?");
				if (repeat.equalsIgnoreCase("no")) {
					ifContinue = false;
				}
			}
			else {
				kidToyChoice.setCost(toyChoice);
				cardAndBalloon = JOptionPane.showInputDialog("Do you want to add a card with the gift? Yes or No");
				kidToyChoice.addCard(cardAndBalloon);
				cardAndBalloon = JOptionPane.showInputDialog("Do you want to add a balloon with the gift? Yes or No");
				kidToyChoice.addBalloon(cardAndBalloon);
				moreToy = JOptionPane.showInputDialog("Do you want to add another gift? Yes or No");
				System.out.println(childName + kidToyChoice.toString());
				total += kidToyChoice.getCost();
                if (moreToy.equalsIgnoreCase("no")) {
                	ifContinue = false;
                }

			}

		}
 
		System.out.println("The total cost of your order is " + totalCost.format(total) + ". Order number is " + orderNum);
		System.out.println("Programmer: " + programmerName);
        System.exit(0);
	   }
	
	

}


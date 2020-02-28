import javax.swing.JOptionPane;
import java.util.Random;
import java.text.NumberFormat;

public class Birthday {

	public static void main(String[] args) {
		String childName = null, toyChoice = null, childAge, repeat = null, cardAndBalloon, moreToy;
		boolean ifContinue = true;
		String programmerName = "Hoang Nguyen";
        Toy kidToyChoice = new Toy();
        int childAgeNum, orderNum;
        double total = 0;
        NumberFormat totalCost = NumberFormat.getCurrencyInstance();
		Random rand = new Random();
		JOptionPane.showMessageDialog(null, "Welcome to the Toy Company to choose gifts for young children");
		while (ifContinue == true){
			kidToyChoice.addCost(kidToyChoice.getCost());
			childName = JOptionPane.showInputDialog("Enter the name of the child:");
			childAge = JOptionPane.showInputDialog("How old is the child?");
			childAgeNum = Integer.parseInt(childAge);
			kidToyChoice.setAge(childAgeNum);
			toyChoice = JOptionPane.showInputDialog("Choose a toy: a plushie, blocks, or a book");
			kidToyChoice.setToy(toyChoice);
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
		orderNum = rand.nextInt(99999);

		System.out.println("The total cost of your order is " + totalCost.format(total) + ". Order number is " + orderNum);
		System.out.println("Programmer: " + programmerName);
        System.exit(0);
	   }
	
	

}


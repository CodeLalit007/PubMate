import javax.swing.JOptionPane;

public class Whisky extends Beverage {
	private String whisky;
	String[] whiskeys = {"Johnnie Walker Blue Label","Johnnie Walker Double Black","Jack Daniel","Johnnie Walker Red Label","Vat 69"};

	public Whisky(String size,int amount,Label lbl) {
		super(size,amount);
		try {
			whisky = (String) JOptionPane.showInputDialog(lbl,"Select a Whisky.","Select a Whisky",
					JOptionPane.QUESTION_MESSAGE,null,whiskeys,whiskeys[0]);
			//Creates a pop up that asks to the user, from which whisky he/she wants his/her drink. Takes lbl as a paramater to display the pop up on the frame
			//If he/she clicks on "OK" following codes will be executed.
			double price;
			if(size.equals("Small / 30ml")) price=250.0;
			else if(size.equals("Medium / 60ml")) price=500.0;
			else price=750.0;
			if(whisky.equals("Johnnie Walker Blue Label")) price*=2.6;
			if(whisky.equals("Johnnie Walker Double Black")) price*=1.1;
			if(whisky.equals("Jack Daniel")) price*=1.7;
			if(whisky.equals("Johnnie Walker Red Black")) price*=1.3;
			if(whisky.equals("Vat 69")) price*=1;
			setPrice(price);
		}
		catch(NullPointerException e) {
		}
	}
	
	@Override
	public String toString() {
		return super.toString()+whisky+" Whisky";
	}
}
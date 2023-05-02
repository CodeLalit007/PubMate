//import javax.swing.JOptionPane;
//
//public class Tea extends Beverage {
//	private boolean sugar;
//
//	public Tea(String size,int amount,Label lbl) {
//		super(size,amount);
//		if(JOptionPane.showConfirmDialog(lbl, "Would you like sugar?","Sugar",JOptionPane.YES_NO_OPTION)==0) sugar=true;
//		else sugar=false;
//		double price;
//		if(size.equals("Small")) price=3.0;
//		else if(size.equals("Medium")) price=4.0;
//		else price=5.0;
//		if(sugar) price*=1.25;
//		setPrice(price);
//	}
//	
//	@Override
//	public String toString() {
//		if(sugar) return super.toString()+"Tea with sugar";
//		else return super.toString()+"Tea";
//	}
//}



import javax.swing.JOptionPane;

public class Rum extends Beverage {
	private String rum;
	String[] rums = {"Old Monk","Bacardi White"};

	public Rum(String size,int amount,Label lbl) {
		super(size,amount);
		try {
			rum = (String) JOptionPane.showInputDialog(lbl,"Select a Rum.","Select a Rum",
					JOptionPane.QUESTION_MESSAGE,null,rums,rums[0]);
			//Creates a pop up that asks to the user, from which rum he/she wants his/her drink. Takes lbl as a paramater to display the pop up on the frame
			//If he/she clicks on "OK" following codes will be executed.
			double price;
			if(size.equals("Small / 30ml")) price=150.0;
			else if(size.equals("Medium / 60ml")) price=300.0;
			else price=450.0;
			if(rum.equals("Old Monk")) price*=1.1;
			if(rum.equals("Bacardi White")) price*=1.4;
			setPrice(price);
		}
		catch(NullPointerException e) {
		}
	}

	@Override
	public String toString() {
		return super.toString()+rum+" Rum";
	}
}
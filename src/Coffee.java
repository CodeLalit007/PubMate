import javax.swing.JOptionPane;

public class Coffee extends Beverage {
	private boolean milk; 

	public Coffee(String size,int amount,Label lbl) {
		super(size,amount);
		if(JOptionPane.showConfirmDialog(lbl, "Would you like milk?","Milk",JOptionPane.YES_NO_OPTION)==0) milk=true;
		else milk=false;
		double price;
		if(size.equals("Small")) price=200;
		else if(size.equals("Medium")) price=300;
		else price=500;
		if(milk) price*=1.5;
		setPrice(price);
	}

	@Override
	public String toString() {
		if(milk) return super.toString()+" Coffee with milk";
		else return super.toString()+" Coffee";
	}
}
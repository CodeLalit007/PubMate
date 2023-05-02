import javax.swing.*;
import javax.swing.ImageIcon;
public class Beer extends Beverage {
    private String beer;
    String[] beers = {"Kingfisher Gold","Kingfisher Ultra","Heineken"};

    public Beer(String size,int amount,Label lbl) {
        super(size,amount);
        try {
            ImageIcon icon = new ImageIcon("img/beer.png");
            beer = (String) JOptionPane.showInputDialog(lbl,"Select a Beer.","Select a Beer",
                    JOptionPane.QUESTION_MESSAGE,icon,beers,beers[0]);
            //Creates a pop up that asks to the user, from which beer he/she wants his/her drink. Takes lbl as a paramater to display the pop up on the frame
            //If he/she clicks on "OK" following codes will be executed.
            double price;
            if(size.equals("Small / 30ml")) price=200.0;
            else if(size.equals("Medium / 60ml")) price=350.0;
            else price=550.0;
            if(beer.equals("Kingfisher Gold")) price*=1.1;
            if(beer.equals("Kingfisher Ultra")) price*=1.5;
            if(beer.equals("Heineken")) price*=1.9;
            setPrice(price);
        }
        catch(NullPointerException e) {
        }
    }

    @Override
    public String toString() {
        return super.toString()+beer+" Beer";
    }
}
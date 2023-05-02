import javax.swing.*;
import javax.swing.ImageIcon;
public class Milkshake extends Beverage {
    private String milkshake;
    String[] milkshakes = {"Banana","Chocolate","Brownie"};

    public Milkshake(String size,int amount,Label lbl) {
        super(size,amount);
        try {
            ImageIcon icon = new ImageIcon("img/milkshake.png");
            milkshake = (String) JOptionPane.showInputDialog(lbl,"Select a Milkshake.","Select a Milkshake",
                    JOptionPane.QUESTION_MESSAGE,icon,milkshakes,milkshakes[0]);
            //Creates a pop up that asks to the user, from which milkshake he/she wants his/her drink. Takes lbl as a paramater to display the pop up on the frame
            //If he/she clicks on "OK" following codes will be executed.
            double price;
            if(size.equals("Small / 30ml")) price=150.0;
            else if(size.equals("Medium / 60ml")) price=300.0;
            else price=450.0;
            if(milkshake.equals("Banana")) price*=1;
            if(milkshake.equals("Chocolate")) price*=1.2;
            if(milkshake.equals("Brownie")) price*=1.6;
            setPrice(price);
        }
        catch(NullPointerException e) {
        }
    }

    @Override
    public String toString() {
        return super.toString()+milkshake+" Milkshake";
    }
}
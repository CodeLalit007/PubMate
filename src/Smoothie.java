import javax.swing.*;
import javax.swing.ImageIcon;
public class Smoothie extends Beverage {
    private String smoothie;
    String[] smoothies = {"Blue Berry","Cream Berry","Strawberry"};

    public Smoothie(String size,int amount,Label lbl) {
        super(size,amount);
        try {
            ImageIcon icon = new ImageIcon("img/smoothie.png");
            smoothie = (String) JOptionPane.showInputDialog(lbl,"Select a Smoothie.","Select a Smoothie",
                    JOptionPane.QUESTION_MESSAGE,icon,smoothies,smoothies[0]);
            //Creates a pop up that asks to the user, from which smoothie he/she wants his/her drink. Takes lbl as a paramater to display the pop up on the frame
            //If he/she clicks on "OK" following codes will be executed.
            double price;
            if(size.equals("Small / 30ml")) price=100.0;
            else if(size.equals("Medium / 60ml")) price=200.0;
            else price=300.0;
            if(smoothie.equals("Blue Berry")) price*=1.1;
            if(smoothie.equals("Cream Berry")) price*=1.1;
            if(smoothie.equals("Strawberry")) price*=1.3;
            setPrice(price);
        }
        catch(NullPointerException e) {
        }
    }

    @Override
    public String toString() {
        return super.toString()+smoothie+" Smoothie";
    }
}
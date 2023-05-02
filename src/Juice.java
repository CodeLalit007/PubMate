import javax.swing.JOptionPane;

public class Juice extends Beverage {
    private String juice;
    String[] juices = {"Pineapple","Orange","Plum"};

    public Juice(String size,int amount,Label lbl) {
        super(size,amount);
        try {
            juice = (String) JOptionPane.showInputDialog(lbl,"Select a Juice.","Select a Juice",
                    JOptionPane.QUESTION_MESSAGE,null,juices,juices[0]);
            //Creates a pop up that asks to the user, from which juice he/she wants his/her drink. Takes lbl as a paramater to display the pop up on the frame
            //If he/she clicks on "OK" following codes will be executed.
            double price;
            if(size.equals("Small / 30ml")) price=150.0;
            else if(size.equals("Medium / 60ml")) price=220.0;
            else price=350.0;
            if(juice.equals("Pineapple")) price*=1.3;
            if(juice.equals("Orange")) price*=1.1;
            if(juice.equals("Plum")) price*=1.7;
            setPrice(price);
        }
        catch(NullPointerException e) {
        }
    }

    @Override
    public String toString() {
        return super.toString()+juice+" Juice";
    }
}
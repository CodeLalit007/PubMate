import javax.swing.JOptionPane;

public class Vodka extends Beverage {
    private String vodka;
    String[] vodkas = {"Absolut","Smirnoff","Grey Goose"};

    public Vodka(String size,int amount,Label lbl) {
        super(size,amount);
        try {
            vodka = (String) JOptionPane.showInputDialog(lbl,"Select a Vodka.","Select a Vodka",
                    JOptionPane.QUESTION_MESSAGE,null,vodkas,vodkas[0]);
            //Creates a pop up that asks to the user, from which vodka he/she wants his/her drink. Takes lbl as a paramater to display the pop up on the frame
            //If he/she clicks on "OK" following codes will be executed.
            double price;
            if(size.equals("Small / 30ml")) price=150.0;
            else if(size.equals("Medium / 60ml")) price=300.0;
            else price=450.0;
            if(vodka.equals("Absolut")) price*=1.8;
            if(vodka.equals("Grey Goose")) price*=3.4;
            if(vodka.equals("Smirnoff")) price*=1.4;
            setPrice(price);
        }
        catch(NullPointerException e) {
        }
    }

    @Override
    public String toString() {
        return super.toString()+vodka+" Vodka";
    }
}
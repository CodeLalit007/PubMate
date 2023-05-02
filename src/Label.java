// PUB MATE

//import java.awt.Graphics;
//import java.awt.Image;
//import java.awt.Toolkit;
//import java.io.IOException;
//import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Label extends JFrame implements ActionListener{
//	Image img = Toolkit.getDefaultToolkit().getImage("D:/xownload.png");
	private static final long serialVersionUID = 1L;
	private JLabel lblSize,lblBev,lblGlass,lblReport;
	private JComboBox<String> size;
	private JRadioButton rdWhisky,rdWater,rdRum,rdCoffee,rdJuice,rdBeer,rdVodka,rdMilkshake,rdSmoothie;
	private ButtonGroup btnGroup;
	private JTextField txtGlass;
	private JButton btnAdd,btnOrder;
	int amount_of;
	ArrayList<Beverage> list_of_bvr = new ArrayList<Beverage>();
	public Label(){
		// this.setContentPane(new JPanel() {
		// 	@Override
		// 	public void paintComponent(Graphics g) {
		// 	   super.paintComponent(g);
		// 	   g.drawImage(img, 0, 0, null);
		// 	   setSize(600,400);
		// 	   setLocationRelativeTo(null);
		// 	}
		//  });
		setLayout(null);
		setSize(800,600);
		setLocationRelativeTo(null);
		setTitle("Order");
		init();
		btnAdd.addActionListener(this); 
		btnOrder.addActionListener(this);
		setVisible(true);
	}
	
	public void init() {
		lblSize = new JLabel("Select size:");// a JLabel that labels the comboBox
		lblSize.setSize(250, 50);
		lblSize.setLocation(100, 10);
		add(lblSize);
		
		String[] sizes = {"Small / 30ml","Medium / 60ml","Large / 90ml"};
		size = new JComboBox<String>(sizes);//
		size.setSelectedIndex(0);//default selection is Small / 30ml
		size.setSize(100, 25);
		size.setLocation(100, 50);
		add(size);
		
		lblBev = new JLabel("Select which type of drink you want to order:");//a JLabel that labels the radioButtons
		lblBev.setSize(500, 50);
		lblBev.setLocation(100, 75);
		add(lblBev);
		
		btnGroup = new ButtonGroup();
		
		rdWhisky = new JRadioButton("Whisky");
		rdWhisky.setSize(75, 50);
		rdWhisky.setLocation(100, 110);
		add(rdWhisky);
		
		rdWater = new JRadioButton("Water");
		rdWater.setSize(75, 50);
		rdWater.setLocation(175, 110);
		add(rdWater);
		
		rdRum = new JRadioButton("Rum");
		rdRum.setSize(75, 50);
		rdRum.setLocation(250, 110);
		add(rdRum);
		
		rdCoffee = new JRadioButton("Coffee");
		rdCoffee.setSize(75, 50);
		rdCoffee.setLocation(325, 110);
		add(rdCoffee);

		rdBeer = new JRadioButton("Beer");
		rdBeer.setSize(75, 50);
		rdBeer.setLocation(250, 150);
		add(rdBeer);

		rdJuice = new JRadioButton("Juice");
		rdJuice.setSize(75, 50);
		rdJuice.setLocation(100, 150);
		add(rdJuice);

		rdMilkshake = new JRadioButton("Milkshake");
		rdMilkshake.setSize(115, 50);
		rdMilkshake.setLocation(325, 150);
		add(rdMilkshake);

		rdSmoothie = new JRadioButton("Smoothie");
		rdSmoothie.setSize(115, 50);
		rdSmoothie.setLocation(400, 110);
		add(rdSmoothie);

		rdVodka = new JRadioButton("Vodka");
		rdVodka.setSize(75, 50);
		rdVodka.setLocation(175, 150);
		add(rdVodka);
		
		btnGroup.add(rdWhisky);
		btnGroup.add(rdWater);
		btnGroup.add(rdRum);
		btnGroup.add(rdCoffee);
		btnGroup.add(rdBeer);
		btnGroup.add(rdJuice);
		btnGroup.add(rdMilkshake);
		btnGroup.add(rdSmoothie);
		btnGroup.add(rdVodka);
		
		lblGlass = new JLabel("Type how many glasses you want to order:");//a JLabel that labels the Text Field
		lblGlass.setSize(500, 50);
		lblGlass.setLocation(100, 180);
		add(lblGlass);
		
		txtGlass = new JTextField();//a JTextField to get how many glasses of beverage is the user want
		txtGlass.setSize(300, 25);
		txtGlass.setLocation(100, 225);
		add(txtGlass);
		
		btnAdd = new JButton("Add");
		btnAdd.setSize(120, 40);
		btnAdd.setLocation(100, 265);
		add(btnAdd);
		
		btnOrder = new JButton("Order");
		btnOrder.setSize(120, 40);
		btnOrder.setLocation(280, 265);
		btnOrder.setEnabled(false);
		add(btnOrder);
		
		lblReport = new JLabel();//will be showing report of the beverages that added.
		lblReport.setSize(500, 50);
		lblReport.setLocation(100, 300);
		add(lblReport);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String size_of = (String)size.getSelectedItem();
		if(e.getSource().equals(btnAdd)) {
			if( rdWhisky.isSelected() || rdRum.isSelected() || rdCoffee.isSelected() || rdWater.isSelected() || rdBeer.isSelected() || rdJuice.isSelected() || rdMilkshake.isSelected() || rdSmoothie.isSelected() || rdVodka.isSelected() && !(txtGlass.getText().isEmpty())) {
				try {
					amount_of  = Integer.parseInt(txtGlass.getText().trim());
					Beverage bvg;
					if(rdWhisky.isSelected())  { bvg = new Whisky(size_of,amount_of,this); }
					else if(rdWater.isSelected())  { bvg = new Water(size_of,amount_of,this); }
					else if(rdRum.isSelected())    { bvg = new Rum(size_of,amount_of,this); }
					else if(rdBeer.isSelected())    { bvg = new Beer(size_of,amount_of,this); }
					else if(rdJuice.isSelected())    { bvg = new Juice(size_of,amount_of,this); }
					else if(rdMilkshake.isSelected())    { bvg = new Milkshake(size_of,amount_of,this); }
					else if(rdSmoothie.isSelected())    { bvg = new Smoothie(size_of,amount_of,this); }
					else if(rdVodka.isSelected())    { bvg = new Vodka(size_of,amount_of,this); }
					else { bvg = new Coffee(size_of,amount_of,this); }
					txtGlass.setText(null);
					list_of_bvr.add(bvg);
					lblReport.setText(bvg.toString()+" added");
					btnGroup.clearSelection();
					btnOrder.setEnabled(true);
				}
				catch(NumberFormatException e1) {//if written data in TextField can't be converted to an integer[String,char,double etc...]
					JOptionPane.showMessageDialog(this, "Enter an integer as amount");
				}
			}	
			else { JOptionPane.showMessageDialog(this, "Choose a drink type and enter an amount");
			//if none of the radio buttons are selected or the textField is empty
			}
		}
		if(e.getSource().equals(btnOrder)) {
			String report = "";
			double pay=0.0;
			for(int i=0;i<list_of_bvr.size();i++) {
				Beverage bvgi = list_of_bvr.get(i);
				report += bvgi.toString();
				double totalprice_of_bvg = bvgi.getAmount() * bvgi.getPrice();
				pay += totalprice_of_bvg;
				report = report + " - "+totalprice_of_bvg+" ₹\n";
			}
			JOptionPane.showMessageDialog(this, report);
			JOptionPane.showMessageDialog(this,	 "You should pay "+pay+"₹");
			lblReport.setText(null);
			btnOrder.setEnabled(false);
			list_of_bvr.clear();
		}	
	}

	public static void main(String[] args) {
		new Label();
	}
}

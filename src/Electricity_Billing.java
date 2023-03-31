import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Electricity_Billing extends JFrame {

	private JPanel contentPane;
	private JTextField txtPowerUsage;
	private JTextField txtHoursUsed;
	private JTextField txtUnitCost;
	private JTextField txtBillPerMonth;
	private JLabel lblCurrency;
	//private JLabel lblAppliances;
	
	private double hoursOfUse;
	private double bill;
	private double unitcost;
	private double total_units;
	private double units_used;
	private double consumed_units;
	
	
	String units[] = {"Watts"};
	String[] applliances = {"Fan", "LED Light Bulb", "AC Air Conditioner", "Refrigerator", 
			"Electric Heater", "Water Heater", "Hair Dryer", "Clothes Dryer", "Clothes Iron"};
	String[] currencies = {"Ghana", "United States", "Nigeria","China", "India"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Electricity_Billing frame = new Electricity_Billing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Electricity_Billing() {
		setTitle("Electricity Bill & E-Levy Calc");
		setResizable(false);
		//frame1 = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 521);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("E-Levy Calc");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO: I am going to add the code to move to the next form to calculate the E-levy tariff.
				E_Levy_Calculator obj = new E_Levy_Calculator();
				obj.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectCountry = new JLabel("Country/Currency*");
		lblSelectCountry.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSelectCountry.setBounds(62, 55, 134, 15);
		contentPane.add(lblSelectCountry);
		
		JLabel lblPowerUsage = new JLabel("Appliance Power *");
		lblPowerUsage.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPowerUsage.setBounds(62, 98, 124, 15);
		contentPane.add(lblPowerUsage);
		
		JLabel lblHoursOfUse = new JLabel("Appliance Use Per Day*");
		lblHoursOfUse.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHoursOfUse.setBounds(62, 144, 148, 15);
		contentPane.add(lblHoursOfUse);
		
		JLabel lblCostOfUnitkilowatt = new JLabel("Cost of Unit/Kilowatt");
		lblCostOfUnitkilowatt.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCostOfUnitkilowatt.setBounds(62, 191, 134, 15);
		contentPane.add(lblCostOfUnitkilowatt);
	
		txtPowerUsage = new JTextField();
		txtPowerUsage.setEditable(false);
		txtPowerUsage.setBounds(231, 96, 86, 20);
		contentPane.add(txtPowerUsage);
		txtPowerUsage.setColumns(10);
		
		
		txtHoursUsed = new JTextField();
		txtHoursUsed.setBounds(231, 142, 86, 20);
		contentPane.add(txtHoursUsed);
		txtHoursUsed.setColumns(10);
		
		txtUnitCost = new JTextField();
		txtUnitCost.setEditable(false);
		txtUnitCost.setBounds(231, 189, 86, 20);
		contentPane.add(txtUnitCost);
		txtUnitCost.setColumns(10);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					if(txtHoursUsed.getText() == "" || txtUnitCost.getText() == ""
							|| txtPowerUsage.getText() == "" ) {
						System.out.println("This person wants to crash our lovely written program");
					}else {
						hoursOfUse = Double.parseDouble(txtHoursUsed.getText());
						unitcost =  Double.parseDouble(txtUnitCost.getText());
						units_used = Integer.parseInt(txtPowerUsage.getText());
						
						total_units = units_used * hoursOfUse * 30; 
						consumed_units = total_units / 1000;
						bill = consumed_units * unitcost;
						txtBillPerMonth.setText(String.valueOf(Math.round(bill)));
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,"Check empty required fields!");
					System.out.println("This guy wanted to break our program" + e);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(156, 232, 129, 41);
		contentPane.add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtPowerUsage.setText(null);
				txtUnitCost.setText(null);
				txtHoursUsed.setText(null);
				txtBillPerMonth.setText(null);
				
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClear.setBounds(318, 232, 129, 41);
		contentPane.add(btnClear);
		
		JLabel lblElectricityBillPer = new JLabel("Monthly Bill");
		lblElectricityBillPer.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblElectricityBillPer.setBounds(79, 309, 86, 14);
		contentPane.add(lblElectricityBillPer);
		
		txtBillPerMonth = new JTextField();
		txtBillPerMonth.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtBillPerMonth.setEditable(false);
		txtBillPerMonth.setColumns(10);
		txtBillPerMonth.setBounds(205, 302, 112, 28);
		contentPane.add(txtBillPerMonth);
		
		JComboBox comboBox_1 = new JComboBox(units);
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_1.setBounds(347, 96, 100, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblAppliances = new JLabel("Typical Appliances*");
		lblAppliances.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAppliances.setBounds(521, 50, 124, 14);
		contentPane.add(lblAppliances);
		
		JComboBox comboBoxAplliances = new JComboBox(applliances);
		comboBoxAplliances.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//txtHouseAddress.setText(comboBoxAplliances.getSelectedItem().toString());
				switch(comboBoxAplliances.getSelectedItem().toString()) {
				case "Fan":
					txtPowerUsage.setText("80");
					break;
				case "LED Light Bulb":
					txtPowerUsage.setText("25");
					break;
				case "AC Air Conditioner":
					txtPowerUsage.setText("900");
					break;
				case "Refrigerator":
					txtPowerUsage.setText("250");
					break;
				case "Electric Heater":
					txtPowerUsage.setText("2000");
					break;
				case "Water Heater":
					txtPowerUsage.setText("4000");
					break;
				case "Hair Dryer":
					txtPowerUsage.setText("1500");
					break;
				case "Clothes Dryer":
					txtPowerUsage.setText("3000");
					break;
				case "Clothes Iron":
					txtPowerUsage.setText("1400");
					break;
					default:
						txtPowerUsage.setText("0");
				}
			}
		});
		comboBoxAplliances.setBounds(521, 79, 141, 20);
		contentPane.add(comboBoxAplliances);
		
		JLabel lblDuration = new JLabel("Hours/Day");
		lblDuration.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDuration.setBounds(347, 145, 66, 14);
		contentPane.add(lblDuration);
		
		/*JLabel*/ lblCurrency = new JLabel("Ghana Cedis");
		lblCurrency.setBounds(327, 192, 75, 14);
		contentPane.add(lblCurrency);
		
		JComboBox comboBox_2 = new JComboBox(currencies);
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		switch(comboBox_2.getSelectedItem().toString()) {
		 		case "Ghana":
		 			lblCurrency.setText("Ghana Cedis");
		 			txtUnitCost.setText("0.70");
		 			break;
		 		case "Nigeria":
		 			lblCurrency.setText("Naira");
		 			txtUnitCost.setText("0.5");
		 			break;
		 		case "China":
		 			lblCurrency.setText("Yen");
		 			txtUnitCost.setText("0.4");
		 			break;
		 		case "United States":
		 			lblCurrency.setText("Dollars");
		 			txtUnitCost.setText("0.09");
		 			break;
		 		case "India":
		 			lblCurrency.setText("Rupees");
		 			txtUnitCost.setText("4");
		 			default:
		 				txtUnitCost.setText("0");
		 		}
		 	}
		 });
		comboBox_2.setBounds(217, 53, 142, 20);
		contentPane.add(comboBox_2);
	}
}

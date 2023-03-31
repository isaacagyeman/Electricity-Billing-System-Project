import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class E_Levy_Calculator extends JFrame {

	private JPanel contentPane;
	private JTextField txtAmount;
	private JLabel lblTariff;
	private JTextField txtTax;
	private JTextField txtTaxAmount;
	
	double amount;
	final double tax = 1.5 / 100.0;
	double taxamount;
	private JButton btnClear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					E_Levy_Calculator frame = new E_Levy_Calculator();
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
	public E_Levy_Calculator() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter amount ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(23, 23, 89, 14);
		contentPane.add(lblNewLabel);
		
		txtAmount = new JTextField();
		txtAmount.setBounds(123, 21, 130, 20);
		contentPane.add(txtAmount);
		txtAmount.setColumns(10);
		
		lblTariff = new JLabel("Tax percentage");
		lblTariff.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTariff.setBounds(23, 63, 105, 14);
		contentPane.add(lblTariff);
		
		txtTax = new JTextField();
		txtTax.setText("1.5");
		txtTax.setEditable(false);
		txtTax.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtTax.setColumns(10);
		txtTax.setBounds(133, 60, 66, 20);
		contentPane.add(txtTax);
		
		JButton btnCalculate = new JButton("Calculate Tax");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					amount = Double.parseDouble(txtAmount.getText());
						if(amount >= 100) {
							taxamount = tax * amount;
							txtTaxAmount.setText(String.valueOf(taxamount));
						}else {
							txtTaxAmount.setText("NO TAX APPLY");
						}
					
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null,"Incorrect input!");
					System.out.println("This guy wanted to break our program" + e);
				}
				
			}
		});
		btnCalculate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCalculate.setBounds(106, 170, 130, 40);
		contentPane.add(btnCalculate);
		
		JLabel lblNewLabel_1 = new JLabel("%");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(206, 63, 24, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTaxAmount = new JLabel("Tax amount");
		lblTaxAmount.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTaxAmount.setBounds(23, 102, 89, 14);
		contentPane.add(lblTaxAmount);
		
		txtTaxAmount = new JTextField();
		txtTaxAmount.setEditable(false);
		txtTaxAmount.setColumns(10);
		txtTaxAmount.setBounds(123, 100, 130, 20);
		contentPane.add(txtTaxAmount);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtAmount.setText(null);
				txtTaxAmount.setText(null);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClear.setBounds(265, 170, 130, 40);
		contentPane.add(btnClear);
	}
}

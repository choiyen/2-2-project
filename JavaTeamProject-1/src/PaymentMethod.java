import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PaymentMethod extends JFrame{
	private JPanel subpaymentmethodPanel = new JPanel();
	private JRadioButton radio = new JRadioButton();
	private String paymentMethod = "신용카드";
	private JTextField[] tf = new JTextField[4];
	private JButton confirmbtn = new JButton("확인");
	private JButton paymentcancelbtn = new JButton("결제 취소");
	private JButton selectpayment = new JButton("선택");
	
	public PaymentMethod(){
		setBackground(new Color(255,255, 255));
		setLayout(new BorderLayout());
		
		JLabel paymentla = new JLabel("최종결제 수단");
		paymentla.setHorizontalAlignment(JLabel.CENTER);
		paymentla.setBackground(Color.black);
		paymentla.setForeground(Color.white);
		paymentla.setOpaque(true);
		
		ButtonGroup group = new ButtonGroup();
		
		radio = new JRadioButton(paymentMethod);
		radio.setPreferredSize(new Dimension(340, 30));
		radio.setHorizontalAlignment(JRadioButton.CENTER);
		group.add(radio);
		subpaymentmethodPanel.add(radio);
			
		radio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int j = 0; j < tf.length; j++) {
					tf[j].setVisible(true);
				}
				confirmbtn.setVisible(true);
				paymentcancelbtn.setVisible(true);
			}
		});
		
		paymentcancelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		for(int i=0; i<tf.length; i++) {
			tf[i] = new JTextField(5);
			subpaymentmethodPanel.add(tf[i]);
			tf[i].setVisible(false);
		}
		
		confirmbtn.setPreferredSize(new Dimension(150,30));
		confirmbtn.setBackground(Color.black);
		confirmbtn.setForeground(Color.white);
		confirmbtn.setVisible(false);
		subpaymentmethodPanel.add(confirmbtn);
		
		paymentcancelbtn.setPreferredSize(new Dimension(150,30));
		paymentcancelbtn.setBackground(Color.black);
		paymentcancelbtn.setForeground(Color.white);
		paymentcancelbtn.setVisible(false);
		subpaymentmethodPanel.add(paymentcancelbtn);
		
		selectpayment.setBackground(Color.red);
		selectpayment.setForeground(Color.white);
		
		add(paymentla, BorderLayout.NORTH);
		add(subpaymentmethodPanel, BorderLayout.CENTER);
		add(selectpayment, BorderLayout.SOUTH);
		
		setTitle("결제수단");
		setVisible(true);
		setSize(400, 240);
		setLocationRelativeTo(null);
		// setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new PaymentMethod();

	}

}

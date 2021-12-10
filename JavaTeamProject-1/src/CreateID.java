import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class CreateID extends JFrame {
	private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; // 드라이버
	private final String DB_URL = "jdbc:mysql://localhost/movie_db?&useSSL=false"; // 접속할 DB 서버

	private final String USER_NAME = "root"; // DB에 접속할 사용자 이름을 상수로 정의
	private final String PASSWORD = "6126"; // 사용자의 비밀번호를 상수로 정의
	
	private JTextField T1, T2, T3, T4, T5, T6, T7, T8, T9, T10;
	
	public void DBLogin(String id, String name, String password, String card) {
		Connection conn = null;
		Statement state = null;

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			state = conn.createStatement();
			
			String sql;
			sql = "insert into login values('"+id+"', '"+name+"', '"+password+"', '"+card+"')";
			
			state.executeUpdate(sql);
			
			}catch(SQLException e) {
				System.out.println("드라이버 연결실패!");
				e.printStackTrace();
			} catch(ClassNotFoundException e){
				System.out.println("드라이버 연결실패!");
			}finally {
				try {
					if(state != null)
						state.close();
				}catch(SQLException ex1) {
				
				}
			
				try {
					if(conn != null) 
						conn.close();
				}catch(SQLException ex1) {
				
				 }
			 }
		}


	public CreateID() {
		JPanel panel = new JPanel();
		JLabel L1, L2, L3, L4, L5, L6;
		JPasswordField pwnd1, pwnd2;
		JButton b1 = new JButton("회원가입");
		JButton b2 = new JButton("취소");
		JButton b3 = new JButton("중복체크");

		Color C1 = new Color(253, 245, 230);
		Color C2 = new Color(250, 128, 114);
		Color C3 = new Color(105, 105, 105);
		panel.setBackground(C1);
		Font font1 = new Font("맑은 고딕", Font.PLAIN, 13);
		Font font2 = new Font("맑은 고딕", Font.BOLD, 13);

		L1 = new JLabel("ID", JLabel.RIGHT);
		L2 = new JLabel("PW", JLabel.RIGHT);
		L3 = new JLabel("재입력", JLabel.RIGHT);
		L4 = new JLabel("이름", JLabel.RIGHT);
		L5 = new JLabel("전화번호", JLabel.RIGHT);
		L6 = new JLabel("카드번호", JLabel.RIGHT);

		T1 = new JTextField();
		T2 = new JTextField();
		T3 = new JTextField();
		T4 = new JTextField();
		T5 = new JTextField();
		T6 = new JTextField();
		T7 = new JTextField();
		T8 = new JTextField();
		T9 = new JTextField();
		T10 = new JTextField();

		pwnd1 = new JPasswordField();
		pwnd2 = new JPasswordField();

		panel.add(L1);
		panel.add(L2);
		panel.add(L3);
		panel.add(L4);
		panel.add(L5);
		panel.add(L6);

		panel.add(T1);
		panel.add(T2);
		panel.add(T3);
		panel.add(T4);// 전화번호
		panel.add(T5);
		panel.add(T6);
		panel.add(T7);// 카드번호
		panel.add(T8);
		panel.add(T9);
		panel.add(T10);

		panel.add(pwnd1);
		panel.add(pwnd2);
		panel.add(b1);
		panel.add(b2);

		panel.setLayout(null);
		L1.setBounds(30, 50, 60, 50);
		T1.setBounds(100, 60, 150, 25);
		b3.setBounds(260, 60, 100, 25);

		L2.setBounds(30, 80, 60, 50);
		pwnd1.setBounds(100, 93, 150, 25);

		L3.setBounds(30, 110, 60, 50);
		pwnd2.setBounds(100, 123, 150, 25);

		L4.setBounds(30, 140, 60, 50);
		T3.setBounds(100, 153, 150, 25);

		L5.setBounds(30, 170, 60, 50);
		T4.setBounds(100, 183, 40, 25);
		T5.setBounds(145, 183, 50, 25);
		T6.setBounds(200, 183, 50, 25);

		L6.setBounds(30, 200, 60, 50);
		T7.setBounds(100, 215, 55, 25);
		T8.setBounds(160, 215, 55, 25);
		T9.setBounds(220, 215, 55, 25);
		T10.setBounds(280, 215, 55, 25);

		b1.setBounds(70, 270, 100, 25);
		b2.setBounds(220, 270, 80, 25);

		L1.setForeground(C3);
		L2.setForeground(C3);
		L3.setForeground(C3);
		L4.setForeground(C3);
		L5.setForeground(C3);
		L6.setForeground(C3);

		T1.setForeground(C3);
		T2.setForeground(C3);
		T3.setForeground(C3);
		T4.setForeground(C3);
		T5.setForeground(C3);
		T6.setForeground(C3);
		T7.setForeground(C3);
		T8.setForeground(C3);
		T9.setForeground(C3);
		T10.setForeground(C3);

		b1.setBackground(C2);
		b2.setBackground(C2);
		b3.setBackground(C2);
		b1.setForeground(C1);
		b2.setForeground(C1);
		b3.setForeground(C1);

		L1.setFont(font1);
		L2.setFont(font1);
		L3.setFont(font1);
		L4.setFont(font1);
		L5.setFont(font1);
		L6.setFont(font1);
		T1.setFont(font1);
		T2.setFont(font1);
		T3.setFont(font1);
		T4.setFont(font1);
		T5.setFont(font1);
		T6.setFont(font1);
		T7.setFont(font1);
		T8.setFont(font1);
		T9.setFont(font1);
		T10.setFont(font1);

		b1.setFont(font2);
		b2.setFont(font2);
		b3.setFont(font2);

		add(panel);

		setTitle("회원가입");
		setVisible(true);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] pass1 = pwnd1.getPassword();
				String password1 = new String(pass1);

				char[] pass2 = pwnd2.getPassword();
				String password2 = new String(pass2);

				String id = T1.getText();
				String name = T3.getText();
				String num1 = T4.getText();
				String num2 = T5.getText();
				String num3 = T6.getText();
				String Num1 = T7.getText();
				String Num2 = T8.getText();
				String Num3 = T9.getText();
				String Num4 = T10.getText();
				String cardnum = Num1 + Num2 + Num3 + Num4;

				if (id.equals("") || name.equals("") || num1.equals("") || num2.equals("") || num3.equals("")
						|| Num1.equals("") || Num2.equals("") || Num3.equals("") || Num4.equals("")
						|| password1.equals("") || password2.equals("")) {
					JOptionPane.showMessageDialog(null, "빈칸이 있습니다.");
				} else {
					if (password1.equals(password2) && password2.equals(password1)) {
						try {
							JOptionPane.showMessageDialog(null, "회원가입이 되었습니다.");
							DBLogin(id, name, password1, cardnum);
							dispose();
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
					}
				}
			}
		});

		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	public static void main(String[] args) {
		new CreateID();
	}
}
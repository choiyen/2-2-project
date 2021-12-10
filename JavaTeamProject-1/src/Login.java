import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login extends JFrame {
	JButton login = new JButton("�α���");

	private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; // ����̹�
	private final String DB_URL = "jdbc:mysql://localhost/movie_db?&useSSL=false"; // ������ DB ����

	private final String USER_NAME = "root"; // DB�� ������ ����� �̸��� ����� ����
	private final String PASSWORD = "6126"; // ������� ��й�ȣ�� ����� ����

	private String id;
	private String password;
	
	public int logincount = 0;
	
	private int connum = 0;
	private int onumber = 0;
	
	public void DBLogin(String ID, String Pass) {
		Connection conn = null;
		Statement state = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			state = conn.createStatement();
			
			String sql;
			sql = "SELECT * FROM login";
			ResultSet rs = state.executeQuery(sql);
			
		    while(rs.next()){
		    	id = rs.getString("id");
				password = rs.getString("password");
				
				if (id.equals(ID) && password.equals(Pass)) {
					JOptionPane.showMessageDialog(null, "�α��� �Ϸ�");
					break;
				}
		    }
		    
		    rs.close();
		    state.close();
		    conn.close();
			}catch(Exception e) {
			e.printStackTrace();
			
			} finally {
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
	
	public void DBMovieIntroduce1(String area) {
		Connection conn = null;
		Statement state = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			state = conn.createStatement();
			
			String sql;
			sql = "select connum from moviecon where qname = '" + area + "'";
			ResultSet rs = state.executeQuery(sql);
			
			if(rs.next()) {
				connum = rs.getInt("connum");
			}
			System.out.println(connum);
			
		    rs.close();
		    state.close();
		    conn.close();
			}catch(Exception e) {
			e.printStackTrace();
			
			} finally {
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
	
	public void DBMovieIntroduce2(String mname) {
		Connection conn = null;
		Statement state = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			state = conn.createStatement();
			
			String sql;
			sql = "select onumber from movie where oname = '" + mname + "'";
			ResultSet rs = state.executeQuery(sql);
			
			if(rs.next()) {
				onumber = rs.getInt("onumber");
			}
			System.out.println(onumber);
			
		    rs.close();
		    state.close();
		    conn.close();
			}catch(Exception e) {
			e.printStackTrace();
			
			} finally {
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
	
	public void DBMovieIntoduceSubmit(String mtime, String mname) {
		Connection conn = null;
		Statement state = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			state = conn.createStatement();
			
			String sql;
			sql = "insert into movietime values('"+connum+"', '"+onumber+"', '"+mtime+"', '"+mname+"', 350)";
		
			state.executeUpdate(sql);

		} catch (SQLException e) {
			System.out.println("����̹� �������!");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �������!");
			
			} finally {
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


	public Login(String mname, String mcity, int n, String mtime, String mperson) {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("ID");
		JLabel pswrd = new JLabel("PW");
		JLabel main = new JLabel("���̵� ��й�ȣ�� �Է��Ͻ� ��, �α��� ��ư�� Ŭ���� �ּ���.");
		JTextField txtID = new JTextField(10);
		JPasswordField txtPass = new JPasswordField(10);
		JButton logBtn = new JButton("�α���");
		JButton CtBtn = new JButton("ȸ�� ����");

		Color C1 = new Color(253, 245, 230);
		Color C2 = new Color(250, 128, 114);
		Color C3 = new Color(105, 105, 105);
		panel.setBackground(C1);
		Font font1 = new Font("���� ���", Font.PLAIN, 13);
		Font font2 = new Font("���� ���", Font.BOLD, 13);

		logBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBLogin(txtID.getText(), txtPass.getText());
				if(!id.equals(txtID.getText()) || !password.equals(txtPass.getText())) {
					JOptionPane.showMessageDialog(null, "������ �����ϴ�.");
				}
				else {
					logincount = logincount + 1;
					DBMovieIntroduce1(mcity);
					DBMovieIntroduce2(mname.substring(1, mname.length()));
					DBMovieIntoduceSubmit(mname.substring(1, mname.length()), "2020-11-" + n + " " + mtime + ":00");
					System.out.print("2020-11-" + n + " " + mtime + ":00");
					dispose();
				}
			}
		});

		CtBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateID();
			}
		});

		panel.add(main);
		panel.add(label);
		panel.add(txtID);
		panel.add(pswrd);
		panel.add(txtPass);
		panel.add(logBtn);
		panel.add(CtBtn);

		panel.setLayout(null);
		main.setBounds(65, 15, 400, 25);
		label.setBounds(125, 50, 50, 50);
		txtID.setBounds(160, 60, 200, 30);
		pswrd.setBounds(125, 90, 50, 50);
		txtPass.setBounds(160, 100, 200, 30);
		logBtn.setBounds(125, 145, 115, 34);
		CtBtn.setBounds(245, 145, 115, 34);

		main.setFont(font1);
		label.setFont(font1);
		txtID.setFont(font1);
		pswrd.setFont(font1);
		txtPass.setFont(font1);
		logBtn.setFont(font2);
		CtBtn.setFont(font2);

		logBtn.setBackground(C2);
		CtBtn.setBackground(C2);

		main.setForeground(C3);
		txtID.setForeground(C3);
		label.setForeground(C3);
		txtPass.setForeground(C3);
		pswrd.setForeground(C3);
		logBtn.setForeground(C1);
		CtBtn.setForeground(C1);

		add(panel);

		setTitle("ȸ�� �α���");
		setVisible(true);
		setSize(500, 260);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	public static void main(String args[]) {
		new Login("", "", 0, "", "");
	}
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MovieSelect extends Panel{
	// ��ȭ ����Ʈ �г� ���� �� ��ư ����
	private JPanel movielistPanel = new JPanel();
	private JPanel submovielistPanel = new JPanel();
	private JButton[] movieslist = new JButton[36];
	
	// ��ȭ ����Ʈ�� ���� ���� �̹���
	private ImageIcon[] originalIcon = {
			new ImageIcon("imgs/12.png"),
			new ImageIcon("imgs/15.png"),
			new ImageIcon("imgs/19.png")
	};
	private Image[] originalImg = {
			originalIcon[0].getImage(),
			originalIcon[1].getImage(),
			originalIcon[2].getImage()
	};
	private Image changedImg[] = {
			originalImg[0].getScaledInstance(30, 30, Image.SCALE_SMOOTH),
			originalImg[1].getScaledInstance(30, 30, Image.SCALE_SMOOTH),
			originalImg[2].getScaledInstance(30, 30, Image.SCALE_SMOOTH)
	};
	private ImageIcon[] img = {
			new ImageIcon(changedImg[0]), 
			new ImageIcon(changedImg[1]), 
			new ImageIcon(changedImg[2])
	};
	
	
	public int changemoive;
	private String[] movielist = new String[18]; // ��ȭ ��� 
	private String[] movieage = new String[18]; // ��ȭ �������� ������ �����ϱ� ����
	private int count = 0; // ��ȭ ����� ���� ������ �����ϱ� ���� count
	
	// ��ȭ ���� �г�
	private JPanel movietheaterPanel = new JPanel();
	private JPanel submovietheaterPanel = new JPanel();
	
	// ������ ��Ÿ�������� ��ҵ�
	private JButton[] city = new JButton[22];
	private int changeleft=0;
	private int changeright=1;// ���ÿ� ���� �ȿ� ����
	private int thcount = 1; // ��ȭ ���� ������ �����ϱ� ���� count
	
	 // ��ȭ �� ��¥ �г�
	private JPanel moviedatatPanel = new JPanel();
	private JPanel submoviedataPanel = new JPanel();
	
	// ��ȱ �� ��¥�� ��Ÿ�������� ��ҵ�
	private JButton[] data = new JButton[31];
	private String day = "��";
	public int changedata = 0;
	public int moviedataselect = 0; // ��ȭ ��¥  ������
	
	// ��ȭ �ð�ǥ �г�
	private JPanel movietimePanel = new JPanel();
	public JPanel submovietimePanel = new JPanel();
	
	// ��ȭ �ð�ǥ�� ��Ÿ�������� ��ҵ�
	private JLabel[] seat = new JLabel[5];
	private JButton[] time = new JButton[5];
	private int changetime = 0; // ��ȭ �ð�ǥ ������
	private JButton[] selectperson = new JButton[10];
	private int changeperson = 0; // 
	
	// �Ʒ��� �г�
	private JPanel movieintroducePanel = new JPanel();
	private JPanel movielistselectPanel = new JPanel();
	private JPanel movietheaterselectPanel = new JPanel();
	private JPanel movieseatselectPanel = new JPanel();
	
	// �Ʒ��� �г� : �ʱ�ȭ���� ���� �͵�
	private JLabel selectmoviela = new JLabel("��ȭ����");
	private JLabel selecttheaterla = new JLabel("���弱��");
	private JButton movieseatbtn = new JButton();
	private ImageIcon beforeseat = new ImageIcon("imgs/beforeseat.png");
	
	// �Ʒ��� �г� : ��ȭ ������ Ŭ�� ��
	private ImageIcon[] selectmovieimg = {
			new ImageIcon("imgs/���ĵ�.jpg"),
			new ImageIcon("imgs/���� �״� ��.jpg"),
			new ImageIcon("imgs/�ٸ���.jpg"),
			new ImageIcon("imgs/�㺸.jpg"),
			new ImageIcon("imgs/����.jpg"),
			new ImageIcon("imgs/������Ʈ.jpg"),
			new ImageIcon("imgs/������.jpg"),
			new ImageIcon("imgs/�ٽ��Ϻ�.jpg"),
			new ImageIcon("imgs/�����׷�.jpg"),
			new ImageIcon("imgs/���;��Ϸ���.jpg"),
			new ImageIcon("imgs/�ֺ��ȯ.jpg"),
			new ImageIcon("imgs/���÷���.jpg"),
			new ImageIcon("imgs/���۸ӽ�.jpg"),
			new ImageIcon("imgs/�ڸ�.jpg"),
			new ImageIcon("imgs/ŷ����������.jpg"),
			new ImageIcon("imgs/�����̵�������.jpg"),
			new ImageIcon("imgs/�׽���.jpg"),
			new ImageIcon("imgs/�������� �뷡.jpg"),
	}; // ��ȭ ���ý� ��ȭ ������ ���
	private JLabel printselectmoviela = new JLabel();
	private JLabel printselectmovienamela = new JLabel();
	private JLabel printselecttheaterla = new JLabel();
	private JLabel printselecttimela = new JLabel();
	private JLabel printselectpersonla = new JLabel();
	private ImageIcon afterseat = new ImageIcon("imgs/afterseat.png");
	private int logincount = 0;
	
	private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; //����̹�
	private final String DB_URL = "jdbc:mysql://localhost/movie_db?&useSSL=false"; //������ DB ����
		
	private final String USER_NAME = "root"; //DB�� ������ ����� �̸��� ����� ����
	private final String PASSWORD = "6126"; //������� ��й�ȣ�� ����� ����
	
	private Login login;
	
	// ��ȭ ����Ʈ ������ ������ ���� �ҽ��ڵ�(movie ���̺�)
	public void DBMovieList() {
		Connection conn = null;
		Statement state = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			state = conn.createStatement();
			
			String sql;
			sql = "SELECT * FROM movie";
			ResultSet rs = state.executeQuery(sql);
			
		    while(rs.next()){
		    	movielist[count] = rs.getString("oname");
				movieage[count] = rs.getString("age");
				count++;
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
	
	// ��ȭ ���� ������ ������ ���� �ҽ��ڵ�(moviecon ���̺�)
	public void DBMovieTheater() {
		Connection conn = null;
		Statement state = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			state = conn.createStatement();
			
			String sql;
			sql = "SELECT * FROM moviecon";
			ResultSet rs = state.executeQuery(sql);
			
	    	for(int i=0; i<city.length; i++) {
	    		if(i % 2 == 1) {
	    			city[i].setText(" ");
	    		}
	    	}
	    	thcount = 1;
			
		    while(rs.next()){
		    	int k = rs.getInt("connum");
		    	String qname = "";
		    	
		    	if(changeleft == 0 && k < 12) { // ����
		    		qname = rs.getString("qname");
		    		city[thcount].setText(qname);
		    		thcount = thcount + 2;
		    	}
		    	else if(changeleft == 2 && k >= 12 && k < 23) { // ���
		    		qname = rs.getString("qname");
		    		city[thcount].setText(qname);
		    		thcount = thcount + 2;
		    	}
		    	else if(changeleft == 4 && k >= 23 && k < 31) { // ��õ
		    		qname = rs.getString("qname");
		    		city[thcount].setText(qname);
		    		thcount = thcount + 2;
		    	}
		    	else if(changeleft == 6 && k >= 31 && k < 34) { //����
		    		qname = rs.getString("qname");
		    		city[thcount].setText(qname);
		    		thcount = thcount + 2;
		    	}
		    	else if(changeleft == 8 && k >= 34 && k < 45) { // ����/��û
		    		qname = rs.getString("qname");
		    		city[thcount].setText(qname);
		    		thcount = thcount + 2;
		    	}
		    	else if(changeleft == 10 && k >= 45 && k < 52) { // �뱸
		    		qname = rs.getString("qname");
		    		city[thcount].setText(qname);
		    		thcount = thcount + 2;
		    	}
		    	else if(changeleft == 12 && k >= 52 && k < 63) { // �λ�,���
		    		qname = rs.getString("qname");
		    		city[thcount].setText(qname);
		    		thcount = thcount + 2;
		    	}
		    	else if(changeleft == 14 && k >= 63 && k < 74) { // ���
		    		qname = rs.getString("qname");
		    		city[thcount].setText(qname);
		    		thcount = thcount + 2;
		    	}
		    	else if(changeleft == 16 && k >= 74 && k < 85) { // ����/����/����
		    		qname = rs.getString("qname");
		    		city[thcount].setText(qname);
		    		thcount = thcount + 2;
		    	}
		    	
		    	if(thcount > 21) {
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
	
	public MovieSelect(){
		DBMovieList();
				
		movielistPanel.setLayout(new BorderLayout());
		movielistPanel.setPreferredSize(new Dimension(265,700));
		
		JLabel movielistla = new JLabel("��ȭ");
		movielistla.setHorizontalAlignment(JLabel.CENTER);
		movielistla.setBackground(Color.black);
		movielistla.setForeground(Color.white);
		movielistla.setOpaque(true);
		
		submovielistPanel.setLayout(new GridLayout(36, 1));
		submovielistPanel.setBackground(new Color(255, 255, 255));
		
		for(int i=0; i<movielist.length; i++) {
			if(movieage[i].equals("12")) {
				movieslist[i] = new JButton(" " + movielist[i], img[0]);
			}
			else if(movieage[i].equals("15")) {
				movieslist[i] = new JButton(" " + movielist[i], img[1]);
			}
			else {
				movieslist[i] = new JButton(" " + movielist[i], img[2]);
			}
			movieslist[i].setBorderPainted(false);
			movieslist[i].setHorizontalAlignment(JButton.LEFT);
			movieslist[i].setPreferredSize(new Dimension(200, 40));
			movieslist[i].setBackground(new Color(255, 255, 255));
			submovielistPanel.add(movieslist[i]);
			
			int change = i;
			movieslist[change].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					movieslist[changemoive].setBackground(new Color(255,255, 255));
					movieslist[changemoive].setForeground(Color.BLACK);
					
					movieslist[change].setBackground(new Color(000, 051, 051));
					movieslist[change].setForeground(Color.WHITE);
					movieslist[change].setFocusPainted(false);
					
					changemoive = change;
					selectmoviela.setVisible(false);
					printselectmoviela.setIcon(selectmovieimg[change]);
					selecttheaterla.setVisible(false);
					printselectmovienamela.setText("               ��ȭ  >   " + movieslist[changemoive].getText());
				}
			});
		}
		// ��ȭ ����Ʈ�� ���� �ҽ��ڵ�
		
		movietheaterPanel.setLayout(new BorderLayout());
		movietheaterPanel.setPreferredSize(new Dimension(265,700));
		
		JLabel movietheaterla = new JLabel("����");
		movietheaterla.setHorizontalAlignment(JLabel.CENTER);
		movietheaterla.setBackground(Color.black);
		movietheaterla.setForeground(Color.white);
		movietheaterla.setOpaque(true);
		
		submovietheaterPanel.setLayout(new FlowLayout());
		submovietheaterPanel.setBackground(new Color(255,255, 255));
		city[0] = new JButton("����");
		city[1] = new JButton("����");
		city[2] = new JButton("���");
		city[3] = new JButton("����");
		city[4] = new JButton("��õ");
		city[5] = new JButton("�Ǵ��Ա�");
		city[6] = new JButton("����");
		city[7] = new JButton("����");
		city[8] = new JButton("����/��û");
		city[9] = new JButton("���빮");
		city[10] = new JButton("�뱸");
		city[11] = new JButton("��");
		city[12] = new JButton("�λ�/���");
		city[13] = new JButton("��");
		city[14] = new JButton("���");
		city[15] = new JButton("�̾�");
		city[16] = new JButton("����/����/����");
		city[17] = new JButton("�ұ�");
		city[18] = new JButton(" ");
		city[19] = new JButton("���");
		city[20] = new JButton(" ");
		city[21] = new JButton("���ſ����Ա�");
		
		for(int i=0; i<city.length; i++) {
			submovietheaterPanel.add(city[i]);
			city[i].setPreferredSize(new Dimension(125, 40));
			
			int select = i;
			if(i % 2 == 0) {
				city[i].setHorizontalAlignment(JLabel.RIGHT);
				city[i].setBackground(new Color(255, 231, 200));
				city[i].setBorderPainted(false);
				city[i].setFont(new Font("����", Font.PLAIN, 15));
				
				city[i].addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						city[changeleft].setBackground(new Color(255, 231, 200));
						
						city[select].setBackground(new Color(255,255, 255));
						city[select].setFocusPainted(false);
						
						changeleft = select;
						
						city[changeright].setBackground(new Color(255,255, 255));
						city[changeright].setForeground(Color.black);
						
						DBMovieTheater(); // ���ø� �������� �� ���ú��� ������ ����
					}
				});
			}
			else {
				city[i].setHorizontalAlignment(JLabel.LEFT);
				city[i].setBackground(new Color(255,255, 255));
				city[i].setBorderPainted(false);
				
				city[i].addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						if(changeright > 0) {
							city[changeright].setBackground(new Color(255, 255, 255));
							city[changeright].setForeground(Color.black);
						}
						city[select].setBackground(new Color(000, 051, 051));
						city[select].setForeground(Color.white);
						city[select].setFocusPainted(false);
						changeright = select;
						
						selecttheaterla.setVisible(false);
						printselecttheaterla.setText("               ����  >    CGV " + city[changeright].getText());
					}
				});
			}
		}
		// ��ȭ ���忡 ���� �ҽ� �ڵ�
		
		moviedatatPanel.setLayout(new BorderLayout());
		moviedatatPanel.setPreferredSize(new Dimension(125,700));
		
		JLabel moviedatala = new JLabel("��¥");
		moviedatala.setHorizontalAlignment(JLabel.CENTER);
		moviedatala.setBackground(Color.black);
		moviedatala.setForeground(Color.white);
		moviedatala.setOpaque(true);
		
		submoviedataPanel.setLayout(new GridLayout(31, 1));
		submoviedataPanel.setBackground(new Color(255,255, 255));
		for(int i=0; i<data.length; i++) {
			int k = i % 7;
			switch(k) {
				case 0: day = "��";
				break;
				case 1: day = "��";
				break;
				case 2: day = "ȭ";
				break;
				case 3: day = "��";
				break;
				case 4: day = "��";
				break;
				case 5: day = "��";
				break;
				case 6: day = "��";
				break;	
			}
			
			data[i] = new JButton(day + "      " + Integer.toString(i+1));
			data[i].setFont(new Font("Arila", Font.BOLD, 18));
			data[i].setHorizontalAlignment(JButton.LEFT);
			data[i].setPreferredSize(new Dimension(105, 40));
			data[i].setBackground(new Color(255,255, 255));
			data[i].setBorderPainted(false);
	
			submoviedataPanel.add(data[i], BorderLayout.CENTER);
			int select = i;
			data[select].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					data[changedata].setBackground(new Color(255,255, 255));
					data[changedata].setForeground(Color.black);
					
					data[select].setBackground(new Color(000, 051, 051));
					data[select].setForeground(Color.white);
					data[select].setFocusPainted(false);
					changedata = select;

					moviedataselect++;
					if(moviedataselect > 0) {
						for(int i=0; i<time.length; i++) {
							time[i].setVisible(true);
							seat[i].setVisible(true);
							time[changetime].setBackground(new Color(255,255, 255));
							time[changetime].setForeground(Color.BLACK);
						}
					}
				}
			});
		}
		// ��ȭ ��¥�� ���� �ҽ� �ڵ�
		
		movietimePanel.setLayout(new BorderLayout());
		movietimePanel.setPreferredSize(new Dimension(405,700));
		
		JLabel movietimela = new JLabel("�ð�");
		movietimela.setHorizontalAlignment(JLabel.CENTER);
		movietimela.setBackground(Color.black);
		movietimela.setForeground(Color.white);
		movietimela.setOpaque(true);
		
		submovietimePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
		submovietimePanel.setBackground(new Color(255,255, 255));

		time[0] = new JButton("12:00");
		time[1] = new JButton("14:00");
		time[2] = new JButton("16:00");
		time[3] = new JButton("18:00");
		time[4] = new JButton("20:00");
		seat[0] = new JLabel("350��");
		seat[1] = new JLabel("350��");
		seat[2] = new JLabel("350��");
		seat[3] = new JLabel("350��");
		seat[4] = new JLabel("350��");
		
		for(int i=0; i<time.length; i++) {
			time[i].setBackground(new Color(255,255, 255));
			time[i].setFont(new Font("Arila", Font.BOLD, 13));
			time[i].setVisible(false);
			seat[i].setVisible(false);
			submovietimePanel.add(time[i]);
			submovietimePanel.add(seat[i]);
			
			int select = i;
			time[select].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					time[changetime].setBackground(new Color(255,255, 255));
					time[changetime].setForeground(Color.BLACK);
					
					time[select].setBackground(new Color(000, 051, 051));
					time[select].setForeground(Color.WHITE);
					time[select].setFocusPainted(false);
					
					changetime = select;
					printselecttimela.setText("               �Ͻ�  >    2020.11." + (changedata + 1) + 
							"(" + data[changedata].getText().substring(0,1) + ")" + " " + time[changetime].getText());
				}
			});
		}
		
		JLabel moviepersonla = new JLabel("�ο�����");
		moviepersonla.setHorizontalAlignment(JLabel.CENTER);
		moviepersonla.setBackground(Color.black);
		moviepersonla.setForeground(Color.white);
		moviepersonla.setOpaque(true);
		moviepersonla.setPreferredSize(new Dimension(385,18));
		
		submovietimePanel.add(moviepersonla);
		
		for(int i=0; i<selectperson.length; i++) {
			selectperson[i] = new JButton(Integer.toString(i + 1));
			selectperson[i].setBackground(new Color(255,255, 255));
			selectperson[i].setPreferredSize(new Dimension(60,30));
			submovietimePanel.add(selectperson[i]);
			
			int person = i;
			selectperson[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					selectperson[changeperson].setBackground(new Color(255,255, 255));
					selectperson[changeperson].setForeground(Color.BLACK);
					
					selectperson[person].setBackground(new Color(000, 051, 051));
					selectperson[person].setForeground(Color.WHITE);
					selectperson[person].setFocusPainted(false);
					
					changeperson = person;
					
					printselectpersonla.setText("               �ο�  >    " + selectperson[person].getText() + "��");
					movieseatbtn.setIcon(afterseat);
				}
			});
		}
		// ��ȭ �ð�ǥ�� ���� �ҽ� �ڵ�
		
		movieintroducePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		movieintroducePanel.setBackground(Color.BLACK);
		movieintroducePanel.setPreferredSize(new Dimension(1130, 210));
		// �Ʒ��� �г� Ʋ �ҽ��ڵ�
		
		movielistselectPanel.setPreferredSize(new Dimension(370, 210));
		movielistselectPanel.setBackground(Color.black);
		selectmoviela.setPreferredSize(new Dimension(370, 150));
		selectmoviela.setVerticalAlignment(JLabel.CENTER);
		selectmoviela.setHorizontalAlignment(JLabel.CENTER);
		selectmoviela.setFont(new Font("Arila", Font.PLAIN, 35));
		printselectmoviela.setPreferredSize(new Dimension(300, 170));

		movielistselectPanel.add(selectmoviela);
		movielistselectPanel.add(printselectmoviela);
		// ��ȭ �̼���  �Ǵ� ���ý� �Ʒ��� �г� ����Ǵ� �ҽ��ڵ�(�Ʒ��� �г��� ���ʺκ�)
		
		movietheaterselectPanel.setPreferredSize(new Dimension(370, 210));
		movietheaterselectPanel.setBackground(Color.BLACK);
		selecttheaterla.setPreferredSize(new Dimension(370, 150));
		selecttheaterla.setVerticalAlignment(JLabel.CENTER);
		selecttheaterla.setHorizontalAlignment(JLabel.CENTER);
		selecttheaterla.setFont(new Font("Arila", Font.PLAIN, 35));
		printselectmovienamela.setPreferredSize(new Dimension(370, 20));
		printselectmovienamela.setForeground(Color.white);
		printselecttheaterla.setPreferredSize(new Dimension(370, 20));
		printselecttheaterla.setForeground(Color.white);
		printselecttimela.setPreferredSize(new Dimension(370, 20));
		printselecttimela.setForeground(Color.white);
		printselectpersonla.setPreferredSize(new Dimension(370, 20));
		printselectpersonla.setForeground(Color.white);
		
		movietheaterselectPanel.add(selecttheaterla);
		movietheaterselectPanel.add(printselectmovienamela);
		movietheaterselectPanel.add(printselecttheaterla);
		movietheaterselectPanel.add(printselecttimela);
		movietheaterselectPanel.add(printselectpersonla);
		// ��ȭ �̸�, ���� �̸�, ���� ����ϴ� �ҽ��ڵ�(�Ʒ��� �г��� �߰��κ�)
		
		movieseatselectPanel.setPreferredSize(new Dimension(370, 210));
		movieseatselectPanel.setBackground(Color.BLACK);
		movieseatbtn.setPreferredSize(new Dimension(370, 150));
		movieseatbtn.setVerticalAlignment(JLabel.CENTER);
		movieseatbtn.setHorizontalAlignment(JLabel.CENTER);
		movieseatbtn.setBackground(Color.BLACK);
		movieseatbtn.setBorderPainted(false);
		movieseatbtn.setIcon(beforeseat);
		
		movieseatbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(movieseatbtn.getIcon() == afterseat && logincount == 0) {
					login = new Login(movieslist[changemoive].getText(), city[changeright].getText(), 
							changedata + 1, time[changetime].getText(), selectperson[changeperson].getText());
				}
				else if(logincount > 0 && login.logincount != 0) {
						new Seat(movieslist[changemoive].getText(), city[changeright].getText(), 
								changedata + 1, time[changetime].getText(), selectperson[changeperson].getText());	
				}
				else {
					login = new Login(movieslist[changemoive].getText(), city[changeright].getText(), 
							changedata + 1, time[changetime].getText(), selectperson[changeperson].getText());
				}
				logincount++;
			}
		});
		
		movieseatselectPanel.add(movieseatbtn);
		// �¼����� ��ư(�Ʒ��� �г��� ������ �κ�)
		
		// ��ȭ �г�
		movielistPanel.add(movielistla, BorderLayout.NORTH);
		movielistPanel.add(new JScrollPane(submovielistPanel), BorderLayout.CENTER);
		
		// ���� �г�
		movietheaterPanel.add(movietheaterla, BorderLayout.NORTH);
		movietheaterPanel.add(submovietheaterPanel, BorderLayout.CENTER);
		
		// ��¥ �г�
		moviedatatPanel.add(moviedatala, BorderLayout.NORTH);
		moviedatatPanel.add(new JScrollPane(submoviedataPanel), BorderLayout.CENTER);
		
		// �ð� �г�
		movietimePanel.add(movietimela, BorderLayout.NORTH);
		movietimePanel.add(submovietimePanel, BorderLayout.CENTER);

		
		// �Ʒ��� �г�
		movieintroducePanel.add(movielistselectPanel);
		movieintroducePanel.add(movietheaterselectPanel);
		movieintroducePanel.add(movieseatselectPanel);
		
		// ���� ū �гο� �гε� �߰�
		add(movielistPanel);
		add(movietheaterPanel);
		add(moviedatatPanel);
		add(movietimePanel);
		add(movieintroducePanel);
	}

}
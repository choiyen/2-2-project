import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MovieSelect extends Panel{
	// 영화 리스트 패널 생성 및 버튼 생성
	private JPanel movielistPanel = new JPanel();
	private JPanel submovielistPanel = new JPanel();
	private JButton[] movieslist = new JButton[36];
	
	// 영화 리스트의 나이 제한 이미지
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
	private String[] movielist = new String[18]; // 영화 목록 
	private String[] movieage = new String[18]; // 영화 나이제한 데이터 연동하기 위해
	private int count = 0; // 영화 제목과 연령 데이터 연동하기 위한 count
	
	// 영화 극장 패널
	private JPanel movietheaterPanel = new JPanel();
	private JPanel submovietheaterPanel = new JPanel();
	
	// 극장을 나타내기위한 요소들
	private JButton[] city = new JButton[22];
	private int changeleft=0;
	private int changeright=1;// 도시와 도시 안에 극장
	private int thcount = 1; // 영화 극장 데이터 연동하기 위한 count
	
	 // 영화 상영 날짜 패널
	private JPanel moviedatatPanel = new JPanel();
	private JPanel submoviedataPanel = new JPanel();
	
	// 영홧 상영 날짜를 나타내기위한 요소들
	private JButton[] data = new JButton[31];
	private String day = "월";
	public int changedata = 0;
	public int moviedataselect = 0; // 영화 날짜  데이터
	
	// 영화 시간표 패널
	private JPanel movietimePanel = new JPanel();
	public JPanel submovietimePanel = new JPanel();
	
	// 영화 시간표를 나타내기위한 요소들
	private JLabel[] seat = new JLabel[5];
	private JButton[] time = new JButton[5];
	private int changetime = 0; // 영화 시간표 데이터
	private JButton[] selectperson = new JButton[10];
	private int changeperson = 0; // 
	
	// 아래쪽 패널
	private JPanel movieintroducePanel = new JPanel();
	private JPanel movielistselectPanel = new JPanel();
	private JPanel movietheaterselectPanel = new JPanel();
	private JPanel movieseatselectPanel = new JPanel();
	
	// 아래쪽 패널 : 초기화면을 위한 것들
	private JLabel selectmoviela = new JLabel("영화선택");
	private JLabel selecttheaterla = new JLabel("극장선택");
	private JButton movieseatbtn = new JButton();
	private ImageIcon beforeseat = new ImageIcon("imgs/beforeseat.png");
	
	// 아래쪽 패널 : 영화 정보들 클릭 시
	private ImageIcon[] selectmovieimg = {
			new ImageIcon("imgs/걸후드.jpg"),
			new ImageIcon("imgs/내가 죽던 날.jpg"),
			new ImageIcon("imgs/다만악.jpg"),
			new ImageIcon("imgs/담보.jpg"),
			new ImageIcon("imgs/도굴.jpg"),
			new ImageIcon("imgs/레버넌트.jpg"),
			new ImageIcon("imgs/렛힘고.jpg"),
			new ImageIcon("imgs/바스켓볼.jpg"),
			new ImageIcon("imgs/삼진그룹.jpg"),
			new ImageIcon("imgs/셔터아일랜드.jpg"),
			new ImageIcon("imgs/애비규환.jpg"),
			new ImageIcon("imgs/위플래쉬.jpg"),
			new ImageIcon("imgs/인퍼머스.jpg"),
			new ImageIcon("imgs/코마.jpg"),
			new ImageIcon("imgs/킹오브프리즘.jpg"),
			new ImageIcon("imgs/프라이드더히어로.jpg"),
			new ImageIcon("imgs/테슬라.jpg"),
			new ImageIcon("imgs/힐빌리의 노래.jpg"),
	}; // 영화 선택시 영화 포스터 출력
	private JLabel printselectmoviela = new JLabel();
	private JLabel printselectmovienamela = new JLabel();
	private JLabel printselecttheaterla = new JLabel();
	private JLabel printselecttimela = new JLabel();
	private JLabel printselectpersonla = new JLabel();
	private ImageIcon afterseat = new ImageIcon("imgs/afterseat.png");
	private int logincount = 0;
	
	private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; //드라이버
	private final String DB_URL = "jdbc:mysql://localhost/movie_db?&useSSL=false"; //접속할 DB 서버
		
	private final String USER_NAME = "root"; //DB에 접속할 사용자 이름을 상수로 정의
	private final String PASSWORD = "6126"; //사용자의 비밀번호를 상수로 정의
	
	private Login login;
	
	// 영화 리스트 데이터 연동을 위한 소스코드(movie 테이블)
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
	
	// 영화 극장 데이터 연동을 위한 소스코드(moviecon 테이블)
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
		    	
		    	if(changeleft == 0 && k < 12) { // 서울
		    		qname = rs.getString("qname");
		    		city[thcount].setText(qname);
		    		thcount = thcount + 2;
		    	}
		    	else if(changeleft == 2 && k >= 12 && k < 23) { // 경기
		    		qname = rs.getString("qname");
		    		city[thcount].setText(qname);
		    		thcount = thcount + 2;
		    	}
		    	else if(changeleft == 4 && k >= 23 && k < 31) { // 인천
		    		qname = rs.getString("qname");
		    		city[thcount].setText(qname);
		    		thcount = thcount + 2;
		    	}
		    	else if(changeleft == 6 && k >= 31 && k < 34) { //강원
		    		qname = rs.getString("qname");
		    		city[thcount].setText(qname);
		    		thcount = thcount + 2;
		    	}
		    	else if(changeleft == 8 && k >= 34 && k < 45) { // 대전/충청
		    		qname = rs.getString("qname");
		    		city[thcount].setText(qname);
		    		thcount = thcount + 2;
		    	}
		    	else if(changeleft == 10 && k >= 45 && k < 52) { // 대구
		    		qname = rs.getString("qname");
		    		city[thcount].setText(qname);
		    		thcount = thcount + 2;
		    	}
		    	else if(changeleft == 12 && k >= 52 && k < 63) { // 부산,울산
		    		qname = rs.getString("qname");
		    		city[thcount].setText(qname);
		    		thcount = thcount + 2;
		    	}
		    	else if(changeleft == 14 && k >= 63 && k < 74) { // 경상
		    		qname = rs.getString("qname");
		    		city[thcount].setText(qname);
		    		thcount = thcount + 2;
		    	}
		    	else if(changeleft == 16 && k >= 74 && k < 85) { // 광주/전라/제주
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
		
		JLabel movielistla = new JLabel("영화");
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
					printselectmovienamela.setText("               영화  >   " + movieslist[changemoive].getText());
				}
			});
		}
		// 영화 리스트에 관한 소스코드
		
		movietheaterPanel.setLayout(new BorderLayout());
		movietheaterPanel.setPreferredSize(new Dimension(265,700));
		
		JLabel movietheaterla = new JLabel("극장");
		movietheaterla.setHorizontalAlignment(JLabel.CENTER);
		movietheaterla.setBackground(Color.black);
		movietheaterla.setForeground(Color.white);
		movietheaterla.setOpaque(true);
		
		submovietheaterPanel.setLayout(new FlowLayout());
		submovietheaterPanel.setBackground(new Color(255,255, 255));
		city[0] = new JButton("서울");
		city[1] = new JButton("강남");
		city[2] = new JButton("경기");
		city[3] = new JButton("강변");
		city[4] = new JButton("인천");
		city[5] = new JButton("건대입구");
		city[6] = new JButton("강원");
		city[7] = new JButton("구로");
		city[8] = new JButton("대전/충청");
		city[9] = new JButton("동대문");
		city[10] = new JButton("대구");
		city[11] = new JButton("명동");
		city[12] = new JButton("부산/울산");
		city[13] = new JButton("목동");
		city[14] = new JButton("경상");
		city[15] = new JButton("미아");
		city[16] = new JButton("광주/전라/제주");
		city[17] = new JButton("불광");
		city[18] = new JButton(" ");
		city[19] = new JButton("상봉");
		city[20] = new JButton(" ");
		city[21] = new JButton("성신여대입구");
		
		for(int i=0; i<city.length; i++) {
			submovietheaterPanel.add(city[i]);
			city[i].setPreferredSize(new Dimension(125, 40));
			
			int select = i;
			if(i % 2 == 0) {
				city[i].setHorizontalAlignment(JLabel.RIGHT);
				city[i].setBackground(new Color(255, 231, 200));
				city[i].setBorderPainted(false);
				city[i].setFont(new Font("굴림", Font.PLAIN, 15));
				
				city[i].addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						city[changeleft].setBackground(new Color(255, 231, 200));
						
						city[select].setBackground(new Color(255,255, 255));
						city[select].setFocusPainted(false);
						
						changeleft = select;
						
						city[changeright].setBackground(new Color(255,255, 255));
						city[changeright].setForeground(Color.black);
						
						DBMovieTheater(); // 도시를 선택했을 때 도시별로 극장이 수정
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
						printselecttheaterla.setText("               극장  >    CGV " + city[changeright].getText());
					}
				});
			}
		}
		// 영화 극장에 대한 소스 코드
		
		moviedatatPanel.setLayout(new BorderLayout());
		moviedatatPanel.setPreferredSize(new Dimension(125,700));
		
		JLabel moviedatala = new JLabel("날짜");
		moviedatala.setHorizontalAlignment(JLabel.CENTER);
		moviedatala.setBackground(Color.black);
		moviedatala.setForeground(Color.white);
		moviedatala.setOpaque(true);
		
		submoviedataPanel.setLayout(new GridLayout(31, 1));
		submoviedataPanel.setBackground(new Color(255,255, 255));
		for(int i=0; i<data.length; i++) {
			int k = i % 7;
			switch(k) {
				case 0: day = "일";
				break;
				case 1: day = "월";
				break;
				case 2: day = "화";
				break;
				case 3: day = "수";
				break;
				case 4: day = "목";
				break;
				case 5: day = "금";
				break;
				case 6: day = "토";
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
		// 영화 날짜에 대한 소스 코드
		
		movietimePanel.setLayout(new BorderLayout());
		movietimePanel.setPreferredSize(new Dimension(405,700));
		
		JLabel movietimela = new JLabel("시간");
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
		seat[0] = new JLabel("350석");
		seat[1] = new JLabel("350석");
		seat[2] = new JLabel("350석");
		seat[3] = new JLabel("350석");
		seat[4] = new JLabel("350석");
		
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
					printselecttimela.setText("               일시  >    2020.11." + (changedata + 1) + 
							"(" + data[changedata].getText().substring(0,1) + ")" + " " + time[changetime].getText());
				}
			});
		}
		
		JLabel moviepersonla = new JLabel("인원선택");
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
					
					printselectpersonla.setText("               인원  >    " + selectperson[person].getText() + "명");
					movieseatbtn.setIcon(afterseat);
				}
			});
		}
		// 영화 시간표에 대한 소스 코드
		
		movieintroducePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		movieintroducePanel.setBackground(Color.BLACK);
		movieintroducePanel.setPreferredSize(new Dimension(1130, 210));
		// 아래쪽 패널 틀 소스코드
		
		movielistselectPanel.setPreferredSize(new Dimension(370, 210));
		movielistselectPanel.setBackground(Color.black);
		selectmoviela.setPreferredSize(new Dimension(370, 150));
		selectmoviela.setVerticalAlignment(JLabel.CENTER);
		selectmoviela.setHorizontalAlignment(JLabel.CENTER);
		selectmoviela.setFont(new Font("Arila", Font.PLAIN, 35));
		printselectmoviela.setPreferredSize(new Dimension(300, 170));

		movielistselectPanel.add(selectmoviela);
		movielistselectPanel.add(printselectmoviela);
		// 영화 미선택  또는 선택시 아래쪽 패널 변경되는 소스코드(아래쪽 패널의 왼쪽부분)
		
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
		// 영화 이름, 극장 이름, 일자 출력하는 소스코드(아래쪽 패널의 중간부분)
		
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
		// 좌석선택 버튼(아래쪽 패널의 오른쪽 부분)
		
		// 영화 패널
		movielistPanel.add(movielistla, BorderLayout.NORTH);
		movielistPanel.add(new JScrollPane(submovielistPanel), BorderLayout.CENTER);
		
		// 극장 패널
		movietheaterPanel.add(movietheaterla, BorderLayout.NORTH);
		movietheaterPanel.add(submovietheaterPanel, BorderLayout.CENTER);
		
		// 날짜 패널
		moviedatatPanel.add(moviedatala, BorderLayout.NORTH);
		moviedatatPanel.add(new JScrollPane(submoviedataPanel), BorderLayout.CENTER);
		
		// 시간 패널
		movietimePanel.add(movietimela, BorderLayout.NORTH);
		movietimePanel.add(submovietimePanel, BorderLayout.CENTER);

		
		// 아래쪽 패널
		movieintroducePanel.add(movielistselectPanel);
		movieintroducePanel.add(movietheaterselectPanel);
		movieintroducePanel.add(movieseatselectPanel);
		
		// 가장 큰 패널에 패널들 추가
		add(movielistPanel);
		add(movietheaterPanel);
		add(moviedatatPanel);
		add(movietimePanel);
		add(movieintroducePanel);
	}

}
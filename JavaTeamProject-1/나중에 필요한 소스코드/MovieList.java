import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;

public class MovieList extends Panel{
	private JPanel movielistPanel = new JPanel();
	private JPanel submovielistPanel = new JPanel();
	private JButton[] movieslist = new JButton[36]; // 영화 리스트 패널 생성 및 버튼 생성
	
	private ImageIcon originalIcon = new ImageIcon("imgs/15.png");
	private Image originalImg = originalIcon.getImage();
	private Image changedImg = originalImg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private ImageIcon img = new ImageIcon(changedImg); // 영화 리스트의 나이 제한 이미지
	
	public int changemoive;
	private String[] movielist = {
			"탐보", "언힌지드", "어디갔어, 버나뎃", "테넷", 
			"브레이크더사일런스", "그린랜드", "국제수사", "죽지않은 인간들의 밤",
			"탐보", "언힌지드", "어디갔어, 버나뎃", "테넷", 
			"브레이크더사일런스", "그린랜드", "국제수사", "죽지않은 인간들의 밤",
			"탐보", "언힌지드", "어디갔어, 버나뎃", "테넷", 
			"브레이크더사일런스", "그린랜드", "국제수사", "죽지않은 인간들의 밤",
			"탐보", "언힌지드", "어디갔어, 버나뎃", "테넷", 
			"브레이크더사일런스", "그린랜드", "국제수사", "죽지않은 인간들의 밤",
	}; // 영화 목록 
	
	private JPanel movietheaterPanel = new JPanel();
	private JPanel submovietheaterPanel = new JPanel(); // 영화 극장 패널
	
	private JButton[] city = new JButton[22];
	private int changeleft=0;
	private int changeright=1;// 도시와 도시 안에 극장
	
	private JPanel moviedatatPanel = new JPanel();
	private JPanel submoviedataPanel = new JPanel(); // 영화 상영 날짜 패널
	
	private JButton[] data = new JButton[31];
	private String day = "월";
	public int changedata = 0;
	public int moviedataselect = 0; // 영화 날짜  데이터
	
	private JPanel movietimePanel = new JPanel();
	public JPanel submovietimePanel = new JPanel(); // 영화 시간표 패널
	
	private JButton[] time = new JButton[5];
	private JLabel[] seat = new JLabel[5];
	private int changetime = 0; // 영화 시간표 데이터
	
	public MovieList(){
		movielistPanel.setLayout(new BorderLayout());
		movielistPanel.setPreferredSize(new Dimension(265,700));
		
		JLabel movielistla = new JLabel("영화");
		movielistla.setHorizontalAlignment(JLabel.CENTER);
		movielistla.setBackground(Color.black);
		movielistla.setForeground(Color.white);
		movielistla.setOpaque(true);
		
		submovielistPanel.setLayout(new GridLayout(36, 1));
		submovielistPanel.setBackground(new Color(233, 247, 222));
		
		for(int i=0; i<movielist.length; i++) {
			movieslist[i] = new JButton(movielist[i], img);
			movieslist[i].setBorderPainted(false);
			movieslist[i].setHorizontalAlignment(JButton.LEFT);
			movieslist[i].setPreferredSize(new Dimension(200, 40));
			movieslist[i].setBackground(new Color(233, 247, 222));
			submovielistPanel.add(movieslist[i]);
			
			int change = i;
			movieslist[change].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					movieslist[changemoive].setBackground(new Color(233, 247, 222));
					movieslist[changemoive].setForeground(Color.BLACK);
					
					movieslist[change].setBackground(new Color(000, 051, 051));
					movieslist[change].setForeground(Color.WHITE);
					movieslist[change].setFocusPainted(false);
					
					changemoive = change;
					// new Login(movieslist[change].getText());
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
		submovietheaterPanel.setBackground(new Color(233, 247, 222));
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
		city[13] = new JButton("명동역 씨네라이트");
		city[14] = new JButton("경상");
		city[15] = new JButton("목동");
		city[16] = new JButton("광주/전라/제주");
		city[17] = new JButton("미아");
		city[18] = new JButton(" ");
		city[19] = new JButton("불광");
		city[20] = new JButton(" ");
		city[21] = new JButton("상봉");
		
		for(int i=0; i<city.length; i++) {
			submovietheaterPanel.add(city[i]);
			city[i].setPreferredSize(new Dimension(125, 40));
			
			int select = i;
			if(i % 2 == 0) {
				city[i].setHorizontalAlignment(JLabel.RIGHT);
				city[i].setBackground(new Color(225, 225, 225));
				city[i].setBorderPainted(false);
				city[i].setFont(new Font("굴림", Font.PLAIN, 15));
				
				city[i].addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						city[changeleft].setBackground(new Color(225, 225, 225));
						
						city[select].setBackground(new Color(233, 247, 222));
						city[select].setFocusPainted(false);
						
						changeleft = select;
						
						city[changeright].setBackground(new Color(233, 247, 222));
						city[changeright].setForeground(Color.black);
						if(select == 0) {
							city[1].setText("강남");
							city[3].setText("강변");
							city[5].setText("건대입구");
							city[7].setText("구로");
							city[9].setText("동대문");
							city[11].setText("명동");
							city[13].setText("목동");
							city[15].setText("미아");
							city[17].setText("불광");
							city[19].setText("상봉");
							city[21].setText("성신여대입구");
						}
						else if(select == 2) {
							city[1].setText("경기광주");
							city[3].setText("고양행신");
							city[5].setText("광교");
							city[7].setText("광교상현");
							city[9].setText("구리");
							city[11].setText("김포운양");
							city[13].setText("김포풍무");
							city[15].setText("김포한강");
							city[17].setText("동백");
							city[19].setText("동수원");
							city[21].setText("동탄");
						}
					}
				});
			}
			else {
				city[i].setHorizontalAlignment(JLabel.LEFT);
				city[i].setBackground(new Color(233, 247, 222));
				city[i].setBorderPainted(false);
				
				city[i].addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						if(changeright > 0) {
							city[changeright].setBackground(new Color(233, 247, 222));
							city[changeright].setForeground(Color.black);
						}
						city[select].setBackground(new Color(000, 051, 051));
						city[select].setForeground(Color.white);
						city[select].setFocusPainted(false);
						changeright = select;
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
		submoviedataPanel.setBackground(new Color(233, 247, 222));
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
			data[i].setBackground(new Color(233, 247, 222));
			data[i].setBorderPainted(false);
	
			submoviedataPanel.add(data[i], BorderLayout.CENTER);
			int select = i;
			data[select].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					data[changedata].setBackground(new Color(233, 247, 222));
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
		submovietimePanel.setBackground(new Color(233, 247, 222));
		time[0] = new JButton("12:00");
		time[1] = new JButton("14:00");
		time[2] = new JButton("16:00");
		time[3] = new JButton("18:00");
		time[4] = new JButton("20:00");
		seat[0] = new JLabel("123석");
		seat[1] = new JLabel("123석");
		seat[2] = new JLabel("123석");
		seat[3] = new JLabel("123석");
		seat[4] = new JLabel("123석");
		for(int i=0; i<time.length; i++) {
			time[i].setBackground(new Color(233, 247, 222));
			time[i].setFont(new Font("Arila", Font.BOLD, 15));
			time[i].setVisible(false);
			seat[i].setVisible(false);
			submovietimePanel.add(time[i]);
			submovietimePanel.add(seat[i]);
			int select = i;
			time[select].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					time[changetime].setBackground(new Color(233, 247, 222));
					time[changetime].setForeground(Color.BLACK);
					
					time[select].setBackground(new Color(000, 051, 051));
					time[select].setForeground(Color.WHITE);
					time[select].setFocusPainted(false);
					
					changetime = select;
					new Login(movieslist[changemoive].getText(), city[changeright].getText(), time[changetime].getText());
				}
			});
		}
		// 영화 시간표에 대한 소스 코드
		
		movielistPanel.add(movielistla, BorderLayout.NORTH);
		movielistPanel.add(new JScrollPane(submovielistPanel), BorderLayout.CENTER);
		
		movietheaterPanel.add(movietheaterla, BorderLayout.NORTH);
		movietheaterPanel.add(submovietheaterPanel, BorderLayout.CENTER);
		
		moviedatatPanel.add(moviedatala, BorderLayout.NORTH);
		moviedatatPanel.add(new JScrollPane(submoviedataPanel), BorderLayout.CENTER);
		
		movietimePanel.add(movietimela, BorderLayout.NORTH);
		movietimePanel.add(submovietimePanel, BorderLayout.CENTER);
		
		add(movielistPanel);
		add(movietheaterPanel);
		add(moviedatatPanel);
		add(movietimePanel);
	}
}
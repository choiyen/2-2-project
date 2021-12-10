import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;

public class MovieList extends Panel{
	private JPanel movielistPanel = new JPanel();
	private JPanel submovielistPanel = new JPanel();
	private JButton[] movieslist = new JButton[36]; // ��ȭ ����Ʈ �г� ���� �� ��ư ����
	
	private ImageIcon originalIcon = new ImageIcon("imgs/15.png");
	private Image originalImg = originalIcon.getImage();
	private Image changedImg = originalImg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private ImageIcon img = new ImageIcon(changedImg); // ��ȭ ����Ʈ�� ���� ���� �̹���
	
	public int changemoive;
	private String[] movielist = {
			"Ž��", "��������", "��𰬾�, ������", "�׳�", 
			"�극��ũ�����Ϸ���", "�׸�����", "��������", "�������� �ΰ����� ��",
			"Ž��", "��������", "��𰬾�, ������", "�׳�", 
			"�극��ũ�����Ϸ���", "�׸�����", "��������", "�������� �ΰ����� ��",
			"Ž��", "��������", "��𰬾�, ������", "�׳�", 
			"�극��ũ�����Ϸ���", "�׸�����", "��������", "�������� �ΰ����� ��",
			"Ž��", "��������", "��𰬾�, ������", "�׳�", 
			"�극��ũ�����Ϸ���", "�׸�����", "��������", "�������� �ΰ����� ��",
	}; // ��ȭ ��� 
	
	private JPanel movietheaterPanel = new JPanel();
	private JPanel submovietheaterPanel = new JPanel(); // ��ȭ ���� �г�
	
	private JButton[] city = new JButton[22];
	private int changeleft=0;
	private int changeright=1;// ���ÿ� ���� �ȿ� ����
	
	private JPanel moviedatatPanel = new JPanel();
	private JPanel submoviedataPanel = new JPanel(); // ��ȭ �� ��¥ �г�
	
	private JButton[] data = new JButton[31];
	private String day = "��";
	public int changedata = 0;
	public int moviedataselect = 0; // ��ȭ ��¥  ������
	
	private JPanel movietimePanel = new JPanel();
	public JPanel submovietimePanel = new JPanel(); // ��ȭ �ð�ǥ �г�
	
	private JButton[] time = new JButton[5];
	private JLabel[] seat = new JLabel[5];
	private int changetime = 0; // ��ȭ �ð�ǥ ������
	
	public MovieList(){
		movielistPanel.setLayout(new BorderLayout());
		movielistPanel.setPreferredSize(new Dimension(265,700));
		
		JLabel movielistla = new JLabel("��ȭ");
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
		// ��ȭ ����Ʈ�� ���� �ҽ��ڵ�
		
		movietheaterPanel.setLayout(new BorderLayout());
		movietheaterPanel.setPreferredSize(new Dimension(265,700));
		
		JLabel movietheaterla = new JLabel("����");
		movietheaterla.setHorizontalAlignment(JLabel.CENTER);
		movietheaterla.setBackground(Color.black);
		movietheaterla.setForeground(Color.white);
		movietheaterla.setOpaque(true);
		
		submovietheaterPanel.setLayout(new FlowLayout());
		submovietheaterPanel.setBackground(new Color(233, 247, 222));
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
		city[13] = new JButton("���� ���׶���Ʈ");
		city[14] = new JButton("���");
		city[15] = new JButton("��");
		city[16] = new JButton("����/����/����");
		city[17] = new JButton("�̾�");
		city[18] = new JButton(" ");
		city[19] = new JButton("�ұ�");
		city[20] = new JButton(" ");
		city[21] = new JButton("���");
		
		for(int i=0; i<city.length; i++) {
			submovietheaterPanel.add(city[i]);
			city[i].setPreferredSize(new Dimension(125, 40));
			
			int select = i;
			if(i % 2 == 0) {
				city[i].setHorizontalAlignment(JLabel.RIGHT);
				city[i].setBackground(new Color(225, 225, 225));
				city[i].setBorderPainted(false);
				city[i].setFont(new Font("����", Font.PLAIN, 15));
				
				city[i].addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						city[changeleft].setBackground(new Color(225, 225, 225));
						
						city[select].setBackground(new Color(233, 247, 222));
						city[select].setFocusPainted(false);
						
						changeleft = select;
						
						city[changeright].setBackground(new Color(233, 247, 222));
						city[changeright].setForeground(Color.black);
						if(select == 0) {
							city[1].setText("����");
							city[3].setText("����");
							city[5].setText("�Ǵ��Ա�");
							city[7].setText("����");
							city[9].setText("���빮");
							city[11].setText("��");
							city[13].setText("��");
							city[15].setText("�̾�");
							city[17].setText("�ұ�");
							city[19].setText("���");
							city[21].setText("���ſ����Ա�");
						}
						else if(select == 2) {
							city[1].setText("��Ɽ��");
							city[3].setText("������");
							city[5].setText("����");
							city[7].setText("��������");
							city[9].setText("����");
							city[11].setText("�������");
							city[13].setText("����ǳ��");
							city[15].setText("�����Ѱ�");
							city[17].setText("����");
							city[19].setText("������");
							city[21].setText("��ź");
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
		// ��ȭ ���忡 ���� �ҽ� �ڵ�
		
		moviedatatPanel.setLayout(new BorderLayout());
		moviedatatPanel.setPreferredSize(new Dimension(125,700));
		
		JLabel moviedatala = new JLabel("��¥");
		moviedatala.setHorizontalAlignment(JLabel.CENTER);
		moviedatala.setBackground(Color.black);
		moviedatala.setForeground(Color.white);
		moviedatala.setOpaque(true);
		
		submoviedataPanel.setLayout(new GridLayout(31, 1));
		submoviedataPanel.setBackground(new Color(233, 247, 222));
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
		// ��ȭ ��¥�� ���� �ҽ� �ڵ�
		
		movietimePanel.setLayout(new BorderLayout());
		movietimePanel.setPreferredSize(new Dimension(405,700));
		JLabel movietimela = new JLabel("�ð�");
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
		seat[0] = new JLabel("123��");
		seat[1] = new JLabel("123��");
		seat[2] = new JLabel("123��");
		seat[3] = new JLabel("123��");
		seat[4] = new JLabel("123��");
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
		// ��ȭ �ð�ǥ�� ���� �ҽ� �ڵ�
		
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
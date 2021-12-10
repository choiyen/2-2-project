import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MovieTime extends Panel{
	private JPanel moviedatatPanel = new JPanel();
	private JPanel submoviedataPanel = new JPanel();
	
	private JButton[] data = new JButton[31];
	private String day = "월";
	public int changedata = 0;
	public int moviedataselect = 0;
	
	private JPanel movietimePanel = new JPanel();
	public JPanel submovietimePanel = new JPanel(); 
	private JButton[] time = new JButton[5];
	private JLabel[] seat = new JLabel[5];
	private int changetime = 0;
	
	public MovieTime() {
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
				}
			});
		}
		
		moviedatatPanel.add(moviedatala, BorderLayout.NORTH);
		moviedatatPanel.add(new JScrollPane(submoviedataPanel), BorderLayout.CENTER);
		
		movietimePanel.add(movietimela, BorderLayout.NORTH);
		movietimePanel.add(submovietimePanel, BorderLayout.CENTER);
		
		add(moviedatatPanel);
		add(movietimePanel);
	}
}

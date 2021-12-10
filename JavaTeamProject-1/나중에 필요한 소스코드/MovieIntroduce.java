import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MovieIntroduce extends Panel{
	private JPanel movieintroducePanel = new JPanel();
	private JPanel movielistselectPanel = new JPanel();
	private JPanel movietheaterselectPanel = new JPanel();
	private JPanel movieseatselectPanel = new JPanel();
	
	public JLabel movielistla = new JLabel("영화선택");
	private JLabel movietheaterla = new JLabel("극장선택");
	private JButton movieseatbtn = new JButton();
	private ImageIcon beforeseat = new ImageIcon("imgs/beforeseat.png");
	private ImageIcon afterseat = new ImageIcon("imgs/afterseat.png");
	
	public int k = 0;
	
	MovieIntroduce(){
		movieintroducePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		movieintroducePanel.setBackground(Color.BLACK);
		movieintroducePanel.setPreferredSize(new Dimension(1130, 210));
		
		movielistselectPanel.setPreferredSize(new Dimension(370, 150));
		movielistselectPanel.setBackground(Color.BLACK);
		movielistla.setPreferredSize(new Dimension(370, 150));
		movielistla.setVerticalAlignment(JLabel.CENTER);
		movielistla.setHorizontalAlignment(JLabel.CENTER);
		movielistla.setFont(new Font("Arila", Font.PLAIN, 35));
		
		movielistselectPanel.add(movielistla);
		
		movietheaterselectPanel.setPreferredSize(new Dimension(370, 150));
		movietheaterselectPanel.setBackground(Color.BLACK);
		movietheaterla.setPreferredSize(new Dimension(370, 150));
		movietheaterla.setVerticalAlignment(JLabel.CENTER);
		movietheaterla.setHorizontalAlignment(JLabel.CENTER);
		movietheaterla.setFont(new Font("Arila", Font.PLAIN, 35));
		
		movietheaterselectPanel.add(movietheaterla);
		
		movieseatselectPanel.setPreferredSize(new Dimension(370, 150));
		movieseatselectPanel.setBackground(Color.BLACK);
		movieseatbtn.setPreferredSize(new Dimension(370, 150));
		movieseatbtn.setVerticalAlignment(JLabel.CENTER);
		movieseatbtn.setHorizontalAlignment(JLabel.CENTER);
		movieseatbtn.setBackground(Color.BLACK);
		movieseatbtn.setBorderPainted(false);
		movieseatbtn.setIcon(beforeseat);
		
		movieseatselectPanel.add(movieseatbtn);
		
		movieintroducePanel.add(movielistselectPanel);
		movieintroducePanel.add(movietheaterselectPanel);
		movieintroducePanel.add(movieseatselectPanel);
		
		add(movieintroducePanel);
	}
}

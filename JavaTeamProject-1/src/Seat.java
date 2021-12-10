import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.xml.parsers.FactoryConfigurationError;

import models.seatBean;

public class Seat extends JFrame {
	private JPanel movielistPanel = new JPanel();
	private JPanel submovielistPanel = new JPanel();
	private JButton[] movieslist = new JButton[36];
	
	private int P_num = 0;
	
   String[] num = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N" };
   boolean[][] select_seat = new boolean[25][14];
   JLabel[][] b = new JLabel[25][14];

   Color BorderColor[] = {Color.YELLOW, Color.GREEN, Color.RED};
   Color BackColor[] = {Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.gray};
   String seatName[] = {"Standard Zone", "Economy Zone", "Prime zone"};
   JLabel seatForm[] = new JLabel[3];
   
	private JPanel movieintroducePanel = new JPanel();
	private JPanel movielistselectPanel = new JPanel();
	private JPanel movietheaterselectPanel = new JPanel();
	private JPanel movieseatselectPanel = new JPanel();
   
   public Seat(String smovie, String stheater, int n, String stime, String sperson) {
      setTitle("1");
      P_num = Integer.parseInt(sperson);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container c = getContentPane();
      c.setLayout(new BorderLayout());
      //c.add(new PreViewPanel(select_seat), BorderLayout.EAST);
      c.setBackground(new Color(255, 255, 255));

      JButton btn = new JButton("hi");
      btn.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent e) {
            System.out.println("선택한 영화 :" + smovie);
            System.out.println("선택한 극장 : " + stheater);
            System.out.println("선택한 날짜 : 2020-11-" + n + " " + stime + ":00");
        //   new PaymentMethod();
         }
      });
      // c.add(btn);
      
    
        
        // 아래쪽 패널 : 초기화면을 위한 것들
        JLabel selectmoviela = new JLabel("영화선택");
        selectmoviela.setForeground(Color.white);
        JLabel selecttheaterla = new JLabel("극장선택");
        selecttheaterla.setForeground(Color.white);
        JButton movieseatbtn = new JButton("");
        movieseatbtn.setForeground(Color.white);
        ImageIcon beforeseat = new ImageIcon("imgs/beforeseat.png");
        
        // 아래쪽 패널 : 영화 정보들 클릭 시
        ImageIcon[] selectmovieimg = {
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
        JLabel printselectmoviela = new JLabel();
        JLabel printselectmovienamela = new JLabel();
        JLabel printselecttheaterla = new JLabel();
        JLabel printselecttimela = new JLabel();
        JLabel printselectpersonla = new JLabel();
        ImageIcon afterseat = new ImageIcon("imgs/afterseat.png");
        int logincount = 0;
        
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
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new PaymentMethod();
				
			}
		});
           
          String k ="<HTML>" + "영화 > " +smovie+"<br>"+ "극장 > " +stheater+"<br>"+ "일시 > " +Integer.toString(n)+ " " +stime+"<br>" 
          + "인원 > "+sperson+" 명 "+"<br>"+ "<HTML/>";
          
           movieseatselectPanel.add(selectmoviela);
           selecttheaterla.setText(k);
           selecttheaterla.setFont(new Font("Arial", Font.PLAIN, 15 ));
           movieseatselectPanel.add(selecttheaterla);
           movieseatselectPanel.add(movieseatbtn);
           
           // 좌석선택 버튼(아래쪽 패널의 오른쪽 부분)
           
           
       	movieintroducePanel.add(movielistselectPanel);
		movieintroducePanel.add(movietheaterselectPanel);
		movieintroducePanel.add(movieseatselectPanel);
   		// 가장 큰 패널에 패널들 추가
   		add(movielistPanel);

   		add(movieintroducePanel);
     
   		c.add(new ScreenPanel(select_seat), BorderLayout.NORTH);
        c.add(new SeatPanel(select_seat), BorderLayout.CENTER);
        c.add(movieintroducePanel, BorderLayout.SOUTH);
        c.add(movielistselectPanel, BorderLayout.SOUTH);
        c.add(movietheaterselectPanel, BorderLayout.SOUTH);
        c.add(movieseatselectPanel, BorderLayout.SOUTH);
        
        movieintroducePanel.add(movielistselectPanel);
        movieintroducePanel.add(movietheaterselectPanel);
      

      // 아래쪽 패널
         
         setSize(1500,800);
         setVisible(true);

   }
   class SeatPanel extends Panel {
         seatBean[] seatlist = new seatBean[3];
         Border B_border = BorderFactory.createLineBorder(Color.BLACK, 3);
         Border Y_border = BorderFactory.createLineBorder(Color.ORANGE, 3);
         Border G_border = BorderFactory.createLineBorder(Color.green, 3);
         Border R_border = BorderFactory.createLineBorder(Color.RED, 3);
         Color BorderColor[] = { Color.ORANGE, Color.GREEN, Color.RED };
         Color BackColor[] = { Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.gray };
         String seatName[] = { "Standard Zone", "Economy Zone", "Prime zone" };
         JLabel seatForm[] = new JLabel[3];
         JLabel[][] b = new JLabel[25][14];
         JList l = new JList();
         DefaultListModel model = new DefaultListModel();
         String[] s = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N" };

         // 사람수
        
         int select_num = 0;

         public SeatPanel(boolean[][] select_seat) {
            // TODO Auto-generated constructor stub

            setLayout(null);

            JLabel l1 = new JLabel(); // 좌석번호
            for (int i = 0; i < 14; i++) {
               l1 = new JLabel(s[i]);
               l1.setFont(new Font("Airal", Font.BOLD, 14));
               l1.setSize(30, 50);
               l1.setLocation(123, 37 + (i * 27));

               add(l1);
            }

            int cnt = 0;
            for (int i = 0; i < 25; i++) {
               for (int j = 0; j < 14; j++) {
                  select_seat[i][j] = false;
                  b[i][j] = new JLabel(Integer.toString(i));
                  b[i][j].addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseClicked(MouseEvent e) {
                        JLabel btn2 = (JLabel) e.getSource();

                        if (!(select_num < P_num)&& (btn2.getBackground() ==Color.LIGHT_GRAY || btn2.getBackground() == Color.GRAY)) {
                           JOptionPane.showMessageDialog(null, "인원 초과!!!");
                        }
                        boolean selected = false;
                        for (int i = 0; i < 25; i++) {
                           for (int j = 0; j < 14; j++) {
                              if (b[i][j].equals(btn2)) {
                                 selected = true;

                                 select_seat[i][j] = !select_seat[i][j];
                                 if (select_seat[i][j] && select_num < P_num) {
                                    btn2.setBackground(Color.black);
                                    String temp = "";
                                    for(int k=0; k< seatlist.length; k++) {
                                       if(btn2.getBorder() == Y_border && seatlist[k].getBorderColor() == Color.ORANGE) {
                                          temp = "["+seatlist[k].getName()+"]" + j + "열 " + i + "번째";
                                       }else if(btn2.getBorder() == G_border && seatlist[k].getBorderColor() == Color.green) {
                                          temp = "["+seatlist[k].getName()+"]" + j + "열 " + i + "번째";
                                       }else if(btn2.getBorder() == R_border && seatlist[k].getBorderColor() == Color.RED) {
                                          temp = "["+seatlist[k].getName()+"]" + j + "열 " + i + "번째";
                                       }
                                    }
                                    
                                    model.addElement(temp);  
                                    l.setModel(model);
                                    select_num++;
                                 } else if (!select_seat[i][j]) {
                                    if (btn2.getBorder() == R_border) {
                                       btn2.setBackground(Color.GRAY);
                                    } else {
                                       btn2.setBackground(Color.LIGHT_GRAY);
                                    }
                                    String temp = "";
                                    for(int k=0; k< seatlist.length; k++) {
                                       if(btn2.getBorder() == Y_border && seatlist[k].getBorderColor() == Color.ORANGE) {
                                          temp = "["+seatlist[k].getName()+"]" + j + "열 " + i + "번째";
                                       }else if(btn2.getBorder() == G_border && seatlist[k].getBorderColor() == Color.green) {
                                          temp = "["+seatlist[k].getName()+"]" + j + "열 " + i + "번째";
                                       }else if(btn2.getBorder() == R_border && seatlist[k].getBorderColor() == Color.RED) {
                                          temp = "["+seatlist[k].getName()+"]" + j + "열 " + i + "번째";
                                       }
                                    }
                                    model.removeElement(temp);
                                    l.setModel(model);
                                    select_num--;
                                 }

                                 System.out.println(select_num);
                                 break;
                              }
                           }
                           if (selected) {

                              break;
                           }

                        }

                     }
                  });
                  b[i][j].setOpaque(true);
                  b[i][j].setHorizontalAlignment(JLabel.CENTER);
                  b[i][j].setBackground(Color.LIGHT_GRAY);
                  b[i][j].setForeground(Color.white);
                  if (j < 3)
                     b[i][j].setBorder(Y_border);
                  else if ((j >= 5) && !(i > 4 && i < 21) || j == 3 || j == 4) {

                     b[i][j].setBorder(G_border);
                  } else {
                     b[i][j].setBorder(R_border);

                     b[i][j].setBackground(Color.gray);
                  }

                  if (i == 7) {
                     cnt = 30;
                  } else if (i == 19) {
                     cnt = 60;
                  }

                  b[i][j].setSize(25, 25);
                  b[i][j].setLocation(140 + i * (25) + cnt, 50 + j * 27);
                  add(b[i][j]);
               }
            }

            for (int i = 0; i < seatlist.length; i++) {
               seatlist[i] = new seatBean(BorderColor[i], seatName[i], BackColor[i]);
            }
            for (int i = 0; i < seatForm.length; i++) {
               seatForm[i] = new JLabel();
               JLabel sn = new JLabel(seatlist[i].getName());
               seatForm[i].setOpaque(true);
               seatForm[i].setHorizontalAlignment(JLabel.CENTER);
               seatForm[i].setBorder(seatlist[i].getBorder());
               seatForm[i].setSize(25, 25);
               sn.setFont(new Font("Gothic", Font.BOLD, 13));
               seatForm[i].setBounds(900, 50 + 30 * i, 25, 25);
               sn.setBounds(933, 50 + 30 * i, 150, 25);
               // seatForm[i].setLocation(10,30*i);
               seatForm[i].setForeground(Color.white);
               seatForm[i].setBackground(seatlist[i].getBackColor());
               add(seatForm[i]);
               add(sn);
            }

            // seatlist
            l.setBounds(900, 150, 170, 260);
            add(l);
               
            setSize(1100,800);
            setVisible(true);

         }
      }
   
   public static void main(String[] args) {
      new Seat("", "", 0, "", "");
   }

}



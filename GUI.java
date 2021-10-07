import java.awt.*;import 
java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
/**


* this is the game class

* @author LiuWei



*/

public class GUI  {
	game Game1 =new game();
	boolean betcontrol=false;
	boolean startcontrol=false;
	boolean re1control=true;
	boolean re2control=true;
	boolean re3control=true;
	int betmoney;
	int total_money=100;
	String i="./image/Images/card_";
	JFrame frame;
	JLabel label_Image1 = new JLabel();
	JLabel label_Image2 = new JLabel();
	JLabel label_Image3 = new JLabel();
	JLabel label_Image4 = new JLabel();
	JLabel label_Image5 = new JLabel();
	JLabel label_Image6 = new JLabel();
	JButton btn_rpcard1 = new JButton ("Replace Card1");
	JButton btn_rpcard2 = new JButton ("Replace Card2");
	JButton btn_rpcard3 = new JButton ("Replace Card3");
	JButton btn_start = new JButton ("Start");
	JButton btn_result = new JButton ("Result");
	JLabel label_bet = new JLabel("Bet $");
	JTextField txt_inputbet = new JTextField (10);
	ImageIcon Image1 = new ImageIcon("./image/Images/card_back.gif");
	JPanel MainPanel = new JPanel();
	JPanel DealerPanel = new JPanel();
	JPanel PlayerPanel = new JPanel();
	JPanel RpCardBtnPanel = new JPanel();
	JPanel ButtonPanel = new JPanel();
	JPanel InfoPanel = new JPanel();
	JMenuBar menuBar = new JMenuBar();
	JMenu menu1 = new JMenu("Control");
	JMenu menu2 = new JMenu("Help");
	JLabel label_info = new JLabel("Please place your bet! Amount of money you have:$ "+ total_money);
	JMenuItem menuItem1 = new JMenuItem("Exit");
	JMenuItem menuItem2 = new JMenuItem("Instruction");		
	
	
	
	 /**

     * This method demostrate the go().

     *

     * @param args Unused.


     */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUI gui1 =new GUI();
		
		gui1.go();
	}
	
	
	/**

     * This method establish the GUI.

     *

     */
	
	
	public void go () {
		frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DealerPanel.add(label_Image1);
		DealerPanel.add(label_Image2);
		DealerPanel.add(label_Image3);
		PlayerPanel.add(label_Image4);
		PlayerPanel.add(label_Image5);
		PlayerPanel.add(label_Image6);
		label_Image1.setIcon(Image1);
		label_Image2.setIcon(Image1);
		label_Image3.setIcon(Image1);
		label_Image4.setIcon(Image1);
		label_Image5.setIcon(Image1);
		label_Image6.setIcon(Image1);
		
		RpCardBtnPanel.add(btn_rpcard1);
		RpCardBtnPanel.add(btn_rpcard2);
		RpCardBtnPanel.add(btn_rpcard3);
		
		
		btn_rpcard1.addActionListener(new replace1());
		btn_rpcard2.addActionListener(new replace2());
		btn_rpcard3.addActionListener(new replace3());
		btn_start.addActionListener(new start());
		btn_result.addActionListener(new result());
		
		menuItem1.addActionListener(new item1());
		menuItem2.addActionListener(new item2());
		
		
		ButtonPanel.add(label_bet);
		ButtonPanel.add(txt_inputbet);
		ButtonPanel.add(btn_start);
		ButtonPanel.add(btn_result);
		
		
		
		
		InfoPanel.add(label_info);
		
		//MainPanel
		MainPanel.setLayout(new BoxLayout(MainPanel,BoxLayout.Y_AXIS));
		MainPanel.add(DealerPanel);
		MainPanel.add(PlayerPanel);
		MainPanel.add(RpCardBtnPanel);
		MainPanel.add(ButtonPanel);
		MainPanel.add(InfoPanel);
		
		//menu
		menu1.add(menuItem1);
		menu2.add(menuItem2);
		menuBar.add(menu1);
		menuBar.add(menu2);
		
		//frame
		frame.setJMenuBar(menuBar);
		frame.add(MainPanel);
		frame.setSize(400,600);
		frame.setVisible(true);
		
	}
	
	/**


	* this is inner class to control the btn_rpcard1 button

	* 
	* @author LiuWei


	*/
	
	class replace1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(betcontrol==true && re1control==true &&(re2control!=false || re3control!=false)) {
				//System.out.print("replace 1");
				Game1.switch_card(0);
				ArrayList <Integer> a=Game1.getCurrent_card2();
				int y=a.get(0);
				
				String x1=i+y+""+".gif";
				label_Image4.setIcon(new ImageIcon(x1));
				re1control=false;
				
			}
				 	
		}		

		
	}
	
	/**


	* this is inner class to control the btn_rpcard2 button

	* 
	* @author LiuWei


	*/
	
	
	class replace2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(betcontrol==true && re2control==true&&(re1control!=false || re3control!=false)) {
				//System.out.print("replace 1");
				Game1.switch_card(1);
				ArrayList <Integer> a=Game1.getCurrent_card2();
				int y=a.get(1);
				
				String x1=i+y+""+".gif";
				label_Image5.setIcon(new ImageIcon(x1));
				re2control=false;
				
			}
				 	
		}		

		
	}
	
	
	/**


	* this is inner class to control the btn_rpcard3 button

	* 
	* @author LiuWei


	*/
	
	class replace3 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
			if(betcontrol==true && re3control==true &&(re1control!=false || re2control!=false)) {
				//System.out.print("replace 1");
				Game1.switch_card(2);
				ArrayList <Integer> a=Game1.getCurrent_card2();
				int y=a.get(2);
				
				String x1=i+y+""+".gif";
				label_Image6.setIcon(new ImageIcon(x1));
				re3control=false;
				
			}
				 	
		}		

		
	}
	
	/**


	* this is inner class to control the start button

	* 
	* @author LiuWei


	*/
	
	class start implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(txt_inputbet.getText() != null) {
				if(txt_inputbet.getText().contains(".")||txt_inputbet.getText().contains("-")) {
					//System.out.print("hi double");
					//JFrame frame1=new JFrame();
					//JLabel txt=new JLabel();
					//txt.setText("Warnning: the bet you please should be positive integer");
					JOptionPane.showMessageDialog(frame, "Warnning: the bet you please should be positive integer");
					//frame1.add(txt);
					//frame1.setSize(100,100);
					//frame1.setVisible(true);
				}
				else if (startcontrol==false){
					startcontrol=true;
					betmoney=Integer.parseInt(txt_inputbet.getText());
				if(betmoney<=total_money) {
					startcontrol=true;
				betcontrol=true;
				
				Game1.random_card();
				ArrayList <Integer> a=Game1.getCurrent_card2();
			
			int x=a.get(0);
			int z=a.get(2);
			int y=a.get(1);
			String x1=i+x+""+".gif";
			
			ImageIcon Image = new ImageIcon(x1);
			String x2=i+y+""+".gif";
			//System.out.print(x2);
			ImageIcon Image2 = new ImageIcon(x2);
			String x3=i+z+""+".gif";
			ImageIcon Image3 = new ImageIcon(x3);
			
			label_Image4.setIcon(Image);
			label_Image5.setIcon(Image2);
			label_Image6.setIcon(Image3);

			label_info.setText("Your current bet is $"+betmoney+"Amount of money you have $ "+total_money);
		}else {
			//JFrame frame1=new JFrame();
			//JLabel txt=new JLabel();
			JOptionPane.showMessageDialog(frame, "Your bet is larger than your total money");
			//txt.setText("Your bet is larger than your total money");
			//frame1.add(txt);
			//frame1.setSize(100,100);
			//frame1.setVisible(true);
		}
				}

			}
	}
	}
	
	/**


	* this is inner class to control the result button

	* 
	* @author LiuWei


	*/
	
	
	class result implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(betcontrol==true) {
				
				ArrayList <Integer> b=Game1.getCurrent_card1();
				int x=b.get(0);
				int z=b.get(2);
				int y=b.get(1);
				
				String x1=i+x+""+".gif";
				
				ImageIcon Image = new ImageIcon(x1);
				String x2=i+y+""+".gif";
				//System.out.print(x2);
				ImageIcon Image2 = new ImageIcon(x2);
				String x3=i+z+""+".gif";
				ImageIcon Image3 = new ImageIcon(x3);
				
				label_Image1.setIcon(Image);
				label_Image2.setIcon(Image2);
				label_Image3.setIcon(Image3);
				
				
				boolean a=Game1.win();
				//Frame frame1=new JFrame();
				//JLabel txt=new JLabel();
				//System.out.print("hi");
				if(a==true) {
					total_money=total_money+betmoney;
					JOptionPane.showMessageDialog(frame, "Congrauations! you win this round");
					
					startcontrol=false;
				}
				else {
					total_money=total_money-betmoney;
					if(total_money==0) {
						JOptionPane.showMessageDialog(frame, "Gameover!\r\n you have not more money! \r\n please start a new game!");
						
					}else {
						JOptionPane.showMessageDialog(frame, "Sorry! Dealer win this round");
					startcontrol=false;
					}
					
				}
				
				betmoney=0;
				label_info.setText("Your current bet is $"+betmoney+"Amount of money you have $ "+total_money);
				betcontrol=false;
				Game1.restart_game();
				try {
					Thread.sleep(100);
					label_Image1.setIcon(Image1);
					label_Image2.setIcon(Image1);
					label_Image3.setIcon(Image1);
					label_Image4.setIcon(Image1);
					label_Image5.setIcon(Image1);
					label_Image6.setIcon(Image1);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//System.out.println("allarrat_Size: "+Game1.all_array.size());
				//frame1.add(txt);
				//System.out.print(a);
				//frame1.setSize(100,100);
				//frame1.setVisible(true);
				txt_inputbet.setText("");
				re1control=true;
				re2control=true;
				re3control=true;
				
				}
				
		
	}

		
	}
	
	/**


	* this is inner class to control the exit menuList

	* 
	* @author LiuWei


	*/
	
	class item1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}
		
	}
	/**


	* this is inner class to control the instruction menuList

	* 
	* @author LiuWei


	*/
	class item2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//JFrame frame1=new JFrame();
			//JTextArea text = new JTextArea(10, 20);
		
			
			JOptionPane.showMessageDialog(frame, "J, Q, K are regarded as special cards.\r\n"
					+ "Rule 1: The one with more special cards wins.\r\n"
					+ "Rule 2: If both have the same number of special cards, add the face values of the other card(s) and take the remainder after dividing the sum by 10. The one with a bigger remainder wins. (Note: Ace = 1).\r\n"
					+ "Rule 3: The dealer wins if both rule 1 and rule 2 cannot distinguish the winner.");
		//	frame1.add(text);
		//	JButton button1=new JButton("OK");
		//	button1.addActionListener(this);
			
			//frame1.setSize(800,200);
			//frame1.setVisible(true);
			
			
		}
		
	}
	
	
	
}

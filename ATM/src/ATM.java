import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class ATM extends JFrame 
{
	Scanner input= new Scanner(System.in);
	String userPassword, Input="";
	public JPanel buttonPanel, textPanel;
	JButton JButtonNumber, enter, clear;
	public JFrame frame;
	JTextField textbox;
	int chances=1, button=0;
	JPasswordField MainPassword= new JPasswordField(4);
	StringBuilder enterPassword= new StringBuilder("");
	public  class buttonAction implements ActionListener 
	{
		public buttonAction()
		{
			buttonPanel= new JPanel();
			textPanel= new JPanel();
			frame = new JFrame(" ATM PIN AUTHENTICATION ");
			frame.setLayout(new BorderLayout());
			frame.setSize(new Dimension(800,600));
			buttonPanel.setLayout(new GridLayout(3,2));
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			textbox= new JTextField(50);
			MainPassword.setFont(new Font(" MS San Serif", Font.BOLD, 17));
			authentication code= new authentication();
			
			textPanel.add(textbox);
			for (int number=1;number<=9;number++)
			{
				JButtonNumber= new JButton(number+"");
				JButtonNumber.addActionListener(this);
				JButtonNumber.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						Input+=((JButton)e.getSource()).getText();
						//MainPassword.setText(Input);
						textbox.setText(Input);
					}
					
				});
				buttonPanel.add(JButtonNumber);
			}
			JButtonNumber= new JButton(0+"");
			JButtonNumber.addActionListener(this);
			JButtonNumber.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					Input+=((JButton)e.getSource()).getText();
					textbox.setText(Input);
					System.out.println(Input);
				}
				
			});
			buttonPanel.add(JButtonNumber);
			JButtonNumber= new JButton("\u23CE");
			
			new clearAction();

			frame.add(buttonPanel, BorderLayout.CENTER);
			frame.add(textPanel, BorderLayout.NORTH);
			enterAction action = new enterAction();
			frame.setVisible(true);
		}
		@Override
		public void actionPerformed(ActionEvent e)
		{
			
		}
		public class enterAction implements ActionListener  
		{
			public enterAction()
			{
				enter= new JButton("enter");

				buttonPanel.add(enter);

				enter.addActionListener(this);
				enter.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
					}
				});
			}
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource()==enter)
				{
					 userPassword= textbox.getText();

					if (authentication.Authentication(userPassword))//takes the users password and compares it to
					{//the other password and if they are the same the welcome window appears 
						JOptionPane.showMessageDialog(null, "welcome");
						System.exit(0);
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "wrong password");//if not the wrong password window appears
						if (chances<3)
						{
							ATM atm= new ATM();
							chances ++;
						}
						else
						{
							System.exit(0);
						}
					}
				}
			}
		}
		public class clearAction implements ActionListener
		{
			public clearAction()
			{
				clear= new JButton("clear");		
				buttonPanel.add(clear);
				clear.addActionListener(this);
				clear.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
					}
				});
			}		
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource()==clear)
				{
					Input = "";
					textbox.setText("");//clears text box
				}
			}
		}
	}
}
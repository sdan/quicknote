package telepromter;


import java.io.*;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;


public class QuickNote{

	JLabel jl = new JLabel();
	JScrollPane sp;
	Font font;
	ImageIcon icon = new ImageIcon("/Users/Nitin/Desktop/icon.jpeg");
	private String[] keyword = new String[100];
	private int words = 0;
	Scanner scanner = null;
	PrintWriter pw = null;
	private JFrame frame;
	private JButton button;
	private JLabel label;
	private JTextArea textField;
	private JButton button2;
	private JButton buttonStart;
	private JLabel label2;
	private JLabel label4;
	private JLabel label5;
	private JLabel label3 = new JLabel("Please Press Save");
	private JTextArea textField2;
	private JTextArea textField3;
	private String line =  " ";
	private boolean toContinue = false;
	private boolean nonExistent = false;



	public QuickNote(){

		frame = new JFrame();
		frame.setBounds(200, 100, 900, 900);
		frame.setTitle("QuickNotes");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new JLabel(new ImageIcon("/Users/Nitin/Desktop/back1.jpg")));
		frame.setLayout(null);

		buttonStart = new JButton("Create QuickNotes", icon);
		buttonStart.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonStart.setFont(new Font("Arial", Font.BOLD, 20));
		buttonStart.addActionListener(listener);
		buttonStart.setBounds(350, 300, 200, 200);
		frame.add(buttonStart);

		label4 = new JLabel();
		label4.setText("Welcome To QuickNote");
		label4.setFont(new Font("Arial", Font.BOLD, 30));
		label4.setBounds(295, 42, 400, 100);
		frame.add(label4);

		frame.setVisible(true);

	}

	public static void main(String[] args) {


		QuickNote tel = new QuickNote();


	}

	private ActionListener listener = new ActionListener(){
		public void actionPerformed(ActionEvent e) {

			if(e.getSource()==buttonStart){
				frame.remove(buttonStart);
				label = new JLabel();
				label.setText("Enter Script:");
				label.setFont(new Font("Arial", Font.BOLD, 15));
				label.setBounds(102, 230, 120, 20);
				frame.add(label);

				textField = new JTextArea();
				textField.setLineWrap(true);
				textField.setWrapStyleWord(true);
				textField.setBounds(100, 250, 300, 300);
				frame.add(textField);

				button = new JButton("Save");
				button.setBounds(100, 650, 120, 20);
				button.setFont(new Font("Arial", Font.BOLD,15));
				button.addActionListener(listener);
				frame.add(button);

				label2 = new JLabel();
				label2.setText("Keywords (separated by spaces)");
				label2.setFont(new Font("Arial", Font.BOLD, 15));
				label2.setBounds(600, 230, 300, 20);
				frame.add(label2);

				textField2 = new JTextArea();
				textField2.setLineWrap(true);
				textField2.setWrapStyleWord(true);
				textField2.setBounds(600, 250, 150, 300);
				frame.add(textField2);

				button2 = new JButton("Make QuickNotes");
				button2.setBounds(600, 650, 120, 20);
				button2.setFont(new Font("Arial", Font.BOLD, 13));
				button2.addActionListener(listener);
				frame.add(button2);


				frame.repaint();


			}
			else if(e.getSource()==button){
				toContinue = true;
			}
			else if(e.getSource()==button2){
				if(toContinue){
					textField3 = new JTextArea();
					textField3.setLineWrap(true);
					textField3.setWrapStyleWord(true);
					textField3.setFont(new Font("Arial", Font.BOLD, 17));
					textField3.setBounds(145, 100, 600, 600);
					frame.add(textField3);
					
					label5 = new JLabel();
					label5.setText("Here are your QuickNotes");
					label5.setFont(new Font("Arial", Font.BOLD, 25));
					label5.setBounds(295, 34, 400, 100);
					frame.add(label5);



					frame.remove(textField2);
					frame.remove(textField);
					frame.remove(button2);
					frame.remove(button);
					frame.remove(label2);
					frame.remove(label3);
					frame.remove(label);
					frame.remove(label4);



					frame.repaint();
				}
				else{

					label3.setBounds(100, 650, 300, 120);
					label3.setFont(new Font("Arial", Font.BOLD, 20));
					frame.add(label3);
					frame.repaint();

 
				}
				if(toContinue){
				input();
				read();
				}

			}
		}
	};



	public void input() {
		int start = 0;
		int end = textField2.getText().indexOf(' ', start);
		int spaces = textField2.getText().length() - textField2.getText().replace(" ", "").length();
		for(int i = 0; i<spaces; i++)
		{

			keyword[i] = textField2.getText().substring(start, end);

			start = end;
			end = textField2.getText().indexOf(' ',start+1);
			
			System.out.println(keyword[i]);

		}
		
	}

	public void read(){
		int start = 0;
		int k = 0;
		int end = textField.getText().indexOf(".");
		line = " ";
		textField3.append("\n\n\n");
		for(int i =0;keyword[k]!=null; i++)
		{

			line  = textField.getText().substring(start, end);
			if(line.indexOf(keyword[k])>=0){
				textField3.append("•"+line + "\n\n\n");
				k++;
				start = end +1;
				end = textField.getText().indexOf(("."), start+1);
				
			}
				
			else{
				start = end+1;
				end = textField.getText().indexOf(("."), end+1);
				

			}
			// if(nonExistent){
			//		textField3.setText("No Keywords found in text");
			//		}

		}

	}
}

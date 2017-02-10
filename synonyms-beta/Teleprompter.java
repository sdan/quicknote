
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.Scanner;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Teleprompter{

	JLabel jl = new JLabel();
	Font font;
	private static Color color = Color.pink;
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
	private JLabel label3 = new JLabel("Please Press Done");
	private JTextArea textField2;
	private JTextArea textField3;
	private String line =  " ";
	private boolean toContinue = false;



	public Teleprompter(){

		frame = new JFrame();
		frame.setBounds(200, 100, 900, 900);
		frame.setTitle("Main Points");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new JLabel(new ImageIcon("/Users/Surya/Desktop/back1.jpg")));
		frame.setLayout(null);

		buttonStart = new JButton("Continue");
		buttonStart.setFont(new Font("Arial", Font.PLAIN, 40));
		buttonStart.addActionListener(listener);
		buttonStart.setBounds(350, 300, 200, 200);
		frame.add(buttonStart);

		frame.setVisible(true);

	}

	public static void main (String args[]) throws Exception {
		Teleprompter tel = new Teleprompter();

		 System.out.println ("Counting Words");
		 FileReader fr = new FileReader ("c:\\Customer1.txt");
		 BufferedReader br = new BufferedReader (fr);
		 String line = br.readLin ();
		 int count = 0;
		 while (line != null) {
				String []parts = line.split(" ");
				for( String w : parts)
				{
					count++;
				}
				line = br.readLine();
		 }
		 System.out.println(count);
	}
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
				label2.setText("Keywords (separated by new spaces)");
				label2.setFont(new Font("Arial", Font.BOLD, 15));
				label2.setBounds(600, 230, 300, 20);
				frame.add(label2);

				textField2 = new JTextArea();
				textField2.setLineWrap(true);
				textField2.setWrapStyleWord(true);
				textField2.setBounds(600, 250, 150, 300);
				frame.add(textField2);

				button2 = new JButton("Get Main Points");
				button2.setBounds(600, 650, 120, 20);
				button2.setFont(new Font("Arial", Font.BOLD, 15));
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
				textField3.setBounds(145, 100, 600, 600);
				frame.add(textField3);

				frame.remove(textField2);
				frame.remove(textField);
				frame.remove(button2);
				frame.remove(button);
				frame.remove(label2);
				frame.remove(label3);
				frame.remove(label);



				frame.repaint();
				}
				else{

					label3.setBounds(100, 550, 120, 20);
					frame.add(label3);
					frame.repaint();


				}
				input();
				//read();


			}
		}
	};



	public void input() {
		int start = 0;
		int end = textField2.getText().indexOf(' ', start);
		for(int i = 0; i<textField2.getLineCount(); i++)
		{

			keyword[i] = textField2.getText().substring(start, end);

			start = end;
			end = textField2.getText().indexOf(' ',start+1);


		}
	}
	public void processingText()
	{
		BufferedReader reader = new BufferedReader(new FileReader(textField1));
		int sentenceCount = 0;
		String line;
		String delimiters = "?!.";

		while ((line = reader.readLine()) != null) { // Continue reading until end of file is reached
		    for (int i = 0; i < line.length(); i++) {
		        if (delimiters.indexOf(line.charAt(i)) != -1) { // If the delimiters string contains the character
		            sentenceCount++;
		        }
		    }
		}

		reader.close();
		System.out.println("The number of sentences is " + sentenceCount);


/*

you got text
you find how many sentences there are by finding how many periods there are
you set each sentence by substringing it into another array
you find if the first word is in the sentence, if not got to next proces AT LEAST ONCE
you find if the second word is in the sentence, if not got to next proces AT LEAST ONCE
you find if the third word is in the sentence, if not got to next proces (does this as many keywords there are) AT LEAST ONCE
evertime o


*/
0




	}
	public void read(){
		int start = 0;
		int k = 0;
		int end = textField.getText().indexOf(".");
		String line = " ";
		for(int i =0; i<textField.getLineCount(); i++)										//line count of intputted long text
		{

			line  = textField.getText().substring(start, end-1);							//GETS LINE FROM START TO END PERIOD +++++ BOTTTTOT commernto
																																				//finds lines in terms of sentences
			if(line.indexOf(keyword[k])!=-1){
				textField3.setText(line);																			//sets "3rd text file "
				k++;
				start = 0;
				end = textField.getText().indexOf(".");
			}
			else{

				end = textField.getText().indexOf(textField.getText().indexOf("."), end);
				start = end;

			}


		}

	}
}

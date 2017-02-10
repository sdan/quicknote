package assignment3;
import java.awt.*; // Font, Color
import java.awt.event.*; // ActionEvent, ActionListener
import java.sql.SQLException;
import javax.swing.*; // JFrame, JPanel, JLabel, JButton
//class
public class Interface extends JFrame {
    private static final long serialVersionUID = 1L;
    //global variables
    //Member account = new Member();
    JPanel panel;
    JLabel label;
    JButton addEventButton;
    JButton updateEventButton;
    JButton deleteEventButton;
    JButton addMemberButton;
    JButton updateMemberButton;
    JButton deleteMemberButton;
    JButton exitButton;
    JButton searchButton;
    JTextArea statusTextArea;
    JPanel buttonPanel;
    JScrollPane statusPanel;
    JPanel c;
    JTextField textButton;
    Image Image1;
    public Interface() {
        super("User Interface");
        //settings for panel that holds the buttons
        panel = new JPanel();
        panel.setSize(getSize());
        panel.setLocation(0, 0);
        panel.setLayout(null);
        //panel.setBackground(Color.WHITE);
        //settings for event label
        label = new JLabel("Event");
        label.setSize(200, 50);
        label.setLocation(50, 10);
        label.setFont(new Font("SansSerif", Font.BOLD, 20));
        panel.add(label);
        //setting for member label
        label = new JLabel("Member");
        label.setSize(200,50);
        label.setLocation(260, 10);
        label.setFont(new Font("SansSerif", Font.BOLD, 20));
        panel.add(label);
        //settings for Add Event
        addEventButton = new JButton("Add");
        addEventButton.setSize(120, 60);
        addEventButton.setLocation(20, 70);
        panel.add(addEventButton);
        //settings for Update Event
        updateEventButton = new JButton("Update");
        updateEventButton.setSize(120, 60);
        updateEventButton.setLocation(20, 160);
        panel.add(updateEventButton);
        //settings for Delete Event
        deleteEventButton = new JButton("Delete");
        deleteEventButton.setSize(120, 60);
        deleteEventButton.setLocation(20, 250);
        panel.add(deleteEventButton);
        //settings for Add Member
        addMemberButton = new JButton("Add");
        addMemberButton.setSize(120, 60);
        addMemberButton.setLocation(240, 70);
        panel.add(addMemberButton);
        //settings for Update Member
        updateMemberButton = new JButton("Update");
        updateMemberButton.setSize(120, 60);
        updateMemberButton.setLocation(240, 160);
        panel.add(updateMemberButton);
        //settings for Delete Member
        deleteMemberButton = new JButton("Delete");
        deleteMemberButton.setSize(120, 60);
        deleteMemberButton.setLocation(240, 250);
        panel.add(deleteMemberButton);
        //settings for exit button
        exitButton = new JButton("Exit");
        exitButton.setSize(80, 30);
        exitButton.setLocation(150, 400);
        panel.add(exitButton);
        //settings for search button
        textButton = new JTextField("   Search");
        textButton.setSize(80,30);
        textButton.setLocation(150, 345);
        panel.add(textButton);
        //settings for window
        setSize(380, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        add(panel);
        setVisible(true);
            exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("EXIT");
                System.exit(0);
            }
        });
    }
}

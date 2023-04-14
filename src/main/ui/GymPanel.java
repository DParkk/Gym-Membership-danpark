package ui;


import model.EventLog;
import model.Gym;
import model.Event;
import model.Member;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.Collections;
import java.util.Iterator;


import persistence.JsonReader;
import persistence.JsonWriter;

// GUI that represents the Gym Membership
public class GymPanel extends JFrame implements ActionListener {
    private Gym gym;
    private JLabel nameLabel;
    private JLabel weightLabel;
    private JLabel heightLabel;
    private JTextField nameField;
    private JTextField weightField;
    private JTextField heightField;
    private JTextArea memberInList;
    private JsonWriter writer;
    private JsonReader reader;
    private ImageIcon backgroundImage;



    //GUI for gym application
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public GymPanel() {
        super("Gym Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 800));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(15, 15, 15, 15));
        setLayout(new FlowLayout());

        gym = new Gym();
        backgroundImage = new ImageIcon("./data/gymImage.jpeg");


        // JLabel showing "Daniel's Gym" image
        JLabel label = new JLabel();
        label.setIcon(backgroundImage);
        add(label);

        JPanel memberPrint = new JPanel();

        memberPrint.setLayout(new BoxLayout(memberPrint, BoxLayout.PAGE_AXIS));
        memberInList = new JTextArea(20,20);
        memberInList.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(memberInList);
        memberPrint.add(new JLabel("List Of Members: "));
        memberPrint.add(scrollPane);



        JButton addBtn = new JButton("Add Member");
        JButton saveBtn = new JButton(("Save"));
        JButton loadBtn = new JButton(("Load"));
        JButton clearBtn = new JButton("Clear");
        JButton sortBtn = new JButton("Sort");
        JButton quitBtn = new JButton("Quit");
        addBtn.setActionCommand("Add Member");
        addBtn.addActionListener(this);
        clearBtn.setActionCommand("Clear");
        clearBtn.addActionListener(this);
        saveBtn.setActionCommand("Save");
        saveBtn.addActionListener(this);
        loadBtn.setActionCommand("Load");
        loadBtn.addActionListener(this);
        sortBtn.setActionCommand("Sort");
        sortBtn.addActionListener(this);
        quitBtn.setActionCommand("Quit");
        quitBtn.addActionListener(this);



        nameLabel = new JLabel("Name: ");
        nameField = new JTextField(30);
        weightLabel = new JLabel("Weight: ");
        weightField = new JTextField(20);
        heightLabel = new JLabel("Height: ");
        heightField = new JTextField(20);

        writer = new JsonWriter("./data/workroom.json");
        reader = new JsonReader("./data/workroom.json");

        JButton addMemberButton = new JButton("Add Member");
        JButton saveMemberButton = new JButton("Save");
        JButton loadMemberButton = new JButton("Load");
        JButton clearMemberButton = new JButton("Clear");
        JButton sortMemberButton = new JButton("Sort");
        JButton quitMemberButton = new JButton("Quit");




        // add Member to the member List
        addMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Member member = new Member(nameField.getText(),Double.parseDouble(weightField.getText()),
                        Double.parseDouble(heightField.getText()));
                gym.addMember(member);
                JOptionPane.showMessageDialog(GymPanel.this,"Member Added.");
            }
        });
        // Clear all the members in the list
        clearMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gym.getMemberList().clear();
                memberInList.setText("");
                JOptionPane.showMessageDialog(GymPanel.this,"Member Cleared.");

            }
        });
        // Sort Member's name alphabetically
        sortMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(gym.getMemberList(), (o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));

            }
        });
        // Save member in list using json.
        saveMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    writer.open();
                    writer.write(gym);
                    writer.close();
                    JOptionPane.showMessageDialog(GymPanel.this, "Members saved to the list");
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(GymPanel.this, "Couldn't save members");
                }
            }
        });
        // Loading member in list using json.
        loadMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gym = reader.read();
                    memberInList.setText("");
                    for (Member member : gym.getMemberList()) {
                        memberInList.append(member.getName() + "\n");
                    }
                    JOptionPane.showMessageDialog(GymPanel.this,"Members Loaded");
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(GymPanel.this,"Couldn't load from file");
                }
            }
        });

        quitMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                printLog(EventLog.getInstance());
            }
        });






        add(nameLabel);
        add(nameField);
        add(heightLabel);
        add(heightField);
        add(weightLabel);
        add(weightField);
        add(addBtn);
        add(clearBtn);
        add(saveBtn);
        add(loadBtn);
        add(sortBtn);
        add(quitBtn);

        add(memberPrint);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }



    //This is the method that is called when the JButton btn is clicked

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Member")) {
            Member member = new Member(nameField.getText(),Double.parseDouble(weightField.getText()),
                                        Double.parseDouble(heightField.getText()));
            gym.addMember(member);

            memberInList.append(member.getName() + "\n");
            // Given the initialization of the program and this variable, anything added ("appended") to memberInList
            // will be shown in the ScrollPane

            nameLabel.setText("Added Member: " + member.getName());
            nameField.setText("");
            heightField.setText("");
            weightField.setText("");


            //This is the method that is called when the JButton clearBtn is clicked
        } else if (e.getActionCommand().equals("Clear"))  {
            gym.getMemberList().clear();
            memberInList.setText("");
            EventLog.getInstance().logEvent(new Event("Member(s) Cleared in the list"));

            JOptionPane.showMessageDialog(GymPanel.this,"Members Cleared.");


        } else if (e.getActionCommand().equals("Save")) {
            try {
                writer.open();
                writer.write(gym);
                writer.close();
                EventLog.getInstance().logEvent(new Event("Saved member(s) in the list"));

                JOptionPane.showMessageDialog(GymPanel.this, "Members saved to the list");
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(GymPanel.this, "Couldn't save members");
            }
        } else if (e.getActionCommand().equals("Load")) {
            try {
                gym = reader.read();
                memberInList.setText("");
                EventLog.getInstance().logEvent(new Event("Member(s) Loaded"));

                for (Member member : gym.getMemberList()) {
                    memberInList.append(member.getName() + "\n");
                }
                JOptionPane.showMessageDialog(GymPanel.this,"Members Loaded");
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(GymPanel.this,"Couldn't load from file");
            }
        } else if (e.getActionCommand().equals("Sort")) {
            Collections.sort(gym.getMemberList(), (o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
            memberInList.setText("");
            for (Member member : gym.getMemberList()) {
                memberInList.append(member.getName() + "\n");
            }
            EventLog.getInstance().logEvent(new Event("Members Sorted alphabetically"));

            JOptionPane.showMessageDialog(GymPanel.this,"Members Sorted");
        } else if (e.getActionCommand().equals("Quit")) {
            printLog(EventLog.getInstance());
            System.exit(0);
        }

    }

    // Effects: prints the log to the console
    public void printLog(EventLog el) {
        Iterator<Event> it = EventLog.getInstance().iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString() + "\n");
        }
    }






    public static void main(String[] args) {
        new GymPanel();
    }

}
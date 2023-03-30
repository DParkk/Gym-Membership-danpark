package ui;

import model.Gym;
import model.Member;
import model.Gym;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.json.JSONObject;
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
    private Image backgroundImage;

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public GymPanel() {
        super("Gym Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 700));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(15, 15, 15, 15));
        setLayout(new FlowLayout());

        gym = new Gym();
        backgroundImage = new ImageIcon("./data/gymImage.jpeg").getImage();

        JPanel memberPrint = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponents(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        memberPrint.setLayout(new BoxLayout(memberPrint, BoxLayout.PAGE_AXIS));
        memberInList = new JTextArea(20,20);
        memberInList.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(memberInList);
        memberPrint.add(new JLabel("List Of Members: "));
        memberPrint.add(scrollPane);



        JButton btn = new JButton("Add Member");
        JButton saveBtn = new JButton(("Save"));
        JButton loadBtn = new JButton(("Load"));
        JButton clearBtn = new JButton("Clear");
        JButton sortBtn = new JButton("Sort");
        btn.setActionCommand("Add Member");
        btn.addActionListener(this);
        clearBtn.setActionCommand("Clear");
        clearBtn.addActionListener(this);
        saveBtn.setActionCommand("Save");
        saveBtn.addActionListener(this);
        loadBtn.setActionCommand("Load");
        loadBtn.addActionListener(this);
        sortBtn.setActionCommand("Sort");
        sortBtn.addActionListener(this);


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


        // add Member to the member List
        addMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Member member = new Member(nameField.getText(),Double.parseDouble(weightField.getText()),
                        Double.parseDouble(heightField.getText()));
                gym.getMemberList().add(member);
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
                Collections.sort(gym.getMemberList(), new Comparator<Member>() {
                    @Override
                    public int compare(Member o1, Member o2) {
                        return o1.getName().compareToIgnoreCase(o2.getName());
                    }
                });

            }
        });

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






        add(nameLabel);
        add(nameField);
        add(heightLabel);
        add(heightField);
        add(weightLabel);
        add(weightField);
        add(btn);
        add(clearBtn);
        add(saveBtn);
        add(loadBtn);

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
            gym.getMemberList().add(member);

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
            JOptionPane.showMessageDialog(GymPanel.this,"Members Cleared.");

        } else if (e.getActionCommand().equals("Save")) {
            try {
                writer.open();
                writer.write(gym);
                writer.close();
                JOptionPane.showMessageDialog(GymPanel.this, "Members saved to the list");
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(GymPanel.this, "Couldn't save members");
            }
        } else if (e.getActionCommand().equals("Load")) {
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
        } else if (e.getActionCommand().equals("Sort")) {
            Collections.sort(gym.getMemberList(), new Comparator<Member>() {
                @Override
                public int compare(Member o1, Member o2) {
                    return o1.getName().compareToIgnoreCase(o2.getName());
                }
            });
        }
    }

    public static void main(String[] args) {
        new GymPanel();
    }
}
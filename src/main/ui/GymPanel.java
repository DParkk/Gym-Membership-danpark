package ui;

import model.Member;
import model.Gym;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GymPanel extends JFrame implements ActionListener {
    private ArrayList<Member> memberList;
    private JLabel nameLabel;
    private JLabel weightLabel;
    private JLabel heightLabel;
    private JTextField nameField;
    private JTextField weightField;
    private JTextField heightField;
    private JTextArea memberInList;

    @SuppressWarnings("checkstyle:MethodLength")
    public GymPanel() {
        super("Gym Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(15, 15, 15, 15));
        setLayout(new FlowLayout());

        JPanel memberPrint = new JPanel();
        memberPrint.setLayout(new BoxLayout(memberPrint, BoxLayout.PAGE_AXIS));
        memberInList = new JTextArea(20,20);
        memberInList.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(memberInList);

        memberPrint.add(new JLabel("List Of Members: "));
        memberPrint.add(scrollPane);

        JButton btn = new JButton("Add Member");
        btn.setActionCommand("Add Member");
        btn.addActionListener(this);

        memberList = new ArrayList<>();
        nameLabel = new JLabel("Name: ");
        nameField = new JTextField(30);
        weightLabel = new JLabel("Weight: ");
        weightField = new JTextField(20);
        heightLabel = new JLabel("Height: ");
        heightField = new JTextField(20);

        JButton addMemberButton = new JButton("Add Member");
        addMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Member member = new Member(nameField.getText(),Double.parseDouble(weightField.getText()),
                        Double.parseDouble(heightField.getText()));
                memberList.add(member);
                JOptionPane.showMessageDialog(GymPanel.this,"Member Added.");
            }
        });



        add(nameLabel);
        add(nameField);
        add(heightLabel);
        add(heightField);
        add(weightLabel);
        add(weightField);
        add(btn);

        add(memberPrint);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    //This is the method that is called when the JButton btn is clicked
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Member")) {
            Member member = new Member(nameField.getText(),Double.parseDouble(weightField.getText()),
                                        Double.parseDouble(heightField.getText()));
            memberList.add(member);

            memberInList.append(member.toString() + "\n");

            nameLabel.setText("Added Member: " + member.getName());
            nameField.setText("");
            heightField.setText("");
            weightField.setText("");

        }
    }

    public static void main(String[] args) {
        new GymPanel();
    }
}
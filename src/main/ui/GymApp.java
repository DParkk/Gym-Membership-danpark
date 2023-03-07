package ui;

import model.Gym;
import model.Member;

import java.util.Scanner;

// Gym registration application
public class GymApp {
    private Scanner input;
    private Gym gym;

    // EFFECTS: runs the Gym application
    public GymApp() {
        input = new Scanner(System.in);
        gym = new Gym();
        runApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user command.
    private void runApp() {

        boolean condition = true;
        while (condition) {

            System.out.println("Hi, do you want to join our gym? (y/n)" + "\n"
                    + "(enter 'n' for your running distance)");
            String checkIn = input.nextLine();

            if (checkIn.equals("y")) {
                memberRegister();

            } else {
                condition = false;
            }
        }
        memberRun();
    }

    // MODIFIES: this
    // EFFECTS: Print out all the users' run distance.
    private void memberRun() {
        for (Member member : gym.getMemberList()) {
            int distance = getDist(member);
            if (distance == 0) {
                System.out.println("Hope to see you again!");
                System.exit(0);
            }
            member.addDistance(distance);
            System.out.println(member.getName() + " has run " + distance + "km." + "\n");
        }
        for (Member member : gym.getMemberList()) {
            System.out.println(member.getName() + " has a running distance of: " + member.getTotalDistance() + "km.");
        }
        rankRunners();
    }


    // MODIFIES: this
    // EFFECTS: processes user input. Let users know their BMI score based on their weight & height input.
    private void memberRegister() {
        System.out.println("Enter your Name: ");
        String name = input.nextLine();

        System.out.println("Enter your height: ");
        int height = input.nextInt();

        System.out.println("Enter your weight: ");
        int weight = input.nextInt();

        Member member = new Member(name, height, weight);

        gym.addMember(member);

        System.out.println("\n" + "Your BMI score is " + member.bmiConverter());

        member.adviser();

        System.out.println("Keep Grinding!" + "\n");
        input.nextLine();
    }

    // MODIFIES: this
    // EFFECTS: Prompts user to enter their run distance or quit the program. Allows user to quit the program.
    private int getDist(Member member) {
        System.out.println(member.getName() + " please enter your run distance(km): ");
        System.out.println("(To quit, enter '0')");
        return input.nextInt();
    }


    // EFFECTS: Allows user to the check who ran the most distance in the gym.
    private void rankRunners() {
        Member mostDist = gym.getMemberList().get(0);
        boolean tie = false;

        for (int i = 1; i < gym.getMemberList().size(); i++) {

            Member current = gym.getMemberList().get(i);

            if (current.getTotalDistance() > mostDist.getTotalDistance()) {
                mostDist = current;
                tie = false;

            } else if (current.getTotalDistance() == mostDist.getTotalDistance()) {
                tie = true;
            }
        }
        if (tie) {
            System.out.println("\n"
                    + "There is a tie for the first place!");

        } else {
            System.out.println("\n" + "The first place goes to " + mostDist.getName() + ", Congratulation!");
        }
    }
}



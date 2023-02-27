package ui;

import model.Member;

import java.util.ArrayList;
import java.util.Scanner;

// Gym registration application
public class GymApp {
    private Scanner input;
    ArrayList<Member> memberList = new ArrayList<>();

    // EFFECTS: runs the Gym application
    public GymApp() {
        runApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user command. Print out all the users' run distance.
    private void runApp() {
        input = new Scanner(System.in);
        boolean condition = true;
        while (condition) {

            System.out.println("Hi, do you want to register? (y/n)");
            String checkIn = input.nextLine();

            if (checkIn.equals("y")) {
                memberRegister();

            } else {
                condition = false;
            }
        }
        for (Member member : memberList) {
            int distance = getDist(member);
            if (distance == 0) {
                System.out.println("Hope to see you again!");
                System.exit(0);
            }
            member.addDistance(distance);
            System.out.println(member.getName() + " has run " + distance + "km.");
            System.out.println(member.getName() + " has a running distance of: "
                                 + member.getTotalDistance() + "km." + "\n");
        }

        rankRunners();
    }

    // MODIFIES: this
    // EFFECTS: processes user input.
    private void memberRegister() {
        System.out.println("Enter your Name: ");
        String name = input.nextLine();

        System.out.println("Enter your height: ");
        int height = input.nextInt();

        System.out.println("Enter your weight: ");
        int weight = input.nextInt();

        Member member = new Member(name, height, weight);

        memberList.add(member);

        System.out.println("\n" + "Your BMI score is " + member.bmiConverter());

        member.adviser();

        System.out.println("Keep Grinding!" + "\n");
        input.nextLine();
    }

    // MODIFIES: this
    // EFFECTS: prompt user to enter their run distance or quit the program.
    private int getDist(Member member) {
        System.out.println(member.getName() + " please enter your run distance(km): ");
        System.out.println("(To quit, enter '0')");
        return input.nextInt();
    }

    // MODIFIES: this
    // EFFECTS: Allows user to the check who ran the most distance in the gym.
    private void rankRunners() {

        Member mostDist = memberList.get(0);

        for (int i = 1; i < memberList.size(); i++) {
            if (memberList.get(i).getTotalDistance() > mostDist.getTotalDistance()) {
                mostDist = memberList.get(i);
                System.out.println("\n" + "The first place goes to " + mostDist.getName() + ", Congratulation!");

            } else if (memberList.get(i).getTotalDistance() == mostDist.getTotalDistance()) {
                System.out.println("\n" + "Everyone has the same running distance. Great work you all!");

            }
        }

    }
}


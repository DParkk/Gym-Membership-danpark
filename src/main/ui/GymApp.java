package ui;

import model.Member;

import java.util.ArrayList;
import java.util.Scanner;

public class GymApp {


    private Scanner input;

    ArrayList<Member> memberList = new ArrayList<>();


    public GymApp() {
        runApp();
    }


    public void runApp() {

        input = new Scanner(System.in);

        boolean condition = true;

        while (condition) {

            System.out.println("Hi, do you want to register? (y/n)");
            String checkIn = input.nextLine();

            if (checkIn.equals("y")) {
                System.out.println("Enter your Name: ");
                String name = input.nextLine();

                System.out.println("Enter your height: ");
                int height = input.nextInt();

                System.out.println("Enter your weight: ");
                int weight = input.nextInt();

                Member member = new Member(name, height, weight);

                memberList.add(member);

                System.out.println("Your BMI score is " + member.bmiConverter());

                member.adviser();

                System.out.println("Keep Grinding!");
                input.nextLine();

            } else {
                condition = false;
            }
        }




        for (Member member : memberList) {
            System.out.println(member.getName() + " please enter your run distance(km): ");
            System.out.println("(To quit, enter '0')");
            int distance = input.nextInt();

            if (distance == 0) {
                System.out.println("Hope to see you again!");
                System.exit(0);

            }

            member.addDistance(distance);
            System.out.println(member.getName() + " has run " + distance + "km.");

        }

        for (Member member : memberList) {
            System.out.println(member.getName() + " has a running distance of: " + member.getTotalDistance() + "km.");
        }
    }
}


package ui;

import model.Member;

import java.util.ArrayList;
import java.util.Scanner;

public class GymApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Member> memberList = new ArrayList<>();


        boolean condition = true;

        while (condition) {
            System.out.println("Enter your Name: ");
            String name = scanner.nextLine();

            System.out.println("Enter your height: ");
            int height = scanner.nextInt();

            System.out.println("Enter your weight: ");
            int weight = scanner.nextInt();

            Member member = new Member(name, height, weight);

            memberList.add(member);

            System.out.println("Thanks for joining our Gym!");
            scanner.nextLine();


        }

        for (Member member : memberList) {
            System.out.println("Hi " + member.getName() + ", please enter your run distance(km): ");
            int distance = scanner.nextInt();
            member.addDistance(distance);
            System.out.println(member.getName() + " has run " + distance + "km.");

        }

        for (Member member : memberList) {
            System.out.println(member.getName() + " has a total distance of: " + member.getTotalDistance() + "km.");
        }
    }

}
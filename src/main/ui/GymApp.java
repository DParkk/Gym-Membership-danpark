package ui;

import model.Gym;
import model.Member;
import model.Result;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Gym registration application
public class GymApp {
    private static final String JSON_STORE = "./data/workroom.json";
    private Scanner input;
    private Gym gym;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: runs the Gym application
    public GymApp() {
        input = new Scanner(System.in);
        gym = new Gym();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user command.
    private void runApp() {

        boolean condition = true;
        while (condition) {

            System.out.println("\n" + "Hi, do you want to join " + gym.getGymName() + "'s gym?" + "\n"
                    + "'y' to continue " + "\n"
                    + "'n' for your running distance" + "\n" + "'s' to save your information to file"
                    + "\n" + "'l' to load your information from file" + "\n" + "'p' to print out current members.");
            System.out.println("Enter 'set new name' to set a new name" + "\n");
            String checkIn = input.nextLine();

            if (checkIn.equals("y")) {
                memberRegister();

            } else if (checkIn.equals("set new name")) {
                // take in user input
                System.out.println("input a new name:");
                String newName = input.next();
                // call gym.setName()
                gym.setName(newName);

            } else if (checkIn.equals("s")) {
                saveWorkRoom();

            } else if (checkIn.equals("l")) {
                loadWorkRoom();

            } else if (checkIn.equals("p")) {
                gym.printMember();

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

        int result = member.adviser();
        if (result == 0) {
            System.out.println("You are within the underweight range.");
        } else if (result == 1) {
            System.out.println("You are within the Healthy Weight range.");
        } else if (result == 2) {
            System.out.println("You are within the overweight range.");
        } else {
            System.out.println("You are within the obese range.");
        }

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

//        boolean tie = false;
        Result res = null;
        try {
            res = gym.getMostDistantRunner();
            if (res.isTie()) {
                System.out.println("\n" + "There is a tie for the first place!");

            } else {
                System.out.println("\n" + "The first place goes to " + res.getMostDist().getName()
                        + ", Congratulation!");
            }
        } catch (Exception e) {
            System.out.println("There are no runners!");
        }
    }

        // throw exception -> catch expcetion print: there are no members
        //


        // EFFECTS: saves the workroom to file

    private void saveWorkRoom() {
        try {
            jsonWriter.open();
            jsonWriter.write(gym);
            jsonWriter.close();
            System.out.println("Saved " + gym.getGymName() + " to " + JSON_STORE + "\n");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

        // MODIFIES: this
        // EFFECTS: loads workroom from file

    private void loadWorkRoom() {
        try {
            gym = jsonReader.read();
            System.out.println("Loaded " + gym.getGymName() + " from " + JSON_STORE + "\n");
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}



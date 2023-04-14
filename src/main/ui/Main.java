package ui;


import model.Event;
import model.EventLog;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            new GymApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
    // Effects: prints the log to the console


}


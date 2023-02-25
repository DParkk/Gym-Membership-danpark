package model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

public class Member {
    private String name;
    private double weight;
    private double height;
    private ArrayList<Integer> runDistance;

    public Member(String name, double height, double weight) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.runDistance = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public double bmiCalculator() {
        return (weight / (height * height) * 10000);
    }

    public double bmiConverter() {
        double bmi = bmiCalculator();
        BigDecimal bd = new BigDecimal(bmi);
        bd = bd.round(new MathContext(3));
        double rounded = bd.doubleValue();

        return rounded;

    }

    public void adviser() {

        if (bmiConverter() < 18.5) {
            System.out.println("You are within the underweight range..");

        } else if (bmiConverter() <= 24.9) {
            System.out.println("You are within the Healthy Weight range.");

        } else if ((bmiConverter() <= 29.9)) {
            System.out.println("You are within the overweight range.");

        } else {
            System.out.println("You are within the obese range.");
        }
    }

    public void addDistance(int distance) {
        runDistance.add(distance);
    }

    public int getTotalDistance() {
        int total = 0;

        for (int distance : runDistance) {
            total += distance;
        }
        return total;
    }
}

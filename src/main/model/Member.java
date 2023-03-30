package model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import org.json.JSONObject;
import persistence.Writable;

// Represents a Member having a name, weight, and height.

public class Member implements Writable  {
    private final String name;
    private final double weight;
    private final double height;
    private final ArrayList<Integer> runDistance;


    /*
     * REQUIRES: name has non-zero length. height & weight > 0
     * EFFECTS: constructs a member with given name, height, and weight.
     */
    public Member(String name, double height, double weight) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.runDistance = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    /*
     * EFFECTS: calculates members' bmi with given height and weight.
     */
    public double bmiCalculator() {
        return (weight / (height * height) * 10000);
    }


    /*
     * EFFECTS: make a value from bmiCalculator() to 3 sig-figs.
     */
    public double bmiConverter() {
        double bmi = bmiCalculator();
        BigDecimal bd = new BigDecimal(bmi);
        bd = bd.round(new MathContext(3));
        double rounded = bd.doubleValue();

        return rounded;

    }

    /*
     * EFFECTS: give an information of members' bmi using a value from bmiConverter().
     */
    public int adviser() {
        if (bmiConverter() < 18.5) {
            return 0;
//            System.out.println("You are within the underweight range."); //

        } else if (bmiConverter() <= 24.9) {
            return 1;
//            System.out.println("You are within the Healthy Weight range.");

        } else if ((bmiConverter() <= 29.9)) {
            return 2;
//            System.out.println("You are within the overweight range.");

        } else {
            return 3;
//            System.out.println("You are within the obese range.");
        }
//        return true;
    }

    /*
     * REQUIRES: distance >= 0
     * MODIFIES: this
     * EFFECTS: takes a distance as an argument and add it to runDistance.
     */
    public void addDistance(int distance) {
        runDistance.add(distance);
    }

    /*
     * EFFECTS: adds up the all the distance in runDistance to total until there is no more,
     *          then return total.
     */
    public int getTotalDistance() {
        int total = 0;

        for (int distance : runDistance) {
            total += distance;
        }
        return total;
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("height", height);
        json.put("weight", weight);

        return json;
    }
}

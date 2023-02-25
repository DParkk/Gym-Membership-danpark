package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Member {
    private String name;
    private int weight;
    private int height;
    private ArrayList<Integer> runDistance;

    public Member(String name, int height, int weight) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.runDistance = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
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

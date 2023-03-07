package model;

import java.util.ArrayList;


public class Gym {
    private ArrayList<Member> memberList;
    private String gymName;


    // EFFECTS: constructs a gym with given gym name and contain member list.
    public Gym() {
        memberList = new ArrayList<>();
        gymName = "Daniel";
    }
    // MODIFIES: this
    // EFFECT: add member to Gym

    public void addMember(Member member) {
        memberList.add(member);
    }


    public ArrayList<Member> getMemberList() {
        return memberList;
    }


    // MODIFIES: this
    // EFFECT: get the runner with the most run-distance or get tied runners. If there's no error throw exception.

    public Result getMostDistantRunner() throws Exception {
        Member mostDist;
        if (memberList.size() == 0) {
            throw new Exception();
        } else {
            mostDist = memberList.get(0);
        }
        boolean tie = false;
        for (int i = 1; i < memberList.size(); i++) {

            Member current = memberList.get(i);

            if (current.getTotalDistance() > mostDist.getTotalDistance()) {
                mostDist = current;
                tie = false;

            } else if (current.getTotalDistance() == mostDist.getTotalDistance()) {
                tie = true;
            }
        }

        Result r = new Result(tie, mostDist);

        return r;
    }

    public void setName(String newName) {
        gymName = newName;
    }

    public String getGymName() {
        return gymName;
    }
}

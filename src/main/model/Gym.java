package model;

import java.util.ArrayList;

public class Gym {
    private ArrayList<Member> memberList;

    public Gym() {
        memberList = new ArrayList<>();
    }

    public void addMember(Member member) {
        memberList.add(member);
    }

    public void addDistance(Member member, int distance) {
        member.addDistance(distance);
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public boolean checkDistanceZero(int distance) {
        return distance == 0;
    }

    private Member rankRunners() {
        Member mostDist = memberList.get(0);
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

        if (tie) {
            return null;
        } else {
            return mostDist;
        }
    }


}

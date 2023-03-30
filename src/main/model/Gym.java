package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Gym Registration application
public class Gym extends ArrayList<Member> implements Writable {
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


    public List<Member> getMemberList() {
        return memberList;
    }


    // MODIFIES: this
    // EFFECT: get the runner with the most run-distance or get tied runners. If there's no runner throw exception.

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




    public int numThingies() {
        return memberList.size();
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", gymName);
        json.put("thingies", thingiesToJson());
        return json;
    }

    // EFFECTS: returns things in this Gym as a JSON array
    private JSONArray thingiesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Member t : memberList) {
            jsonArray.put(t.toJson());
        }

        return jsonArray;
    }
}


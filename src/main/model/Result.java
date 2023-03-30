package model;

// Result class to represent tie record.
public class Result {
    private boolean tie;
    private Member mostDist;


    //EFFECTS: constructs a result with boolean tie, and member with the most run-distance.

    public Result(boolean tie, Member mostDist) {
        this.tie = tie;
        this.mostDist = mostDist;
    }

    // MODIFIES: this
    // EFFECTS: Return true if it is tied for most run-distance.

    public boolean isTie() {
        return tie;
    }
    // MODIFIES: this
    // EFFECTS: Return the member with the most run-distance.

    public Member getMostDist() {
        return mostDist;
    }
}

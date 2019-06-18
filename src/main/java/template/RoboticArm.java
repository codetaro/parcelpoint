package template;

import java.util.Map;

public class RoboticArm extends Robot {

    private final int defaultPosition = -1;

    public RoboticArm(int position, Rack rack) {
        super(-1, rack);
    }

    public void forward(Rack rack) {
        if (this.position < (rack.getColNum() - 1)) this.position++;
    }

    /**
     * Dropping the load on a full column or the default position leads to nothing happening.
     * Once a load is successfully dropped the arm moves forward one position except when in the last column where nothing happens.
     * The arm cannot move ahead of the last column and will stay there if it receives a forward command.
     *
     * @param rack
     */
    public void drop(Rack rack, String load) {
        if (this.position == defaultPosition || rack.isColumnFull(this.position)) return;
        else {
            if (rack.onload(this.position, load)) {
                if (this.position == (rack.getColNum() - 1)) {
                    return;
                } else {
                    forward(rack);
                }
            } else {
                return;
            }
        }
    }

    public void reset() {
        this.position = -1;
    }
}

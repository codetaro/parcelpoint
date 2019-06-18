package command;

import template.Robot;

public class RobotDropCommand implements Command {
    Robot robot;
    String load;

    public RobotDropCommand(Robot robot, String load) {
        this.robot = robot;
        this.load = load;
    }

    public void execute() {
        robot.drop(this.load);
    }

    public void undo() {

    }
}

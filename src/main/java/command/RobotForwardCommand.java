package command;

import template.Robot;

public class RobotForwardCommand implements Command {
    Robot robot;

    public RobotForwardCommand(Robot robot) {
        this.robot = robot;
    }

    public void execute() {
        robot.forward();
    }

    public void undo() {

    }
}

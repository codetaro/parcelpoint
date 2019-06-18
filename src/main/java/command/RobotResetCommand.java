package command;

import template.Robot;

public class RobotResetCommand implements Command {
    Robot robot;

    public RobotResetCommand(Robot robot) {
        this.robot = robot;
    }

    public void execute() {
        robot.reset();
    }

    public void undo() {

    }
}

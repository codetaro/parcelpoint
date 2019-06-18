package command;

public class ParcelPoint {
    private Command macroCommand;

    public void setCommand(Command macroCommand) {
        this.macroCommand = macroCommand;
    }

    public void simulateArm() {
        macroCommand.execute();
    }
}

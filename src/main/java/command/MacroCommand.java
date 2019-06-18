package command;

import java.util.List;

public class MacroCommand implements Command {
    List<Command> commands;

    public MacroCommand(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (int i = 0; i < commands.size(); i++) {
            commands.get(i).execute();
        }
    }

    @Override
    public void undo() {
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
    }
}

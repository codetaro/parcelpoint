package command;

import template.Rack;
import template.Robot;
import template.RoboticArm;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParcelPointTest {

    public static void main(String[] args) {
        ParcelPoint parcelPoint = new ParcelPoint();

        Rack rack = new Rack(5, 10);
        Robot robot = new RoboticArm(-1, rack);

        List<String> commands = parseCommands("FD{foo}FFD{bar}RFFD{Foo}RFFD{World}D{}DA{hello}");
        Command macro = createMacroCommand(commands, robot);

        parcelPoint.setCommand(macro);
        parcelPoint.simulateArm();

        System.out.println(rack.getCurrentState());
    }

    public static List<String> parseCommands(String input) {
        String regex = "(F)|(D[\\w]*\\{[\\w]*\\})|(R)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> commands = new ArrayList<String>();
        while (matcher.find()) {
            commands.add(matcher.group());
        }
        return commands;
    }

    public static Command createMacroCommand(List<String> commands, Robot robot) {
        List<Command> commandList = new ArrayList<>();
        for (String command : commands) {
            if (command.matches("F")) {
                commandList.add(new RobotForwardCommand(robot));
            }
            if (command.matches("D[\\w]*\\{[\\w]*\\}")) {
                Pattern pattern = Pattern.compile("D[\\w]*\\{([\\w]*)\\}");
                Matcher matcher = pattern.matcher(command);
                if (matcher.find())
                    commandList.add(new RobotDropCommand(robot, matcher.group(1)));
            }
            if (command.matches("R")) {
                commandList.add(new RobotResetCommand(robot));
            }
        }
        return new MacroCommand(commandList);
    }
}
package template;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Robot {
    protected int position;
    protected Rack rack;

    public Robot(int position, Rack rack) {
        this.position = position;
        this.rack = rack;
    }

    public final Map<String, List> simulateArm(final String input) {
        List<String> commands = parseCommands(input);
        return execute(commands);
    }

    private List<String> parseCommands(String input) {
        String regex = "(F)|(D[\\w]*\\{[\\w]*\\})|(R)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> commands = new ArrayList<String>();
        while (matcher.find()) {
            commands.add(matcher.group());
        }
        return commands;
    }

    private Map<String, List> execute(List<String> commands) {
        for (String command : commands) {
            if (command.matches("F")) forward(rack);
            if (command.matches("D[\\w]*\\{[\\w]*\\}")) {
                Pattern pattern = Pattern.compile("D[\\w]*\\{([\\w]*)\\}");
                Matcher matcher = pattern.matcher(command);
                if (matcher.find()) drop(rack, matcher.group(1));
            }
            if (command.matches("R")) reset();
        }
        return rack.getCurrentState();
    }

    public void forward() {
        forward(this.rack);
    }

    public abstract void forward(Rack rack);

    public void drop(String load) {
        drop(this.rack, load);
    }

    public abstract void drop(Rack rack, String load);

    public abstract void reset();
}

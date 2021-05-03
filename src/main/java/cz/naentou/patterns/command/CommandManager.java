package cz.naentou.patterns.command;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    private int index = 0;
    private final List<Command> stack = new ArrayList<>();

    public String invoke(Command command) {
        String text = command.execute();
        stack.add(command);
        index = stack.size()-1;

        return text;
    }

    public void undo() {
        if (index > -1) {
            Command command = stack.get(index--);
            if (command.isReversible()) {
                command.undo();
            }
        }
    }

    public void redo() {
        if (index < stack.size()-1) {
            Command command = stack.get(index++ + 1);
            command.execute();
        }
    }
}

package cz.naentou.patterns.command;

/**
 * Command Interface which will be implemented by the exact commands.
 *
 * @author Andy <borec(at)naentou.cz>
 */
public interface Command {

    String execute();

    void undo();

    default boolean isReversible() {
        return true;
    }
}

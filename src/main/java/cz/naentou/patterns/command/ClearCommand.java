package cz.naentou.patterns.command;

/**
 * @author Andy <borec(at)naentou.cz>
 */
public class ClearCommand implements Command {
    private final Document document;
    private String text;

    public ClearCommand(Document document) {
        this.document = document;
    }

    @Override
    public String execute() {
        this.text = this.document.copy();
        this.document.delete();

        return this.text;
    }

    @Override
    public void undo() {
        if (text != null) {
            this.document.insert(text, 0);
        }
    }
}

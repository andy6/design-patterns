package cz.naentou.patterns.command;

/**
 * @author Andy <borec(at)naentou.cz>
 */
public class CutCommand implements Command {

    private final Document document;
    private String text;
    private final int position;
    private final int length;

    public CutCommand(Document document, int position, int length) {
        this.document = document;
        this.position = position;
        this.length = length;
    }

    @Override
    public String execute() {
        this.text = this.document.copy(position, length);
        this.document.delete(position, length);

        return this.text;
    }

    @Override
    public void undo() {
        this.document.insert(text, position);
    }
}

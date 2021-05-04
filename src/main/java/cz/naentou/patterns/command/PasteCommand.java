package cz.naentou.patterns.command;

/**
 * @author Andy <borec(at)naentou.cz>
 */
public class PasteCommand implements Command {

    private final Document document;
    private final String text;
    private final int position;

    public PasteCommand(Document document, String text, int position) {
        this.document = document;
        this.text = text;
        this.position = position;
    }

    @Override
    public String execute() {
        this.document.insert(text, position);

        return this.document.read();
    }

    @Override
    public void undo() {
        this.document.delete(position, text.length());
    }
}


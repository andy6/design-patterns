package cz.naentou.patterns.command;

public class CopyCommand implements Command {

    private final Document document;
    private String text;
    private final int position;
    private final int length;

    public CopyCommand(Document document, int position, int length) {
        this.document = document;
        this.position = position;
        this.length = length;
    }

    @Override
    public String execute() {
        this.text = this.document.copy(position, length);

        return this.text;
    }

    @Override
    public void undo() {
        throw new RuntimeException("Undo of copy operation is not supported.");
    }

    @Override
    public boolean isReversible() { return false; }
}


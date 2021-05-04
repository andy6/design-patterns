package cz.naentou.patterns.command;

/**
 * @author Andy <borec(at)naentou.cz>
 */
public class DocumentInvoker {

    private Document document;
    private CommandManager commandManager;

    public DocumentInvoker(CommandManager commandManager, Document document) {
        this.document = document;
        this.commandManager = commandManager;
    }

    public String read() {
        return document.read();
    }

    public String cut(int position, int length) {
        Command cutCommand = new CutCommand(document, position, length);

        return commandManager.invoke(cutCommand);
    }

    public String copy() {
        Command copyCommand = new CopyCommand(document, 0, document.read().length());

        return commandManager.invoke(copyCommand);
    }

    public String copy(int position, int length) {
        Command copyCommand = new CopyCommand(document, position, length);

        return commandManager.invoke(copyCommand);
    }

    public String paste(String text, int position) {
        Command pasteCommand = new PasteCommand(document, text, position);

        return commandManager.invoke(pasteCommand);
    }

    public String clear() {
        Command clearCommand = new ClearCommand(document);

        return commandManager.invoke(clearCommand);
    }

}

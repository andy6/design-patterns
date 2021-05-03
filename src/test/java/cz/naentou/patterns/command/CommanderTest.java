package cz.naentou.patterns.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommanderTest {

    private String initText;
    private CommandManager commandManager;
    private DocumentInvoker documentInvoker;

    @BeforeEach
    void setUp() {
        this.initText = "Initialization text. ";
        Document document = new Document(initText);

        this.commandManager = new CommandManager();
        this.documentInvoker = new DocumentInvoker(commandManager, document);
    }

    @Test
    public void commandStack() {
        String addedText = "Added another text. ";
        documentInvoker.paste(addedText, initText.length());
        assertEquals(initText + addedText, documentInvoker.read(), "1 PASTE("+addedText+") failed.");

        documentInvoker.cut(0, initText.length());
        assertEquals(addedText, documentInvoker.read(), "2 CUT(0, "+initText.length()+") failed.");

        commandManager.undo();
        commandManager.undo();
        commandManager.undo();
        commandManager.undo();
        assertEquals(initText, documentInvoker.read(), "3 UNDO failed.");

        commandManager.redo();
        commandManager.redo();
        commandManager.redo();
        commandManager.redo();
        assertEquals(addedText, documentInvoker.read(), "4 REDO failed.");

        String copiedText = documentInvoker.copy();
        assertEquals(copiedText, documentInvoker.read(), "5 COPY failed.");

        documentInvoker.clear();
        assertEquals("", documentInvoker.read(), "6 CLEAR failed.");

        commandManager.undo();
        assertEquals(copiedText, documentInvoker.read(), "7 UNDO failed.");

        copiedText = documentInvoker.copy(0, 3);
        assertEquals(copiedText, "Add", "5 COPY failed.");
    }
}

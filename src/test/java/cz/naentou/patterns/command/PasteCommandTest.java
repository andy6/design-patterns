package cz.naentou.patterns.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Andy <borec(at)naentou.cz>
 */
class PasteCommandTest {
    private String text;
    private PasteCommand pasteCommand;
    private Document document;

    @BeforeEach
    void setUp() {
        this.text = "Document text.";
        this.document = new Document("");
        this.pasteCommand = new PasteCommand(document, text, 0);
    }

    @org.junit.jupiter.api.Test
    void givenDocument_whenRunPasteCommand_thenReturnText() {
        String newText = pasteCommand.execute();
        assertEquals(newText, this.text);
    }

    @Test
    void givenDocument_whenRunUndo_thenThrowException() {
        pasteCommand.execute();
        pasteCommand.undo();

        assertEquals("", document.read());
    }
}
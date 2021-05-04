package cz.naentou.patterns.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Andy <borec(at)naentou.cz>
 */
class ClearCommandTest {

    private String text;
    private ClearCommand clearCommand;
    private Document document;

    @BeforeEach
    void setUp() {
        this.text = "Document text.";
        this.document = new Document(this.text);
        this.clearCommand = new ClearCommand(document);
    }

    @Test
    void givenDocument_whenRunClearCommand_thenReturnEmptyDocument() {
        clearCommand.execute();
        assertEquals("", document.read());
    }

    @Test
    void givenDocument_whenRunUndo_thenReturnOriginalDocumentText() {
        String originalText = clearCommand.execute();
        clearCommand.undo();

        assertEquals(originalText, this.text);
    }
}
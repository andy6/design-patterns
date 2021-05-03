package cz.naentou.patterns.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CopyCommandTest {

    private String text;
    private CopyCommand copyCommand;
    private Document document;

    @BeforeEach
    void setUp() {
        this.text = "Document text.";
        this.document = new Document(this.text);
        this.copyCommand = new CopyCommand(document, 0, text.length());
    }

    @Test
    void givenDocument_whenRunCopyCommand_thenReturnText() {
        String copiedText = copyCommand.execute();
        assertEquals(copiedText, this.text);
    }

    @Test
    void givenDocument_whenRunUndo_thenThrowException() {
        copyCommand.execute();

        assertFalse(copyCommand.isReversible());

        assertThrows(RuntimeException.class, () -> copyCommand.undo());
    }
}
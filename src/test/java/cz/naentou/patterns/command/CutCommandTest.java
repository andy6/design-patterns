package cz.naentou.patterns.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CutCommandTest {
    private String text;
    private CutCommand cutCommand;
    private Document document;

    @BeforeEach
    void setUp() {
        this.text = "Document text.";
        this.document = new Document(this.text);
        this.cutCommand = new CutCommand(document, 0, text.length());
    }

    @Test
    void givenDocument_whenRunCutCommand_thenReturnText() {
        String extractedText = cutCommand.execute();
        assertEquals(extractedText, this.text);
    }

    @Test
    void givenDocument_whenRunUndo_thenThrowException() {
        String extractedText = cutCommand.execute();
        cutCommand.undo();

        assertEquals(extractedText, this.text);
    }
}
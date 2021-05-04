package cz.naentou.patterns.composite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Andy <borec(at)naentou.cz>
 */
public class CompositeTest {
    private Directory root;
    private TextFile csvFile;
    private TextFile xmlFile;

    @BeforeEach
    void setUp() {
        this.root = new Directory("root");
        this.csvFile = new TextFile("file.csv", 64L);
        this.xmlFile = new TextFile("file.xml", 32L);
    }

    @Test
    public void givenFiles_whenCreateDirectory_thenComputeSizeofDirectory() {
        Directory subtitlesDir = new Directory("subtitles");
        TextFile firstSubFile = new TextFile("first.sub", 128L);
        TextFile secondSubFile = new TextFile("second.sub", 256L);

        root.addFile(csvFile);
        root.addFile(xmlFile);

        subtitlesDir.addFile(xmlFile);
        subtitlesDir.addFile(firstSubFile);
        subtitlesDir.addFile(secondSubFile);
        subtitlesDir.removeFile(xmlFile);
        subtitlesDir.addFile(new Directory("emptyDirectory"));

        root.addFile(subtitlesDir);

        assertEquals(480L, root.getSize());

        System.out.println(root.getFiles());
    }
}

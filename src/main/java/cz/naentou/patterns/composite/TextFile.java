package cz.naentou.patterns.composite;

/**
 * @author Andy <borec(at)naentou.cz>
 */
public class TextFile implements File {
    private final String name;
    private final String type;
    private final long size;

    public TextFile(String name, long size) {
        this.name = name;
        this.type = "file";
        this.size = size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public long getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return "TextFile{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", size=" + size +
                "}\n";
    }
}

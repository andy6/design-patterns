package cz.naentou.patterns.composite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Andy <borec(at)naentou.cz>
 */
public class Directory implements File {
    private final String name;
    private final String type;
    private final List<File> files = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
        this.type = "dir";
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

        return files.stream().mapToLong(File::getSize).sum();
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void removeFile(File file) {
        files.remove(file);
    }

    public Collection<File> getFiles() {
        return files;
    }

    @Override
    public String toString() {
        return "Directory{" +
                "name='" + name + '\'' +
                ", files=" + files +
                ", size=" + getSize() +
                "}\n";
    }
}

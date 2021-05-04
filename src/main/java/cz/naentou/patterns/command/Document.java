package cz.naentou.patterns.command;

/**
 * Receiver.
 *
 * @author Andy <borec(at)naentou.cz>
 */
public class Document {

    private String text;

    public Document(String text) {
        this.text = text;
    }

    public String read() {
        return text;
    }

    public void insert(String text, int position) {
        this.text = new StringBuilder(this.text).insert(position, text).toString();
    }

    public void delete() {
        this.text = "";
    }

    public void delete(int position, int length) {
        this.text = new StringBuilder(this.text).delete(position, position+length).toString();
    }

    public String copy() {
        return this.text;
    }

    public String copy(int position, int length) {
        return new StringBuilder(this.text).substring(position, position+length);
    }
}

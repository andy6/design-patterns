package cz.naentou.patterns.builder;

import java.util.Objects;

/**
 * @author Andy <borec(at)naentou.cz>
 */
public class Size implements Cloneable {
    private String value;

    public Size(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return new Size(this.getValue());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Size size = (Size) o;
        return Objects.equals(value, size.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

package lab.O5fifth.languageClasses.textParts.sentenceParts;

import java.util.Objects;

public class Mark implements SentencePart {
    private final char value;

    public Mark(char value) {
        if (".,!?;:'\"()<>+-".contains(String.valueOf(value))) {
            this.value = value;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Mark(String value) {
        if (value.length() == 1 || ".,!?;:'\"()<>+-".contains(String.valueOf(value))) {
            this.value = value.charAt(0);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public char getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark = (Mark) o;
        return value == mark.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

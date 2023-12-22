package lab.O5fifth.languageClasses.textParts.sentenceParts.wordPart;

public class Letter {
    private final char value;

    public Letter(char value) {
        if (Character.isLetter(value)) {
            this.value = value;
        } else throw new IllegalArgumentException();
    }

    public Letter(String value) {
        if (value.length() == 1 && (Character.isLetter(value.charAt(0)) || "'-".contains(value))) {
            this.value = value.charAt(0);
        } else throw new IllegalArgumentException(value);
    }

    public char getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

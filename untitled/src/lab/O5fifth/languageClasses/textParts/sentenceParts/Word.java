package lab.O5fifth.languageClasses.textParts.sentenceParts;

import lab.O5fifth.languageClasses.textParts.sentenceParts.wordPart.Letter;

import java.util.Arrays;

public class Word implements SentencePart {
    private final Letter[] value;

    public Word(Letter[] value) {
        this.value = value;
    }

    public Word(String string) {
        this.value = Arrays.stream(string.trim().split("")).map(Letter::new).toList().toArray(new Letter[0]);
    }

    public Letter[] getValue() {
        return value;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Letter letter : value) {
            str.append(letter);
        }
        return str.toString();
    }
}

package lab.O5fifth.languageClasses;

import lab.O5fifth.languageClasses.textParts.sentenceParts.Mark;
import lab.O5fifth.languageClasses.textParts.sentenceParts.SentencePart;
import lab.O5fifth.languageClasses.textParts.sentenceParts.Word;

import java.util.Arrays;

public class Sentence {
    private final SentencePart[] value;

    public Sentence(SentencePart[] value) {
        this.value = value;
    }

    public Sentence(String string) {
        String[] wordsAndMarks = string.trim().split("(?=[.,!?;:\"()<>+])|\\s+");
        System.out.println(Arrays.stream(wordsAndMarks).toList());
        this.value = new SentencePart[wordsAndMarks.length];
        for (int i = 0; i < wordsAndMarks.length; i++) {
            if (wordsAndMarks[i].length() == 1 && ".,!?;:\"()<>+".contains(wordsAndMarks[i])) {
                this.value[i] = new Mark(wordsAndMarks[i]);
            } else {
                this.value[i] = new Word(wordsAndMarks[i]);
            }
        }

    }

    public SentencePart[] getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < value.length; i++) {
            str.append(value[i]);
            if (!(i == value.length - 1 || value[i + 1] instanceof Mark)) {
                str.append(" ");
            }
        }
        return str.toString();
    }
}

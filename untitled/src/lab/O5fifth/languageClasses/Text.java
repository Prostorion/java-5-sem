package lab.O5fifth.languageClasses;

import java.util.ArrayList;
import java.util.List;

public class Text {
    private final Sentence[] value;

    public Sentence[] getValue() {
        return value;
    }

    public Text(String string) {
        List<String> sentences = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            str.append(string.charAt(i));
            if ("?.!".contains(String.valueOf(string.charAt(i)))) {
                sentences.add(str.toString());
                str = new StringBuilder();
            }
        }
        this.value = new Sentence[sentences.size()];
        for (int i = 0; i < this.value.length; i++) {
            this.value[i] = new Sentence(sentences.get(i));
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Sentence sentence : value) {
            str.append(sentence).append(" ");
        }
        return str.toString();
    }
}

package lab.O5fifth;

import lab.O5fifth.languageClasses.Text;
import lab.O5fifth.languageClasses.textParts.sentenceParts.Mark;
import lab.O5fifth.languageClasses.textParts.sentenceParts.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FifthLabClass {
    /*
    variant 20
    C3 = 2 -> String
    C17 = 3 -> В усіх питальних реченнях заданого тексту знайти та надрукувати без повторень слова заданої довжини.
    */
    public static void main(String[] args) {
        String string = "What is the meaning of life? Life's meaning varies from person to person. " +
                "Are you content with your current situation? Contentment often eludes those chas" +
                "ing material success. How can one find inner peace? Inner peace can be attained " +
                "through mindfulness and self-acceptance. Why do we fear the unknown? Fear of the" +
                " unknown stems from our natural survival instincts. What's the key to a successf" +
                "ul relationship? Communication and trust are crucial for a successful relationsh" +
                "ip. How can we combat climate change? Combating climate change requires global c" +
                "ooperation and sustainable practices. What's the significance of art in society?" +
                " Art enriches society by offering unique perspectives and emotional expression. " +
                "Can we ever truly understand the universe?";
        Text text = new Text(string);
        System.out.println(text);

        getWordsFromQuestions(text, 3);
    }

    private static void getWordsFromQuestions(Text text, int length) {
        Arrays.stream(text.getValue())
                .filter(sen -> sen.getValue()[sen.getValue().length - 1].equals(new Mark('?')))
                .map(sen -> {
                    List<Word> words = new ArrayList<>();
                    Arrays.stream(sen.getValue()).forEach(senPart -> {
                        if (senPart instanceof Word && ((Word) senPart).getValue().length == length) {
                            words.add((Word) senPart);
                        }
                    });
                    return words;
                })
                .forEach(System.out::println);
        ;
    }


}

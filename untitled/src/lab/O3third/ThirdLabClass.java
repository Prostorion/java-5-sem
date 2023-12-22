package lab.O3third;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThirdLabClass {
    public static void main(String[] args) {
        String text = "What is the meaning of life? Life's meaning varies from person to person. " +
                "Are you content with your current situation? Contentment often eludes those chas" +
                "ing material success. How can one find inner peace? Inner peace can be attained " +
                "through mindfulness and self-acceptance. Why do we fear the unknown? Fear of the" +
                " unknown stems from our natural survival instincts. What's the key to a successf" +
                "ul relationship? Communication and trust are crucial for a successful relationsh" +
                "ip. How can we combat climate change? Combating climate change requires global c" +
                "ooperation and sustainable practices. What's the significance of art in society?" +
                " Art enriches society by offering unique perspectives and emotional expression. " +
                "Can we ever truly understand the universe?";
        String[] questions = getQuestions(text);
        for (String s : questions) {
            System.out.println(s);
        }
        outputWords(questions, 5);
    }


    /*
    variant 20
    C3 = 2 -> String
    C17 = 3 -> В усіх питальних реченнях заданого тексту знайти та надрукувати без повторень слова заданої довжини.
     */
    private static String[] getQuestions(String text) {
        //first spit - split by "?" - result is parts of text with questions in the end.
        //So we can split those parts into sentences. Last and only always is the question.
        String[] firstSplit = text.split("[?]+\\s*");
        List<String> questions = new ArrayList<>();
        for (String s : firstSplit) {
            String[] secondSplit = s.split("[.!?]+\\s*");
            questions.add(secondSplit[secondSplit.length - 1]);
        }
        return questions.toArray(new String[0]);
    }

    private static void outputWords(String[] questions, int length) {
        StringBuilder str = new StringBuilder();
        Arrays.stream(questions).forEach(string -> str.append(" ").append(string).append(" "));
        String[] words = str.toString().split("\\s+");
        for (String word : words) {
            if (word.length() == length) System.out.println(word);
        }
    }
}

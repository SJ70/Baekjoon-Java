import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1339 {

    private static List<String> words = new ArrayList<>();

    private static class Alphabet {
        char alphabet;
        int score = 0;
        int value = 0;

        public Alphabet (char alphabet) {
            this.alphabet = alphabet;
        }

        public String toString() {
            return alphabet + ":" + score + ":" + value;
        }
    }

    private static List<Alphabet> alphabets = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();

        for (String word : words) {
            addAlphabetScore(word);
        }

        Collections.sort(alphabets, (o1, o2) -> - o1.score + o2.score);
        for (int i=0; i<=9; i++) {
            alphabets.get(i).value = 9 - i;
        }

        Collections.sort(alphabets, (o1, o2) -> o1.alphabet - o2.alphabet);

        System.out.println(calcResult());
//        System.out.println(alphabets);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<26; i++) {
            alphabets.add(new Alphabet((char) ('A' + i)));
        }
        for (int i=0; i<n; i++) {
            String word = br.readLine();
            words.add(word);
        }
    }

    private static void addAlphabetScore(String word) {
        int length = word.length();
        for (int i=0; i<length; i++) {
            int charIndex = word.charAt(i) - 'A';
            int score = (int) Math.pow(10, length - i - 1);
            alphabets.get(charIndex).score += score;
        }
    }

    private static int calcResult() {
        int result = 0;
        for (String word : words) {
            result += getNumValue(word);
        }
        return result;
    }

    private static int getNumValue(String word) {
        int result = 0;
        int length = word.length();
        for (int i=0; i<length; i++) {
            char c = word.charAt(i);
            int charIndex = c - 'A';
            result *= 10;
            result += alphabets.get(charIndex).value;
        }
        return result;
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15947 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = "baby sukhwan tururu turu very cute tururu turu in bed tururu turu baby sukhwan".split(" ");
        String word = words[(N - 1) % words.length];
        int add = (N - 1) / words.length;
        if (word.startsWith("turu") && add > 0) {
            word = word + "ru".repeat(add);
            if (word.length() >= 12) {
                word = "tu+ru*" + (word.length()-2)/2;
            }
        }
        System.out.println(word);
    }

}

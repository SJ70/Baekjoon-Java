import java.io.*;
import java.util.*;

public class _1181 {

    public static void main(String[] args) throws IOException {

        // list
        List<String> words = new ArrayList<>();

        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            words.add(br.readLine());
        }

        // sort
        Collections.sort(words, (a, b) -> {
            int aLength = a.length();
            int bLength = b.length();

            if (aLength == bLength) {
                for (int i = 0; i < aLength; i++) {
                    char aChar = a.charAt(i);
                    char bChar = b.charAt(i);
                    if (aChar != bChar) {
                        return aChar - bChar;
                    }
                }
            }

            return aLength - bLength;
        });

        // output
        StringBuilder sb = new StringBuilder();

        sb.append(words.get(0));
        for (int i=1; i<n; i++) {
            if (words.get(i).equals(words.get(i-1))) {
                continue;
            }
            sb.append('\n');
            sb.append(words.get(i));
        }
        System.out.println(sb);

    }

}
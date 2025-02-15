import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _6996 {

    private static boolean solveAnagrams(String first, String second ) {
        int[] arr = new int[26];
        for (char c : first.toCharArray()) {
            arr[c - 'a']++;
        }
        for (char c : second.toCharArray()) {
            arr[c - 'a']--;
        }
        for (int value : arr) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTests = sc.nextInt();

        for (int i = 0; i < numTests; i++) {
            String first = sc.next().toLowerCase();
            String second = sc.next().toLowerCase();

            System.out.println(first + " & " + second + " are " + (solveAnagrams(first, second) ? "anagrams." : "NOT anagrams."));
        }
    }
}

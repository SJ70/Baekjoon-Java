import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _3062 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            sb.append(isPalindromeWhenFlipAndSum(br.readLine()) ? "YES\n" : "NO\n");
        }
        System.out.print(sb);
    }

    private static boolean isPalindromeWhenFlipAndSum(String str) {
        int length = str.length();
        int flippedNum = 0;
        for (int i = length - 1; i >= 0; i--) {
            flippedNum *= 10;
            flippedNum += str.charAt(i) - '0';
        }
        int num = Integer.parseInt(str);
        int sum = flippedNum + num;
        String sumString = String.valueOf(sum);
        return isPalindrome(sumString);
    }

    private static boolean isPalindrome(String str) {
        int length = str.length();
        int left = 0;
        int right = length - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

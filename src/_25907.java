import java.util.Scanner;

public class _25907 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int left = 1;
        int right = N;
        while (true) {
            int mid = (left + right) / 2;
            System.out.printf("? %d\n", mid);
            System.out.flush();
            int sheep = sc.nextInt();
            int wolves = mid - sheep;

            if (sheep == wolves) {
                System.out.printf("! %d\n", mid);
                System.out.flush();
                return;
            }
            else if (sheep < wolves) {
                right = mid;
            }
            else {
                left = mid;
            }
        }

    }

}

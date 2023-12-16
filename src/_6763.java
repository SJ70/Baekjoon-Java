import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6763 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int limit = Integer.parseInt(br.readLine());
        int speed = Integer.parseInt(br.readLine());
        int diff = limit - speed;

        int cost = 0;
        if (diff <= -30) {
            cost = 500;
        }
        else if (diff <= -21) {
            cost = 270;
        }
        else if (diff <= -1) {
            cost = 100;
        }
        else {
            System.out.println("Congratulations, you are within the speed limit!");
            return;
        }

        System.out.printf("You are speeding and your fine is $%d.\n", cost);
    }

}

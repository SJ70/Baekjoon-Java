import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _33191 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        if (money >= Integer.parseInt(br.readLine())) {
            System.out.println("Watermelon");
            return;
        }
        if (money >= Integer.parseInt(br.readLine())) {
            System.out.println("Pomegranates");
            return;
        }
        if (money >= Integer.parseInt(br.readLine())) {
            System.out.println("Nuts");
            return;
        }
        System.out.println("Nothing");
    }
}

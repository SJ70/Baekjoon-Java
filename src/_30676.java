import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _30676 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(getResult(Integer.parseInt(br.readLine())));

    }

    private static String getResult(int value){
        if (value >= 620) {
            return "Red";
        }
        if (value >= 590) {
            return "Orange";
        }
        if (value >= 570) {
            return "Yellow";
        }
        if (value >= 495) {
            return "Green";
        }
        if (value >= 450) {
            return "Blue";
        }
        if (value >= 425) {
            return "Indigo";
        }
        if (value >= 380) {
            return "Violet";
        }
        return "";
    }

}

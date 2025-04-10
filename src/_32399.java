import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _32399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        switch (br.readLine()) {
            case "(1)":
                System.out.println(0);
                break;
            case "()1":
            case "1()":
            case ")(1":
            case "1)(":
                System.out.println(1);
                break;
            case ")1(":
                System.out.println(2);
                break;
        }
    }

}

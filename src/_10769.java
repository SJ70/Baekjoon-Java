import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10769 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] smile = str.split(":-\\)");
        String[] sad = str.split(":-\\(");

        if (smile.length==1 && sad.length==1) {
            System.out.println("none");
            return;
        }
        if (smile.length == sad.length) {
            System.out.println("unsure");
            return;
        }
        if (smile.length > sad.length) {
            System.out.println("happy");
            return;
        }
        if (smile.length < sad.length) {
            System.out.println("sad");
            return;
        }

    }

}

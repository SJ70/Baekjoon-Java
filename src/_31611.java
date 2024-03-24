import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _31611 {

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        System.out.println( n%7==2 ? 1 : 0 );

    }

}

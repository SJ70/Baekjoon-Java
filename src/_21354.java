import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _21354 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()) * 7;
        int P = Integer.parseInt(st.nextToken()) * 13;
        switch (Integer.compare(A, P)) {
            case -1:
                System.out.println("Petra");
                return;
            case 0:
                System.out.println("lika");
                return;
            case 1:
                System.out.println("Axel");
                return;
        }
    }

}

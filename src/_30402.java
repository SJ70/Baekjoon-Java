import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _30402 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i<15; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<15; j++) {
                switch (st.nextToken().charAt(0)) {
                    case 'w' :
                        System.out.println("chunbae");
                        return;
                    case 'b' :
                        System.out.println("nabi");
                        return;
                    case 'g' :
                        System.out.println("yeongcheol");
                        return;
                }
            }
        }

    }

}

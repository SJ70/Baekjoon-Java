import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _29267 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int save = 0;
        int current = 0;
        for (int i=0; i<N; i++) {
            switch (br.readLine()) {
                case "save":
                    save = current;
                    break;
                case "load":
                    current = save;
                    break;
                case "shoot":
                    current--;
                    break;
                case "ammo":
                    current += K;
                    break;
            }
            System.out.println(current);
        }
    }

}

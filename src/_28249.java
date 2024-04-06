import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _28249 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i=0; i<n; i++) {
            switch (br.readLine()) {
                case "Poblano" : result += 1500; break;
                case "Mirasol" : result += 6000; break;
                case "Serrano" : result += 15500; break;
                case "Cayenne" : result += 40000; break;
                case "Thai" : result += 75000; break;
                case "Habanero" : result += 125000; break;
            }
        }

        System.out.println(result);
    }

}

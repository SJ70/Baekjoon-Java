import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _29823 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ns = 0;
        int ew = 0;
        for (char c : br.readLine().toCharArray()) {
            switch (c) {
                case 'N' : ns--; break;
                case 'S' : ns++; break;
                case 'E' : ew--; break;
                case 'W' : ew++; break;
                default : break;
            }
        }
        System.out.println(Math.abs(ns) + Math.abs(ew));
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11586 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] strings = new String[N];
        for (int i=0; i<N; i++) {
            strings[i] = br.readLine();
        }
        switch (Integer.parseInt(br.readLine())) {
            case 1 :
                for (int r=0; r<N; r++) {
                    System.out.println(strings[r]);
                }
                break;
            case 2 :
                for (int r=0; r<N; r++) {
                    for (int c=0; c<N; c++) {
                        System.out.print(strings[r].charAt(N-1-c));
                    }
                    System.out.println();
                }
                break;
            case 3 :
                for (int r=0; r<N; r++) {
                    System.out.println(strings[N-1-r]);
                }
                break;
        }
    }

}

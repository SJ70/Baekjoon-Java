import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _21895 {

    private static class RSP {
        int r = 0;
        int s = 0;
        int p = 0;

        public char getMaxWin() {
            if (r == 2) {
                return 'P';
            }
            if (s == 2) {
                return 'R';
            }
            if (p == 2) {
                return 'S';
            }

            if (r == 0) {
                return 'S';
            }
            if (p == 0) {
                return 'R';
            }
            if (s == 0) {
                return 'P';
            }
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        RSP[] rsps = new RSP[N];
        for (int i=0; i<N; i++) {
            rsps[i] = new RSP();
        }
        for (int i=0; i<2; i++) {
            String str = br.readLine();
            for (int j=0; j<N; j++) {
                switch (str.charAt(j)) {
                    case 'R' : rsps[j].r++; break;
                    case 'S' : rsps[j].s++; break;
                    case 'P' : rsps[j].p++; break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (RSP rsp : rsps) {
            sb.append(rsp.getMaxWin());
        }
        System.out.println(sb);

    }

}

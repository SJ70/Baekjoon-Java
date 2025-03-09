import java.io.*;

public class _9663 {
    public static void main(String[] args) throws IOException {
        init();
        BT(0,0);
        System.out.println(answer);
    }
    static int N, answer;
    static boolean[] checkC, checkD1, checkD2;
    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = 0;
        checkC = new boolean[N];
        checkD1 = new boolean[2*N-1];
        checkD2 = new boolean[2*N-1];
    }

    public static void BT(int r, int c){
        if(r==N){
            answer++;
            return;
        }

        int d1 = r+c;
        int d2 = N-1-r+c;

        if(!checkC[c] && !checkD1[d1] && !checkD2[d2]){
            checkC[c] = checkD1[d1] = checkD2[d2] = true;
            BT(r+1,0);
            checkC[c] = checkD1[d1] = checkD2[d2] = false;
        }
        if(c+1<N){
            BT(r,c+1);
        }
    }

}
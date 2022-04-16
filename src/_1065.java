import java.io.*;
public class _1065 {
    public static boolean Hansu(int n){
        int hun = n/100;
        int ten = n%100/10;
        int one = n%10;
        return hun-ten == ten-one;
    }
    public static void main(String[] args) throws IOException {
        String NN = new BufferedReader(new InputStreamReader(System.in)).readLine();
        int N = Integer.parseInt(NN);
        int cnt = 99; // 1부터 99까지의 한수
        // 두 자리 수인 경우 이하의 수가 모두 한수
        if(NN.length()<=2) cnt = N;
        else for(int i=100; i<=N; i++) if(Hansu(i)) cnt++;
        System.out.println(cnt);
    }
}

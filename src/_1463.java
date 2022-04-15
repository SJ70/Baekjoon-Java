import java.util.*;
import java.io.*;
public class _1463{

    static Queue<Integer> q = new LinkedList<>();
    static int N;
    static int[] X;

    public static void fill(int n1, int n0){
        if(X[n1]==0) { // 나중에 들어오는 카운트 값이 크므로 값이 비어있을 때만 넣음
            X[n1] = X[n0] + 1;
            q.add(n1);
            //System.out.print(" "+n1);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        X = new int[N+1];

        q.add(1);
        if(N!=1)
            while(X[N]==0) {
                int n = q.poll();
                //System.out.print(X[n]+1+":");
                if(n*3<=N) fill(n*3,n);
                if(n*2<=N) fill(n*2,n);
                fill(n+1,n);
                //System.out.println();
            }
        System.out.println(X[N]);
    }
}
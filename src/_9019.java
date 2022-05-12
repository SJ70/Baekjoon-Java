import java.io.*;
import java.util.*;

public class _9019 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, target;
    static String[] arr;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());
            arr = new String[10000];
            arr[N]="";
            q = new ArrayDeque<>();
            Solve(N);
            //test_print();
            bw.write(arr[target]+"\n");
        }
        bw.flush();
    }
    public static void Solve(int n){
        D(n);
        S(n);
        L(n);
        R(n);
        if(arr[target]==null)
            Solve(q.poll());
    }
    public static void D(int m){
        int n = m*2;
        if(n>9999) n%=10000;
        if(arr[n]==null){
            arr[n]=arr[m]+"D";
            q.add(n);
        }
    }
    public static void S(int m){
        int n = m-1;
        if(n==-1) n=9999;
        if(arr[n]==null){
            arr[n]=arr[m]+"S";
            q.add(n);
        }
    }
    public static void L(int m){
        int n = m;
        int tmp = n/1000;
        n*=10;
        n+=tmp;
        n%=10000;
        if(arr[n]==null) {
            arr[n]=arr[m]+"L";
            q.add(n);
        }
    }
    public static void R(int m){
        int n = m;
        int tmp = n%10;
        n+= tmp*10000;
        n/=10;
        if(arr[n]==null){
            arr[n]=arr[m]+"R";
            q.add(n);
        }
    }
    public static void test_print(){
        for(int i=0; i<10000; i++){
            if(arr[i]!=null)
                System.out.println(i+":"+arr[i]);
        }
    }
}

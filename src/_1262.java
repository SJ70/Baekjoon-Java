import java.io.*;
import java.util.*;

public class _1262 {
    static int N, r1, c1, r2, c2, size, mid;

    public static void main(String[] args) throws IOException{
        input();
        size = 2*N-1;
        mid = N-1;
        print();
    }
    public static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
    }
    public static char getChar(int r, int c){
        int dist = Math.abs(r-mid) + Math.abs(c-mid);
        return (dist<N) ? (char)('a'+dist%26) : '.';
    }
    public static void print(){
        StringBuilder sb = new StringBuilder();
        for(int r=r1; r<=r2; r++){
            for(int c=c1; c<=c2; c++){
                sb.append(getChar(r%size,c%size));
            }
            if(r<r2) sb.append('\n');
        }
        System.out.print(sb);
    }
}

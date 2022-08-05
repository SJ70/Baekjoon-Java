import java.util.*;

public class _1697 {
    public static void main(String[] args){
        Integer[] time = new Integer[100001];
        Queue<Integer> q = new ArrayDeque<>();

        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        q.add(start); q.add(0);
        int end = sc.nextInt();

        while(!q.isEmpty()){
            int N = q.poll();
            int T = q.poll();
            if( N<0 || N>100000 || time[N]!=null ) continue;
            time[N] = T;
            if( N==end ) break;
            q.add(N*2); q.add(T+1);
            q.add(N-1); q.add(T+1);
            q.add(N+1); q.add(T+1);
        }
        System.out.println(time[end]);
    }
}
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class _16953 {
    static Scanner sc = new Scanner(System.in);
    static int start,end;
    static long Result = -1L;
    public static void main(String[] args){
        start = sc.nextInt();
        end = sc.nextInt();

        QueueAdd(start,1);
        while(!Q.isEmpty())
            BFS(Q.poll(),Qt.poll());
        System.out.println(Result);
    }
    static Queue<Integer> Q = new ArrayDeque<>();
    static Queue<Integer> Qt = new ArrayDeque<>();
    public static void BFS(int n, int time){
        if(n>end) return;
        if(n==end){
            Q.clear();
            Result=time;
            return;
        }
        if(n<=1000000000/2) QueueAdd(n*2,time+1);
        if(n<1000000000/10-1) QueueAdd(n*10+1,time+1);
    }
    public static void QueueAdd(int n, int time){
        Q.add(n);
        Qt.add(time);
    }
}

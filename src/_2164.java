import java.util.*;

public class _2164 {
    static Deque<Integer> D = new ArrayDeque<>();
    public static void main(String[] args){
        int N = new Scanner(System.in).nextInt();
        for(int i=1; i<=N; i++){
            D.addLast(i);
        }
        while(D.size()>1){
            D.pollFirst();
            D.addLast(D.pollFirst());
        }
        System.out.println(D.poll());
    }
}

import java.util.*;

public class _12852 {
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> q = new ArrayDeque<>();
    static int N;
    static Integer[] arr, history;
    public static void main(String[] args){
        N = new Scanner(System.in).nextInt();

        if(N==1){
            System.out.println(0+"\n"+1);
            return;
        }

        arr = new Integer[N+1];
        history = new Integer[N+1];
        arr[N] = 0;
        q.add(N); q.add(1);
        while(!q.isEmpty()){
            int n = q.poll();
            int t = q.poll();
            if(n==1){
                q.clear();
                break;
            }
            if(n%3==0 && arr[n/3]==null){
                arr[n/3]=t;
                history[n/3]=n;
                q.add(n/3); q.add(t+1);
            }
            if(n%2==0 && arr[n/2]==null){
                arr[n/2]=t;
                history[n/2]=n;
                q.add(n/2); q.add(t+1);
            }
            if(n>1 && arr[n-1]==null){
                arr[n-1]=t;
                history[n-1]=n;
                q.add(n-1); q.add(t+1);
            }
        }
        //print();
        int x = 1;
        while(true){
            x=history[x];
            q.addFirst(x);
            if(x==N) break;
        }
        sb.append(q.size()+"\n");
        q.addLast(1);
        while(!q.isEmpty()){
            sb.append(q.poll()+" ");
        }
        System.out.println(sb);
    }
    public static void print(){
        System.out.println();
        for(int i=0; i<=N; i++){
            System.out.printf("%5d",i);
        }
        System.out.println();
        for(int i=0; i<=N; i++){
            System.out.printf("%5d",arr[i]);
        }
        System.out.println();
        for(int i=0; i<=N; i++){
            System.out.printf("%5d",history[i]);
        }
        System.out.println();
    }
}

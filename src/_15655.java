import java.io.*;
import java.util.*;

public class _15655 {
    static int N,M;
    static ArrayList<Integer> nums = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(nums);

        BT(0,0);
        System.out.println(sb);
    }
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> q = new ArrayDeque<>();
    public static void BT(int index, int cnt){
        if(cnt==M){
            for(int i=0; i<M; i++){
                sb.append(q.peekFirst()).append(' ');
                q.add(q.pollFirst());
            }
            sb.append('\n');
            return;
        }
        if(index>=N) return;
        q.addLast(nums.get(index));
        BT(index+1, cnt+1);
        q.pollLast();
        BT(index+1, cnt);
    }
}

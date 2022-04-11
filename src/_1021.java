import java.io.*;
import java.util.*;
public class _1021 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        int result_cnt=0;

        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<N;i++)
            q.add(i+1);

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            int cnt = 0;
            int dest = Integer.parseInt(st2.nextToken());
            // 찾는 원소가 아닌 경우
            while(dest!=q.peek()){
//                bw.write(q.peek()+" ");
                q.add(q.poll());
                cnt++;
            }
//            bw.write("\n");
            // 최단거리가 반대방향
            if(q.size()-cnt < cnt)
                cnt = q.size()-cnt;
            result_cnt += cnt;
            // 찾은 경우 poll
            q.poll();
        }
        bw.write(String.valueOf(result_cnt));
        bw.flush();
    }
}

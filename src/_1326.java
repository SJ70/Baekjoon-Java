import java.io.*;
import java.util.*;

public class _1326 {
    static int N, FROM, TO;
    static int[] MAP, visitedTime;
    static Queue<Integer> Q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        input();

        visitedTime = new int[N];
        for(int i=0; i<N; i++){
            visitedTime[i] = -1;
        }
        Q.add(FROM);
        visitedTime[FROM] = 0;
        for(int time=1; !Q.isEmpty(); time++){
            int Q_size = Q.size();
            for(int i=0; i<Q_size; i++){
                int pos = Q.poll();
                for(int left = pos - MAP[pos]; left>=0; left-=MAP[pos]){
                    if(visitedTime[left]==-1){
                        visitedTime[left] = time;
                        Q.add(left);
                    }
                }
                for(int right = pos + MAP[pos]; right<N; right+=MAP[pos]){
                    if(visitedTime[right]==-1){
                        visitedTime[right] = time;
                        Q.add(right);
                    }
                }
            }
        }

        System.out.println(visitedTime[TO]);
    }
    public static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st_map = new StringTokenizer(br.readLine());
        StringTokenizer st_from_to = new StringTokenizer(br.readLine());

        MAP = new int[N];
        for(int i=0; i<N; i++){
            MAP[i] = Integer.parseInt(st_map.nextToken());
        }

        FROM = Integer.parseInt(st_from_to.nextToken()) -1;
        TO = Integer.parseInt(st_from_to.nextToken()) -1;
    }
}

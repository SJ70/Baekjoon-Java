import java.io.*;
import java.util.*;

public class _2170 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> lines = new PriorityQueue<>(
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] l1, int[] l2) {
                        if(l1[0]==l2[0]) return l1[1]-l2[1];
                        return l1[0]-l2[0];
                    }
                }
        );
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int length = 0;
        int currentPos = Integer.MIN_VALUE;
        while(!lines.isEmpty()){
            int from = lines.peek()[0];
            int to = lines.poll()[1];
//            System.out.printf("%d %d %d %d\n",from , to,currentPos, to - Math.max(from,currentPos));
            if(to<currentPos) continue;
            length += to - Math.max(from,currentPos);
            currentPos = to;
        }
        System.out.println(length);
    }
}

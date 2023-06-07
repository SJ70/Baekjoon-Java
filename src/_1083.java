import java.util.*;
import java.io.*;

public class _1083 {

    static int N, S;
    static int[] Arr;

    public static void main(String[] args) throws IOException{
        input();
        sort();
        print();
    }

    public static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            Arr[i] = Integer.parseInt(st.nextToken());
        }

        S = Integer.parseInt(br.readLine());
    }

    public static void sort(){
        Comparator<int[]> comp = new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        };

        for(int i=0; i<N && S>0; i++){
            PriorityQueue<int[]> num = new PriorityQueue<>(comp); // [숫자,인덱스]
            for(int j=i; j<N; j++){
                num.add(new int[]{Arr[j],j});
            }

            while(!num.isEmpty()){
                int targetIndex = num.poll()[1];
                int swapCnt = targetIndex - i;
                if(S >= swapCnt){
                    if(swapCnt>0){
                        pull(i, targetIndex);
                        S -= swapCnt;
                    }
                    break;
                }
            }
        }
    }

    public static void pull(int to, int from){
        int tmp = Arr[from];
        for(int i=from; i>to; i--){
            Arr[i] = Arr[i-1];
        }
        Arr[to] = tmp;
    }

    public static void print(){
        StringBuilder sb = new StringBuilder();
        for(int e : Arr){
            sb.append(e).append(' ');
        }
        System.out.println(sb);
    }
}

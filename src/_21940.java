import java.io.*;
import java.util.*;

public class _21940 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] D = new int[N][N];
        for(int r=0; r<N; r++)
            for(int c=0; c<N; c++)
                D[r][c] = Integer.MAX_VALUE;
        int M = Integer.parseInt(st.nextToken());

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int time = Integer.parseInt(st.nextToken());
            D[from][to] = Math.min(D[from][to], time);
        }

        for(int across=0; across<N; across++){
            for(int from=0; from<N; from++){
                if(across==from || D[from][across]==Integer.MAX_VALUE) continue;
                for(int to=0; to<N; to++){
                    if(from==to || D[across][to]==Integer.MAX_VALUE) continue;
                    D[from][to] = Math.min(D[from][to], D[from][across]+D[across][to]);
                }
            }
        }
        for(int i=0; i<N; i++){
            D[i][i]=0;
        }

//        for(int from=0; from<N; from++){
//            System.out.println();
//            for(int to=0; to<N; to++){
//                System.out.printf("%4d",D[from][to]==Integer.MAX_VALUE?-1:D[from][to]);
//            }
//        }

        int K = Integer.parseInt(br.readLine());

        int[] home = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int k=0; k<K; k++){
            home[k] = Integer.parseInt(st.nextToken())-1;
        }

        Queue<Integer> answer = new ArrayDeque<>();
        int minMaxDist = Integer.MAX_VALUE;
        for(int dest=0; dest<N; dest++){
            int maxDist = 0;
            for(int i=0; i<K; i++){
                if(D[home[i]][dest]==Integer.MAX_VALUE || D[dest][home[i]]==Integer.MAX_VALUE){
                    maxDist = Integer.MAX_VALUE;
                    break;
                }
                maxDist = Math.max(maxDist, D[home[i]][dest] + D[dest][home[i]]);
            }
//            System.out.println(maxDist);
            if(minMaxDist > maxDist){
                answer.clear();
                minMaxDist = maxDist;
                answer.add(dest);
            }
            else if(minMaxDist == maxDist){
                answer.add(dest);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!answer.isEmpty()){
            sb.append(answer.poll()+1).append(' ');
        }
        System.out.println(sb);
    }
}

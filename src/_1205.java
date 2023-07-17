import java.io.*;
import java.util.*;

public class _1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int L = Math.min(N,P);

        if(N==0){
            if(P>0){
                System.out.println(1);
                return;
            }
            else {
                System.out.println(-1);
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] scores = new int[L];
        for(int i=0; i<L; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬 기준 순위
        int sortRank = N+1;
        for(int i=0; i<L; i++){
            if(score > scores[i]){
                sortRank = i+1;
                break;
            }
        }

        // 순위 표기 기준 순위
        int displayRank = N+1;
        for(int i=0; i<L; i++){
            if(score >= scores[i]){
                displayRank = i+1;
                break;
            }
        }

//        System.out.printf("sortRank:%d\n",sortRank);
//        System.out.printf("displayRank:%d\n",displayRank);
        if(sortRank>P){
            System.out.println(-1);
            return;
        }
        else{
            System.out.println(displayRank);
            return;
        }
    }
}

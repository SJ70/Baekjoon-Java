import java.io.*;
import java.util.*;

public class _2303 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{

        // init
        ArrayList<Integer>[] PlayersHaveScore = new ArrayList[10];
        for(int i=0; i<10; i++){
            PlayersHaveScore[i] = new ArrayList<>();
        }

        // input
        int N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N; i++){
            PlayersHaveScore[getMaxScore(inputCards())].add(i);
        }

        // print
        for(int i=9; i>=0; i--){
            if(!PlayersHaveScore[i].isEmpty()){
                System.out.println( PlayersHaveScore[i].get( PlayersHaveScore[i].size()-1 ) );
                return;
            }
        }

    }
    public static int[] inputCards() throws IOException{
        int[] arr = new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<5; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
    public static int getMaxScore(int[] arr){
        int max = -1;
        for(int i=0; i<3; i++){
            for(int j=i+1; j<4; j++){
                for(int k=j+1; k<5; k++){
                    max = Math.max( (arr[i]+arr[j]+arr[k])%10 , max);
                }
            }
        }
        return max;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _25916 {
    static int HoleCnt,MaxSize;
    static int[] Hole;
    public static void main(String[] args) throws IOException{
        init();
        int Max_Result = -1;
        int current_Sum = 0;
        int from = 0;
        for(int to=0; to<HoleCnt; to++) {
            current_Sum += Hole[to];
            while(current_Sum>MaxSize) {
                current_Sum -= Hole[from];
                from++;
            }
            Max_Result = Math.max(current_Sum,Max_Result);
            if(current_Sum==MaxSize){
                 break;
            }
        }
        System.out.println(Max_Result);
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HoleCnt = Integer.parseInt(st.nextToken());
        MaxSize = Integer.parseInt(st.nextToken());

        Hole = new int[HoleCnt];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<HoleCnt; i++){
            Hole[i] = Integer.parseInt(st.nextToken());
        }
    }
}

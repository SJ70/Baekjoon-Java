import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12865 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int ItemCnt, MaxWeight;
    static int[] Arr;
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        ItemCnt = Integer.parseInt(st.nextToken());
        MaxWeight = Integer.parseInt(st.nextToken());
        Arr = new int[MaxWeight+1];

        for(int i=0; i<ItemCnt; i++){
            st = new StringTokenizer(br.readLine());
            int Weight = Integer.parseInt(st.nextToken());
            int Value = Integer.parseInt(st.nextToken());
            if(Weight>MaxWeight) continue;  // 배낭에 하나도 넣을 수 없는 경우 배제
            DP(Weight,Value);
            //PrintArr();
        }
        System.out.println(Arr[MaxWeight]);
    }
    public static void DP(int Weight, int Value){
        for(int i=MaxWeight; i>=Weight; i--){
            if(Weight+i<=MaxWeight){
                Arr[i+Weight] = Math.max(Arr[i]+Value, Arr[i+Weight]);
            }
        }
        Arr[Weight] = Math.max(Value, Arr[Weight]);
    }
    public static void PrintArr(){
        for(int i=0; i<=MaxWeight; i++){
            System.out.print(Arr[i]+" ");
        }
        System.out.println();
    }
}

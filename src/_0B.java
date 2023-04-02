import java.io.*;
import java.util.*;

public class _0B {
    static ArrayList<Integer>[] Num = new ArrayList[2]; //[홀,짝]
    public static void main(String[] args) throws IOException{
        init();
        System.out.printf("%d %d", getMinEven(), getMinOdd());
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Num[0] = new ArrayList<>();
        Num[1] = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int value = Integer.parseInt(st.nextToken());
            Num[ Math.abs(value)%2==1 ? 0 : 1 ].add(value);
        }

        Collections.sort(Num[0]);
        Collections.sort(Num[1]);
    }
    public static int getMinEven(){
        // 홀-홀=짝, 짝-짝=짝
        int result = Integer.MAX_VALUE;
        for(ArrayList<Integer> AL : Num){
            for(int i=1; i<AL.size(); i++){
                int sub = Math.abs(AL.get(i) - AL.get(i-1));
                result = Math.min(result, sub);
            }
        }
        return result==Integer.MAX_VALUE ? -1 : result;
    }
    public static int getMinOdd(){
        // 홀-짝=홀
        int result = Integer.MAX_VALUE;

        int odd = 0;
        int even = 0;
        while(odd<Num[0].size() && even<Num[1].size()){
            int sub = getSub(odd,even);
            result = Math.min(result, sub);
            if(getSub(odd+1,even) < getSub(odd,even+1)) odd++;
            else even++;
        }

        return result==Integer.MAX_VALUE ? -1 : result;
    }
    public static int getSub(int oddIndex, int evenIndex){
        if(oddIndex>=Num[0].size() || evenIndex>=Num[1].size()) return Integer.MAX_VALUE;
        return Math.abs( Num[0].get(oddIndex) - Num[1].get(evenIndex) );
    }
}

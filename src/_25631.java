import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _25631 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int OverlapMax = 0;
        HashMap<Integer,Integer> hs = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int value = Integer.parseInt(st.nextToken());
            if(!hs.containsKey(value)){
                hs.put(value,1);
            }
            else{
                hs.replace(value,hs.get(value)+1);
            }
            OverlapMax = Math.max(OverlapMax,hs.get(value));
        }
        System.out.println(OverlapMax);
    }
}
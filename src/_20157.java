import java.io.*;
import java.util.*;

public class _20157 {

    private final static Map<Double, Integer> cntPerSlope[] = new Map[2];

    public static void main(String[] args) throws IOException{
        cntPerSlope[0] = new HashMap<>();
        cntPerSlope[1] = new HashMap<>();

        int yIsZero = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i< n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            if(y==0){
                yIsZero++;
                continue;
            }
            int section = x>=0 ? 0 : 1;
            double slope = y/x;

            int cnt = cntPerSlope[section].getOrDefault(slope, 0);
            cntPerSlope[section].put(slope, cnt + 1);
        }

        int maxCnt = yIsZero;
        for(Map<Double, Integer> map : cntPerSlope){
            for(Map.Entry<Double, Integer> entry : map.entrySet()){
                int cnt = entry.getValue();
                if(cnt > maxCnt){
                    maxCnt = cnt;
                }
            }
        }

        System.out.println(maxCnt);
    }
}

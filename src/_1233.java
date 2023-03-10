import java.io.*;
import java.util.*;

public class _1233 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] cnt = new int[A+B+C+1];
        int maxValue = -1;
        int maxCnt = -1;
        for(int a=1; a<=A; a++){
            for(int b=1; b<=B; b++){
                for(int c=1; c<=C; c++){
                    int value = a+b+c;
                    cnt[value]++;
                    if(cnt[value]>maxCnt){
                        maxValue = value;
                        maxCnt = cnt[value];
                    }
                }
            }
        }

        System.out.println(maxValue);
    }
}

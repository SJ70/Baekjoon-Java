import java.io.*;
import java.util.*;

public class _28455 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> Lvs = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<N; i++){
            Lvs.add(Integer.parseInt(br.readLine()));
        }

        int LvSum = 0;
        int StatSum = 0;

        int cnt = Math.min(N, 42);
        for(int i=1; i<=cnt; i++){
            int lv = Lvs.poll();
            LvSum += lv;
            StatSum += lv<60 ? 0 : lv<100 ? 1 : lv<140 ? 2 : lv<200 ? 3 : lv<250 ? 4 : 5;
        }

        System.out.printf("%d %d",LvSum,StatSum);
    }
}

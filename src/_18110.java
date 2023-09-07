import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class _18110 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n==0){
            System.out.println(0);
            return;
        }

        ArrayList<Integer> difficulty = new ArrayList<>();
        for(int i=0; i<n; i++){
            difficulty.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(difficulty);

        int exclude = (int)Math.round(n*0.15);
        int applyCnt = n - 2 * exclude;
        if (applyCnt==0){
            System.out.println(0);
            return;
        }

        int sum = 0;
        for(int i=exclude; i<n-exclude; i++){
            sum += difficulty.get(i);
        }

        int result = (int)Math.round((double)sum/applyCnt);
        System.out.println(result);
    }
}

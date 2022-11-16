import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6810 {
    public static void main(String[] args) throws IOException{
        int[] num = {9,7,8,0,9,2,1,4,1,8,0,0,0};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=10; i<=12; i++){
            num[i] = Integer.parseInt(br.readLine());
        }
        int result = 0;
        for(int i=0; i<13; i+=2)
            result += num[i];
        for(int i=1; i<13; i+=2)
            result += num[i]*3;
        System.out.printf("The 1-3-sum is %d",result);
    }
}

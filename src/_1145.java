import java.io.*;
import java.util.*;

public class _1145 {
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int[] nums = new int[5];
        for(int i=0; i<5; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        int result = nums[2];
        while(true){
            int divided = 0;
            for(int n : nums){
                if(result%n==0){
                    divided++;
                }
            }
            if(divided>=3){
                System.out.println(result);
                return;
            }
            result++;
        }
    }
}

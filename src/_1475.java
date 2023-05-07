import java.io.*;

public class _1475 {
    public static void main(String[] args) throws IOException{
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        int[] nums = new int[10];
        for(int i=0; i<str.length(); i++){
            nums[str.charAt(i)-'0']++;
        }
        nums[6] = nums[9] = (nums[6]+nums[9])/2 + (nums[6]+nums[9])%2;

        int result = 0;
        for(int n : nums){
            result = Math.max(n, result);
        }
        System.out.println(result);
    }
}

import java.io.*;
import java.util.*;

public class _27231 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            sb.append(getResult(br.readLine())).append('\n');
//            System.out.println();
        }
        System.out.print(sb);
    }
    public static String getResult(String str){

        int[] nums = new int[10];
        for(int i=0; i<str.length(); i++) {
            nums[str.charAt(i)-'0']++;
        }

        // 0과 1로만 이루어진 수라면 무한
        if(nums[0] + nums[1] == str.length()) return "Hello, BOJ 2023!";

        bt_values = new HashSet<>();
        int num = Integer.parseInt(str);
        int digit = (int)Math.pow(10,(int)Math.log10(num)+1);
        add_bt_values(0,num,digit);

//        for(int i=0; i<10; i++) System.out.print(nums[i]+" ");
//        System.out.println();
//        System.out.println(bt_values);

        int result = 0;
        int pow = 1;
        while(true){
            int value = 0;
            for(int i=1; i<=9; i++){
                value += Math.pow(i, pow) * nums[i];
            }
//            System.out.printf("%d : %d \n",pow,value);
            if(value > num) break;
            if(bt_values.contains(value)) result++;
            pow++;
        }

        return String.valueOf(result);
    }
    static HashSet<Integer> bt_values;
    public static void add_bt_values(int current_num, int rest_num, int digit){
        if(rest_num==0){
//            System.out.printf("added : %d\n\n",current_num);
            bt_values.add(current_num);
        }
        while(true){
            digit/=10;
            if(digit<=0) break;
//            System.out.printf("%d %d %d -> (%d, %d)\n",current_num,rest_num,digit,current_num+rest_num/digit,rest_num%digit);
            add_bt_values(current_num + rest_num/digit, rest_num%digit, digit);
        }
    }
}

import java.io.*;

public class _2592 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int max_cnt_value = 0;
        int max_cnt = 0;
        int[] cnt = new int[1000];
        for(int i=0; i<10; i++){
            int value = Integer.parseInt(br.readLine());
            sum += value;
            if(++cnt[value]>max_cnt){
                max_cnt_value = value;
                max_cnt = cnt[value];
            }
        }
        System.out.printf("%d\n%d",sum/10,max_cnt_value);
    }
}

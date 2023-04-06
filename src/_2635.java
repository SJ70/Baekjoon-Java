import java.io.*;

public class _2635 {
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

        int maxLength = 0;
        StringBuilder result = new StringBuilder();
        for(int i=N; i>=N/2; i--){
            int n1 = N;
            int n2 = i;
            int length = 2;
            StringBuilder sb = new StringBuilder().append(n1).append(' ').append(n2);
            while(n1>=n2){
                int sub = n1-n2;
                n1 = n2;
                n2 = sub;
                sb.append(' ').append(sub);
                length++;
            }
            if(length > maxLength){
                maxLength = length;
                result = sb;
            }
        }
        System.out.println(maxLength);
        System.out.print(result);
    }
}

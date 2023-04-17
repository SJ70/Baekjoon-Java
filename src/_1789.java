import java.io.*;

public class _1789 {
    public static void main(String[] args) throws IOException{
        long N = Long.parseLong(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int result = 0;
        for(int i=1; N>0; i++){
            N -= i;
            result++;
//            System.out.println(N+","+i);
        }
        if(N<0) result--;
        System.out.println(result);
    }
}

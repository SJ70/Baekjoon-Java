import java.io.*;

public class _1437 {
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        if(N<=1){
            System.out.println(N);
            return;
        }

        int three = N/3;
        int two = 0;
        switch(N%3){
            case 1 : three--; two+=2; break;
            case 2 : two++; break;
        }
//        System.out.printf("%d %d \n",three,two);

        long result = 1;
        for(int i=0; i<three; i++){
            result = result * 3 % 10007;
        }
        for(int i=0; i<two; i++){
            result = result * 2 % 10007;
        }
        System.out.println(result);
    }
}

import java.io.*;

public class _1526 {
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        while(N>3){

            if(isFourAndSeven(N)){
                System.out.println(N);
                return;
            }

            int tmp = getOne(N);
            if(tmp>7){
                N = N - tmp + 7;
            }
            else if(tmp>4){
                N = N - tmp + 4;
            }
            else{
                N = N - tmp - 3;
            }
        }
    }
    public static boolean isFourAndSeven(int n){
        while(n>0){
            if(n%10!=7 && n%10!=4) return false;
            n/=10;
        }
        return true;
    }
    public static int getOne(int n){
        return n%10;
    }
}

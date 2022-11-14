import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10844 {
    static int N;
    static int[][] Arr;
    public static void main(String[] args) throws IOException {
        init();
        DP();
//        printArr();
        System.out.println(getResult());
    }
    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Arr = new int[N][10];
        for(int i=1; i<=9; i++)
            Arr[0][i] = 1;
    }
    public static void DP(){
        for(int i=1; i<N; i++){
            for(int num=0; num<=9; num++){
                if(num>0) Arr[i][num] += Arr[i-1][num-1];
                if(num<9) Arr[i][num] += Arr[i-1][num+1];
                Arr[i][num] %= 1000000000;
            }
        }
    }
    public static void printArr(){
        System.out.print("    ");
        for(int i=0; i<N; i++){
            System.out.printf("      [%2d]",i+1);
        }
        System.out.println();
        for(int num=0; num<=9; num++){
            System.out.printf(" [%d]",num);
            for(int i=0; i<N; i++){
                System.out.printf("%10d",Arr[i][num]);
            }
            System.out.println();
        }
    }
    public static int getResult(){
        int result = Arr[N-1][0];
        for(int i=1; i<=9; i++){
            result += Arr[N-1][i];
            result %= 1000000000;
        }
        return result;
    }
}

import java.util.Scanner;

public class _10870 {
    static int[] arr;
    static int N;
    public static void main(String[] args){
        N = new Scanner(System.in).nextInt();
        if(N<=1){
            System.out.println(N);
            return;
        }
        arr = new int[N+2];
        arr[0]=0;
        arr[1]=1;
        fillArr(2);
        System.out.println(arr[N]);
    }
    public static void fillArr(int index){
        arr[index]=arr[index-1]+arr[index-2];
        if(index+1>N+1) return;
        fillArr(index+1);
    }
}

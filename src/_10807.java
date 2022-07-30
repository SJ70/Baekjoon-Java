import java.util.Scanner;

public class _10807 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[201];
        for(int i=0; i<N; i++){
            arr[sc.nextInt()+100]++;
        }
        System.out.println(arr[sc.nextInt()+100]);
    }
}
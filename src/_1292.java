import java.util.Scanner;

public class _1292 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        int[] arr = new int[1001];
        int n = 1;
        int i = 1;
        while(i<1000){
            for(int j=0; j<n; j++){
                arr[i] = n;
                //System.out.println(i+" "+arr[i]);
                i++;
                if(i==1001) break;
            }
            n++;
        }
        int result=0;
        for(int k=s; k<=e; k++)
            result += arr[k];
        System.out.println(result);
    }
}

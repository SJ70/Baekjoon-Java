import java.util.Scanner;

public class _2609 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int tmp = Math.min(A,B);
        for(int i=tmp; i>=1; i--){
            if(A%i==0 && B%i==0){
                System.out.println(i);
                break;
            }
        }
        tmp = Math.max(A,B);
        for(int i=tmp; i<=2000000000; i++){
            if(i%A==0 && i%B==0){
                System.out.println(i);
                break;
            }
        }
    }
}

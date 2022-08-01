import java.util.Scanner;

public class _4101 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int A = sc.nextInt();
            int B = sc.nextInt();
            if(A==0 && B==0) return;
            if(A>B)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}
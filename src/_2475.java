import java.util.Scanner;

public class _2475 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Result = 0;
        for(int i=0; i<5; i++)
            Result += Math.pow(sc.nextInt(),2);
        System.out.println(Result%10);
    }
}

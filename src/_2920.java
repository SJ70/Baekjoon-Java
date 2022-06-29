import java.util.Scanner;

public class _2920 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Result = 0;
        for(int i=0; i<8; i++)
            Result = Result*10 + sc.nextInt();
        switch(Result){
            case 12345678 :
                System.out.println("ascending");
                break;
            case 87654321 :
                System.out.println("descending");
                break;
            default:
                System.out.println("mixed");
                break;
        }
    }
}

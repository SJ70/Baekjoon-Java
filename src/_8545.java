import java.util.Scanner;

public class _8545 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for(int i=2; i>=0; i--){
            sb.append(str.charAt(i));
        }
        System.out.print(sb);
    }
}

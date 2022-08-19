import java.util.Scanner;

public class _11945 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        if( R==0 || C==0 ) return;

        String[] str = new String[R];
        for(int r=0; r<R; r++){
            str[r] = sc.next();
        }
        for(int r=0; r<R; r++){
            for(int c=C-1; c>=0; c--){
                System.out.print(str[r].charAt(c));
            }
            System.out.println();
        }
    }
}

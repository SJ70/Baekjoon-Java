import java.util.*;
public class _2738 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int[][] arr = new int[R][C];
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                arr[r][c] = sc.nextInt();
            }
        }
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                System.out.print( arr[r][c]+sc.nextInt() + " " );
            }
            System.out.println();
        }
    }
}

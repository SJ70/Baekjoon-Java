import java.util.Scanner;

public class _16939 {
    static int[] cube = new int[24];
    public static void main(String[] args){
        Input();
        System.out.printf("%d",canSolve()?1:0);
    }
    public static void Input(){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<24; i++)
            cube[i] = sc.nextInt();
    }
    public static boolean canSolve(){
        // 마주보는 2면이 알맞을 때, 측면을 2가지 방법으로 돌렸을 때 큐브가 맞추어지는가
        if(isMatched(0) && isMatched(8)) return isMatched(Roll(0)) || isMatched(Roll(1)) ;
        else if(isMatched(4) && isMatched(20)) return isMatched(Roll(2)) || isMatched(Roll(3)) ;
        else if(isMatched(12) && isMatched(16)) return isMatched(Roll(4)) || isMatched(Roll(5)) ;
        else return false;
    }
    static int[][] roll = {
            {5,6,17,18,21,22,13,14,5,6} , {6,5,14,13,22,21,18,17,6,5},
            {1,2,18,20,12,11,15,13,1,2} , {2,1,13,15,11,12,20,18,2,1},
            {1,3,5,7,9,11,24,22,1,3} , {3,1,22,24,11,9,7,5,3,1}
    };
    public static int[] Roll(int i){
        int[] C = new int[24];
        for(int k=0; k<8; k++)
            C[ roll[i][k]-1 ] = cube[ roll[i][k+2]-1 ];
        for(int k=0; k<24; k++)
            if(C[k]==0) C[k] = cube[k];
//        for(int k=0; k<24; k++)
//            System.out.printf("%2d",C[k]);
//        System.out.println();
        return C;
    }
    public static boolean isMatched(int n){
        return( cube[n]==cube[n+1] && cube[n]==cube[n+2] && cube[n]==cube[n+3] );
    }
    public static boolean isMatched(int[] c){
        for(int i=0; i<=20; i+=4)
            if( c[i]!=c[i+1] || c[i]!=c[i+2] || c[i]!=c[i+3] )
                return false;
        return true;
    }
}

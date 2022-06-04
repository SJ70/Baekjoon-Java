import java.util.*;

public class _1038 {
    static ArrayList<Integer> Arr = new ArrayList<>();
    static int N;
    static Queue<Integer> Q = new ArrayDeque<>();
    public static void main(String[] args){
        N = new Scanner(System.in).nextInt();
        MakeNum();
        while( !Arr.isEmpty() ){
            int X = Q.poll();
            Arr.add(X);
            //System.out.println(X);
            MakeDecreasing(X);
            if( X==987654321 || N==0 ) break;
            N--;
        }
        if(N>1) System.out.println(-1);
        else if(N==1) System.out.println("9876543210"); // int 표현 불가능
        else System.out.println(Arr.get(Arr.size()-1));
    }
    public static void MakeNum(){
        for(int i=0; i<=9; i++){
            Q.add(i);
            Arr.add(i);
        }
    }
    public static void MakeDecreasing(int N){
        int n = N%10;
        for(int i=0; i<=n-1; i++){
            Q.add( N*10 + i );
        }
    }
}

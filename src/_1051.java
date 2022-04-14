import java.util.*;
public class _1051 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] num = new int[N][M];
        for(int i=0; i<N; i++){
            String tmp = sc.next();
            for(int j=0; j<M; j++)
                num[i][j]=tmp.charAt(j)-48;
        }
        /*
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++)
                System.out.print(num[i][j]);
            System.out.println();
        }
        //*/
        int max = 0;
         // 정사각형의 최대 크기: Math.min(M,N)^2
        for(int i=0; i<N; i++)
            for(int j=0; j<M; j++)
                for(int k=0; k<Math.min(N-i,M-j); k++)
                    if(num[i][j]==num[i][j+k])
                        if(num[i][j+k]==num[i+k][j])
                            if(num[i+k][j]==num[i+k][j+k])
                                max = Math.max(max,k+1);
        System.out.println(max*max);
    }
}

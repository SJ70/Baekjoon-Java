import java.util.Scanner;

public class _3035 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int ZR = sc.nextInt();
        int ZC = sc.nextInt();
        String[] str = new String[N];
        for(int i=0; i<N; i++)
            str[i]=sc.next();
        for(int i=0; i<N; i++){
            for(int k=0; k<ZR; k++){
                for(int j=0; j<M; j++){
                    for(int l=0; l<ZC; l++){
                        System.out.print(str[i].charAt(j));
                    }
                }
                System.out.println();
            }
        }
    }
}

import java.util.Scanner;

public class _1174 {
    static int N;
    static int[] Num;
    public static void main(String[] args){
        N = new Scanner(System.in).nextInt();
        for(int size=1; size<=10 && N>0; size++){ //자릿수
            Num = new int[size];
            MakeNum(0,0,9);
        }
        if(N>0) System.out.println(-1);
    }
    public static void MakeNum(int index, int min, int max){
        if(index==Num.length){
            N--;
            if(N==0){
                for(int i=0; i<Num.length; i++)
                    System.out.print(Num[i]);
                System.out.println();
            }
        }
        else{
            for(int i=min; i<=max && N>0; i++){
                Num[index] = i;
                MakeNum(index+1,0,i-1);
            }
        }
    }
}

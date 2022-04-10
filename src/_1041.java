import java.util.*;
public class _1041 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long[] num = new long[6];
        long result = 0L;
        for(int i=0; i<6; i++)
            num[i]=sc.nextLong();

        // 주사위 1개 : 가장 작은 수를 제외한 값들의 합
        if(N==1){
            Arrays.sort(num);
            for(int i=0; i<5; i++)
                result += num[i];
        }
        // 주사위 2*2*2개 이상
        else{
            //꼭짓점 : 경우의 수 8가지
            long vertex = 999L;
            for(int i=0; i<=5; i+=5)    // A(0),F(5)
                for(int j=1; j<=4; j+=3) // B(1),E(4)
                    for(int k=2; k<=3; k++) // C(2),D(3)
                        vertex = Math.min(vertex, num[i]+num[j]+num[k]);
            result += 4 * vertex;
            //모서리 : 경우의 수 8가지
            long edge = 999L;
            for(int i=0; i<=5; i+=5)    // A(0),F(5)
                for(int j=1; j<=4; j++)  // B(1),C(2),D(3),E(4)
                    edge = Math.min(edge, num[i]+num[j]);
            for(int i=1; i<=4; i+=3)    // B(1),E(4)
                for(int j=2; j<=3; j++)  // C(2),D(3)
                    edge = Math.min(edge, num[i]+num[j]);
            result += 4 * (N-2) * edge; //윗 모서리
            result += 4 * (N-1) * edge; //옆 모서리
        }
        // 주사위 3*3*3개 이상
        if(N>2){
            //면 : 가장 작은 값
            Arrays.sort(num);
            result += (N-2)*(N-2) * num[0]; //윗면
            result += 4 * (N-2)*(N-1) * num[0]; //옆면
        }
        System.out.println(result);
    }
}
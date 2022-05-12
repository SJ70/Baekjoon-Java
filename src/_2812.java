import java.util.*;
import java.io.*;

public class _2812 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        int K = sc.nextInt();
        String str = sc.next();
        int[] Num = new int[N];
        for(int i=0; i<N; i++){
            Num[i] = str.charAt(i)-48;
        }

        Queue<Integer> result = new ArrayDeque<>();
        int delCnt = 0;

        // 지울 수 있는 수+1 만큼 앞에서부터 가장 큰 수 탐색
        int max = 0;
        for(int i=0; i<K; i++){
            max = Math.max(max,Num[i]);
        }
        // max가 나올 때까지 앞에서부터 제거
        int index = 0;
        while(Num[index]!=max){
            delCnt++;
            index++;
        }
        // 앞자리가 뒷자리보다 작을 경우 제거
        for(int i=index; i<N; i++){
            if(i<N-1 && Num[i]<Num[i+1] && delCnt<K){
                delCnt++;
            }
            else{
                result.add(Num[i]);
            }
            index++;
        }
        for(int i=0; i<N-K; i++){
            bw.write(String.valueOf(result.poll()));
        }
        bw.flush();
    }
}

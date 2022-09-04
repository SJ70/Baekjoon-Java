import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class _2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //범위 및 중앙값을 위한 목록
        ArrayList<Integer> arr = new ArrayList<>();
        //산술평균값
        int Sum = 0;
        //최빈값
        int[] MostCnt = new int[8001];
        int MostMax = 0;
        ArrayList<Integer> MostUsed = new ArrayList<>();

        for(int i=0; i<N; i++){
            int n = Integer.parseInt(br.readLine());
            //범위 및 중앙값을 위한 목록 저장
            arr.add(n);
            //산술평균값
            Sum+=n;
            //중간값
            MostCnt[n+4000]++;
            if(MostMax<MostCnt[n+4000]){
                MostMax=MostCnt[n+4000];
                MostUsed.clear();
                MostUsed.add(n);
            }
            else if(MostMax==MostCnt[n+4000]){
                MostUsed.add(n);
            }
        }
        //산술평균값
        double AM = Math.round((double)Sum/N);
        //범위 및 중앙값을 위한 목록 정렬
        Collections.sort(arr);
        //최빈값 2번째로 작은 값을 얻기 위한 정렬
        Collections.sort(MostUsed);
        int Middle = arr.get(N/2);
        int Range = arr.get(arr.size()-1) - arr.get(0);
        System.out.printf("%.0f\n%d\n%d\n%d",AM,Middle,(MostUsed.size()==1)?MostUsed.get(0):MostUsed.get(1),Range);
    }
}

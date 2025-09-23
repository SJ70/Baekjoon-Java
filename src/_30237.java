import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class _30237 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());

            List<Integer>[] numsList = new List[N];
            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int M = Integer.parseInt(st.nextToken());
                numsList[i] = new ArrayList<>();
                for (int j=0; j<M; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    numsList[i].add(value);
                }
            }

            int[] entireNumCnt = new int[101];
            for (List<Integer> nums : numsList) {
                for (int num : nums) {
                    entireNumCnt[num]++;
                }
            }

            List<Integer>[] idxContainsNum = new List[101];
            for (int i=1; i<=100; i++) {
                idxContainsNum[i] = new ArrayList<>();
            }
            for (int i=0; i<N; i++) {
                for (int num : numsList[i]) {
                    idxContainsNum[num].add(i);
                }
            }

            int entireNumKinds = 0;
            for (int i=1; i<=100; i++) {
                if (entireNumCnt[i] > 0) {
                    entireNumKinds++;
                }
            }

            int result = 0;
            for (int i=1; i<=100; i++) {
                int resultTmp = entireNumKinds;
                if (entireNumCnt[i] == 0) {
                    continue;
                }
                int[] entireNumCntTmp = new int[101];
                for (int j=1; j<=100; j++) {
                    entireNumCntTmp[j] = entireNumCnt[j];
                }
                for (int idx : idxContainsNum[i]) {
                    for (int num : numsList[idx]) {
                        entireNumCntTmp[num]--;
                        if (entireNumCntTmp[num] == 0) {
                            resultTmp--;
                        }
                    }
                }
                if (resultTmp < entireNumKinds) {
                    result = Math.max(result, resultTmp);
                }
            }
            sb.append(result);
            sb.append('\n');
        }
        System.out.print(sb);
    }

}

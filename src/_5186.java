import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _5186 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<=T; t++) {
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            int[][] arr = new int[L][2];
            // friends
            for (int n=0; n<N; n++) {
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken()) - 1;
                int d = st.nextToken().equals("S") ? 0 : 1;
                arr[l][d]++;
            }

            PriorityQueue<int[]> cars = new PriorityQueue<>((a, b) -> b[1] - a[1]);
            // cars
            for (int c=0; c<C; c++) {
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken()) - 1;
                int size = Integer.parseInt(st.nextToken());
                cars.add(new int[]{l, size});

            }

            for (int c=0; c<C; c++) {
                int[] car = cars.poll();
                int l = car[0];
                int size = car[1];

                if (arr[l][0] > 0) {
                    // 운전자 확보
                    arr[l][0]--;
                    size--;

                    // 취객 확보
                    int tmp = Math.min(arr[l][1], size);
                    size -= tmp;
                    arr[l][1] -= tmp;

                    // 남은 자리 소모
                    arr[l][0] -= Math.min(arr[l][0], size);
                }

            }

            int result = Arrays.stream(arr)
                    .map(a -> Arrays.stream(a).sum())
                    .mapToInt(Integer::valueOf)
                    .sum();

            System.out.printf("Data Set %d: \n%d\n", t, result);
        }
    }

}

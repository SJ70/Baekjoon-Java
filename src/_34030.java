import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _34030 {

    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        // 2
        boolean canSort2 = true;

        // 연속된 짝수 수열과 연속된 홀수 수열로 자르기
        List<List<Integer>> lists = new ArrayList<>();
        int tmp = -1;
        List<Integer> list = new ArrayList<>();
        for (int value : arr) {
            if (value % 2 != tmp) {
                if (!list.isEmpty()) {
                    lists.add(list);
                }
                list = new ArrayList<>();
                tmp = value % 2;
            }
            list.add(value);
        }
        if (!list.isEmpty()) {
            lists.add(list);
        }
//        System.out.println(lists);

        // 각 홀수, 짝수 수열의 최소값, 최대값을 비교하여 정렬이 가능한지 확인
        for (int i=1; i<lists.size(); i++) {
            int prevMaxValue = lists.get(i - 1)
                    .stream()
                    .max((a, b) -> a - b)
                    .get();
            int curMinValue = lists.get(i)
                    .stream()
                    .min((a, b) -> a - b)
                    .get();
            if (prevMaxValue > curMinValue) {
                canSort2 = false;
                break;
            }
        }



        // 1
        boolean canSort1 = true;

        // 마지막으로 정렬된 홀 또는 짝의 수열의 정보
        int minValue = 0; // 앞으로 당겨올 수 있는 최소값
        int maxValue = 0; // 맨 뒤 값
        int status = -1;
        for (int i=0; i<N; i++) {
            // 홀짝 여부가 같을 경우 정렬이 되어 있어야 함
            if (status == arr[i] % 2) {
                if (maxValue > arr[i]) {
                    canSort1 = false;
                    break;
                }
                // 정렬이 되어 있다면 최대 값을 갱신
                maxValue = arr[i];
            }
            // 홀짝 여부가 다를 경우
            else {
                // 정렬이 되어 있다면 홀짝을 변경
                if (maxValue < arr[i]) {
                    status = arr[i] % 2;
                    minValue = maxValue;
                    maxValue = arr[i];
                }
                // 숫자가 작은 경우 해당 숫자를 앞으로 당겨오고 최소값을 해당 값으로 변경
                else if (maxValue > arr[i]) {
                    // 해당 최소값 이상의 값은 모두 당겨올 수 있음
                    if (minValue <= arr[i]) {
                        minValue = arr[i];
                    }
                    else {
                        canSort1 = false;
                        break;
                    }
                }
            }
        }

        System.out.println(canSort1 ? "So Lucky" : "Unlucky");
        System.out.println(canSort2 ? "So Lucky" : "Unlucky");

    }

}

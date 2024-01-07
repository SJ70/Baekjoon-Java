import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _2831 {

    private static int n;

    private static List<Integer> menWannaTaller = new ArrayList<>();
    private static List<Integer> menWannaShorter = new ArrayList<>();
    private static List<Integer> womenWannaTaller = new ArrayList<>();
    private static List<Integer> womenWannaShorter = new ArrayList<>();

    private static int result;

    public static void main(String[] args) throws IOException {
        init();
        match(menWannaTaller, womenWannaShorter);
        match(womenWannaTaller, menWannaShorter);
        System.out.println(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        initValues(br.readLine(), menWannaTaller, menWannaShorter);
        initValues(br.readLine(), womenWannaTaller, womenWannaShorter);
    }

    private static void initValues(String stringValue, List<Integer> wannaTaller, List<Integer> wannaShorter) {
        StringTokenizer st = new StringTokenizer(stringValue);
        for (int i=0; i<n; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (value > 0) {
                wannaTaller.add(value);
            }
            else {
                wannaShorter.add(- value);
            }
        }
        Collections.sort(wannaTaller);
        Collections.sort(wannaShorter);
    }

    private static void match(List<Integer> wannaTaller, List<Integer> wannaShorter) {
        int matchedCount = 0;
        int wannaTallerCount = wannaTaller.size();
        int wannaTallerIndex = 0;
        int wannaShorterCount = wannaShorter.size();
        int wannaShorterIndex = 0;

        while(wannaTallerIndex < wannaTallerCount && wannaShorterIndex < wannaShorterCount) {
            int wannaTallerValue = wannaTaller.get(wannaTallerIndex);
            int wannaShorterValue = wannaShorter.get(wannaShorterIndex);
            if (wannaTallerValue < wannaShorterValue) {
                matchedCount++;
                wannaTallerIndex++;
                wannaShorterIndex++;
            }
            else {
                wannaShorterIndex++;
            }
        }

        result += matchedCount;
    }

}

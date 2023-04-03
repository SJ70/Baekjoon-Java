import java.io.*;
import java.util.*;

public class _2304 {
    static ArrayList<int[]> AL = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        input();

        Collections.sort(AL, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int MaxHeightIndex = searchMaxHeightIndex(0, AL.size()-1);
        int result = AL.get(MaxHeightIndex)[1];

//        for(int[] e : AL){
//            System.out.println(e[0]+","+e[1]);
//        }
//        System.out.println(result);

        int left = MaxHeightIndex;
        while(0 < left){
            int MHI = searchMaxHeightIndex(0, left-1);
            int length = (AL.get(left)[0] - AL.get(MHI)[0]);
            int height = AL.get(MHI)[1];
//            System.out.println(left+" : "+length+"*"+height);
            result += length * height;
            left = MHI;
        }

        int right = MaxHeightIndex;
        while(right < AL.size()-1){
            int MHI = searchMaxHeightIndex(right+1, AL.size()-1);
            int length = (AL.get(MHI)[0] - AL.get(right)[0]);
            int height = AL.get(MHI)[1];
//            System.out.println(right+" : "+length+"*"+height);
            result += length * height;
            right = MHI;
        }

        System.out.println(result);
    }

    public static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int[] pillar = new int[]{pos,height};
            AL.add(pillar);
        }
    }
    public static int searchMaxHeightIndex(int from, int to){
        int MaxHeightIndex = 0;
        int MaxHeight = 0;
        for(int i=from; i<=to; i++){
            if(MaxHeight < AL.get(i)[1]){
                MaxHeightIndex = i;
                MaxHeight = AL.get(i)[1];
            }
        }
        return MaxHeightIndex;
    }
}

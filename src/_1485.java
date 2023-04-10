import java.io.*;
import java.util.*;

public class _1485 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr = new int[4][2];
    static HashMap<Integer, Integer> distance;
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            input();
            sb.append(isSquare() ? 1 : 0).append('\n');
        }
        System.out.print(sb);
    }
    public static void input() throws IOException{
        for(int i=0; i<4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
    }
    public static boolean isSquare(){
        distance = new HashMap<>();
        for(int i=0; i<3; i++){
            for(int j=i+1; j<4; j++){
                int d = getDist(arr[i], arr[j]);
//                System.out.printf("%d %d : %d\n",i,j,d);
                distance.put(d, distance.getOrDefault(d,0)+1);
            }
        }

        boolean four, two;
        four = two = false;
        for(Map.Entry<Integer, Integer> e : distance.entrySet()){
            if(e.getValue()==4) four=true;
            else if(e.getValue()==2) two=true;
        }
        return (four&&two);
    }
    public static int getDist(int[] o1, int[] o2){
        return (int)Math.pow(o1[0]-o2[0], 2) + (int)Math.pow(o1[1]-o2[1], 2);
    }
}

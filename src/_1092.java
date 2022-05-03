import java.io.*;
import java.util.*;

public class _1092 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer> Crain;
    static ArrayList<Integer> Box;
    public static void Input() throws IOException{
        Crain = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            Crain.add(Integer.parseInt(st.nextToken()));
        }
        Box = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            Box.add(Integer.parseInt(st.nextToken()));
        }
    }
    public static void main(String[] args) throws IOException{
        Input();
        Collections.sort(Crain,Collections.reverseOrder());
        Collections.sort(Box,Collections.reverseOrder());
        if(Crain.get(0) < Box.get(0)){
            System.out.println(-1);
        }
        else {
            int cnt = 0;
            while(Box.size() != 0){
                int cIndex = 0;
                int bIndex = 0;
                while(cIndex <= Crain.size()-1 && bIndex <= Box.size()-1){
                    if(Crain.get(cIndex) >= Box.get(bIndex)){
                        cIndex++;
                        Box.remove(bIndex);
                    } else {
                        bIndex++;
                    }
                }
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}

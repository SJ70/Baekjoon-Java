import java.io.*;
import java.util.*;

public class _1930 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] Dice;
    static HashSet<Integer> AbleCase;

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            setDiceValue();
            setAbleCases();
//            System.out.println(" : "+getSecondDiceHashCode());
            appendResult(AbleCase.contains(getSecondDiceHashCode()));
        }
        System.out.print(sb);
    }
    public static void setAbleCases(){
        final int[][] UnderIndex_SideIndex = {{1,2,3},{2,0,3},{1,3,0},{0,2,1}};
        AbleCase = new HashSet<>();

        for(int under=0; under<4; under++){
            for(int side=0; side<3; side++){
                int value = Dice[under];
                for(int i=0; i<3; i++){
                    value = value*10 + Dice[UnderIndex_SideIndex[under][(side+i)%3]];
                }
                AbleCase.add(value);
//                System.out.println(value);
            }
        }
    }
    public static void setDiceValue(){
        Dice = new int[4];
        for(int i=0; i<4; i++){
            int value = Integer.parseInt(st.nextToken());
            Dice[i] = value;
        }
    }
    public static int getSecondDiceHashCode(){
        int value = 0;
        for(int i=0; i<4; i++){
            value = value * 10 + Integer.parseInt(st.nextToken());
        }
        return value;
    }
    public static void appendResult(boolean b){
        sb.append(b ? 1 : 0).append('\n');
    }
}

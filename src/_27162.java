import java.io.*;
import java.util.*;

public class _27162 {
    static final int ONES = 0;
    static final int TWOS = 1;
    static final int THREES = 2;
    static final int FOURS = 3;
    static final int FIVES = 4;
    static final int SIXES = 5;
    static final int FOUR_OF_A_KIND = 6;
    static final int FULL_HOUSE = 7;
    static final int LITTLE_STRAIGHT = 8;
    static final int BIG_STRAIGHT = 9;
    static final int YACHT = 10;
    static final int CHOICE = 11;
    static int[] Score = new int[12];

    static int[] Dices = new int[3];
    static int[] DiceNumCnt = new int[6];
    static status currentStatus;
    public enum status{
        NoPair,OnePair,Triple
    }
    public static void main(String[] args) throws IOException{
        init();
        observeStatus();
        observeScore();
        System.out.println(MaxScore());
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for(int i=0; i<12; i++){
            if(str.charAt(i)=='N'){
                Score[i] = -1;
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<3; i++){
            Dices[i] = Integer.parseInt(st.nextToken());
            DiceNumCnt[Dices[i]-1]++;
        }
    }
    public static void observeStatus(){
        Arrays.sort(Dices);
        if(Dices[0]==Dices[1] && Dices[1]==Dices[2]){
            currentStatus = status.Triple;
        }
        else if(Dices[0]==Dices[1] || Dices[1]==Dices[2]){
            currentStatus = status.OnePair;
        }
        else{
            currentStatus = status.NoPair;
        }
    }
    public static void observeScore(){

        for(int i=ONES; i<=SIXES; i++){
            if(isAble(i)){
                // (해당 눈금 수 + 2) * 눈금
                switch(DiceNumCnt[i]){
                    case 0 : Score[i] = 2*(i+1); break;
                    case 1 : Score[i] = 3*(i+1); break;
                    case 2 : Score[i] = 4*(i+1); break;
                    case 3 : Score[i] = 5*(i+1); break;
                }
            }
        }

        if(isAble(FOUR_OF_A_KIND) && currentStatus!=status.NoPair) {
            // 페어의 눈금 수 * 4
            Score[FOUR_OF_A_KIND] = Dices[1] * 4;
        }

        if(isAble(FULL_HOUSE)) {
            if(currentStatus==status.Triple){
                Score[FULL_HOUSE] = Dices[2]*3 + ((Dices[2]==6)?5:6)*2;
            }
            else if(currentStatus==status.OnePair){
                Score[FULL_HOUSE] = Dices[0]*2 + Dices[2]*3;
            }
        }

        for(int i=LITTLE_STRAIGHT; i<=BIG_STRAIGHT; i++){
            if(isAble(i)){
                if(currentStatus==status.NoPair){
                    int min = (i==LITTLE_STRAIGHT) ? 1 : 2;
                    int max = (i==LITTLE_STRAIGHT) ? 5 : 6;
                    if(Dices[0]>=min && Dices[2]<=max){
                        Score[i] = 30;
                    }
                }
            }
        }

        if(isAble(YACHT) && currentStatus==status.Triple){
            Score[YACHT] = 50;
        }

        if(isAble(CHOICE)){
            Score[CHOICE] = Dices[0] + Dices[1] + Dices[2] + 12;
        }
    }
    public static boolean isAble(int n){
        return Score[n]==0;
    }
    public static int MaxScore(){
        int max = 0;
        for(int i=0; i<12; i++){
            if(Score[i]>max) max=Score[i];
//            System.out.println(Score[i]);
        }
        return max;
    }
}

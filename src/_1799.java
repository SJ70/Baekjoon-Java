import java.util.*;

public class _1799 {
    public static void main(String[] args){
        Input();

        Bt1(0,0);
        Bt2(0,0);

        System.out.println( Result1_Max + Result2_Max );
    }
    static int Result1_Max = -1;
    static int Result2_Max = -1;
    static int N;
    static int[][] Map;
    static ArrayList<Integer> PutAbleR1 = new ArrayList<>();
    static ArrayList<Integer> PutAbleC1 = new ArrayList<>();
    static ArrayList<Integer> PutAbleR2 = new ArrayList<>();
    static ArrayList<Integer> PutAbleC2 = new ArrayList<>();
    public static void Input(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Map = new int[N][N];
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                Map[r][c] = sc.nextInt();
                if(Map[r][c]==1){
                    if(r%2==c%2){
                        PutAbleR1.add(r);
                        PutAbleC1.add(c);
                    }
                    else{
                        PutAbleR2.add(r);
                        PutAbleC2.add(c);
                    }
                }
            }
        }
    }
    //홀수칸
    public static void Bt1(int index, int cnt){
        if(PutAbleR1.size()==index){
            Result1_Max = Math.max(Result1_Max,cnt);
            //Print();
        }
        else{
            int r = PutAbleR1.get(index);
            int c = PutAbleC1.get(index);
            if(canPutHere(r,c)){
                Map[r][c]=2; //놓음
                Bt1(index+1,cnt+1);
                Map[r][c]=1; //놓지않음
            }
            Bt1(index+1,cnt);
        }
    }
    //짝수칸
    public static void Bt2(int index, int cnt){
        if(PutAbleR2.size()==index){
            Result2_Max = Math.max(Result2_Max,cnt);
            //Print();
        }
        else{
            int r = PutAbleR2.get(index);
            int c = PutAbleC2.get(index);
            if(canPutHere(r,c)){
                Map[r][c]=2; //놓음
                Bt2(index+1,cnt+1);
                Map[r][c]=1; //놓지않음
            }
            Bt2(index+1,cnt);
        }
    }
    public static boolean canPutHere(int r, int c){
        // (0,0)에서 우측하단으로 채우므로 상단만 확인
        // 좌측상단
        for(int i=1; r-i>=0 && c-i>=0; i++)
            if(Map[r-i][c-i]==2) return false;
        // 우측상단
        for(int i=1; r-i>=0 && c+i<N; i++)
            if(Map[r-i][c+i]==2) return false;
        return true;
    }
    public static void Print(){
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++)
                System.out.printf("%2d",Map[r][c]);
            System.out.println();
        }
        System.out.println();
    }
}

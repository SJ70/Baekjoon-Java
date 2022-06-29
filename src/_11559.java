import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class _11559 {
    public static void main(String[] args){
        Input();
        int cntBoom = 0;
        int cntPuyo = PuyoR.size();
        while(true){
            //Print();
            Boom();
            //Print();
            FallDown();
            //Print();
            PuyoQueueAdd();
            if(cntPuyo==PuyoR.size()) break;
            else cntPuyo = PuyoR.size();
            cntBoom++;
        }
        System.out.println(cntBoom);
    }
    static char[][] Map = new char[12][6];
    static Queue<Integer> PuyoR = new ArrayDeque<>();
    static Queue<Integer> PuyoC = new ArrayDeque<>();
    public static void Input(){
        Scanner sc = new Scanner(System.in);
        for(int r=0; r<12; r++){
            String str = sc.nextLine();
            for(int c=0; c<6; c++){
                Map[r][c] = str.charAt(c);
                if(Map[r][c]!='.'){
                    PuyoR.add(r);
                    PuyoC.add(c);
                }
            }
        }
    }
    public static void Print(){
        for(int r=0; r<12; r++){
            System.out.println();
            for(int c=0; c<6; c++){
                System.out.print(Map[r][c]);
            }
        }
        System.out.println();
    }
    static boolean[][] Visited;
    static Queue<Integer> BoomR = new ArrayDeque<>();
    static Queue<Integer> BoomC = new ArrayDeque<>();
    public static void Boom(){
        Visited = new boolean[12][6];
        int T = PuyoR.size();
        for(int i=0; i<T; i++){
            int r = PuyoR.poll();
            int c = PuyoC.poll();
            if(Visited[r][c]) continue;
            CheckNearby(r,c,Map[r][c]);
            if(BoomR.size()>=4){
                while(!BoomR.isEmpty()){
                    Map[BoomR.poll()][BoomC.poll()]='.';
                }
            }
            else{
                BoomR.clear();
                BoomC.clear();
            }
        }
    }
    public static void CheckNearby(int r, int c, char C){
        if( r<0 || r==12 || c<0 || c==6 || Visited[r][c] ) return;
        if(Map[r][c]==C){
            Visited[r][c] = true;
            BoomR.add(r);
            BoomC.add(c);
            CheckNearby(r+1,c,C);
            CheckNearby(r-1,c,C);
            CheckNearby(r,c+1,C);
            CheckNearby(r,c-1,C);
        }
    }
    public static void FallDown(){
        char[][] Map2 = new char[12][6];
        for(int c=0; c<6; c++){
            int Map2RIndex = 11;
            for(int r=11; r>=0; r--){
                Map2[r][c]='.'; //init
                if(Map[r][c]!='.'){
                    Map2[Map2RIndex][c]=Map[r][c];
                    Map2RIndex--;
                }
            }
        }
        Map = Map2;
    }
    public static void PuyoQueueAdd(){
        for(int r=0; r<12; r++){
            for(int c=0; c<6; c++){
                if(Map[r][c]!='.'){
                    PuyoR.add(r);
                    PuyoC.add(c);
                }
            }
        }
    }
}

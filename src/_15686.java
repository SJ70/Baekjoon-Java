import java.io.*;
import java.util.*;

public class _15686 {
    static int N, M;
    static ArrayList<Integer> HomeR = new ArrayList<>();
    static ArrayList<Integer> HomeC = new ArrayList<>();
    static ArrayList<Integer> ChickenR = new ArrayList<>();
    static ArrayList<Integer> ChickenC = new ArrayList<>();
    static int[][] Distance;
    static int Result_Min = 500000;

    public static void main(String[] args) throws IOException {
        Input();
        DetermineDistance();
        ChickenDistance(new boolean[C],0,0);
        System.out.println(Result_Min);
    }

    public static void Input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                switch(Integer.parseInt(st.nextToken())){
                    case 1:
                        HomeR.add(r);
                        HomeC.add(c);
                        break;
                    case 2:
                        ChickenR.add(r);
                        ChickenC.add(c);
                        break;
                }
            }
        }
    }

    static int H,C;
    public static void DetermineDistance(){
        H = HomeR.size();
        C = ChickenR.size();
        Distance = new int[H][C];
        for(int i=0; i<H; i++){
            int r1 = HomeR.get(i);
            int c1 = HomeC.get(i);
            //System.out.printf("\nhome #%d:",i);
            for(int j=0; j<C; j++){
                Distance[i][j] = Math.abs( r1-ChickenR.get(j) ) + Math.abs( c1-ChickenC.get(j) );
                //System.out.printf(" %d",Distance[i][j]);
            }
        }
    }

    public static void ChickenDistance(boolean[] B, int index, int cnt){
        if(cnt==C-M){
            int result = 0;
            for(int i=0; i<H; i++){
                int min = 2500;
                for(int j=0; j<C; j++){
                    if(!B[j]) min=Math.min(min,Distance[i][j]);
                }
                result += min;
            }
//            for(int i=0; i<C; i++)
//                System.out.print(B[i]+" ");
//            System.out.println(result);
            Result_Min = Math.min(Result_Min, result);
        }
        else if(index+1<=C){
            ChickenDistance(Copy(B),index+1,cnt);
            B[index]=true;
            ChickenDistance(B,index+1,cnt+1);
        }
    }
    public static boolean[] Copy(boolean[] B0){
        boolean[] B = new boolean[C];
        for(int i=0; i<C; i++)
            B[i]=B0[i];
        return B;
    }
}

import java.io.*;
import java.util.*;

public class _20055 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static int cnt = 0;
    static ArrayList<Belt> A;
    public static class Belt{
        int Dur;
        boolean Robot = false;
        public Belt(int Dur){
            this.Dur = Dur;
        }
        public Belt(int Dur, boolean Robot){
            this.Dur = Dur;
            this.Robot = Robot;
        }
    }
    public static void main(String[] args) throws IOException{
        Input();
        while(true){
            cnt++;
            MoveBelt();
            MoveRobot();
            SetRobot();
            //test_print();
            if(K<=0) break;
        }
        System.out.println(cnt);
    }
    public static void Input() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N*2; i++){
            int n = Integer.parseInt(st.nextToken());
            if(n==0) K--;
            A.add(new Belt(n));
        }
    }
    public static void test_print(){
        for(int i=0; i<A.size(); i++)
            System.out.printf("%6d",A.get(i).Dur);
        System.out.println();
        for(int i=0; i<A.size(); i++)
            System.out.printf("%6B",A.get(i).Robot);
        System.out.println("\n");
    }
    public static void MoveBelt(){
        A.add(0,new Belt(A.get(2*N-1).Dur,false));
        A.remove(2*N);
    }
    public static void MoveRobot(){
        if(A.get(N-1).Robot) A.set(N-1, new Belt(A.get(N-1).Dur,false));
        for(int i=N-2; i>=0; i--){
            if(A.get(i).Robot && !A.get(i+1).Robot && A.get(i+1).Dur>0){
                A.set(i, new Belt(A.get(i).Dur,false));
                A.set(i+1, new Belt(A.get(i+1).Dur-1,true));
                if(A.get(i+1).Dur==0) K--;
            }
        }
    }
    public static void SetRobot(){
        if(!A.get(0).Robot && A.get(0).Dur>0){
            A.set(0, new Belt(A.get(0).Dur-1,true));
            if(A.get(0).Dur==0) K--;
        }
    }
}

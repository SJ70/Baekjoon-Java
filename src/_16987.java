import java.io.*;
import java.util.*;

public class _16987 {
    static int N;
    static int[] HP, Atk;
    static int brokenMax = 0;
    static int broken = 0;
    public static void main(String[] args) throws IOException{
        init();
        bt(0);
        System.out.println(brokenMax);
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        HP = new int[N];
        Atk = new int[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            HP[i] = Integer.parseInt(st.nextToken());
            Atk[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void bt(int index){
        if(brokenMax==N || index==N) return;
        if(isBroken(index)){
            bt(index+1);
            return;
        }
        for(int i=0; i<N; i++){
            if(i!=index && HP[i]>0){
                HP[index]-=Atk[i];
                HP[i]-=Atk[index];
                int brokenNow = (isBroken((index))?1:0) + (isBroken(i)?1:0);
                broken += brokenNow;

                brokenMax = Math.max(brokenMax, broken);
                bt(index+1);

                broken -= brokenNow;
                HP[index]+=Atk[i];
                HP[i]+=Atk[index];
            }
        }
    }
    public static boolean isBroken(int i){
        return HP[i]<=0;
    }
}

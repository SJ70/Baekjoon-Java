import java.io.*;
import java.util.*;

public class _3019 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int C,P;
    static int[] Map;
    static int Cnt = 0;
    public static void main(String[] args) throws IOException{
        Input();
        Solve();
        System.out.println(Cnt);
    }
    public static void Input() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Map = new int[C];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++)
            Map[i] = Integer.parseInt(st.nextToken());
    }
    public static void Solve(){
        switch(P){
            case 1 : cnt1(); cnt4(); break;                     // I
            case 2 : cnt2(); break;                             // #
            case 3 : cnt3b(); cnt2a(); break;                   // S
            case 4 : cnt3a(); cnt2b(); break;                   // Z
            case 5 : cnt3(); cnt2a(); cnt2b(); cnt3c(); break;  // T
            case 6 : cnt2(); cnt3(); cnt2c(); cnt3d(); break;   // L
            case 7 : cnt2(); cnt3(); cnt2d(); cnt3e(); break;   // r
        }
    }
    public static void Compare(int[] Diff){
        for(int i=0; i<=C-Diff.length; i++){
            boolean Add = true;
            for(int j=1; j<Diff.length; j++){
                if( Map[i+j] != Map[i] + Diff[j] ){
                    Add = false;
                    break;
                }
            }
            //System.out.print(Add+" ");
            if(Add) Cnt++;
        }
        //System.out.println(Cnt);
    }
    public static void cnt1(){  // | 형태
        Cnt+=C;
    }
    public static void cnt2(){  // __ 형태
        Compare( new int[] {0, 0} );
    }
    public static void cnt2a(){ // -_ 형태
        Compare( new int[] {0,-1} );
    }
    public static void cnt2b(){ // _- 형태
        Compare( new int[] {0, 1} );
    }
    public static void cnt2c(){ // `_ 형태
        Compare( new int[] {0,-2} );
    }
    public static void cnt2d(){ // _` 형태
        Compare( new int[] {0, 2} );
    }
    public static void cnt3(){  // ___ 형태
        Compare( new int[] {0, 0, 0} );
    }
    public static void cnt3a(){ // -__ 형태
        Compare( new int[] {0,-1,-1} );
    }
    public static void cnt3b(){ // __- 형태
        Compare( new int[] {0, 0, 1} );
    }
    public static void cnt3c(){ // -_- 형태
        Compare( new int[] {0,-1, 0} );
    }
    public static void cnt3d(){ // _-- 형태
        Compare( new int[] {0, 1, 1} );
    }
    public static void cnt3e(){ // --_ 형태
        Compare( new int[] {0, 0,-1} );
    }
    public static void cnt4(){  // ____ 형태
        Compare( new int[] {0, 0, 0, 0} );
    }
}
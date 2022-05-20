import java.io.*;
import java.util.*;

public class _21608 {
    public static void main(String[] args) throws IOException{
        Input();
        for(int i=0; i<Std.length; i++){
            Sit(Std[i]);
            //test_print();
        }
        //test_print();
        System.out.println(SumSatisfaction());
    }
    static int N;
    static Queue<Student> q = new ArrayDeque<>(); //
    static Queue<Student> q2 = new ArrayDeque<>(); // 결괏값 산출용 큐
    static int[][] Map;
    static Student[] Std;   // 배열의 순서 : 앉는 순서
    public static class Student{
        int r,c,n;
        int[] prefer = new int[4];
        public Student(int n,int a,int b,int c,int d){
            this.n = n;
            this.prefer = new int[]{a,b,c,d};
        }
        public void Sit(int r, int c){
            this.r=r; this.c=c;
        }
    }
    public static void Input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Std = new Student[N*N];
        Map = new int[N][N];
        for(int i=0; i<N*N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Std[i] = new Student(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
    }
    public static void Sit(Student S){
        int stf=0, empty=-1, sit_r=-1, sit_c=-1;
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(Map[r][c]==0){   // 해당 자리가 비어있을 때만
                    int stf_tmp = Satisfaction(S,r,c);
                    int empty_tmp = Empty(S,r,c);
                    // 만족도가 4일 경우 더 이상의 연산 필요 X
                    if( stf_tmp == 4 ){
                        Map[r][c] = S.n;
                        S.Sit(sit_r,sit_c);
                        return;
                    }
                    // 만족도가 높거나 || 같지만 주변에 빈 자리가 더 많은 경우
                    if(  stf < stf_tmp  ||  stf == stf_tmp && empty < empty_tmp  ){
                        stf = stf_tmp;
                        empty = empty_tmp;
                        sit_r = r;
                        sit_c = c;
                    }
                }
            }
        }
        Map[sit_r][sit_c] = S.n;
        S.Sit(sit_r,sit_c);
    }
    //상하좌우로 만족도 확인
    public static int Satisfaction(Student S, int r, int c){
        int stf = 0;
        if( r-1>=0 && isPrefered( S,Map[r-1][c] )) stf++;
        if( r+1< N && isPrefered( S,Map[r+1][c] )) stf++;
        if( c-1>=0 && isPrefered( S,Map[r][c-1] )) stf++;
        if( c+1< N && isPrefered( S,Map[r][c+1] )) stf++;
        return stf;
    }
    public static int Empty(Student S, int r, int c){
        int empty = 0;
        if( r-1>=0 && Map[r-1][c]==0 ) empty++;
        if( r+1< N && Map[r+1][c]==0 ) empty++;
        if( c-1>=0 && Map[r][c-1]==0 ) empty++;
        if( c+1< N && Map[r][c+1]==0 ) empty++;
        return empty;
    }
    public static boolean isPrefered(Student S, int std){
        for(int i=0; i<4; i++)
            if( std == S.prefer[i] ) return true;
        return false;
    }
    public static int SumSatisfaction(){
        int result = 0;
        int index = 0;
        for(int r=0; r<N; r++)
            for(int c=0; c<N; c++){
                int stf=0;
                switch(Satisfaction( Std[index], Std[index].r, Std[index].c)){
                    case 0 : break;
                    case 1 : stf=1; break;
                    case 2 : stf=10; break;
                    case 3 : stf=100; break;
                    case 4 : stf=1000; break;
                }
                result += stf;
//                System.out.printf("%d {%d,%d,%d,%d} : %d \n",Std[index].n,Std[index].prefer[0],Std[index].prefer[1],Std[index].prefer[2],Std[index].prefer[3],result);
                index++;
            }
        return result;
    }
    public static void test_print(){
        System.out.println();
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                System.out.printf("%3d",Map[r][c]);
            }
            System.out.println();
        }
    }
}

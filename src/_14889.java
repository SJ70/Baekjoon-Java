import java.io.*;
import java.util.*;

public class _14889 {
    public static void main(String[] args) throws IOException{
        init();
        bt(0);
        System.out.println(resultMin);
    }
    static int N;
    static int[][] arr;
    static int sumAll;
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for(int r=0; r<N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
                sumAll += arr[r][c];
            }
        }
    }
    static List<Integer> member = new ArrayList<>();
    static int resultMin = 99999999;
    public static void bt(int index){

        if(member.size()==N/2){
            resultMin = Math.min( resultMin, calcResult() );
            return;
        }
        if(index==N) return;

        member.add(index);
        bt(index+1);

        member.remove(member.lastIndexOf(index));
        bt(index+1);

    }
    public static int calcResult(){
        List<Integer> member2 = new ArrayList<>();
        int index=0;
        for(int i=0; i<N; i++){
            if(index<member.size() && member.get(index)==i){
                index++;
            }
            else{
                member2.add(i);
            }
        }
        return Math.abs( getTeamValue(member) - getTeamValue(member2) );
    }
    public static int getTeamValue(List<Integer> li){
        int result = 0;
        for(int e1 : li){
            for(int e2 : li){
                result += arr[e1][e2];
            }
        }
        return result;
    }
}

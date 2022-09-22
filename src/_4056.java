import java.io.*;
import java.util.*;

public class _4056 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            Complete = false;
            BlankR.clear();
            BlankC.clear();
            InputMap();
            if(!CheckSolvable()){
                sb.append("Could not complete this grid.\n\n");
                continue;
            }
            FillBlank(0);
            if(Complete){
                AppendMap();
            }
            else{
                sb.append("Could not complete this grid.\n\n");
            }
        }
        System.out.println(sb);
    }
    static int[][] Map = new int[9][9];
    static ArrayList<Integer> BlankR = new ArrayList<>();
    static ArrayList<Integer> BlankC = new ArrayList<>();
    public static void InputMap() throws IOException {
        for(int r=0; r<9; r++){
            String str = br.readLine();
            for(int c=0; c<9; c++){
                Map[r][c] = str.charAt(c)-'0';
                if(Map[r][c]==0){
                    BlankR.add(r);
                    BlankC.add(c);
                }
            }
        }
    }
    static boolean Complete;
    public static void FillBlank(int index){
        if(Complete) return;
        if(index==BlankR.size()){
            Complete=true;
            return;
        }
        for(int num=1; num<=9; num++){
            FillNum(BlankR.get(index),BlankC.get(index),num,index);
            if(Complete) return;
        }
    }
    public static void FillNum(int r, int c, int num, int index){
        //System.out.printf("%d %d %d %d\n",r,c,num,index);
        if(isSatisfied(r,c,num)){
            Map[r][c] = num;
            FillBlank(index+1);
        }
    }
    public static boolean isSatisfied(int r, int c, int num){
        boolean[] used = new boolean[9];
        used[num-1] = true;
        int A,B;
        if(r<=2) A=0;
        else if(r<=5) A=3;
        else A=6;
        if(c<=2) B=0;
        else if(c<=5) B=3;
        else B=6;
        for(int i=A; i<A+3; i++) {
            for(int j=B; j<B+3; j++) {
                if(Map[i][j]!=0){
                    if(!used[Map[i][j]-1]){
                        used[Map[i][j]-1]=true;
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        used = new boolean[9];
        used[num-1] = true;
        for(int i=0; i<9; i++){
            if(Map[i][c]!=0){
                if(!used[Map[i][c]-1]){
                    used[Map[i][c]-1]=true;
                }
                else{
                    return false;
                }
            }
        }
        used = new boolean[9];
        used[num-1] = true;
        for(int i=0; i<9; i++){
            if(Map[r][i]!=0){
                if(!used[Map[r][i]-1]){
                    used[Map[r][i]-1]=true;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
    public static void AppendMap(){
        for(int r=0; r<9; r++){
            for(int c=0; c<9; c++){
                sb.append(Map[r][c]);
            }
            sb.append('\n');
        }
        sb.append('\n');
    }
    public static boolean CheckSolvable(){
        boolean[] used;
        for(int i=0; i<9; i+=3){
            for(int j=0; j<9; j+=3){
                used = new boolean[9];
                for(int r=i; r<i+3; r++){
                    for(int c=j; c<j+3; c++){
                        if(Map[r][c]!=0){
                            if(!used[Map[r][c]-1]){
                                used[Map[r][c]-1]=true;
                            }
                            else {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        for(int r=0; r<9; r++){
            used = new boolean[9];
            for(int c=0; c<9; c++){
                if(Map[r][c]!=0){
                    if(!used[Map[r][c]-1]){
                        used[Map[r][c]-1]=true;
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        for(int c=0; c<9; c++){
            used = new boolean[9];
            for(int r=0; r<9; r++){
                if(Map[r][c]!=0){
                    if(!used[Map[r][c]-1]){
                        used[Map[r][c]-1]=true;
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
import java.io.*;
import java.util.*;

public class _2251 {
    public static void main(String[] args){
        init();
        DFS(0,0,Bottle[2]);
        printResults();
    }

    static int[] Bottle = new int[3];
    public static void init(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<3; i++){
                Bottle[i] = Integer.parseInt(st.nextToken());
            }
        }
        catch(Exception e){
        }
    }

    static HashSet<Integer> History = new HashSet<>();
    static HashSet<Integer> Results = new HashSet<>();
    public static void DFS(int a, int b, int c){
        // 히스토리에 현 상태가 있다면 리턴, 없다면 추가
        int historyValue = HistoryValueOf(a,b,c);
        if(History.contains(historyValue)) return;
        else History.add(historyValue);

        // 결과값 추가
        if(a==0) Results.add(c);

        // 분기
        int a_space = Bottle[0]-a;
        int b_space = Bottle[1]-b;
        int c_space = Bottle[2]-c;

        if(a>0){
            if(b_space>0){
                int movable = Math.min(a, b_space);
                DFS(a-movable, b+movable, c);
            }
            if(c_space>0){
                int movable = Math.min(a, c_space);
                DFS(a-movable, b, c+movable);
            }
        }
        if(b>0){
            if(a_space>0){
                int movable = Math.min(b, a_space);
                DFS(a+movable, b-movable, c);
            }
            if(c_space>0){
                int movable = Math.min(b, c_space);
                DFS(a, b-movable, c+movable);
            }
        }
        if(c>0){
            if(a_space>0){
                int movable = Math.min(c, a_space);
                DFS(a+movable, b, c-movable);
            }
            if(b_space>0){
                int movable = Math.min(c, b_space);
                DFS(a, b+movable, c-movable);
            }
        }
    }
    public static int HistoryValueOf(int a, int b, int c){
        return a*1000000 + b*1000 + c;
    }

    public static void printResults(){
        ArrayList<Integer> list = new ArrayList<>(Results);
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(int element : list)
            sb.append(element).append(' ');
        System.out.print(sb);
    }
}

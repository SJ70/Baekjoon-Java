import java.io.*;
import java.util.*;

public class _13913 {
    public static void main(String[] args) throws IOException{
        init();

        while(!Q.isEmpty()){
            bfs(Q.poll());
        }

        printResult();
    }
    static int Start, End;
    static Queue<Integer> Q = new ArrayDeque<>();
    static Integer[] Visited;
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Start = Integer.parseInt(st.nextToken());
        End = Integer.parseInt(st.nextToken());
        Visited = new Integer[100001];
        Q.add(Start);
    }
    public static void bfs(int index){
        if(index==End){
            Q.clear();
            return;
        }
        visit(index, index-1);
        visit(index, index+1);
        visit(index, index*2);
    }
    public static void visit(int from, int to){
        if(to>=0 && to<=100000 && to!=Start && Visited[to]==null){
            Visited[to] = from;
            Q.add(to);
        }
    }
    public static void printResult(){
        Deque<Integer> result = new ArrayDeque<>();
        for(int i=End; i!=Start; i=Visited[i]){
            result.addFirst(i);
        }
        result.addFirst(Start);

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()-1).append('\n');
        while(!result.isEmpty()){
            sb.append(result.pollFirst()).append(' ');
        }

        System.out.println(sb);
    }
}

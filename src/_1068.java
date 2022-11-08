import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1068 {
    static int N;
    static ArrayList<ArrayList<Integer>> Tree = new ArrayList<>();
    static int cnt = 0;
    public static void main(String[] args) throws IOException{
        init();
        //printTree();
        if(!NextNode.isEmpty() && isLeafNode(NextNode.peek())){
            System.out.println(1);
            return;
        }
        while(!NextNode.isEmpty())
            BFS(NextNode.poll());
        System.out.println(cnt);
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            Tree.add(new ArrayList<>());
        }
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int DeletedNode = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            if(i==DeletedNode) continue;
            int parentsIndex = arr[i];
            if(parentsIndex==-1) NextNode.add(i);
            else Tree.get(parentsIndex).add(i);
        }
    }
    public static void printTree(){
        for(int i=0; i<N; i++){
            for(int j=0; j<Tree.get(i).size(); j++){
                System.out.printf("%d -> %d\n",i,Tree.get(i).get(j));
            }
        }
    }
    static Queue<Integer> NextNode = new ArrayDeque<>();
    public static void BFS(int index){
        for(int node : Tree.get(index)){
            if(isLeafNode(node)) cnt++;
            else NextNode.add(node);
        }
    }
    public static boolean isLeafNode(int index){
        return Tree.get(index).size()==0;
    }
}

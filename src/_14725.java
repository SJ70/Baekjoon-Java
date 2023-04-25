import java.io.*;
import java.util.*;

public class _14725 {
    private static class Node{
        HashMap<String, Node> M = new HashMap<>();
        public boolean has(String str){
            return this.M.containsKey(str);
        }
        public void add(String str){
            this.M.put(str, new Node());
        }
        public Node get(String str){
            return this.M.get(str);
        }
        public boolean isEmpty(){
            return this.M.isEmpty();
        }
        public ArrayList<String> getSortedList(){
            ArrayList<String> arr = new ArrayList<>();
            for(Map.Entry<String, Node> e : this.M.entrySet()){
                arr.add(e.getKey());
            }
            Collections.sort(arr);
            return arr;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // HashMap Input
        Node Cave = new Node();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            Node pos = Cave;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for(int j=0; j<k; j++){
                String str = st.nextToken();
                if(!pos.has(str)){
                    pos.add(str);
                }
                pos = pos.get(str);
            }
        }

        // print
        visit(0, Cave);
        System.out.print(sb);
    }
    static StringBuilder sb = new StringBuilder();
    public static void visit(int depth, Node Cave){
        if(Cave.isEmpty()) return;

        ArrayList<String> arr = Cave.getSortedList();
        for(String e : arr){
            sb.append("--".repeat(depth)).append(e).append('\n');
            visit(depth+1, Cave.get(e));
        }
    }
}
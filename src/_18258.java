import java.io.*;
import java.util.*;

public class _18258 {
    static Deque<Integer> q = new ArrayDeque<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String Inst = st.nextToken();
            switch(Inst){
                case "push" : q.add(Integer.parseInt(st.nextToken())); break;
                case "pop" : bw.write(q.isEmpty()?"-1\n":q.poll()+"\n"); break;
                case "size" : bw.write(q.size()+"\n"); break;
                case "empty" : bw.write(q.isEmpty()?"1\n":"0\n"); break;
                case "front" : bw.write(q.size()==0?"-1\n":q.peek()+"\n"); break;
                case "back" : bw.write(q.size()==0?"-1\n":q.peekLast()+"\n"); break;
            }
        }
        bw.flush();
        bw.close();
    }
}
import java.io.*;
import java.util.*;

public class _10866 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<String> D = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push_front" : D.addFirst(st.nextToken()); break;
                case "push_back" : D.addLast(st.nextToken()); break;
                case "pop_front" : bw.write(D.isEmpty()?"-1\n":D.pollFirst()+"\n"); break;
                case "pop_back" : bw.write(D.isEmpty()?"-1\n":D.pollLast()+"\n"); break;
                case "size" : bw.write(D.size()+"\n"); break;
                case "empty" : bw.write(D.isEmpty()?"1\n":"0\n"); break;
                case "front" : bw.write(D.isEmpty()?"-1\n":D.peekFirst()+"\n"); break;
                case "back" : bw.write(D.isEmpty()?"-1\n":D.peekLast()+"\n"); break;
            }
        }
        bw.flush();
        bw.close();
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class _1874 {
    static int N;
    static Queue<Integer> queue = new ArrayDeque<>();
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N; i++){
            queue.add(i);
        }
        for(int i=0; i<N; i++){
            try{
                work(Integer.parseInt(br.readLine()));
            }
            catch(Exception e){
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
    public static void work(int n){
        while(true){
            if(stack.isEmpty() || stack.peek()<n){
                stack.push(queue.poll());
                sb.append('+').append('\n');
            }
            else if(stack.peek()>n){
                stack.pop();
                sb.append('-').append('\n');
            }
            else if(stack.peek()==n){
                stack.pop();
                sb.append('-').append('\n');
                return;
            }
        }
    }
}

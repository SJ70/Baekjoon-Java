import java.io.*;
import java.util.*;

public class _27497 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> D = new ArrayDeque<>();
        Stack<Boolean> isPutFront = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(Integer.parseInt(st.nextToken())){
                case 1 : D.addLast(st.nextToken().charAt(0)); isPutFront.push(false); break;
                case 2 : D.addFirst(st.nextToken().charAt(0)); isPutFront.push(true); break;
                case 3 :
                    if(!D.isEmpty()){
                        if(isPutFront.pop()) D.pollFirst();
                        else D.pollLast();
                    }
                    break;
            }
        }
        if(D.isEmpty()){
            System.out.println(0);
            return;
        }
        StringBuilder sb = new StringBuilder();
        while(!D.isEmpty()){
            sb.append(D.pollFirst());
        }
        System.out.println(sb);
    }
}

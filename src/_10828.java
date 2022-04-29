import java.io.*;
import java.util.*;

public class _10828 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static class Stack{
        ArrayList<Integer> arr = new ArrayList<>();

        public void Command(String S){
            StringTokenizer st = new StringTokenizer(S);
            switch (st.nextToken()) {
                case "push" : this.Push(Integer.parseInt(st.nextToken())); break;
                case "pop" : this.Pop(); break;
                case "size" : this.Size(); break;
                case "empty" : this.Empty(); break;
                case "top" : this.Top(); break;
            }
        }
        public int LastIndex(){
            return this.arr.size()-1;
        }
        public boolean isEmpty(){
            return this.arr.size()==0;
        }

        public void Push(int n){
            this.arr.add(n);
        }
        public void Pop(){
            if(isEmpty()) System.out.println(-1);
            else{
                System.out.println(this.arr.get(this.LastIndex()));
                this.arr.remove(this.LastIndex());
            }
        }
        public void Size(){
            System.out.println(this.arr.size());
        }
        public void Empty(){
            if(isEmpty()) System.out.println(1);
            else System.out.println(0);
        }
        public void Top(){
            if(isEmpty()) System.out.println(-1);
            else System.out.println(this.arr.get(this.LastIndex()));
        }
    }
    public static void main(String[] args) throws IOException{
        Stack S = new Stack();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++)
            S.Command(br.readLine());
    }
}

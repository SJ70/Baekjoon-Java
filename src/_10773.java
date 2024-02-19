import java.util.*;

public class _10773 {
    static Scanner sc = new Scanner(System.in);
    private static class Stack{
        ArrayList<Integer> arr = new ArrayList<>();
        public void write(){
            int n = sc.nextInt();
            if(n==0) this.arr.remove(this.arr.size()-1);
            else this.arr.add(n);
        }
        public int sum(){
            int n = 0;
            for(int i=0; i<this.arr.size(); i++)
                n+= arr.get(i);
            return n;
        }
    }
    public static void main(String[] args){
        int K = sc.nextInt();
        Stack S = new Stack();
        for(int i=0; i<K; i++){
            S.write();
        }
        System.out.println(S.sum());
    }
}

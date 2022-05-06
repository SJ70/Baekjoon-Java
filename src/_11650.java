import java.io.*;
import java.util.*;

public class _11650 {
    public static class yList{
        ArrayList<Integer> yValue = new ArrayList<>();
        boolean isNotSorted = true;
        public void add(Integer N){
            this.yValue.add(N);
        }
        public void sort(){
            Collections.sort(this.yValue);
            isNotSorted = false;
        }
        public Integer pop(){
            Integer X = this.yValue.get(0);
            this.yValue.remove(0);
            return X;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<Integer> X;
    static yList[] Y;

    public static void Input() throws IOException{
        int N = Integer.parseInt(br.readLine());
        X = new ArrayList<>();
        Y = new yList[200001];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            X.add(x);
            if(Y[x+100000]==null) Y[x+100000] = new yList();
            Y[x+100000].add(Integer.parseInt(st.nextToken()));
        }
    }
    public static void Sort_Print() throws IOException{
        Collections.sort(X);
        for(int i=0; i<X.size(); i++){
            int index = X.get(i)+100000;
            if(Y[index].isNotSorted) Y[index].sort();
            bw.write(X.get(i)+" "+Y[index].pop()+"\n");
        }
    }
    public static void main(String[] args) throws IOException{
        Input();
        Sort_Print();
        bw.flush();
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _1015 {
    static boolean SortByValue;
    public static class Obj implements Comparable<Obj>{
        int value, index, sortedIndex;
        public Obj(int value, int index){
            this.value = value;
            this.index = index;
        }
        public void setSortedIndex(int i){
            this.sortedIndex = i;
        }
        public int compareTo(Obj obj){
            if(SortByValue) return Integer.compare(this.value,obj.value);
            else return Integer.compare(this.index,obj.index);
        }
    }
    static ArrayList<Obj> Arr = new ArrayList<>();
    static int N;
    public static void main(String[] args) throws IOException{
        input();
        SortByValue = true;
        Collections.sort(Arr);
        setSortedIndex();
        SortByValue = false;
        Collections.sort(Arr);
        printSortedIndex();
    }
    public static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            Arr.add(new Obj(Integer.parseInt(st.nextToken()), i));
        }
    }
    public static void setSortedIndex(){
        for(int i=0; i<N; i++){
            Arr.get(i).setSortedIndex(i);
        }
    }
    public static void printSortedIndex(){
        StringBuilder sb = new StringBuilder();
        for(Obj obj : Arr){
            sb.append(obj.sortedIndex).append(' ');
        }
        System.out.println(sb);
    }
}

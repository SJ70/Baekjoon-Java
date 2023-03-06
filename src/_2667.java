import java.io.*;
import java.util.*;

public class _2667 {
    static int N;
    static int[][] arr;
    static int num = 0;
    static int currenSectionSize;
    static ArrayList<Integer> sectionSize = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        init();
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(arr[r][c]==-1){
                    currenSectionSize = 0;
                    num++;
                    setSection(r,c);
                    sectionSize.add(currenSectionSize);
                }
            }
        }
        printResult();
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int r=0; r<N; r++){
            String str = br.readLine();
            for(int c=0; c<N; c++){
                if(str.charAt(c)=='1') arr[r][c] = -1;
            }
        }
    }
    public static void setSection(int r, int c){
        arr[r][c] = num;
        currenSectionSize++;
        if(r-1>=0 && arr[r-1][c]==-1) setSection(r-1,c);
        if(r+1<N  && arr[r+1][c]==-1) setSection(r+1,c);
        if(c-1>=0 && arr[r][c-1]==-1) setSection(r,c-1);
        if(c+1<N  && arr[r][c+1]==-1) setSection(r,c+1);
    }
    public static void printResult(){
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        Collections.sort(sectionSize);
        for(int e : sectionSize){
            sb.append('\n').append(e);
        }
        System.out.println(sb);
    }
}

import java.io.*;
import java.util.*;

public class _2447 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int size;
    static boolean[][] Map;
    public static void main(String[] args) throws IOException{
        size = new Scanner(System.in).nextInt();
        Map = new boolean[size][size];
        for(int i=size; i>=3; i/=3)
            MakeBlank(i);
        Print();
        bw.flush();
        bw.close();
    }
    public static void MakeBlank(int N){
        for(int r=0; r<size; r+=N){
            for(int c=0; c<size; c+=N){
                if(Map[r+N/3][c+N/3]) continue;    // 이미 이전에 비워놓은 공간일 경우
                for(int i=r+N/3; i<r+N*2/3; i++){
                    for(int j=c+N/3; j<c+N*2/3; j++){
                        Map[i][j]=true;
                    }
                }
            }
        }
    }
    public static void Print() throws IOException{
        for(int r=0; r<size; r++){
            for(int c=0; c<size; c++){
                bw.write(Map[r][c]?' ':'*');
            }
            bw.write('\n');
        }
    }
}

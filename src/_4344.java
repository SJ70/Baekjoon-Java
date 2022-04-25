import java.io.*;
import java.util.*;

public class _4344 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static double OverAver() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] score = new int[Integer.parseInt(st.nextToken())];
        double average = 0;
        for(int i=0; i<score.length; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            average += score[i];
        }
        average /= score.length;
        double cnt = 0;
        for(int i=0; i<score.length; i++)
            if(score[i]>average) cnt++;
        return cnt/score.length*100;
    }
    public static void main(String[] args) throws IOException{
        int C = Integer.parseInt(br.readLine());
        for(int i=0; i<C; i++)
            System.out.printf("%.3f%%\n",OverAver());
    }
}

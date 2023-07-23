import java.io.*;
import java.util.*;

public class _28217 {
    static int N;
    static int[][][] TRIANGLE;
    public static void main(String[] args) throws IOException {
        input();
        ArrayList<String> TrianglesCanExist = makeTrianglesCanExist(TRIANGLE[0]);
        String GoalShape = getGoalShape(TRIANGLE[1]);
        System.out.println(getResult(TrianglesCanExist, GoalShape));
    }
    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        TRIANGLE = new int[2][N][N];

        for(int i=0; i<2; i++){
            for(int r=0; r<N; r++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int c=0; c<=r; c++){
                    TRIANGLE[i][r][c] = Integer.parseInt(st.nextToken()) + 1;
                }
            }
        }
    }
    private static ArrayList<String> makeTrianglesCanExist(int[][] triangle) {
        ArrayList<String> TrianglesCanExist = new ArrayList<>();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(triangle[r][c]>0){
                    sb1.append(triangle[r][c]);
                }
            }
            for(int c=N-1; c>=0; c--){
                if(triangle[r][c]>0){
                    sb2.append(triangle[r][c]);
                }
            }
        }
        for(int c=0; c<N; c++){
            for(int r=0; r<N; r++){
                if(triangle[r][c]>0){
                    sb3.append(triangle[r][c]);
                }
            }
            for(int r=N-1; r>=0; r--){
                if(triangle[r][c]>0){
                    sb4.append(triangle[r][c]);
                }
            }
        }
        for(int i=N-1; i>=0; i--){
            for(int j=0; j+i<N; j++){
                if(triangle[j+i][j]>0){
                    sb5.append(triangle[j+i][j]);
                }
            }
            for(int j=N-1-i; j>=0; j--){
                if(triangle[j+i][j]>0){
                    sb6.append(triangle[j+i][j]);
                }
            }
        }

        TrianglesCanExist.add(sb1.toString());
        TrianglesCanExist.add(sb2.toString());
        TrianglesCanExist.add(sb3.reverse().toString());
        TrianglesCanExist.add(sb4.reverse().toString());
        TrianglesCanExist.add(sb5.toString());
        TrianglesCanExist.add(sb6.toString());

        return TrianglesCanExist;
    }

    private static String getGoalShape(int[][] triangle){
        StringBuilder sb = new StringBuilder();
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(triangle[r][c]>0){
                    sb.append(triangle[r][c]);
                }
            }
        }
        return sb.toString();
    }

    private static int getResult(ArrayList<String> TrianglesCanExist, String GoalShape){
        int min_result = Integer.MAX_VALUE;
//        System.out.println(GoalShape+'\n');
        for(String Triangle : TrianglesCanExist){
//            System.out.println(Triangle);
            int result = 0;
            for(int i=0; i<Triangle.length(); i++){
                if(Triangle.charAt(i)!=GoalShape.charAt(i)){
                    result++;
                }
            }
            min_result = Math.min(min_result, result);
        }
        return min_result;
    }
}

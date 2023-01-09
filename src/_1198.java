import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1198 {
    public static void main(String[] args) throws IOException{
        initArr();

        double MaxArea = -1f;

        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                for(int k=j+1; k<N; k++){
                    MaxArea = Math.max(MaxArea,getArea(i,j,k));
                }
            }
        }

        System.out.print(MaxArea);
    }
    static int[][] PosArr;
    static int N;
    public static void initArr() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        PosArr = new int[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            PosArr[i][0] = Integer.parseInt(st.nextToken());
            PosArr[i][1] = Integer.parseInt(st.nextToken());
        }
    }
    public static double getArea(int i1, int i2, int i3){
        int x1 = PosArr[i1][0];
        int y1 = PosArr[i1][1];
        int x2 = PosArr[i2][0];
        int y2 = PosArr[i2][1];
        int x3 = PosArr[i3][0];
        int y3 = PosArr[i3][1];

        // 헤론의 공식
        double a = Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
        double b = Math.sqrt(Math.pow(x2-x3,2)+Math.pow(y2-y3,2));
        double c = Math.sqrt(Math.pow(x3-x1,2)+Math.pow(y3-y1,2));

        double s = (a+b+c)/2;

        double S = Math.sqrt( (s)*(s-a)*(s-b)*(s-c) );
        return S;
    }
}

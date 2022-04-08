import java.util.*;
public class _1064 {
    public static double dist(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
    }
    public static double slope(int x1, int y1, int x2, int y2){
        double dx = x1-x2;
        double dy = y1-y2;
        return dy/dx;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int xa = sc.nextInt();
        int ya = sc.nextInt();
        int xb = sc.nextInt();
        int yb = sc.nextInt();
        int xc = sc.nextInt();
        int yc = sc.nextInt();

        // L[0~2] : ab,ac,bc 길이
        double[] L = {dist(xa,ya,xb,yb),dist(xa,ya,xc,yc),dist(xb,yb,xc,yc)};
        double[] S = {slope(xa,ya,xb,yb),slope(xa,ya,xc,yc),slope(xb,yb,xc,yc)};
        Arrays.sort(L);
        // 평행사변형을 만들 수 없는 경우
        // 3점이 일직선 상에 존재 : 기울기가 같다 / 분모0->inf -> 곱셈 이용
        if((xa-xb)*(ya-yc)==(xa-xc)*(ya-yb))
            System.out.println(-1.0);
        // 2점 이상 일치
        else if(L[0]==0||L[1]==0||L[2]==0)
            System.out.println(-1.0);
        else{
            // 큰 둘레 : AB,AC,BC 중 큰 수 2개 *2
            double max = 2*(L[1]+L[2]);
            // 작은 둘레 : AB,AC,BC 중 작은 수 2개 *2
            double min = 2*(L[0]+L[1]);
            System.out.println(max-min);
        }
    }
}
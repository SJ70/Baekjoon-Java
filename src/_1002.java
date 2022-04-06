import java.util.Scanner;
public class _1002 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int result;
        int rp = sc.nextInt();
        for(int i=0; i<rp; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();
            double d = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
            double sum_r = r1+r2, sub_r = Math.abs(r1-r2);

            if(d==0&&r1==r2) result=-1;
            else if(d==0 || d>sum_r || d<sub_r) result=0;
            else if(d==sum_r || d==sub_r) result=1;
            else result=2;

            System.out.println(result);
        }
    }
}

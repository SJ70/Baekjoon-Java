import java.util.*;

public class _1855 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        String str = sc.next();

        if(C==1){
            System.out.println(str);
            return;
        }

        int R = str.length()/C;
        char[][] map = new char[R][C];
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                char tmp = str.charAt(r*C+c);
                if(r%2==0) map[r][c] = tmp;
                else map[r][C-1-c] = tmp;
            }
        }
//        for(int r=0; r<R; r++) {
//            for (int c=0; c<C; c++)
//                System.out.print(map[r][c]);
//            System.out.println();
//        }
        for(int c=0; c<C; c++){
            for(int r=0; r<R; r++){
                if(map[r][c]!='\0') System.out.print(map[r][c]);
            }
        }

    }
}

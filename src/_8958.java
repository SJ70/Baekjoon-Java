import java.util.Scanner;
public class _8958{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int repeat = sc.nextInt();

        for(int i=0; i<repeat; i++){
            String OX = sc.next();
            int tmp=1;
            int score=0;
            for(int j=0; j<OX.length(); j++){
                if(OX.charAt(j)=='O'){
                    score+=tmp;
                    tmp++;
                }
                else tmp=1;
            }
            System.out.println(score);
        }
    }
}
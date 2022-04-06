import java.util.Scanner;
public class _2839{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int sugar = sc.nextInt();
        int count = 0;

        if(sugar==4||sugar==7) count=-1;
        else{
            switch(sugar%10){ //1의자리수로판별
                case 0 : break;
                case 5 : break;
                case 3 : sugar-=3; count+=1; break;
                case 6 : sugar-=6; count+=2; break;
                case 8 : sugar-=8; count+=2; break;
                case 9 : sugar-=9; count+=3; break;
                case 1 : sugar-=11; count+=3; break;
                case 2 : sugar-=12; count+=4; break;
                case 4 : sugar-=14; count+=4; break;
                case 7 : sugar-=17; count+=5; break;
            }
            count+=sugar/5;
        }
        System.out.println(count);
    }
}
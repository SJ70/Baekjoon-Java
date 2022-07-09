import java.util.Scanner;

public class _2941 {
    public static void main(String[] args){
        String str = ' '+' '+new Scanner(System.in).next();
        int result = 0;
        for(int i=str.length()-1; i>=2; i--){
            result++;
            //System.out.println(i+","+str.charAt(i)+","+result);
            switch(str.charAt(i)){
                case'=':{
                    switch(str.charAt(i-1)){
                        case'c':
                        case's': i--; break;
                        case'z': {
                            if(str.charAt(i-2)=='d')
                                i-=2;
                            else i--;
                            break;
                        }
                    }
                    break;
                }
                case'-':{
                    switch(str.charAt(i-1)){
                        case'c':
                        case'd': i--; break;
                    }
                    break;
                }
                case'j':{
                    switch(str.charAt(i-1)){
                        case'l':
                        case'n': i--; break;
                    }
                    break;
                }
            }
        }
        System.out.println(result);
    }
}

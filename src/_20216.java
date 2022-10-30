import java.util.Scanner;

public class _20216 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            String str = sc.nextLine();
            switch(str.charAt(str.length()-1)){
                case'?': System.out.println("Quack!"); break;
                case'.': System.out.println("*Nod*"); break;
                default: return;
            }
        }
    }
}
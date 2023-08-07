import java.io.*;

public class _28290 {
    public static void main(String[] args) throws IOException {
        switch(new BufferedReader(new InputStreamReader(System.in)).readLine()){
            case "fdsajkl;" :
            case "jkl;fdsa" :
                System.out.println("in-out");
                return;
            case "asdf;lkj" :
            case ";lkjasdf" :
                System.out.println("out-in");
                return;
            case "asdfjkl;" :
                System.out.println("stairs");
                return;
            case ";lkjfdsa" :
                System.out.println("reverse");
                return;
            default :
                System.out.println("molu");
                return;
        }
    }
}

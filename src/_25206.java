import java.io.*;
import java.util.*;

public class _25206 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double totScore = 0f;
        double totCredit = 0f;
        for(int i=0; i<20; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            if(!grade.equals("P")){
                totCredit += credit;
                switch(grade){
                    case "A+" : totScore += credit*4.5f; break;
                    case "A0" : totScore += credit*4.0f; break;
                    case "B+" : totScore += credit*3.5f; break;
                    case "B0" : totScore += credit*3.0f; break;
                    case "C+" : totScore += credit*2.5f; break;
                    case "C0" : totScore += credit*2.0f; break;
                    case "D+" : totScore += credit*1.5f; break;
                    case "D0" : totScore += credit*1.0f; break;
                    case "F"  : totScore += credit*0.0f; break;
                }
            }
        }
        System.out.println(totScore/totCredit);
    }
}

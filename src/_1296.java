import java.io.*;
import java.util.PriorityQueue;

public class _1296 {

    static int[] Score = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name = br.readLine();

        int nameLength = name.length();
        for(int i=0; i<nameLength; i++){
            char c = name.charAt(i);
            if(c=='L') Score[0]++;
            else if(c=='O') Score[1]++;
            else if(c=='V') Score[2]++;
            else if(c=='E') Score[3]++;
        }

        int MaxScore = -1;
        String WinnerTeam = "";

        int teamCnt = Integer.parseInt(br.readLine());
        PriorityQueue<String> teamNames = new PriorityQueue<>();
        for(int i=0; i<teamCnt; i++){
            teamNames.add(br.readLine());
        }

        while(!teamNames.isEmpty()){
            String teamName = teamNames.poll();
            int score = getScore(teamName);
            if(score > MaxScore){
                MaxScore = score;
                WinnerTeam = teamName;
            }
        }

        System.out.println(WinnerTeam);
    }

    private static int getScore(String teamName){
        int[] score = new int[4];
        for(int i=0; i<4; i++){
            score[i] = Score[i];
        }

        int nameLength = teamName.length();
        for(int i=0; i<nameLength; i++){
            char c = teamName.charAt(i);
            if(c=='L') score[0]++;
            else if(c=='O') score[1]++;
            else if(c=='V') score[2]++;
            else if(c=='E') score[3]++;
        }

        long L = score[0];
        long O = score[1];
        long V = score[2];
        long E = score[3];

        return (int)(((L+O) * (L+V) * (L+E) * (O+V) * (O+E) * (V+E)) % 100);
    }
}

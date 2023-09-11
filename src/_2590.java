import java.io.*;

public class _2590 {

    public static void main(String[] args) throws IOException {
        int[] paperCnt = inputPaperCnt();
        int boardCnt = getBoardCnt(paperCnt);
        System.out.println(boardCnt);
    }

    private static int[] inputPaperCnt() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] paperCnt = new int[7];
        for(int i=1; i<=6; i++){
            paperCnt[i] = Integer.parseInt(br.readLine());
        }

        return paperCnt;
    }

    public static int getBoardCnt(int[] paperCnt) {

        int boardCnt = 0;

        // 6
        boardCnt += paperCnt[6];
        paperCnt[6] = 0;

        // 5
        boardCnt += paperCnt[5];
        paperCnt[1] -= paperCnt[5] * 11;
        paperCnt[5] = 0;

        // 4
        boardCnt += paperCnt[4];
        paperCnt[2] -= paperCnt[4] * 5;
        paperCnt[4] = 0;

        // 4, 5, 6 : 0
        // 1, 2 : 음수 ~ 양수
        // 3 : 0 ~ 양수

        // 3 (*4)
        int fourOfThree = paperCnt[3] / 4;
        boardCnt += fourOfThree;
        paperCnt[3] -= fourOfThree * 4;

        // 3 (*3)
        int threeOfThree = paperCnt[3] / 3;
        boardCnt += threeOfThree;
        paperCnt[3] -= threeOfThree * 3;
        paperCnt[2] -= threeOfThree * 1;
        paperCnt[1] -= threeOfThree * 5;

        // 3 (*2)
        int twoOfThree = paperCnt[3] / 2;
        boardCnt += twoOfThree;
        paperCnt[3] -= twoOfThree * 2;
        paperCnt[2] -= twoOfThree * 3;
        paperCnt[1] -= twoOfThree * 6;

        // 3 (*1)
        boardCnt += paperCnt[3];
        paperCnt[2] -= paperCnt[3] * 5;
        paperCnt[1] -= paperCnt[3] * 7;
        paperCnt[3] = 0;

        // 3, 4, 5, 6 : 0
        // 1, 2 : 음수 ~ 양수

        // 2
        if(paperCnt[2]>0){
            int nineOfTwo = (int)Math.ceil((double) paperCnt[2]/9);
            boardCnt += nineOfTwo;
            paperCnt[2] -= nineOfTwo * 9;
        }

        // 3, 4, 5 ,6 : 0
        // 2 : 음수 ~ 0
        // 1 : 음수 ~ 양수

        // 2가 음수라면 1로 치환
        if(paperCnt[2]<0){
            paperCnt[1] += paperCnt[2] * 4;
            paperCnt[2] = 0;
        }

        if(paperCnt[1]>0){
            int thirtyThreeOfOne = (int)Math.ceil((double) paperCnt[1]/36);
            boardCnt += thirtyThreeOfOne;
            paperCnt[1] -= thirtyThreeOfOne * 36;
        }
        return boardCnt;
    }
}

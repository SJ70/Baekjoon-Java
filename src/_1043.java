import java.util.*;
public class _1043 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int pn = sc.nextInt();
        int[] whoKnow = new int[N+1];
        int[][] party = new int[M][N+1];

        // 진실을 아는 사람 (1)
        for(int i=0; i<pn; i++)
            whoKnow[sc.nextInt()] = 1;
        // 파티 별 참여자 // index0 : 참가자수 / index1~ : 참가자명단
        for(int i=0; i<M; i++){
            int tmp = sc.nextInt();
            party[i][0] = tmp;
            for(int j=1; j<=tmp; j++)
                party[i][j] = sc.nextInt();
        }
        // '진실을아는사람'을 만날 사람에겐 과장해선 안 됨 -> 마지막 파티부터 첫 파티까지 역순으로 계산
        // '진실을아는사람'이 포함된 파티에 있는 사람은 '진실을아는사람'이 된 것으로 간주
        int result = 0;
        for(int r=0; r<N; r++){
            for(int i=M-1; i>=0; i--){
                for(int j=1; j<=party[i][0]; j++){  // '진실을아는사람'이 하나 라도 있을 경우 참가자 전원 '진실을아는사람'
                    if(whoKnow[party[i][j]]==1){
                        for(int k=1; k<=party[i][0]; k++)
                            whoKnow[party[i][k]]=1;
                        break;
                    }
                }
            }
        }
        // '진실을아는사람'을 만나지 않는 파티 재확인
        for(int i=M-1; i>=0; i--){
            int tmp = 0;
            for(int j=1; j<=party[i][0]; j++)
                tmp += whoKnow[party[i][j]];  // '진실을아는사람'이 하나 라도 있을 경우 tmp>0
            if(tmp==0) result++;
        }
        System.out.println(result);
    }
}

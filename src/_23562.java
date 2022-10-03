import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _23562 {
    public static void main(String[] args) throws IOException{
        Init();
        //PrintCostsToFill();
        int MaxShapeCaseSize = Math.min(R,C);
        int Result = 99999999;
        for(int k=1; k*3<=MaxShapeCaseSize; k++){
            int size = k*3;
            for(int rStart=0; rStart<=R-size; rStart++){
                for(int cStart=0; cStart<=C-size; cStart++){
                    ShapeCase = new boolean[size][size];
                    int Cost = CostToEraseAll;
                    for(int r=rStart; r<rStart+size; r++){
                        for(int c=cStart; c<cStart+size; c++){
                            if(r>=rStart+k && r<rStart+(2*k) && c>=cStart+k && c<cStart+(3*k)) continue;
                            Cost += CostsToFill[r][c];
                        }
                    }
                    Result = Math.min(Cost,Result);
                }
            }
        }
        System.out.print(Result);
    }
    static int R,C,CostToFill,CostToErase,CostToEraseAll;
    static boolean[][] Map, ShapeCase;
    static int[][] CostsToFill;
    public static void Init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        CostToFill = Integer.parseInt(st.nextToken());
        CostToErase = Integer.parseInt(st.nextToken());

        Map = new boolean[R][C];
        CostsToFill = new int[R][C];
        for(int r=0; r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                Map[r][c] = str.charAt(c)=='#';
                // 다 지워놨다고 가정, 지운 곳을 다시 채울 경우 비용 환불
                if(Map[r][c]){
                    CostsToFill[r][c] -= CostToErase;
                    CostToEraseAll += CostToErase;
                }
                else CostsToFill[r][c] = CostToFill;
            }
        }
    }
    public static void PrintCostsToFill(){
        System.out.println();
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                System.out.printf("%3d",CostsToFill[r][c]);
            }
            System.out.println();
        }
    }
}

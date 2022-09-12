public class _1318 {
    static boolean[][] Poker = new boolean[4][13];
    static int[] Shape = new int[4];
    static int[] Num = new int[13];
    static int[] Pedigree = new int[12];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        BT(0,0,0);
        int all=0;
        for(int i=0; i<12; i++){
            all+=Pedigree[i];
        }
        for(int i=0; i<12; i++){
            int gcd = GCD(Pedigree[i],all);
            sb.append((Pedigree[i]/gcd)+"/"+(all/gcd)+"\n");
            //sb.append((Pedigree[i])+"/"+(all)+"\n");
        }
        System.out.println(sb);
    }
    public static void BT(int c, int n, int cnt){
        if(cnt==6){
            Pedigree[Distinguish()-1]++;
            //Print();
            return;
        }
        if(n>12){
            c++; n=0;
        }
        if(c>3) return;
        if(52-(c*13+n)<6-cnt) return;
        Poker[c][n]=true;
        Shape[c]++;
        Num[n]++;
        BT(c,n+1,cnt+1);
        Poker[c][n]=false;
        Shape[c]--;
        Num[n]--;
        BT(c,n+1,cnt);
    }
    static boolean FourCard,FullHouse,Triple,TwoPair,OnePair;
    public static int Distinguish(){
        if(isRTF()) return 12;
        if(isSTF()) return 11;
        FourCard=false;
        FullHouse=false;
        Triple=false;
        TwoPair=false;
        OnePair=false;
        GetPair();
        if(FourCard) return 10;
        if(FullHouse) return 9;
        if(isFlush()) return 8;
        if(isMountain()) return 7;
        if(isBackStraight()) return 6;
        if(isStraight()) return 5;
        if(Triple) return 4;
        if(TwoPair) return 3;
        if(OnePair) return 2;
        return 1;
    }
    public static boolean isRTF(){
        for(int i=0; i<4; i++){
            if(Poker[i][0]&&Poker[i][1]&&Poker[i][2]&&Poker[i][3]&&Poker[i][4]) return true;
        }
        return false;
    }
    public static boolean isSTF(){
        for(int k=0; k<4; k++){
            int continuity = 0;
            for(int i=0; i<13; i++){
                if(Poker[k][i]) continuity++;
                else continuity=0;
                if(continuity==5) return true;
            }
        }
        return false;
    }
    public static void GetPair(){
        int Tri = 0;
        int Pair = 0;
        for(int i=0; i<13; i++){
            if(Num[i]==4){
                FourCard=true;
                return;
            }
            else if(Num[i]==2){
                Pair++;
            }
            else if(Num[i]==3){
                Tri++;
            }
        }
        if( Tri>=2 || (Tri>0 && Pair>0) ){
            FullHouse=true;
        }
        else if( Tri>0 ){
            Triple=true;
        }
        else if( Pair>=2 ){
            TwoPair=true;
        }
        else if( Pair>0 ){
            OnePair= true;
        }
    }
    public static boolean isFlush(){
        for(int i=0; i<4; i++){
            if(Shape[i]>=5) return true;
        }
        return false;
    }
    public static boolean isMountain(){
        return ( Num[0]>0 && Num[9]>0 && Num[10]>0 && Num[11]>0 && Num[12]>0);
    }
    public static boolean isBackStraight(){
        return ( Num[0]>0 && Num[1]>0 && Num[2]>0 && Num[3]>0 && Num[4]>0);
    }
    public static boolean isStraight(){
        int continuity = 0;
        for(int i=0; i<13; i++){
            if(Num[i]>0) continuity++;
            else continuity=0;
            if(continuity==5) return true;
        }
        return false;
    }
    public static void Print(){
        System.out.print("\n    ");
        for(int n=0; n<13; n++){
            System.out.print(Num[n]+" ");
        }
        System.out.print("\n");
        for(int c=0; c<4; c++){
            System.out.print(Shape[c]+" : ");
            for(int n=0; n<13; n++){
                System.out.print(Poker[c][n]?((n+1)+" "):". ");
            }
            System.out.print("\n");
        }
        System.out.print(" --> ");
        switch(Distinguish()){
            case 1 : System.out.print("탑"); return;
            case 2 : System.out.print("원페어"); return;
            case 3 : System.out.print("투페어"); return;
            case 4 : System.out.print("트리플"); return;
            case 5 : System.out.print("스트레이트"); return;
            case 6 : System.out.print("빽스트레이트"); return;
            case 7 : System.out.print("마운틴"); return;
            case 8 : System.out.print("플러쉬"); return;
            case 9 : System.out.print("풀하우스"); return;
            case 10 : System.out.print("포카드"); return;
            case 11 : System.out.print("스트레이트 플러쉬"); return;
            case 12 : System.out.print("로얄 스트레이트 플러쉬"); return;
        }
        System.out.print("\n\n");
    }
    public static int GCD(int a, int b){
        // 유클리드 호제법
        if(a%b==0) return b;
        else return GCD(b,a%b);
    }
}

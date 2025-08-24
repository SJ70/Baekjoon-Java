import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17081 {

    private static int R, C;
    private static char[][] map;
    private static char[] moves;
    private static Monster[][] monsters;
    private static Integer[][] weapons;
    private static Integer[][] shields;
    private static String[][] accessories;

    private static class Monster {
        String name;
        int att;
        int def;
        int curHp;
        int maxHp;
        int exp;
    }

    private static int startR = -1;
    private static int startC = -1;
    private static int curR = -1;
    private static int curC = -1;

    private static int turn = 0;
    private static int lv = 1;
    private static int curHp = 20;
    private static int maxHp = 20;
    private static int att = 2;
    private static int weaponAtt = 0;
    private static int def = 2;
    private static int shieldDef = 0;
    private static int curExp = 0;
    private static int maxExp = 5;

    private static int curAccCnt = 0;
    private static boolean hr;
    private static boolean re;
    private static boolean co;
    private static boolean ex;
    private static boolean dx;
    private static boolean hu;
    private static boolean cu;

    private static boolean won;
    private static String killedBy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // map input
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int infoCnt = 0;
        map = new char[R][C];
        for (int r=0; r<R; r++) {
            map[r] = br.readLine().toCharArray();
            for (int c=0; c<C; c++) {
                switch (map[r][c]) {
                    case '@' :
                        startR = curR = r;
                        startC = curC = c;
                        map[r][c] = '.';
                        break;
                    case 'B' :
                    case 'M' :
                    case '&' :
                        infoCnt++;
                        break;
                }
            }
        }

        // move input
        moves = br.readLine().toCharArray();

        // map setting
        monsters = new Monster[R][C];
        weapons = new Integer[R][C];
        shields = new Integer[R][C];
        accessories = new String[R][C];
        for (int i=0; i<infoCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            switch (map[r][c]) {
                case '&' : // monster
                case 'M' : // boss
                    Monster monster = new Monster();
                    monster.name = st.nextToken();
                    monster.att = Integer.parseInt(st.nextToken());
                    monster.def = Integer.parseInt(st.nextToken());
                    monster.maxHp = monster.curHp = Integer.parseInt(st.nextToken());
                    monster.exp = Integer.parseInt(st.nextToken());
                    monsters[r][c] = monster;
                    break;
                case 'B' : // chest
                    String itemType = st.nextToken();
                    switch (itemType) {
                        case "W" : weapons[r][c] = Integer.parseInt(st.nextToken()); break;
                        case "A" : shields[r][c] = Integer.parseInt(st.nextToken()); break;
                        case "O" : accessories[r][c] = st.nextToken(); break;
                    }
                    break;
            }
        }

        // move
        game : for (int move : moves) {

//            log();

            int dr, dc;
            switch (move) {
                case 'R' : dr = 0; dc = 1; break;
                case 'L' : dr = 0; dc = -1; break;
                case 'U' : dr = -1; dc = 0; break;
                case 'D' : dr = 1; dc = 0; break;
                default : dr = 0; dc = 0; break;
            }

            // check is out or wall
            int nextR = curR + dr;
            int nextC = curC + dc;
            if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C || map[nextR][nextC] == '#') {
                // can't go
            }
            else {
                // can go, so go
                curR = nextR;
                curC = nextC;
            }

            turn++;
            switch (map[curR][curC]) {

                case '^' : // spike
                    curHp -= dx ? 1 : 5;
                    if (curHp <= 0) {
                        curHp = 0;
                        if (re) {
                            revive();
                        }
                        else {
                            killedBy = "SPIKE TRAP";
                            break game;
                        }
                    }
                    break;

                case 'B' : // chest
                    if (weapons[curR][curC] != null) {
                        weaponAtt = weapons[curR][curC];
                    }
                    else if (shields[curR][curC] != null) {
                        shieldDef = shields[curR][curC];
                    }
                    else if (accessories[curR][curC] != null && curAccCnt < 4) {
                        switch (accessories[curR][curC]) {
                            case "HR" :
                                if (!hr) {
                                    hr = true;
                                    curAccCnt++;
                                }
                                break;
                            case "RE" :
                                if (!re) {
                                    re = true;
                                    curAccCnt++;
                                }
                                break;
                            case "CO" :
                                if (!co) {
                                    co = true;
                                    curAccCnt++;
                                }
                                break;
                            case "EX" :
                                if (!ex) {
                                    ex = true;
                                    curAccCnt++;
                                }
                                break;
                            case "DX" :
                                if (!dx) {
                                    dx = true;
                                    curAccCnt++;
                                }
                                break;
                            case "HU" :
                                if (!hu) {
                                    hu = true;
                                    curAccCnt++;
                                }
                                break;
                            case "CU" :
                                if (!cu) {
                                    cu = true;
                                    curAccCnt++;
                                }
                                break;
                        }
                    }
                    map[curR][curC] = '.';
                    break;

                case '&' : // monster
                    Monster monster = monsters[curR][curC];
                    // first att
                    if (co && dx) {
                        monster.curHp -= Math.max(1, 3 * (att + weaponAtt) - monster.def);
                    }
                    else if (co) {
                        monster.curHp -= Math.max(1, 2 * (att + weaponAtt) - monster.def);
                    }
                    else {
                        monster.curHp -= Math.max(1, att + weaponAtt - monster.def);
                    }

                    while (true) {
                        // check kill
                        if (monster.curHp <= 0) {
                            map[curR][curC] = '.';
                            regen();
                            addExp(monster.exp);
                            break;
                        }

                        // def
                        curHp -= Math.max(1, monster.att - def - shieldDef);

                        // check die
                        if (curHp <= 0) {
                            curHp = 0;
                            if (re) {
                                revive(monster);
                                break;
                            }
                            else {
                                killedBy = monster.name;
                                break game;
                            }
                        }

                        // att
                        monster.curHp -= Math.max(1, att + weaponAtt - monster.def);
                    }
                    break;

                case 'M' : // boss

                    if (hu) {
                        curHp = maxHp;
                    }

                    Monster boss = monsters[curR][curC];
                    // first att
                    if (co && dx) {
                        boss.curHp -= Math.max(1, 3 * (att + weaponAtt) - boss.def);
                    }
                    else if (co) {
                        boss.curHp -= Math.max(1, 2 * (att + weaponAtt) - boss.def);
                    }
                    else {
                        boss.curHp -= Math.max(1, att + weaponAtt - boss.def);
                    }

                    // check kill
                    if (boss.curHp <= 0) {
                        map[curR][curC] = '.';
                        regen();
                        addExp(boss.exp);
                        won = true;
                        break game;
                    }

                    // first def
                    if (!hu) {
                        curHp -= Math.max(1, boss.att - def - shieldDef);
                    }

                    while (true) {
                        // check die
                        if (curHp <= 0) {
                            curHp = 0;
                            if (re) {
                                revive(boss);
                                break;
                            }
                            else {
                                killedBy = boss.name;
                                break game;
                            }
                        }

                        // att
                        boss.curHp -= Math.max(1, att + weaponAtt - boss.def);

                        // check kill
                        if (boss.curHp <= 0) {
                            map[curR][curC] = '.';
                            regen();
                            addExp(boss.exp);
                            won = true;
                            break game;
                        }

                        // def
                        curHp -= Math.max(1, boss.att - def - shieldDef);
                    }
                    break;

            }

        }

        // result
        StringBuilder sb = new StringBuilder();
        for (int r=0; r<R; r++) {
            for (int c=0; c<C; c++) {
                if (killedBy == null && curR == r && curC == c) {
                    sb.append('@');
                }
                else {
                    sb.append(map[r][c]);
                }
                if (c == C-1) {
                    sb.append('\n');
                }
            }
        }
        sb.append(String.format("Passed Turns : %d\n", turn));
        sb.append(String.format("LV : %d\n", lv));
        sb.append(String.format("HP : %d/%d\n", curHp, maxHp));
        sb.append(String.format("ATT : %d+%d\n", att, weaponAtt));
        sb.append(String.format("DEF : %d+%d\n", def, shieldDef));
        sb.append(String.format("EXP : %d/%d\n", curExp, maxExp));
        if (won) {
            sb.append("YOU WIN!");
        }
        else if (killedBy != null) {
            sb.append(String.format("YOU HAVE BEEN KILLED BY %s..", killedBy));
        }
        else {
            sb.append("Press any key to continue.");
        }
        System.out.print(sb);

    }

    private static void revive(Monster monster) {
        revive();
        monster.curHp = monster.maxHp;
    }

    private static void revive() {
        curHp = maxHp;
        curR = startR;
        curC = startC;
        re = false;
        curAccCnt--;
    }

    private static void addExp(int exp) {
        curExp += exp;
        if (ex) {
            curExp += exp / 5;
        }
        if (curExp >= maxExp) {
            lv++;
            curExp = 0;
            maxExp = lv * 5;
            maxHp += 5;
            att += 2;
            def += 2;
            curHp = maxHp;
        }
    }

    private static void regen() {
        if (hr) {
            curHp = Math.min(maxHp, curHp + 3);
        }
    }

    private static void log() {
        System.out.println("------------------------------");
        for (int r=0; r<R; r++) {
            for (int c=0; c<C; c++) {
                if (killedBy == null && curR == r && curC == c) {
                    System.out.print('@');
                }
                else {
                    System.out.print(map[r][c]);
                }
                if (c == C-1) {
                    System.out.println();
                }
            }
        }
        System.out.println();
        System.out.printf("Passed Turns : %d\n", turn);
        System.out.printf("LV : %d\n", lv);
        System.out.printf("HP : %d/%d\n", curHp, maxHp);
        System.out.printf("ATT : %d+%d\n", att, weaponAtt);
        System.out.printf("DEF : %d+%d\n", def, shieldDef);
        System.out.printf("EXP : %d/%d\n", curExp, maxExp);
        System.out.println();
        System.out.print("ACC : ");
        if (hr) System.out.print("HR ");
        if (re) System.out.print("RE ");
        if (co) System.out.print("CO ");
        if (ex) System.out.print("EX ");
        if (dx) System.out.print("DX ");
        if (hu) System.out.print("HU ");
        if (cu) System.out.print("CU ");
        System.out.println();
        System.out.println();
    }

}

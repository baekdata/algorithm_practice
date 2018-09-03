package Study180906;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Pair {
    int first;
    int second;
    Pair(int first, int second) { // 백준 정답, 추 후 참고 
        this.first = first;
        this.second = second;
    }
} 
public class BJ_3197_lake_test {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int sx,sy,ex,ey;
        sx=sy=ex=ey=-1;
        Queue<Pair> swan, nswan, water, nwater;
        swan = new LinkedList<Pair>();
        nswan = new LinkedList<Pair>();
        water = new LinkedList<Pair>();
        nwater = new LinkedList<Pair>(); // 다 각각 따로 저장 
        char[][] a = new char[n][m];
        boolean[][] wcheck = new boolean[n][m];
        boolean[][] scheck = new boolean[n][m];
        for (int i=0; i<n; i++) {
            a[i] = sc.next().toCharArray();
            for (int j=0; j<m; j++) {
                if (a[i][j] == 'L') {
                    if (sx == -1) {
                        sx = i;
                        sy = j;
                    } else {
                        ex = i;
                        ey = j;
                    }
                    a[i][j] = '.';
                }
                if (a[i][j] == '.') {
                    water.add(new Pair(i, j));
                    wcheck[i][j] = true;
                }
            }
        }
        swan.add(new Pair(sx,sy));
        scheck[sx][sy] = true;
        for (int i=0;; i++) {
            while (!water.isEmpty()) {
                Pair p = water.remove();
                int x = p.first;
                int y = p.second;
                a[x][y] = '.';
                for (int k=0; k<4; k++) {
                    int nx = x+dx[k];
                    int ny = y+dy[k];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (wcheck[nx][ny]) continue;
                    if (a[nx][ny] == '.') {
                        water.add(new Pair(nx,ny));
                        wcheck[nx][ny] = true;
                    } else {
                        nwater.add(new Pair(nx,ny));
                        wcheck[nx][ny] = true;
                    }
                }
            }
            while (!swan.isEmpty()) {
                Pair p = swan.remove();
                int x = p.first;
                int y = p.second;
                for (int k=0; k<4; k++) {
                    int nx = x+dx[k];
                    int ny = y+dy[k];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (scheck[nx][ny]) continue;
                    if (a[nx][ny] == '.') {
                        swan.add(new Pair(nx,ny));
                        scheck[nx][ny] = true;
                    } else {
                        nswan.add(new Pair(nx,ny));
                        scheck[nx][ny] = true;
                    }
                }
            }
            if (scheck[ex][ey]) {
                System.out.println(i);
                break;
            }
            water = nwater;
            swan = nswan;
            nwater = new LinkedList<Pair>();
            nswan = new LinkedList<Pair>();
        }
    }
}
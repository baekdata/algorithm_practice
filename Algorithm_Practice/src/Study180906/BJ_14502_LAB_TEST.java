package Study180906;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class BJ_14502_LAB_TEST {
    public static class Pair {
        int r, c;
        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    static int N, M;
    static int[][] map, temp;
    static int max = 0;
    
    // 안전영역 구하는 함수
    static void findSafeZone() {
        int safezone = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(temp[i][j] == 0)
                    safezone++;
            }
        }
        
        max = Math.max(max, safezone);        
    }
    
    // 바이러스 퍼뜨리는 함수
    static void spreadVirus() {
        Queue<Pair> q = new LinkedList<Pair>();
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};
        
        // temp에 map을 옮기고, 바이러스가 있는 위치를 큐에 저장
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                temp[i][j] = map[i][j]; 
                
                if(temp[i][j] == 2)
                    q.add(new Pair(i, j));
            }
        }
 
        while(!q.isEmpty()) {
            Pair p = q.remove();
            int r = p.r;
            int c = p.c;
            
            for(int i = 0; i < 4; i++) {
                int R = r + dr[i];
                int C = c + dc[i];
                
                if(R < 0 || N <= R || C < 0 || M <= C) continue;
                
                if(temp[R][C] == 0) {
                    temp[R][C] = 2;
                    q.add(new Pair(R, C));
                }
            }
        }
        
        findSafeZone();
    }
    
    // 벽 세우는 함수
    static void walls(int cnt) {
        if(cnt == 3) {    
            spreadVirus(); // 3개 다 세우면 바이러스 퍼뜨리기
            return;
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    walls(cnt+1);
                    map[i][j] = 0;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        N = s.nextInt();
        M = s.nextInt();
        map = new int[N][M];
        temp = new int[N][M];
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = s.nextInt();
            }
        }
        
        walls(0);
        
        System.out.println(max);
    }
}
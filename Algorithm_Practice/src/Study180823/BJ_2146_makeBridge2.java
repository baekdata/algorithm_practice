package Study180823;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2146_makeBridge2 { // 다리 만들기 // BFS + DFS
   // dfs로 라벨링하여 번호 매긴 후// bfs로 각 섬에서 다 다리 놓아가며 최단거리 구하기 - 이 외에도 3개 다 놓기 / 간척 하나씩 늘려나가기 등 존재 
   static int num;
   static int[][] arr;
   static boolean[][] check;
   static int[] dx = { -1, 0, 1, 0 };
   static int[] dy = { 0, 1, 0, -1 };
   static int count = 1;
   static int result = 100000; // max값 세팅, min값 구해야함.

   public static void main(String args[]) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      num = Integer.parseInt(br.readLine());
      check = new boolean[num][num];
      arr = new int[num][num];

      for (int i = 0; i < num; i++) { // 입력
         StringTokenizer st = new StringTokenizer(br.readLine());
         for (int j = 0; j < num; j++) {
            arr[i][j] = Integer.parseInt(st.nextToken());
         }
      }

      for (int i = 0; i < num; i++) { //섬마다 체크
         for (int j = 0; j < num; j++) {
            if (arr[i][j] == 1) {
               count++;
               arr[i][j] = count;
               dfs(i, j);
            }
         }
      }

      for (int i = 0; i < num; i++) { //섬에 모든 지점에서 시작, 가장 빠른 지점 체크. 최단거리
         for (int j = 0; j < num; j++) {
            if (arr[i][j] != 0) {
               bfs(i, j);
               for (boolean[] row: check) // 매번 동일한 조건필요하므로 초기화
                  Arrays.fill(row, false);
            }
         }
      }
      System.out.println(result); // 결과값 출력
   }

   public static void dfs(int x, int y) { // 각 섬 체크.
      for (int i = 0; i < 4; i++) {
         int nextX = x + dx[i];
         int nextY = y + dy[i];

         if (nextX >= 0 && nextY >= 0 && nextX < num && nextY < num){ // 벽체크
            if (arr[nextX][nextY] == count) continue; //다음 갈 위치가 같은 섬이면 패스
            if (arr[nextX][nextY] == 0) continue; //다음 갈 위치가 바다이면 패스
            arr[nextX][nextY] = count;
            dfs(nextX, nextY);
         }
      }
   }

   public static void bfs(int x, int y) {
      int nx = x;   
      int ny = y; 
      Queue<BridgePoint> q = new LinkedList<BridgePoint>();
      q.add(new BridgePoint(x, y,0));

      while (!q.isEmpty()) {
         BridgePoint curPoint = q.poll();
         for (int i = 0; i < 4; i++) {
            int nextX = curPoint.x + dx[i];
            int nextY = curPoint.y + dy[i];
            int nextCount = curPoint.count + 1;

            if (nextX >= 0 && nextY >= 0 && nextX < num && nextY < num){ // 벽체크
               if (arr[nextX][nextY] == arr[nx][ny]) continue; // 이미 섬이자 같은 섬이면 패스
               if (check[nextX][nextY]) continue; // 이미 방문했는지 체크
               if (arr[nextX][nextY]!=0){ // 바다 아닐 경우 다른 섬
                  result = Math.min(result, nextCount-1); // 매번 최단거리 체크
                  return;
               }
               check[nextX][nextY] = true; // 지나간 곳은 -1로 체크
               q.add(new BridgePoint(nextX,nextY,nextCount));
            }
         }
      }
   }
}

class BridgePoint { // 섬과 연결되기 위한 각 섬들 좌표  / 좌표, 해당 좌표 카운트 
   int x;
   int y;
   int count;
   BridgePoint(int x, int y,int count) {
      this.x = x;
      this.y = y;
      this.count = count;
   }
}

package Study180823;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
public class BJ_2146_makeBridge { // 다리 만들기 // BFS + DFS // LAB 연구소 함께 풀어보
//	http://zoonvivor.tistory.com/122 참고
// dfs로 라벨링하여 번호 매긴 후//
// bfs로 각 섬에서 다 다리 놓아가며 최단거리 구하기 - 이 외에도 3개 다 놓기 / 간척 하나씩 늘려나가기 등 존재 
	
    static int[][] arr;
    static int[][] reset;
    static int N;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int count = 1;
    static int min = Integer.MAX_VALUE;
 
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        N = Integer.parseInt(br.readLine());
        reset = new int[N][N];
        arr = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                reset[i][j] = Integer.parseInt(str[j]);
            }
        }
        //-----------------입력부------------------\\
        
        //다리를 건너기전에 해야 할 일이 하나 있다.
        //섬 마다 번호를 붙혀줘야한다. 아래 DFS는 번호를 붙혀주는 작업을 한다.
        //1번째 방문하는 섬은 2번으로 2번째는 3번으로 ...
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (reset[i][j] == 1) {
                    count++;
                    reset[i][j] = count;
                    Labeling_DFS(i, j);
                }
            }
        }
        Reset();    //arr함수를 reset 함수로 초기화 시켜줌. (복사)
        
        //가장 가까운 다리길이를 찾는 과정
        //섬에서 시작하여 다른 섬에 가장 빨리 도착할 때 값을 저장하고 돌아온다.
        //섬의 모든 지점에서 확인한다. 상하좌우에 섬이 있을 수 있고 최단거리가 될 수 있으므로
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != 0) {
                    ShortestPath_BFS(i, j);
                    Reset();
                }
            }
        }
        System.out.println(min);
    }
 
    public static void Labeling_DFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            //좌표 넘어가면 패스
            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                continue;
            }
            //다음 갈 위치가 같은 섬이면 패스
            if (reset[nextX][nextY] == count) {
                continue;
            }
            //다음 갈 위치가 바다이면 패스
            if (reset[nextX][nextY] == 0) {
                continue;
            }
            //섬의 번호를 count로 통일한다. (count는 2,3,4 등등 순으로 증가한다)
            reset[nextX][nextY] = count;
            Labeling_DFS(nextX, nextY);
        }
 
    }
 
    public static void ShortestPath_BFS(int x, int y) {
        
        //inX, inY 는 출발 섬의 값을 저장하기위한 좌표이다.
        int inX =x;    //출발 섬의 x좌표
        int inY = y; //출발 섬의 y좌표
        Queue<Dot> q = new LinkedList<Dot>();
        q.add(new Dot(x, y,0));
 
        while (!q.isEmpty()) {
            Dot current = q.poll();
            for (int i = 0; i < 4; i++) {
                //다음 간척사업할 위치좌표와 거리 저장 변수
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];
                int nextCount = current.count + 1;
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                    continue;
                }
                //다음 간척할 자리가 이미 섬이라면 패스
                if (arr[nextX][nextY] == arr[inX][inY]) {
                    continue;
                }
                //다음 간척할 자리가 이미 간척한 자리라면 패스
                if(arr[nextX][nextY]==-1){
                    continue;
                }
                //다음 간척할 자리가 바다가 아니라면
                //이미 섬과 간척자리는 위에 조건에 걸렸으므로 이 조건일 때는 무조건 다른 섬이다.
                if(arr[nextX][nextY]!=0){
                    //다른 섬에 도착했을때의 최단거리를 비교하여 저장. 그리고 리턴
                    min = Math.min(min, nextCount-1);
                    return;
                }
                //간척한 자리는 -1로 놓는다. 그리고 큐에 넣는다.
                arr[nextX][nextY] = -1;
                q.add(new Dot(nextX,nextY,nextCount));
                
            }
        }
 
    }
 
    //간척사업으로 인해 -1로 변한 자리를 되돌려 놔야 다른 최단거리를 구할 수 있다.
    public static void Reset() {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                arr[i][j] = reset[i][j];
            }
        }
    }
}
 
class Dot {
    int x;
    int y;
    int count;
    Dot(int x, int y,int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
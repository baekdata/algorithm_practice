package Study180823;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_14502_LAB { // 연구소, 완전탐색, bfs //삼성 기출문제.
	
	//TODO 완전탐색 퍼뜨리는거랑 다 체크, 안보고 혼자 구현해보기.
//	http://suriisurii.tistory.com/32
	
    static int n,m,ans=0;
    static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
    static int[][] a = new int[9][9], map = new int[9][9];
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                a[i][j] = in.nextInt();
         
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(a[i][j]==2 || a[i][j]==1) continue;
                cloneMap();
                map[i][j]=1;
                go(1);
                map[i][j]=0;
            }
        }
        System.out.println(ans);
        in.close();
    }
    
    public static void cloneMap(){
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                map[i][j] = a[i][j];
    }
    
    public static void virus(){
        int[][] temp = new int[n][m];
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                temp[i][j] = map[i][j];
         
        Queue<PointLAB> q = new LinkedList<>();
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                if(temp[i][j]==2)
                    q.add(new PointLAB(i,j));
         
        while(!q.isEmpty()){
        	PointLAB now = q.remove();
            int x = now.x;
            int y = now.y;
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(temp[nx][ny]==2 || temp[nx][ny]==1) continue;
                temp[nx][ny]=2;
                q.add(new PointLAB(nx,ny));
            }
        }
        int cnt = 0;
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                if(temp[i][j]==0) ++cnt;
         
        ans = Math.max(ans, cnt);
    }
    
    public static void go(int cnt){
        if(cnt==3){
            virus();
            return;
        }
         
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++){
                if(map[i][j]==1 || map[i][j]==2) continue;
                map[i][j]=1;
                go(cnt+1);
                map[i][j]=0;
            }
    }

    public static class PointLAB{
        int x, y;
        public PointLAB(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
package Study180809;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BJ_3190_Snake { // http://suriisurii.tistory.com/30 뱀, 시뮬레이션  >> 이 소스 아니면 http://sysout.tistory.com/24 이거 참고. 
    static int n,sx,sy,dir=3,k,l,time;
    static boolean finish = false;
    static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
    static int[][] a = new int[101][101];
    static char[] change = new char[10001];
    static Deque<Point> snake = new ArrayDeque<>();
    static void changeDir(){
        char now = change[time];
        switch(dir){
        case 0:
            if(now=='D') dir=3;
            else dir=2;
            break;
        case 1:
            if(now=='D') dir=2;
            else dir=3;
            break;
        case 2:
            if(now=='D') dir=0;
            else dir=1;
            break;
        case 3:
            if(now=='D') dir=1;
            else dir=0;
            break;
        }
    }
    static void move(){
        Point head = snake.peekFirst();
        int x = head.x , y = head.y;
        switch(dir){
        case 0:
            --x;
            break;
        case 1:
            ++x;
            break;
        case 2:
            --y;
            break;
        case 3:
            ++y;
            break;
        }
        if(x<0 || x>=n || y<0 || y>=n || a[x][y]==2){
            finish = true;
            return;
        }
        snake.addFirst(new Point(x,y));
        if(a[x][y]==0) {
            a[snake.peekLast().x][snake.peekLast().y]=0;
            snake.removeLast();
        }
        a[x][y]=2;
    }
    public static void go(){
        while(!finish){
            if(change[time]=='D' || change[time]=='L') changeDir();
            move();
            ++time;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        for(int i=0; i<k; i++){
            int x = in.nextInt()-1;
            int y = in.nextInt()-1;
            a[x][y] = 1;//사과의 위치
        }
        l = in.nextInt();
        for(int i=0; i<l; i++){
            int x = in.nextInt();
            String s = in.next();
            change[x] = s.charAt(0);
        }
        a[0][0] = 2;
        snake.addLast(new Point(0,0));
        go();
        System.out.println(time);
        in.close();
    }
    public static class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
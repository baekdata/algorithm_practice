package Algorithm;
 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 
public class Maze implements stack {
    
    static class ListNode {
        int x;
        int y;
        int dir;
        ListNode link;
        
        public ListNode() {
            // TODO Auto-generated constructor stub
        }
        
        public ListNode(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.link = null;
        }
        
        public String toString() {
            return "< " + x + ", " + y + " >";
        }
    }
    
    /** 스택 top ListNode **/
    private ListNode top;
    
    /** 미로객체 생성자 **/
    public Maze() {
        // TODO Auto-generated constructor stub
        top = null;
    }
    
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        if(top == null) 
            return true;
        else 
            return false;
    }
 
    @Override
    public void push(ListNode getNode) {
        // TODO Auto-generated method stub
        ListNode newNode = new ListNode();
        newNode.x = getNode.x;
        newNode.y = getNode.y;
        newNode.dir = getNode.dir;
        newNode.link = top;
        
        if(isEmpty()) {
            top = newNode;
            return ;
        }
        
        top = newNode;
    }
 
    @Override
    public ListNode pop() {
        // TODO Auto-generated method stub
        if(isEmpty())
            return null;
        else {
            ListNode node = top;
            top = top.link;
            return node;
        }
    }
 
    @Override
    public void delete() {
        // TODO Auto-generated method stub
        if(isEmpty())
            return ;
        else 
            top = top.link;
    }
 
    @Override
    public Object peek() {
        // TODO Auto-generated method stub
        return top;
    }
    
    public static void main(String[] args) {
        
        Maze stack = new Maze();
        
        /** 미로 가로, 세로 크기 **/
        int mazeSizeRow = 7;
        int mazeSizeColumn = 6;
        
        /** 미로 좌표 **/
        int[][] maze = new int[mazeSizeRow+2][mazeSizeColumn+2];
        int[][] mark = new int[mazeSizeRow+2][mazeSizeColumn+2];
        
        /** 방향 **/
        int[][] dir = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
        // 북[0], 동[1], 남[2], 서[3]
        
        /** 목표좌표 **/
        int goal_x = 0, goal_y = 0;
        
        try {
            String buf = null;
            
            BufferedReader filebr = new BufferedReader(new FileReader("sample.txt"));
            
            // 첫번째 초기 위치설정
            buf = filebr.readLine() ;
            stack.push(new ListNode(Character.getNumericValue(buf.charAt(0)), 
                    Character.getNumericValue(buf.charAt(2)), 0));
            
            // 두번째 출구 위치설정
            buf = filebr.readLine();
            goal_x = Character.getNumericValue(buf.charAt(0));
            goal_y = Character.getNumericValue(buf.charAt(2));
            
            // maze에 미로 삽입
            for(int i=0 ; i<mazeSizeRow+2 ; i++) {
                buf = filebr.readLine() ;
                for(int j=0 ; j<(mazeSizeColumn+2) * 2 ; j++) {
                    if(j % 2 == 0)
                        maze[i][j/2] = Character.getNumericValue(buf.charAt(j));
                }
            }
            
            filebr.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
        // 미로 탐색 시작
        System.out.println("미로 탐색 시작!");
        while( !(stack.isEmpty()) ) {
            ListNode my  = (ListNode)stack.pop();
            
            while(my.dir < 4) {
                int next_x = my.x + dir[my.dir][0];
                int next_y = my.y + dir[my.dir][1];
                
                // 탐색 성공시.
                if(my.x == goal_x && my.y == goal_y) {
                    stack.push(new ListNode(my.x, my.y, my.dir));
                    
                    Maze mazePath = new Maze();
                    while(!stack.isEmpty()) {
                        mazePath.push(stack.pop());
                    }
                    
                    while(!mazePath.isEmpty()) {
                        System.out.println(mazePath.top.toString());
                        mazePath.pop();
                    }
                    System.out.println("미로탐색 종료!");
                    break;
                }
                
                if(maze[next_x][next_y] == 0 && mark[next_x][next_y] != 1) {
                    mark[next_x][next_y] = 1;
                    stack.push(new ListNode(my.x, my.y, my.dir));
                    my.x = next_x;
                    my.y = next_y;
                    my.dir = 0;
                }
                else {
                    my.dir++;
                }
            }
            
        }
        
    }
}

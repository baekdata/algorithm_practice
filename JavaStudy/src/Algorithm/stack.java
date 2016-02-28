package Algorithm;
 
import Algorithm.Maze.ListNode;
 
public interface stack {
    
    // 스택이 공백인지 검사
    boolean isEmpty(); 
    
    // 스택에 원소 x를 삽입
    void push(ListNode x);
    
    // 스택의 톱 원소를 삭제하여 반환
    ListNode pop();
    
    // 스택의 톱 원소를 삭제
    void delete();
    
    // 스택의 톱 원소 검색
    Object peek();
}

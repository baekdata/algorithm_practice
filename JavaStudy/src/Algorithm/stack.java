package Algorithm;
 
import Algorithm.Maze.ListNode;
 
public interface stack {
    
    // ������ �������� �˻�
    boolean isEmpty(); 
    
    // ���ÿ� ���� x�� ����
    void push(ListNode x);
    
    // ������ �� ���Ҹ� �����Ͽ� ��ȯ
    ListNode pop();
    
    // ������ �� ���Ҹ� ����
    void delete();
    
    // ������ �� ���� �˻�
    Object peek();
}

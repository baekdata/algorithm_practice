package Algorithm;

public class Node {
	private char data;
	private Node left;
	private Node right;
	
	public Node(char data){
		this.setData(data);
	}
	
	public void setData(char data){
		this.data = data;
	}
	
	public char getData(){
		return data;
	}
	
	public void setLeft(Node left){
		this.left = left;
	}
	
	public Node getLeft(){
		return left;
	}
	
	public void setRight(Node right){
		this.right = right;
	}
	
	public Node getRight(){
		return right;
	}
}

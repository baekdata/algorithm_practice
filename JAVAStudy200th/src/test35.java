public class test35 { // �ִ�����, ��Ŭ���� ȣ����, �ִ������� ���ϴ� ������ ���� ���� �� ������ ū ������ ���� ���� ���� ���� �ݺ�
	public static void main(String[] args){
		int m = 150;
		int n = 350;
		
		while(m!=n){
			System.out.print((m)+"��  "+(n)+"�Դϴ�.");
			if(m>n)
				m-=n;
			else if(n>m)
				n-=m;
		}
		System.out.println();
		System.out.println("�ִ� ����� "+m+"�Դϴ�.");
	}
}

import java.util.Scanner;

public class FoodFactory { // ���� // �׸��� // �ҽ��� ���� // ���̿켱 �ʺ� ���� ���� �� ���� // �˰��� �ٽ� ���� �ʿ� // ������ ok
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 1;
		int result = 1;

		Food f[] = new Food[5001]; // Ŭ���� ��ü �迭 ����
		for(int i=0; i<n; i++){
			f[i] = new Food(); // ���� ���ְ� �־�� �������� �Ȼ���
			f[i].w= sc.nextInt();
			f[i].h=sc.nextInt();
		}

		for(int i=0; i<n; i++){
			for(int j=i+1; j<n; j++){
				if(f[j].w<f[i].w){
					Food temp = new Food();
					temp = f[j];
					f[j] = f[i];
					f[i] = temp;
				}else if(f[j].w == f[i].w){
					if(f[j].h<f[i].h){
						Food temp = new Food();
						temp = f[j];
						f[j] = f[i];
						f[i] = temp;
					}
				}
			}
		}

		boolean flag[] = new boolean[5001]; // ���� count����
		int total = 0;
		int start = -1;
		Food first = new Food(); // Ŭ���� ��ü �ӽú��� ����
		int flag_count = 0;

		while(true){ // �ϴ� ���ѷ��� ������
			total++; // ó�� 1���� �����ϹǷ� +1;
			for(int i=start+1; i<n; i++){
				if (flag[i] == false){
					first = f[i];
					start = i;
					//����ߴٰ� ǥ��
					flag[i] = true;
					flag_count++;

					break;
				}
			}

			for (int i = start + 1; i < n; i++)
			{
				if (f[i].w >= first.w && f[i].h >= first.h && flag[i]==false)
				{
					//������ �ҽ����� �񱳴������ ��ü
					first = f[i];
					flag_count++;
					flag[i] = true;
				}
			}

			if (flag_count == n)
				break;
		}
		System.out.println(total);
	}

	static class Food{
		int w=0;
		int h=0;
	}
}
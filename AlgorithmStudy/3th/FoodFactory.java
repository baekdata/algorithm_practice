import java.util.Scanner;

public class FoodFactory { // 정올 // 그리디 // 소시지 공장 // 길이우선 너비 다음 정렬 후 진행 // 알고리즘 다시 이해 필요 // 정올은 ok
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 1;
		int result = 1;

		Food f[] = new Food[5001]; // 클래스 객체 배열 생성
		for(int i=0; i<n; i++){
			f[i] = new Food(); // 생성 해주고 넣어야 널포인터 안생김
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

		boolean flag[] = new boolean[5001]; // 각각 count여부
		int total = 0;
		int start = -1;
		Food first = new Food(); // 클래스 객체 임시변수 지정
		int flag_count = 0;

		while(true){ // 일단 무한루프 돌리기
			total++; // 처음 1부터 시작하므로 +1;
			for(int i=start+1; i<n; i++){
				if (flag[i] == false){
					first = f[i];
					start = i;
					//사용했다고 표시
					flag[i] = true;
					flag_count++;

					break;
				}
			}

			for (int i = start + 1; i < n; i++)
			{
				if (f[i].w >= first.w && f[i].h >= first.h && flag[i]==false)
				{
					//이전의 소시지를 비교대상으로 교체
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
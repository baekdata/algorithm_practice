package Study180927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * 참고 : http://whereisusb.tistory.com/185?category=746476
 * @author jongsubaek
 *
 */

public class SW_5658_treasure_ref{ // sw 모의고사 // 16진수 좌물쇠 // 보물상자 비밀번호 
	static int n,k,cut;
	static char[] arr; // 16진수도 들어가므로 문자열 배열 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int i=1;i<=tc;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			String t = br.readLine();
			arr = new char[t.length()];
			
			for(int j=0;j<t.length();j++)
				arr[j] = t.charAt(j);
			cut = t.length()/4; // 4개로 나눈 값 
			
			list.clear();
			solve();
			Collections.sort(list); // 내림차순 위해서는 미리 오름차순 필요 
			Collections.reverse(list); // 내림차순 정렬 
			sb.append("#"+i+" "+list.get(k-1)+"\n");
		}
		System.out.print(sb);
	}

	static List<Integer> list = new ArrayList<>();
	
	private static void solve() {
		boolean flag = true;
		// 원하는 개수만큼 도달할 때까지
		while(flag) { // contain 안될때까지 돌리기 
			flag = false;
			// 우선적으로 숫자를 뽑아내기
			for(int i=0;i<arr.length;) {
				int idx=0;
				String sNum = "";
				while(idx!=cut) { // cut 숫자만큼 arr에서 뽑아내기 
					sNum += arr[i++];
					idx++;
				}
				int t = getInt(sNum); // 16진수 10진수로 변환 
				if(!list.contains(t)) {
					list.add(t);
					flag = true;
				}
			}
			// 회전 시키기
			rotate();
		}
	}

	private static int getInt(String t) { // 10진수 16진수로 변환 
		return Integer.parseInt(t,16);
	}

	private static void rotate() {// 배열에 넣고 회전 
		// 시계 방향 회전이니 가장 마지막걸 저장
		char lastN = arr[arr.length-1];
		for(int i=arr.length-1;i>0;i--)
			arr[i] = arr[i-1]; 
		arr[0] = lastN;
	}
}

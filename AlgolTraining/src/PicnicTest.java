import java.io.*;
import java.util.*;
public class PicnicTest{
    static boolean isFriend[][];
    static int n;
 
    public static void main(String args[]) throws NumberFormatException, IOException{
        Scanner br = new Scanner(System.in);
        int T = Integer.parseInt(br.nextLine().trim());
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.nextLine());
            n = Integer.parseInt(st.nextToken());   // 총 인원수
            int m = Integer.parseInt(st.nextToken());   // 쌍 개수
 
            isFriend = new boolean[n][n];
            st = new StringTokenizer(br.nextLine());
            for(int i = 0; i < m; i++){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                isFriend[a][b] = true;
                isFriend[b][a] = true;              
            }
            System.out.println( countParings(new boolean[n]) );
        }
    }
 
    static int countParings(boolean taken[]){
        // 비어있는 사람 찾기
        int firstFree = -1;
        for(int i = 0; i < n; i++){
            if( !taken[i] ){
                firstFree = i;
                break;
            }
        }
        // 기저사례 : 모두 짝지었다면 끝
        if( firstFree == -1 )
            return 1;
         
        int ret = 0;        
        for(int pair = firstFree + 1; pair < n; pair++){
            if( !taken[pair] && isFriend[firstFree][pair] ){
                taken[firstFree] = true;
                taken[pair] = true;
                 
                ret += countParings(taken);
                 
                taken[firstFree] = false;
                taken[pair] = false;
            }
        }
        return ret;
    }
}
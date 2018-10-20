package samsungProb;
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
class testMain {
    static int[][] arr;
    static int[] result;
    static int N;
    static int count;
    static int[] start;
    static int[] link;
    static int min = Integer.MAX_VALUE;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        arr = new int[N][N];
        result = new int[N];
        start = new int[N];
        link = new int[N];
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        DFS(0, 0);
        System.out.println(min);
    }
 
    public static void DFS(int start, int depth) {
        for (int i = start; i < N; i++) {
            result[i] = 1;
            count++;
            DFS(i + 1, depth + 1);
            result[i] = 0;
            count--;
        }
        //-----------경우의 수를 구하고 난 후----------------//
        if (count == N / 2){
            //print();
            calc();
        }
    }
 
    public static void print() {
        for (int i = 0; i < N; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
 
    public static void calc() {
        int start_sum = 0;
        int liNk_sum = 0;
        int start_cNt = 0;
        int liNk_cNt = 0;
        //value[] 값이 1이면 스타트팀, 0이면 link 팀이 된다.
        for (int k = 0; k < N; k++) {
            if (result[k] == 1) {
                //start_cnt는 0부터 스타트 팀에 사람이 들어올때마다 1씩 증가한다.
                start[start_cNt++] = k;
            } else {
                //link_cnt는 0부터 스타트 팀에 사람이 들어올때마다 1씩 증가한다.
                link[liNk_cNt++] = k;
            }
        }
 
        //두팀이 가질 수 있는 점수를 다 구한다.
        //(1,1) (2,2) 등이 발생할 때 값은 0이므로 따로 조건을 만들지 않았다.
        for (int x = 0; x < N / 2; x++) {
            for (int y = 0; y < N / 2; y++) {
                start_sum += arr[start[x]][start[y]];
                liNk_sum += arr[link[x]][link[y]];
            }
        }
        //최소값 구함
        if (min > Math.abs(start_sum - liNk_sum)) {
            min = Math.abs(start_sum - liNk_sum);
        }
    }
}
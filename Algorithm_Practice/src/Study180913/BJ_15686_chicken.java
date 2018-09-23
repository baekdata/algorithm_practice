package Study180913;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class BJ_15686_chicken {
 
    static ArrayList<Point> chicken = new ArrayList<>();
    static ArrayList<Point> house = new ArrayList<>();
    static int[][] map = null;
    static ArrayList<Integer> result = new ArrayList<>();
    public static void main(String[] args) {
         
        //1. 치킨집을 고른다. nCr
        //2. 각각의 집에서 개별적으로 너비탐색! 가장 먼저 걸리면 해당 좌표 저장
        //3. 모든 집에서 치킨거리를 구했으면, 그 합을 저장한다! (nCr 하나의 경우의 수 치킨거리를 구한것이다.)
        //4. 모든 조합에 대해 1.2.3. 반복 
        //5. 모든 조합에 대해 제일 작은 값 리턴 (총 치킨거리)
         
        Scanner sc = new Scanner(System.in);
         
        int n = sc.nextInt(); //nxn 지도
        int r = sc.nextInt(); //r개의 치킨집만 선택
         
        map = new int[n][n];
         
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
            }
        }
         
        filter(map);
        solution(r);
    }
 
    private static void solution(int r) {
        //큰 골조는 조합 프레임
        int []combination = new int[chicken.size()];
        int []seleted = new int[chicken.size()];
        for(int i=0; i<combination.length; i++){
            combination[i] = i; 
        }
         
        nCr(seleted, chicken.size(), r, 0, 0, combination);
 
        Collections.sort(result);
        System.out.print(result.get(0));
    }
 
    private static void nCr(int[] seleted, int n, int r, int index, int target, int[] combination) {
        if(r == 0){
             int size = map.length;
             int[][] temp_map = new int[size][size];
             Queue<Point> queue = new LinkedList<>();
              
             for(int i=0; i<index; i++){
                 int x = chicken.get(combination[seleted[i]]).x;
                 int y = chicken.get(combination[seleted[i]]).y;
                  
                 temp_map[x][y] = 2;
                  
             }
 
             int distance = 0;
             //System.out.println("=> 탐색시작"); 
             for(int i=0; i<house.size(); i++){ 
                 int startX = house.get(i).x;
                 int startY = house.get(i).y;
             
                 queue.add(new Point(startX,startY));
                 Point p = getChickenDistance(temp_map, queue);
                  
                 distance += Math.abs(p.x - startX) + Math.abs(p.y - startY);
                    for(int a=0; a<size; a++){
                        for(int b=0; b<size; b++){       
                            if(temp_map[a][b]==1){
                                temp_map[a][b] = 0;
                            }
                        }
                    }
             }
              
             result.add(distance);
             distance = 0;
 
        }else if(target == n){
            return;
        }else{
            seleted[index] = target;
            nCr(seleted, n, r-1, index+1, target+1, combination);
            nCr(seleted, n, r, index, target+1, combination);
        }
         
    }
 
 
 
    static int[] goX = {-1,0,1,0};
    static int[] goY = {0,1,0,-1};
    private static Point getChickenDistance(int[][] temp_map, Queue<Point> queue) {
     
        int n = temp_map.length;
        int m = temp_map.length;
         
        while(!queue.isEmpty()){    
            Point start = queue.poll();
             
            for(int i=0; i<4; i++){
                int x = start.x + goX[i];
                int y = start.y + goY[i];
             
            if(-1 < x && x < n && -1 < y && y < m){
                if(temp_map[x][y] == 0){
                temp_map[x][y] = 1;
                queue.add(new Point(x,y));
                }else if(temp_map[x][y] == 2){
                    //System.out.println("치킨거리 : "+x+" "+y);
                    queue.clear();
                 
                    return new Point(x,y);
                }
            }
             
            }
             
        }
         
        return null;    
         
    }
 
    /**
     * 각 좌표값 구분해서 치킨, 집 나눠 집어넣기 
     * @param array
     */
    private static void filter(int[][] array) {
        int n = array.length;   
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(array[i][j] == 2){ // 치
                    chicken.add(new Point(i,j));
                }else if(array[i][j] == 1){
                    house.add(new Point(i,j));
                }
            }
        }
    }
}
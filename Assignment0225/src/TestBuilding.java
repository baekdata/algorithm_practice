import java.util.Scanner;
import java.util.Stack;
public class TestBuilding {
    private static void calcBuildings(Building[] buildings) { // 빌딩, 스택 사용, Success, 익히기
        Stack<Building> stack = new Stack<>();
        stack.push(buildings[0]);
 
        for (int i = 1; i < buildings.length; i++) {
            Building building = buildings[i];
            Building top = stack.peek();
            while (top.height < building.height) {
                buildings[top.number - 1].nextBuilding = building;
                stack.pop();
                if (stack.isEmpty() == true)
                    break;
                top = stack.peek();
            }
            stack.push(building);
        }
 
        for (Building building : buildings) {
            if (building.nextBuilding != null)
                System.out.println(building.nextBuilding.number);
            else
                System.out.println(0);
        }
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Building[] buildings = new Building[N];
        for (int i = 0; i < N; i++)
            buildings[i] = new Building(i + 1, scanner.nextInt());
        scanner.close();
//         Building[] buildings = new Building[6];
//         buildings[0] = new Building(1, 3);
//         buildings[1] = new Building(2, 2);
//         buildings[2] = new Building(3, 6);
//         buildings[3] = new Building(4, 1);
//         buildings[4] = new Building(5, 1);
//         buildings[5] = new Building(6, 2);
        calcBuildings(buildings);
    }
 
    public static class Building {
        public int number;
        public int height;
        public Building nextBuilding;
 
        public Building(int number, int height) {
            this.number = number;
            this.height = height;
        }
 
        @Override
        public String toString() {
            return "[" + number + ", " + height + "]";
        }
    }
}
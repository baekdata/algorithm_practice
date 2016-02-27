import java.util.Scanner;
import java.util.Stack;
 
public class TestPartMax { // PartMax 답안 // 90점 // 마지막 시간초과 // stack활용
 
    private static void calc(Element[] sequence, final Sector[] sectors) {
 
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < sequence.length; i++) {
            while (stack.isEmpty() == false)
                if (sequence[i].element > sequence[stack.peek()].element)
                    sequence[stack.pop()].smallerThan = i;
                else
                    break;
            stack.push(i);
        }
        
        for (Sector sector : sectors) {
            Element element = sequence[sector.from];
            while (element.smallerThan != -1 && element.smallerThan <= sector.to)
                element = sequence[element.smallerThan];
            System.out.println(element.element);
        }
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int Q = scanner.nextInt();
        Element[] sequence = new Element[N];
        for (int i = 0; i < sequence.length; i++)
            sequence[i] = new Element(scanner.nextInt());
        Sector[] sectors = new Sector[Q];
        for (int i = 0; i < sectors.length; i++)
            sectors[i] = new Sector(scanner.nextInt() - 1, scanner.nextInt() - 1);
        scanner.close();
        
        calc(sequence, sectors);
    }
 
    public static class Element {
        public int element;
        public int smallerThan;
 
        public Element(int element) {
            this.element = element;
            this.smallerThan = -1;
        }
    }
 
    public static class Sector {
        public int from;
        public int to;
 
        public Sector(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}


public class test01 {
    public static long ones( int number ) {
        int value = 1;
        int n = 1;
        int numberOfOne = 1;

        while( n % number != 0) {
            value *= 10;
            n += value % number;
            ++numberOfOne;
        }   
        return numberOfOne;
    }
    public static void main(String[] args) {
        System.out.println(ones(3));
    }
}
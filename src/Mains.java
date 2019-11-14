import java.util.Scanner;

public class Mains {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int num = scanner.nextInt();
            int count = 0 ;
            for(int i = 1 ; i <= num ;i++){
                int j = i ;
                while(j%5 == 0){
                    count++;
                    j /= 5;
                }
            }
            System.out.println(count);
        }
    }
}

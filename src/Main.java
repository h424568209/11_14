import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int num = scanner.nextInt();
                String s = Integer.toString(num);
                StringBuilder res = new StringBuilder();
                for(int i= s.length()-1 ; i>=0 ; i--){
                    res.append(s.charAt(i));
                }
            System.out.println(res);
        }
    }
}

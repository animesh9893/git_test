import java.util.Scanner;
import java.util.Random;

class TakeInput {
    String inputString(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        return s;
    }

    int inputInt(){
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        sc.close();
        return s;
    }
}

class RandomNumberGenerator {

    public static int randGenerate(int lower, int upper) {
        Random rand = new Random();
        return rand.nextInt((upper - lower) + 1) + lower;
    }

}




public class Input {
    public static void main(String[] args) {
        TakeInput t = new TakeInput();
        // System.out.println(t.inputString());

        RandomNumberGenerator r = new RandomNumberGenerator();
        System.out.println(r.randGenerate(0, 7));
    }
}

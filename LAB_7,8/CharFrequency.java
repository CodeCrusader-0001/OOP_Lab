import java.util.HashMap;
import java.util.Scanner;

public class CharFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.next();
        System.out.print("Enter threshold frequency: ");
        int n = sc.nextInt();

        HashMap<Character, Integer> freq = new HashMap<>();
        for (char ch : str.toCharArray())
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

        freq.forEach((ch, count) -> {
            if (count > n) System.out.println(ch + ": " + count);
        });
    }
}

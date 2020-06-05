import java.util.Scanner;

public class Decode {

    private static String decrypt(String encoded_string) {
        return b.a(Constant.hc, encoded_string);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in_str = sc.nextLine();
        System.out.println(decrypt(in_str));
    }

}

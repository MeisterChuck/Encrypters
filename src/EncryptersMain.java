import java.util.Scanner;

class EncryptersMain{
    public static void main(String[] args){
        Encrypters encryption;
        Scanner scan = new Scanner(System.in);
        String iOne, iTwo;

        System.out.println("\nEnter words: ");
        iOne = scan.nextLine();
        System.out.println("Enter the key");
        iTwo = scan.nextLine();

        encryption = new Encrypters(iOne, iTwo);
    }
}
import java.util.Scanner;

public class Main {
    public static int SetRoof(){
        System.out.println("Choose the maximum number for your guess:\nmax:");
        int input = -1;
        while (input == -1){
            try{
                input = new Scanner(System.in).nextInt();
            }catch (Exception e){
                System.out.println("Must be an integer!:");
            }
        }

        while(input < 1){
            System.out.println("Max number cannot be 0 or below. Try again:");
            input = new Scanner(System.in).nextInt();
        }
        return input;
    }

    public static int GenNum(int roof){
        int gen = (int) Math.floor(Math.random() * (roof+1));
        return (int)gen;
    }
    public static void main(String[] args) {
        Scanner sc;
        boolean game = true;
        int guess = -1;
        int roof;
        int guessCount = 0;
        int num;
        String keyword = "help";

        roof = SetRoof();
        num = GenNum(roof);
        while (game && guess != num){
            System.out.println("Guess:");
            sc = new Scanner(System.in);
            String _input = sc.next();
            if(_input.equals("help")){
                if(!_input.equals("help")) continue;
                System.out.println("The number you are looking for is " + (num % 2 == 0 ? "even" : "odd") + ".");
                continue;
            }
            guess = Integer.valueOf(_input);
            if(guess < 0 || guess > roof) {
                System.out.println("That is not in the guessable interval.");
                continue;
            }
            guessCount++;

            //if(guess != num) System.out.println("Nope. It is " + (guess > num ? "lower" : "higher") + ".");
            if(guess != num) System.out.println("Nope.");
        }

        System.out.println("You got it! The number was " + num + ". It took " + guessCount + " guesses to get it.");
        System.out.println("Wanna play again?");
        sc = new Scanner(System.in);
        if(sc.next().toLowerCase().equals("yes")) main(null);

        System.out.println("Bye");
        System.out.println("Bye");
    }
}
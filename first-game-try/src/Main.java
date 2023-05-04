import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int hp = Player.hp;
        int food = Player.food;
        String[] invetory = Player.invetory;


        while(Player.isAlive) {
            Player.days++;
            PlayerCanDo.stat();
            Player.writing();
            playerAlive();
        }
    }

    private static void playerAlive(){
        int random = randomDecider();
        PlayerCanDo.storeNumBefor(randomDecider());
        System.out.println(PlayerCanDo.numBefore);

        if(random == 0){
            System.out.println("Találtál egy dobozt megnézed? y/n");
            PlayerCanDo.readNext();
            if(!PlayerCanDo.next.equals("n")) {
                System.out.println("Találtál egy kést");
                PlayerCanDo.inventoryAdd("Kés");
                return;
            }
            System.out.println("no");
            return;
        }
        if(random == 1) {
            System.out.println("");
            return;
        }
        if(random == 2) {
            System.out.println("");
            return;
        }
        if(random == 3) {
            System.out.println("");
            return;
        }
        if(random == 4) {
            System.out.println("");
            return;
        }
        if(random == 5) {
            System.out.println("");
            return;
        }
        if(random == 6) {
            System.out.println("");
            return;
        }
        if(random == 7) {
            System.out.println("");
            return;
        }
        if(random == 8) {
            System.out.println("");
            return;
        }
        if(random == 9) {
            System.out.println("");
            return;
        }


        // fight events

        if(random == 30){
            System.out.println("fight");
            PlayerCanDo.readNext();
            PlayerCanDo.removeItem("Kés");
            if(!PlayerCanDo.next.equals("n")) {
                System.out.println("fight 1");
                return;
            }
            System.out.println("no");
            return;
        }
        if(random == 31) {
            System.out.println("fight 2");
            PlayerCanDo.readNext();
            PlayerCanDo.removeItem("Kés");
            if(!PlayerCanDo.next.equals("n")) {
                System.out.println("fight 2");
                return;
            }
            System.out.println("no");
            return;
        }
        if(random == 32) {
            System.out.println("fight 3");
            PlayerCanDo.readNext();
            PlayerCanDo.removeItem("Kés");
            if(!PlayerCanDo.next.equals("n")) {
                System.out.println("Fight 3");
                return;
            }
            System.out.println("no");
            return;
        }
    }

    public static int randomDecider(){
        if(/*PlayerCanDo.inventoryChecker("Kés") &&*/ Player.days%4 == 0){
            int randrand = (int) Math.floor(Math.random()*3);
            if(randrand == 1){
                int fightEventrandom = (int) Math.floor(Math.random()*3+30);
                return fightEventrandom;
            }else {
                System.out.println("nem adta be");
                return 0;
            }
        }else {
            int random = (int) Math.floor((Math.random()*10));
            return 0;
        }
    }

}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PlayerCanDo {

    public static String next;
    private static int counter = -1;
    private static int backpackCounter = -1;
    public static ArrayList <Integer> numBefore = new ArrayList <Integer>();

    public static Scanner answ = new Scanner(System.in);

    public enum PlayerEvent {
        hunger,
        feed,
        damage,
        heal,
    }

    public static String readNext() {
        next = answ.next();
        return next;
    }

    public static void answer(PlayerEvent event, float intesity) {
        switch(event) {
            case hunger:
                Player.food -= intesity;
                break;
            case feed:
                Player.food += intesity;
                break;
            case damage:
                Player.hp -= intesity;
                break;
            case heal:
                Player.hp += intesity;
                break;
        }
    }

    public static void inventoryAdd(String thingadd) {
        counter++;
        if(counter >= 5) {
            System.out.println("Az inventory teli");
            addToBackpack(thingadd);

        } else {
            try {
                Player.invetory[arrayIndex(" ", Player.invetory)] = thingadd;
            }catch(Exception e){
                System.out.println("Nincs üre hely az inventoridban");
            }
        }

    }

    public static boolean itemChecker(String thatContains, String[] arr) {
        boolean contains = Arrays.asList(arr).contains(thatContains);
        return contains;
    }

    public static int arrayIndex(String itemNeedsIndex, String[] arr) {
        if(itemChecker(itemNeedsIndex, arr)) {
            try {
                int i;
                for(i = 0; i < arr.length; i++) {
                    if(arr[i].equals(itemNeedsIndex)) {
                        break;
                    }
                }
                return i;
            }catch(Exception e) {
                System.out.println(e);
            }

        }
        return arr.length +1;
    }

    public static void addToBackpack(String thingadd){
        if(backpackCounter < (Player.haveLargeBackpack ? Player.largeBackpack.length : Player.backpack.length) -1){
            backpackCounter++;
            if(!Player.haveLargeBackpack){
            Player.backpack[backpackCounter] = thingadd;
            return;
            }
            Player.largeBackpack[backpackCounter] = thingadd;
            return;
        }else System.out.println("A backpack teli");
    }

    public static void removeItem(String thingremove){
        if(!itemChecker(thingremove, Player.invetory)){
            try {
                arrayIndex(thingremove, (Player.haveLargeBackpack ? Player.largeBackpack : Player.backpack));
            }catch(Exception e){
                System.out.println("Nincs ilyen itemed");
            }
        }
        try {
            Player.invetory[arrayIndex(thingremove, Player.invetory)] = " ";
        }catch(Exception e) { }
    }


    public static <numBefore> void storeNumBefor(int eventNum){
        numBefore.add(eventNum);
    }

    public static int randomNumber(int howMany, boolean isFight){
        int random = (int) Math.floor((Math.random()*howMany+(isFight ? +30: + 0)));
        return random;
    }

    public static void dayhunger(){
        if(Player.days %3 == 0){
            Player.food --;
            System.out.println("-1 food");
        }else return;
    }

    public static void dead(){
        Player.hp = 0;
        Player.food = 0;
        Player.isAlive = false;
    }


    public static void stat(){
        System.out.println("Days: " + Player.days);
        System.out.println("Hp: " + Player.hp);
        dayhunger();
        System.out.println("Food: " + Player.food);
        System.out.println("Alive: " + Player.isAlive);
        System.out.println("Inventory: " + Player.convertToString(Player.invetory));
        System.out.println((Player.haveLargeBackpack ? "Large Backpack" + Player.convertToString(Player.largeBackpack) : "Small Backpack" + Player.convertToString(Player.backpack) ));
    }
}

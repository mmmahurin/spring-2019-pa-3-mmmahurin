
import java.util.Scanner;
import java.util.Random;

public class Main {

    private static int winnings;
    private static int totalPoints = 500;
    private static int currentPoints = totalPoints +- winnings;
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String userChoice = "";

        userChoice = menuChoice(keyboard);


       //could not get points to carry over tried to implement a global like variables.

        while (userChoice.equals("1")) {
            slotMachine();
            // System.out.println(currentPoints);
            String choice = "";
            System.out.println("\nWould you like to play another round?");
            choice = keyboard.nextLine();


            if (choice.equalsIgnoreCase("yes")) {

                slotMachine();
                System.out.println("\nWould you like to play another round?");
                choice = keyboard.nextLine();

            }

            if (!choice.equalsIgnoreCase("yes")) {
                menuChoice(keyboard);
                break;




            }

        } while (userChoice.equals("2")) {
            diceToss();
            String choice = "";
            System.out.println("\nWould you like to play another round?");
            choice = keyboard.nextLine();


            while (choice.equalsIgnoreCase("yes")) {

                diceToss();
                System.out.println("\nWould you like to play another round?");
                choice = keyboard.nextLine();

            }
            if (!choice.equalsIgnoreCase("yes")) {
                menuChoice(keyboard);
                break;



            }

        }
        if (userChoice.equals("3")) {
            System.out.print(currentPoints +winnings);

        } else if (userChoice.equals("4")) {
            menuChoice(keyboard);
            keyboard.nextLine();
        }
        else if (userChoice.equals("5")){
            System.exit(0);

        }
    }




    public static String menuChoice(Scanner keyboard) {


            String choice = "";
            System.out.println("Enter 1 to play the Slot Machine");
            System.out.println("Enter 2 to play Dice Toss");
            System.out.println("Enter 3 to see current points");
            System.out.println("Enter 4 to start over");
            System.out.println("Enter 5 to exit");
            choice = keyboard.nextLine();
            return choice;





    }

    public static int slotMachine() {
        String[] word = {"Elephant", "Computer", "Football", "Resume", "Capstone", "Crimson"};
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter wager");
        int smAmount = keyboard.nextInt();
        Random r = new Random();
        int r1, r2, r3;
        r1 = r.nextInt(5);
        r2 = r.nextInt(5);
        r3 = r.nextInt(5);
        System.out.println(word[r1] + " " + word[r2] + " " + word[r3]);
        if (r1 == r2 && r2 == r3) {
                System.out.println("Congratulations! You have won: " + smAmount * 3);
                winnings = (smAmount * 3);
               // currentPoints = totalPoints + winnings;
                System.out.print(currentPoints +winnings);
                return currentPoints;

        } else if (r1 == r2 || r2 == r3 || r1 == r3) {
            System.out.println("Congratulations! You have won: " + smAmount * 2);
            winnings = (smAmount * 2);
            //currentPoints = totalPoints + winnings;
            System.out.print(currentPoints + winnings);
            return currentPoints;


        } else {
            System.out.println("Oh no! You have lost: " + smAmount);
            winnings = - smAmount;
          // currentPoints = totalPoints + winnings;
            System.out.println("\n" + currentPoints);
           return currentPoints;
        }
    }


    public static int diceToss(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter wager");
        int dtAmount = keyboard.nextInt();
        int d1 = (int)(Math.random()* 6+1);
        int d2 = (int)(Math.random()* 6+1);
        int sum = d1 + d2;
        String choice = "";
        System.out.println("Enter 1 to play Range");
        System.out.println("Enter 2 to play Amount");
        choice = keyboard.next();
        if (choice.equals("1")){
            String choice1 = "";
            System.out.println("High or Low?");
            choice1 = keyboard.next();
            if (choice1.equalsIgnoreCase("high")){
                if( sum >=9 && sum <=12){
                    System.out.print(sum);
                    System.out.println("\nCongratulations! You've won: " + dtAmount*2);
                    winnings = dtAmount *2;
                    System.out.print(currentPoints+winnings);
                  //  System.out.println(currentPoints);

                }
                else{
                    System.out.print(sum);
                    System.out.println("\nOh no! You've lost: " + dtAmount);
                    winnings = - dtAmount;
                    System.out.print(currentPoints+winnings);
                }

            }
            if (choice1.equalsIgnoreCase("low")){
                if (sum >=2 && sum <=5){
                    System.out.print(sum);
                    System.out.println("\nCongratulations! You've won: " + dtAmount*2);
                    winnings = dtAmount *2;
                    System.out.print(currentPoints+winnings);

                }
                else {
                    System.out.print(sum);
                    System.out.println("\nOh no! You have lost: " + dtAmount);
                    winnings = - dtAmount;
                    System.out.print(currentPoints+winnings);


                }
            }
            return currentPoints;

        }
        if (choice.equals("2")){
            String choice2 = "";
            System.out.println("Pick an exact amount 2-12");
            choice2 = keyboard.next();

            if (choice2.equals(sum)){
                System.out.print(sum);
                System.out.println("Congratulations! You've won: " + dtAmount * 3);
                winnings = dtAmount*3;
                System.out.print(currentPoints+winnings);
            }
            else{
                System.out.print(sum);
                System.out.println("\nOh no! You've lost " + dtAmount);
                winnings = - dtAmount;
                System.out.print(currentPoints+winnings);
            }


            }
        return currentPoints;

        }


    }








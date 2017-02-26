import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class Blackjack{

    public static void main (String args []){
    Scanner scan = new Scanner(System.in);
    int moneyGained = 0;
    int totalMoney = 0;
    System.out.println("\nWelcome to Blackjack Elite!");
    System.out.println("In this version of the game the stakes are raised a bit higher.\n\nJacks are worth 11\nQueens are worth 12\nAnd Kings are worth 13");
    System.out.println("\nYou start out with $100 to bet");
    System.out.println("Ready to play?\n");

    do{
        moneyGained = play(totalMoney);
        totalMoney += moneyGained;
        System.out.println("Money left: $" + totalMoney);
        System.out.println("Wanna play again? (yes/no)");
    } while(scan.next().equals("yes"));

    }//main
    private static int play(int totalMoney){
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        Deck deck = new Deck();
        Card currentPlayerCard;
        Card nextPlayerCard;
        Card currentAICard;
        Card secondPlayerCard;
        Card nextAICard;
        final int limit = 21;
        int currentPlayerScore = 0;
        int currentAIScore = 0;
        String choice;
        boolean AIchoice;
        int bet = 0;
        int moneyLeft = 0;
        int Hundred = 100;

        if(totalMoney == 0){
        moneyLeft += Hundred;
        } else {
            moneyLeft = totalMoney;
        }

        System.out.println("How much do you want to bet?");
        bet = scan.nextInt();
        moneyLeft = moneyLeft - bet;
        System.out.println("Money left: $" + moneyLeft);

        deck.shuffle();

        currentPlayerCard = deck.dealCard();
        secondPlayerCard = deck.dealCard();
        nextPlayerCard = deck.dealCard();
        nextAICard = deck.dealCard();


        currentPlayerScore = currentPlayerCard.getValue() + secondPlayerCard.getValue();

        currentAICard = deck.dealCard();
        currentAIScore = currentAICard.getValue();

        System.out.println();
        System.out.println("Your first card is  " + currentPlayerCard);
        System.out.println("Your second card is " + secondPlayerCard);
        System.out.println();
        System.out.println("Your current score is  " + currentPlayerScore);
        System.out.println("The Dealer's score is  " + currentAIScore);
        System.out.println();

        while(currentPlayerScore < limit){
            System.out.println("Hit or Stand?");
            choice = scan2.nextLine();
            System.out.println();

            if(choice.equals("Hit")){
                System.out.println("Your next card is " + nextPlayerCard);
                currentPlayerScore = nextPlayerCard.getValue() + currentPlayerScore;


            if(getRandomBoolean() == true ){
                currentAIScore = nextAICard.getValue() + currentAIScore;
                System.out.println("The Dealer's card is " + nextAICard);
            }
             else if(getRandomBoolean() == false){
                System.out.println("The Dealer has chosen to stand");
            }

            }//hit
            if (choice.equals("Stand")){
                System.out.println("You've chosen to stand");
                break;
            }

            System.out.println();
            System.out.println("Your current score is " + currentPlayerScore);
            System.out.println("The Dealer's score is " + currentAIScore);
            System.out.println();

            if(currentAIScore > limit){
                break;
            }
        }//while

        if(currentPlayerScore > currentAIScore && currentPlayerScore < limit){
                currentAIScore = nextAICard.getValue() + currentAIScore;
                System.out.println("The Dealer's last card is " + nextAICard);
            } else {
                System.out.println("The Dealer has chosen to stand");
            }



        if(currentPlayerScore > limit){
            System.out.println("Bust! You've gone over 21!! You lose you get nothing!");
        } else if (currentPlayerScore > currentAIScore) {
            System.out.println("Charlie my boy, you've won!");
            bet = bet*2;
            moneyLeft = moneyLeft + bet;
        }
        if(currentAIScore > limit){
            System.out.println("You've won! The Dealer busted!");
            bet = bet*2;
            moneyLeft = moneyLeft + bet;
        } else if(currentAIScore > currentPlayerScore){
            System.out.println("The Dealer has beat you.");
            moneyLeft = moneyLeft - bet;


        if(currentAIScore == limit){
            System.out.println("The Dealer has won.");
             moneyLeft = moneyLeft - bet;

        }
        if(currentAIScore == currentPlayerScore){
            System.out.println("You've tied. No one wins...");
        }

        }

        if(moneyLeft <= 0){
            System.out.println("You've got no money left. Get out!");
            System.exit(1);
        }
        return moneyLeft;
    }//play

    public static boolean getRandomBoolean(){
        Random rand = new Random();
        return rand.nextBoolean();
    }


   }//class:

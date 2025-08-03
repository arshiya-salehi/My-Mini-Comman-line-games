
import java.util.Scanner;

class Main {

  private static final Scanner SCAN = new Scanner(System.in);

  public static void main(String[] args) {
    Blackjack player = new Blackjack();
    int moneyOntable = 0; // money that you place on the table
    while (Blackjack.checkStartingMoney(moneyOntable) == false) {
      System.out.println();
      System.out.println(Blackjack.welcome());
      moneyOntable = SCAN.nextInt();
      if (moneyOntable < 0) {
        System.out.println(Blackjack.negetiveMoney());
      }
      if (moneyOntable == 0) {
        System.out.println(Blackjack.noMoneyForStartignMoney());
      }
    }
    player.setStartingMoney(moneyOntable);
    while (true) {
      // I am not sure if I want to make a reach for it or not
      boolean nextRound = false; // determine how many rounds you can play
      boolean checkBet = false;
      System.out.println();
      while (checkBet == false) {
        int bet; // bet
        System.out.println(Blackjack.line());
        System.out.println(Blackjack.betString());
        bet = SCAN.nextInt();
        player.setBet(bet);
        if (bet > player.getStartingmoney() || bet <= 0) {
          System.out.println("error");
        } else {
          checkBet = true;
        }
      }

      System.out.println();
      System.out.println(Blackjack.userSpace());
      System.out.println();
      System.out.println(player.firstTwocardS());
      System.out.println();
      System.out.print(Blackjack.valString());
      System.out.println(player.getCardValue());
      System.out.println();
      if (player.getCardValue() == 21) {
        nextRound = true;
        System.out.println(Blackjack.blackjackMass());
        player.winMoney();
      }
      System.out.println(Blackjack.dealerSpace());
      System.out.println();
      System.out.println(player.dealerHand());
      if (player.getDealerFirstCard() == 11 && player.getCardValue() != 21) { // this is if the dealer get a ace in the
                                                                              // first round
        System.out.println();
        System.out.println(Blackjack.betOnAce());
        System.out.println();
        System.out.println(Blackjack.yesORno());
        int insurance; // yes or no for dealer bet
        insurance = SCAN.nextInt();
        if (insurance == 1) {
          System.out.println();
          System.out.println(player.hitDealer());
          System.out.println(player.getDealerCardValue());
          if (player.getDealerCardValue() == 21) {
            System.out.println("(you win)"); // the wining and losing determanation is correct but the number do not get
                                             // calculated
          } else {
            System.out.println("(you lost)");
            player.loseMoney();
          }
        } else {
          System.out.println("(no bet)");
        }
      }
      System.out.println();
      System.out.print(Blackjack.dealervalString());
      System.out.println(player.getDealerCardValue());
      System.out.println();
      System.out.println(Blackjack.comandsList());
      System.out.println();
      while (nextRound == false) {
        int command; // commands // hit is (1) double is (2) split is (3) stand is (4) info is (5)
                     // question is (6) stop is (7)
        command = SCAN.nextInt();
        if (command == 1) {
          System.out.println(player.hit());
          System.out.println();
          System.out.print(Blackjack.valString());
          System.out.println(player.getCardValue());
          if (player.getCardValue() == 21) { // found out if you are blackjack with you first two cards
            // System.out.println(Blackjack.blackjackMass());
            System.out.println("(You win)");
            player.winMoney();
            nextRound = true;
          }
          if (player.getCardValue() > 21) { // if you are busted your cards
            System.out.println(Blackjack.youBusted());
            nextRound = true;
            player.loseMoney();
          }
        } else if (command == 2) {
          player.doubleCommand();
          // }else if(command==3){
          // System.out.println("have no idea how to make this");
        } else if (command == 4) {
          while (player.getDealerCardValue() < 17) { // the dealer can hit on its cards until it get to 17 (rule of
                                                     // blackjack)
            System.out.println();
            System.out.println(player.hitDealer());
            System.out.print(Blackjack.dealervalString());
            System.out.println(player.getDealerCardValue());
            // then it have to compare the value of cards and reset them to zero.(also bet
            // needed to be reset to 0)
          }
          if (player.getDealerCardValue() == player.getCardValue()) {
            System.out.println();
            System.out.println("(tie)");
            nextRound = true;
          } else if (player.getCardValue() > player.getDealerCardValue() || player.getDealerCardValue() > 21) {
            System.out.println();
            System.out.println("(you win)");
            player.winMoney();
            nextRound = true;
          } else {
            System.out.println();
            System.out.println("(you lost)");
            player.loseMoney();
            nextRound = true;
          }
        } else if (command == 5) {
          System.out.println();
          System.out.println(player.info());
        } else if (command == 6) {
          System.out.println();
          System.out.println(Blackjack.whatEachdo());
        } else if (command == 7) {
          System.out.println(player.info());
          player.resetStartingMoney();
          break;
        } else {
          System.out.println();
          System.out.println(Blackjack.commandError());
          // check if you put other commands and
        }
      }
      if (player.getStartingmoney() == 0) {
        System.out.println();
        System.out.println(Blackjack.outOfmoney());
        break;
        // end the game
      }
      player.resetDealerValue();
      player.resetMycardValue();
      player.resetCards();
    }
  }
}


public class Blackjack{

  private int startingMoney;
  private double myCards;       // get reseted every round                     
  private double dealerCards;  // get reseted every round
  private int bet;
  private double firstCard;    // get reseted every round
  private double secondCard;   // get reseted every round
  private double dealerFirstCard;    // get reseted every round

  
  public Blackjack(){                        // everytime an object created the values get reseted because of the loop
                      // we have 13 cards so the range supuse to be 13, I need numbers from 2 and 11 (ace have two possible values)
      this.firstCard=0;        // user
      this.secondCard=0;       // user
      this.dealerFirstCard=0;  // dealer
  }

  public void setStartingMoney(int a){
  this.startingMoney=a;
  }

  public void resetStartingMoney(){
    this.startingMoney=0;
  }


  public void resetDealerValue(){     // reset the value of cards at the end of the round
    this.dealerCards=0;
  }
  public void resetMycardValue(){
    this.myCards=0;
  }

  public void resetCards(){
    this.firstCard=0;
    this.secondCard=0;
    this.dealerCards=0;
  }

  public static String betOnAce(){
    return "do you want to bet on dealer cards? ";  // statement
  }

  public static String yesORno(){          // statement
    return "type (1) if it is a yes";
  }

  public static String outOfmoney(){           // statement
    return "you are out of money";
  }

  public static String commandError(){         // statement
    return "we only have 7 commands, choose from 1 to 7";
  }

  
  public static String line(){                      // make it neet
    return "-------------------------------------------------------------";
  }

  public static String rule(){             // statement
    return "(your bet is higher than your money that you put)";
  }

  public static String welcome(){          // statement
         return "Welcome to the blackjack please say how much money do you got ?";
  }

  
  public static String betString(){         // statement
    return "what is your bet ? ";
  }

  public static String betOnDealercards(){    // statement
    return "Do you bet on the dealers cards?";
  }

  public static String comandsList(){        // statement
        return "hit is (1)\ndouble is (2)\nstand is (4)\nhow much money I have is (5)\nquestions (6)\nstop playing is (7)";
  }

  public static String whatEachdo(){          // statement
    return "hit: will add a card to your hand" + '\n' + "double: will twice the bet" + '\n' + "split: you can make sparate bet on each cards if both of the cards have the value of above seven" + '\n' + "stand : you stop";
  }

  public static String dealerSpace(){      // give a space to the dealer hand
        return "          (dealer hand)";
  }

  public static String userSpace(){      // give a space to the dealer hand
        return "          (user hand)";
  }

  public static String valString(){       // statement
    return "your card value is: ";
  }

  public static String dealervalString(){      // statement
    return "dealer card value is: ";
  }

  public static String youBusted(){           // statement
    return "(you are busted)";
  }

  public String info(){                     // statement
    return "your Money is: "+startingMoney;
  }

  public void loseMoney(){                     // decrese the money          
    this.startingMoney=this.startingMoney - this.bet;
  }

  public void winMoney(){                     // add to money               
    this.startingMoney=this.startingMoney+this.bet;
  }

  public void setBet(int a){    // this is working because the return statement for it is working
    this.bet=a;
  }

  public void doubleCommand(){
    this.bet=this.bet*2;
  }

  public int getStartingmoney(){            // money you put on table
        return this.startingMoney;
  }
  
  public double getCardValue(){              // what value do you creat with the cards
          return (int)this.myCards;                // the cast is not working it will return a double value with decimal
  }

  public double getDealerCardValue(){        // what value does the dealer make with its cards
          return (int)this.dealerCards;
  }
  

  public double getDealerFirstCard(){       
    return this.dealerFirstCard;
  }


  public String firstTwocardS(){             //(1=club,2=spade,3=dimoind,4=heart)
      
      double firstCard=(int)(Math.random()*13+2);
      double secondCard=(int)(Math.random()*13+2);         // start the round with two cards
      this.firstCard=firstCard;
      this.secondCard=secondCard;

      String firstcardName="";                  // for saving the names in a place
      String secondcardName="";
      if(firstCard>10){                  // if the number is higher than 10 it means it is a picture and then the value of the card get changed
        if(firstCard==11){
             firstcardName="Ace";
        }
          if(firstCard==12){
              firstcardName="king";
              firstCard=10;
          }
          if(firstCard==13){
              firstcardName="queen";
              firstCard=10;
          }
          if(firstCard==14){
              firstcardName="jack";
              firstCard=10;
          }
      }
      if(secondCard>10){
        if(secondCard==11){
              secondcardName="Ace";
        }
          if(secondCard==12){
              secondcardName="king";
              secondCard=10;
          }
          if(secondCard==13){
              secondcardName="queen";
              secondCard=10;
          }
          if(secondCard==14){
              secondcardName="jack";
              secondCard=10;
          }
      }
      if(firstCard==11 && secondCard==11){            // if we already have an Ace and get another ace the value of the secodn ace sopuse to be one
          secondCard=1;
      }
      this.myCards= firstCard + secondCard; 
          double a=(int)(Math.random()*4+1);   // first card type
          double b=(int)(Math.random()*4+1);   // second card type           
          if(a==1){
                if(b==1){
                          return "club " + (int)firstCard + " " +firstcardName + ", " + "club " + (int)secondCard + " " + secondcardName;
                }
                if(b==2){
                          return "club " + (int)firstCard+ " " +firstcardName  + ", "+ "spade " + (int)secondCard + " " +secondcardName ;
                }
                if(b==3){
                          return "club " + (int)firstCard + " " +firstcardName + ", " + "dimoind " + (int)secondCard+" " +secondcardName;
                }
                else{
                          return "club " + (int)firstCard + " " +firstcardName + ", "+ "heart " + (int)secondCard+" " +secondcardName; 
                }                  
      }
      if(a==2){
                if(b==1){
                          return "spade " + (int)firstCard+" " +firstcardName + ", " + "club " + (int)secondCard+" " +secondcardName;
                }
                if(b==2){
                          return "spade " + (int)firstCard +" " +firstcardName + ", " + "spade " + (int)secondCard+" " +secondcardName;
                }
                if(b==3){
                          return "spade " + (int)firstCard +" " + firstcardName + ", "+ "dimoind " + (int)secondCard+" " +secondcardName;
                }
                else{
                          return "spade " + (int)firstCard +" " + firstcardName + ", " + "heart " + (int)secondCard+" " +secondcardName; 
                }
      }
      if(a==3){
                if(b==1){
                          return "dimoind " + (int)firstCard+" " + firstcardName + ", "  + "club " + (int)secondCard+" " +secondcardName;
                }
                if(b==2){
                          return "dimoind " + (int)firstCard +" " + firstcardName + ", " + "spade " + (int)secondCard+" " +secondcardName;
                }
                if(b==3){
                          return "dimoind " + (int)firstCard + " " +firstcardName+ ", "  + "dimoind " + (int)secondCard+" " +secondcardName;
                }
                else{
                          return "dimoind " + (int)firstCard + " " +firstcardName + ", " + "heart " + (int)secondCard+" " +secondcardName; 
                }
      }
      else{
           if(b==1){
                          return "heart " + (int)firstCard + " " +firstcardName + ", " + "club " + (int)secondCard+" " +secondcardName;
                }
                if(b==2){
                          return "heart " + (int)firstCard + " " +firstcardName + ", " + "spade " + (int)secondCard+" " +secondcardName;
                }
                if(b==3){
                          return "heart " + (int)firstCard + " " +firstcardName + ", " + "dimoind " + (int)secondCard+" " +secondcardName;
                }
                else{
                          return "heart " + (int)firstCard + " " +firstcardName + ", " + "heart " + (int)secondCard+" " +secondcardName; 
                }
      }
  }


public String dealerHand(){   
  
  double firstCard=(int)(Math.random()*13+2);
  this.dealerFirstCard=firstCard;
  String cardName="";           
  if(firstCard>10){
    if(firstCard==11){
              cardName="Ace";
    }
    if(firstCard==12){
              cardName="king";
              firstCard=10;
          }
          if(firstCard==13){
              cardName="queen";
              firstCard=10;
          }
          if(firstCard==14){
              cardName="jack";
              firstCard=10;
          }
      }
  this.dealerCards+=firstCard;           // value adding
  double a=(int)(Math.random()*4+1);
            if(a==1){
                        return "club " + (int)firstCard + " "+cardName ;
              }
              if(a==2){
                        return "spade " + (int)firstCard + " "+cardName ;
              }
              if(a==3){
                        return "doimend " + (int)firstCard + " "+ cardName ;
              }
              else{
                        return "heart " + (int)firstCard + " "+cardName; 
              }
            }

  public String hit(){
          double thirdCard=(int)(Math.random()*13+2);
          String thirdCardName="";
            if(thirdCard==11){
                thirdCardName="Ace";
            }
                if(thirdCard==12){
                          thirdCardName="king";
                          thirdCard=10;
                      }
                      if(thirdCard==13){
                          thirdCardName="queen";
                          thirdCard=10;
                      }
                      if(thirdCard==14){
                          thirdCardName="jack";
                          thirdCard=10;
                      }
                    
    if(firstCard==11 && thirdCard==11|| secondCard==11 && thirdCard==11){          // if you already have an Ace the other Aces have the value of one
                          thirdCard=1;
                          thirdCardName="Ace";
                        }
  if(firstCard!=11 && secondCard!=11 && thirdCard==11){
    thirdCard=1;
  }
      this.myCards+=thirdCard;                     // add the values
      double b=(int)(Math.random()*4+1); // type of card
      if(b==1){
                        return "club " + (int)thirdCard + " "+ thirdCardName ;
              }
              if(b==2){
                        return "spade " + (int)thirdCard + " "+ thirdCardName ;
              }
              if(b==3){
                        return "doimend " + (int)thirdCard + " "+ thirdCardName ;
              }
              else{
                        return "heart " + (int)thirdCard + " "+ thirdCardName ; 
              }

}

  public String hitDealer(){
    double dealerSecondCard=(int)(Math.random()*13+2);
    String dealerSecondCardName="";
    if(dealerSecondCard>10){
      if(dealerSecondCard==11){
          dealerSecondCardName="Ace";
      }
      if(dealerSecondCard==12){
                        dealerSecondCardName="king";
                        dealerSecondCard=10;
                    }
                    if(dealerSecondCard==13){
                        dealerSecondCardName="queen";
                        dealerSecondCard=10;
                    }
                    if(dealerSecondCard==14){
                        dealerSecondCardName="jack";
                        dealerSecondCard=10;
                    }
    }
    
    this.dealerCards+=dealerSecondCard;
    if(dealerFirstCard!=11 && this.dealerCards>21){
         dealerSecondCard=1;
         this.dealerCards+=dealerSecondCard;
    }
    double b=(int)(Math.random()*4+1);   // choose a type
    if(b==1){
                          return "club " + (int)dealerSecondCard+ " " +dealerSecondCardName;
                }
                if(b==2){
                          return "spade " + (int)dealerSecondCard+ " " +dealerSecondCardName;
                }
                if(b==3){
                          return "doimend " + (int)dealerSecondCard+ " " +dealerSecondCardName;
                }
                else{
                          return "heart " + (int)dealerSecondCard+ " " +dealerSecondCardName; 
                }
  }


  public static String blackjackMass(){     // statement
        return "you black jacked";
  }

  public static String noMoney(){  // statement
    return "You put zero money for your bet (I am not stupid)";
  }

  public static String negetiveMoney(){           // statement
    return "money is not a negetive number(I am not stupid)";
  }

  public static String noMoneyForStartignMoney(){      // statement
    return "you put zero on your table(I am not stupid)";
  }

  public static boolean checkStartingMoney(int a){        // check if the money is positive
      if(a>0){
        return true;
      }else{
        return false;
      }
  }
}


# Console-Black-jack-game

# 🎲 Console Blackjack Game

A simple **console-based Blackjack game** written in **Java**.  
This project simulates the classic card game where you play against the dealer, place bets, and try to hit 21 without going over.

---

## 📂 Project Structure

Console-Black-jack-game-main/
├── Blackjack.java # Core game logic (cards, bets, dealer & player actions)
├── Main.java # Entry point, handles user interaction via console
├── .gitignore # Git ignore file
└── README.md # Project documentation

yaml
Copy code

---

## 🚀 Features

- 🎴 Deal cards to player and dealer  
- 💵 Manage starting money and bets  
- 🤖 Dealer AI logic (hits until threshold)  
- 🔄 Play multiple rounds until money runs out  
- ❌ Handles invalid inputs (negative or zero bets)  

---

## 🛠️ Requirements

- **Java Development Kit (JDK) 8+**
- A terminal or IDE that supports running Java programs

---

## ▶️ How to Run

1. **Clone or Download** this repository.  
   ```bash
   git clone https://github.com/<your-username>/Console-Black-jack-game.git
   cd Console-Black-jack-game-main
Compile the Java files

bash
Copy code
javac Main.java Blackjack.java
Run the game

bash
Copy code
java Main
🎮 Gameplay Instructions
Start the game: Enter the amount of money you want to begin with.

You cannot start with 0 or negative money.

Place a bet: Before each round, enter your bet.

You cannot bet more than your current balance.

Get your cards: You will be dealt two cards, and the dealer gets one visible card.

Your turn: Decide whether to Hit (draw another card) or Stand (end your turn).

Dealer's turn: The dealer will play automatically until a stopping rule is reached.

Outcome: The round ends with one of the following results:

🎉 You win → bet is added to your balance

😢 You lose → bet is deducted from your balance

🤝 Draw → bet is returned

Continue or quit: Play as long as you have money.

🧑‍💻 Code Overview
Blackjack.java

Stores and manages player/dealer cards and bets

Handles win/lose/draw conditions

Contains utility methods for validation and messages

Main.java

Entry point of the program

Manages game loop

Handles user input and connects with Blackjack class logic

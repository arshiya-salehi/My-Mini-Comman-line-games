# Hangman Game 🎮

A simple **command-line Hangman game** implemented in Python.  
The player tries to guess the hidden word one letter at a time before the hangman is fully drawn.

---

## 📂 Project Structure

hangman-main/
│── main.py # Main script to run the Hangman game
│── README.md # Project documentation

yaml
Copy code

---

## ▶️ How to Run

1. Make sure you have **Python 3.x** installed on your system.
2. Clone or download this repository.
3. Open a terminal in the project folder.
4. Run the game with:

```bash
python main.py
🎯 Gameplay Instructions
The program will randomly select a hidden word.

You guess the word by entering one letter at a time.

Each wrong guess draws another part of the hangman.

The game ends when:

✅ You guess all the letters correctly.

❌ The hangman is fully drawn.

🛠 Requirements
Python 3.x
(No external libraries required)

💡 Example Output
yaml
Copy code
+---+
 |  |
    |
    |
    |
    |
=========
Word: _ _ _ _ _
Guess a letter:

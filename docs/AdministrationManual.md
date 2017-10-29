# Administration Manual

## How to Install and Run
The application is hosted on a private repository on github.com. You can get it from the following link: https://github.com/Multiline/TicTacToe

You will need JDK 1.8 or greater installed on your computer to deploy and run the application.

You can use the git command to clone the repository to your machine, using the console writing the following command.

- <code>git clone https://github.com/Multiline/TicTacToe.git</code>

You can also download a zip archive using the link in the first paragraph and unzip it.

The building process is done using the program Gradle https://gradle.org/docs/#getting-started. It automates the process of building the program using a special script.
 
- Open up the Shell (Linux/UNIX) or Command prompt (Windows using "cmd") and navigate using <code> cd [the location] </code> to the place where the TicTacToe repsoitory was put. The location could for example be <code> C:\TicTacToe\ </code>. 

- Run the command: <code> gradlew build </code>. Then Gradle will run all the test cases and check if the program is ready. It informs you if there are any fails or if it was successful.

Please keep in mind that if you are using Linux/UNIX (or Git Bash) you need to insert <code>'./'</code> in front of the command.

- Run the command: <code> gradlew run </code>. 
This command will run the TicTacToe game.

When the program starts the user is greeted to welcome him to the game. 

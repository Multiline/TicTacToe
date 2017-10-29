# Administration Manual

## How to Install and Run
If you are using Linux/UNIX; bash or shell you need to insert <code>./   </code> in front of each command. In Windows you open the command prompt (cmd), and run the following commands:
  
- Open up the shell / command prompt and navigate using <code> cd [the location] </code> to the place where the TicTacToe repsoitory was located. The location could for example be <code> C:\TicTacToe\ </code>
- Run the command: <code> gradlew build </code>. Using it, Gradle runs all the test cases and checks if the program is ready, in order to run it.
- Run the command: <code> gradlew run </code>. This command will run the TicTacToe game and a greeting will appear to welcome you in the console. From there you can put in your first mark in the game against your opponent.

## How to Deploy, Run and Maintain

The code can be downloaded from our repository https://github.com/Multiline/TicTacToe.git The code is written in Java. In order to run it, you have have to have version Java 1.8 or greater installed. Jave can be installed from https://java.com/en/download/. The TicTacToe git comes with Gradle, in order to compile it. Further information on Gradle can be found on Gradle's website: https://gradle.org/docs/ 

After the Gradle script has been run a report on the building process can be accessed in the folder <code> build/reports/tests/test/index.html </code>.

The code is built up using the 'loosely coupled' coding method in order to change the coding later on. 

It is worth mentioning that Heroku, was implemented for this project.

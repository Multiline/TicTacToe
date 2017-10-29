# Development Manual

The application is hosted on a private repository on github.com. You can get it from the following link: https://github.com/Multiline/TicTacToe

The code is written in Java. You will need JDK 1.8 or greater installed on your computer to deploy and run the application. Java can be installed from https://java.com/en/download/.

You can use the git command to clone the repository to your machine, using the console writing the following command.

- <code>git clone https://github.com/Multiline/TicTacToe.git</code>

You can also download a zip archive using the link in the first paragraph and unzip it.

The TicTacToe git comes with Gradle, in order to compile it. 

After the Gradle script has been run a report on the building process can be accessed in the folder <code> build/reports/tests/test/index.html </code>.

The code is built up using the 'loosely coupled' coding method in order to change the coding later on. 

Everyone has their own branch when coding and using github. 

If you want to add to this project, then please do the following.

1. After you have made the change to the code, then run the Gradle check. 
<code> gradlew check (in Windows) and ./gradlew check (in Linux/UNIX) </code>
The Gradle check compiles and runs all the unit tests.

2. If the build was successful and no errors were incurred the changes should be committed to the branch.

3. To merge your changes with the Master, you need to push your commits to the branch and then create a pull request. Other contributer then must review the commits and wait for check from Travis (a continueous integration service, that checks the code (builds and tests the code for correctness). If everything is OK the other contributer (the reviewer) will accepted the commit to the Master.

4. To build the project you write the following command: <code> gradlew build (in Windows) and gradlew build (in Linux/UNIX) </code>. 

It is worth mentioning that Heroku, was implemented for this project.

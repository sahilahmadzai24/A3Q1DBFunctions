Name: Sahil Ahmadzai 101267903
Assignment 3 Question 1
VIDEO DEMONSTRATION LINK: https://youtu.be/UE5Baln4T84 


All code and scripts are in the folder ‘A3Q1DBFunctions’ which was created in IntelliJ

To start compiling and running application:
Open PgAdmin4
Click servers, click your server (in my case, PostgreSQL18), then find databases and right click it and from that toolbar click create then database
Name the database “StudentsDB” and save
Click your newly made StudentsDB database, scroll down to schemas and right click it then click query tool, this will make a text editor pop up where you can enter queries
Click the folder icon and open the ‘A3Q1DBFunctions’ folder where everything is stored and navigate to the ‘db_scripts’ folder, click this folder and open the 
‘students_table.sql’ file inside. Then click the play button icon to run this query. We have now successfully created our database, table, and filled the table with sample 
data

I used IntelliJ IDE for the creation of the functions, I followed the week 7 video ‘PostgreSQL - JDBC Example’ 
https://brightspace.carleton.ca/d2l/le/content/396898/viewContent/4367649/View to set up the JDBC environment
So open the attached ‘A3Q1DBFunctions’ folder and IntelliJ should automatically detect its environment and download the required dependencies 
Inside the ‘src’ folder, click ‘main’ folder, then ‘java’ folder, then you will see the ‘main.java’ file which has all the code and functions to run
One thing to note is inside this file we have these 3 lines to kickstart the connection process to the database:
private static final String URL = "jdbc:postgresql://localhost:5432/StudentsDB";
private static final String USER = "postgres";
private static final String PASSWORD = "postgres";
This has the url of my database, my username, and my password, so if any of these is different than yours then you must change the code in order to match, usually it would be 
the password that may be different or the database name which in my case is ‘StudentsDB'
Now you can click build at the top and build project to compile all code
We then continue to the testing part, which is all done in the main.java file inside its main method, in here is where we can run any of the methods to make changes to the 
database
After calling any of the methods of your choice, you can click the play button at the top to run the main method which will call on all the method calls inside it, this will 
make changes to the database depending on what you called inside, you can verify by calling getAllStudents() to see your changes, or by opening PgAdmin4 and checking your 
database’s values to see if anything has updated

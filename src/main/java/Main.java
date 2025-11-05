import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    //used to connect to the database since it needs a url, the postgresql user, and it's password
    private static final String URL = "jdbc:postgresql://localhost:5432/StudentsDB";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    //getAllStudents(): Retrieves and displays all records from the students table
    public static void getAllStudents(){
        try{
            //create connection to the postgresql database and create a statement to send query
            //then execute the query and get the results of that query
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM students");
            ResultSet resultSet = statement.getResultSet();

            System.out.println("\n--- All Students: ---");

            //looping through each row in the result set and displaying info
            while(resultSet.next()){
                int studentId = resultSet.getInt("student_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String enrollmentDate = resultSet.getString("enrollment_date");

                System.out.println("Student ID: " + studentId +
                        " | First Name: " + firstName +
                        " | Last Name: " + lastName +
                        " | Email: " + email +
                        " | Enrollment Date: " + enrollmentDate);
            }
        }catch (Exception e){
            //if any errors occur during process of connecting to query or executing query
            System.out.println("Error getting all students: " + e);
        }
    }

    //addStudent(first_name, last_name, email, enrollment_date): Inserts a new student record into the students table
    public static void addStudent(String first_name, String last_name, String email, String enrollment_date) {
        try {
            //create connection to the postgresql database and create a statement to send query
            //then execute the query with excecuteUpdate (which updates the DB instead of just returning stuff to see)
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO students (first_name, last_name, email, enrollment_date) " +
                    "VALUES ('" + first_name + "', '" + last_name + "', '" + email + "', '" + enrollment_date + "')");

        } catch (Exception e) {
            //if any errors occur during process of connecting to query or executing query
            System.out.println("Error adding student: " + e);
        }
    }

    //updateStudentEmail(student_id, new_email): Updates the email address for a student with the specified student_id
    public static void updateStudentEmail(int student_id, String new_email) {
        try {
            //create connection to the postgresql database and create a statement to send query
            //then execute the query with executeUpdate (which updates the DB instead of just returning stuff to see)
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE students SET email = '" + new_email + "' WHERE student_id = " + student_id);

        } catch (Exception e) {
            //if any errors occur during process of connecting to query or executing query
            System.out.println("Error updating student email: " + e);
        }
    }

    //deleteStudent(student_id): Deletes the record of the student with the specified student_id
    public static void deleteStudent(int student_id) {
        try {
            //create connection to the postgresql database and create a statement to send query
            //then execute the query with executeUpdate (which updates the DB instead of just returning stuff to see)
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM students WHERE student_id = " + student_id);

        } catch (Exception e) {
            //if any SQL or connection error occurs, print the error message
            System.out.println("Error deleting student: " + e);
        }
    }

    //to test functions
    public static void main(String[] args){

    }
}

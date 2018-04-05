import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
       //try {
//            OpenFile();
        /*}
        catch(TestException ex) {
            System.err.println(ex.getMessage() +
                    " ursprungsfel:" +
                    ex.getCause().getMessage());
        }*/

        MyLong no = new MyLong(1L);
        AddOne(no);
        System.out.println(no.getTheValue());
    }

    static void OpenFile() /*throws TestException*/ {
        try {
            FileInputStream input = new FileInputStream("test.txt");
        }
        catch(FileNotFoundException ex) {
            throw new TestException(
                    "Application error, could not open file!", ex);
        }
    }

    static void AddOne(MyLong number) {
        //number += 1;
        number.setTheValue(5);
    }
}

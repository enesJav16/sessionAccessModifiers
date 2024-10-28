import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Product[] products= {new Book(1L,"book","Book1","Book1's author"),
                             new Book(2L,"book","Book2","Book2's author"),
                             new Electronics(3L,"electronics","Phone","Samsung")};


        User[]users={new User(1L,"enes","marat uulu","enes@","enes1234",products)};
        User user=new User();
        user.setUsersArr(users);

        user.start();
    }
}
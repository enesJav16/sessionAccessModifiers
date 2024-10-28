import java.time.LocalDate;
import java.util.Scanner;

public class Book extends Product {
    private String authorFullName;

    public Book() {}

    public Book(Long id, int productCount, String type, LocalDate createDate, int price, String description, String name, Long id1, String authorFullName) {
        super(id, productCount, type, createDate, price, description, name);
        this.authorFullName = authorFullName;
    }
    public Book(Long id,String type,String name,String authorFullName){
        super(id,0,type,null,0,null,name);
        this.authorFullName=authorFullName;
    }



    public String getAuthorFullName() {
        return authorFullName;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }

    public Product bookInfo() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        Book book = new Book();

        System.out.println("Type name of the book:");
        setName(scanner.nextLine());

        System.out.println("Type name of the author:");
        authorFullName=scanner.nextLine();
        return book;
    }
}

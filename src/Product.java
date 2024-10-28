import java.time.LocalDate;
import java.util.Scanner;

public class Product extends User{
    private Long id;
    private String name;
    private String description;
    private int price;
    private LocalDate createDate;
    private String type;
    private int productCount;

    int idArrayCapacity=1;
    private Long idStart=4L;
    private Long[] idArray=new Long[idArrayCapacity];


    private Product[]products=new Product[1];

    public Product(){}
    public Product(Long id, int productCount, String type, LocalDate createDate, int price, String description, String name) {
        this.id = id;
        this.productCount = productCount;
        this.type = type;
        this.createDate = createDate;
        this.price = price;
        this.description = description;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void addProduct(){
        int count=1;
        Scanner scanner=new Scanner(System.in);
        Scanner scanner1=new Scanner(System.in);
        for (int i = 0; i < getProductsArrayLength(); ) {
            System.out.println("What type (1)Book/(2)Electronics.");
            String productType= scanner.nextLine();
            System.out.println("Adding product #"+count);

            if (productType.equals("1")){
                Book book=new Book();
                getProducts()[i]=book.bookInfo();
                getProducts()[i].type="Book";
                getProducts()[i].id=idStart;
                idArray[idArrayCapacity]=idStart;
                idArrayCapacity++;
                idStart++;

            } else if (productType.equals("2")) {
                Electronics electronics=new Electronics();
                getProducts()[i]=electronics.electronicInfo();
                getProducts()[i].type="Electronics";
                getProducts()[i].id=idStart;
                idArray[idArrayCapacity]=idStart;
                idArrayCapacity++;
                idStart++;
            } else {
                i=getProductsArrayLength();
            }
            System.out.println("Product #"+count+" is added. What do you want to next");
            setProductsArrayLength(getProductsArrayLength()+1);
            count++;
            System.out.println("(1)ADD ANOTHER PRODUCT------------(2)GO TO PROFILE");
            int input1= scanner1.nextInt();
            switch (input1){
                case 1:
                    i++;
                    break;
                case 2:
                    i=getProductsArrayLength();
                    break;
                default:
                    System.out.println("Incorrect action.");
                    i=getProductsArrayLength();
                    break;
            }
        }
    }

    public void getAllBooks(){
        System.out.println("Books in list: ");
        for (Product product:getProducts()) {
            if(product instanceof Book){
                Book book= (Book) product;
                System.out.println("ID:"+book.getId()+
                        "Name of the book: "+book.getName()+
                        "Authors name: "+book.getAuthorFullName());
            }
        }
    }

    public void getAllElectronics(){
        System.out.println("Electronics in list: ");
        for (Product product:getProducts()) {
            if(product instanceof Electronics){
                Electronics electronics= (Electronics) product;
                System.out.println("ID:"+electronics.getId()+
                        "Name of the book: "+electronics.getName()+
                        "Authors name: "+electronics.getColor());
            }
        }
    }

    public void getAllProducts(){
        System.out.println("Books in list: ");
        for (Product product:getProducts()) {
            if(product instanceof Book){
                Book book= (Book) product;
                System.out.println("ID:"+book.getId()+
                                   "Name of the book: "+book.getName()+
                                   "Authors name: "+book.getAuthorFullName());
            }
        }
        System.out.println("Electronics in list: ");
        for (Product product:getProducts()) {
            if(product instanceof Electronics){
                Electronics electronics= (Electronics) product;
                System.out.println("ID:"+electronics.getId()+
                        "Name of the book: "+electronics.getName()+
                        "Authors name: "+electronics.getColor());
            }
        }
    }
}

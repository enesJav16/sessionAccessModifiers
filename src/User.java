import java.util.Scanner;

public class User extends UserManager {
    int arrayLength=1;
    int productsArrayLength=1;

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;


    private Product[] products =new Product[productsArrayLength];
    private User[] usersArr = new User[arrayLength];




    boolean check1 = true;
    boolean check2 = true;
    boolean check3 = true;
    boolean check4 = true;

    public User() {
    }

    public User(Long id, String firstName, String lastName, String email, String password, Product[] products) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.products = products;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public User[] getUsersArr() {
        return usersArr;
    }

    public void setUsersArr(User[] usersArr) {
        this.usersArr = usersArr;
    }

    public boolean isCheck3() {
        return check3;
    }

    public void setCheck3(boolean check3) {
        this.check3 = check3;
    }

    public boolean isCheck4() {
        return check4;
    }

    public void setCheck4(boolean check4) {
        this.check4 = check4;
    }

    public int getProductsArrayLength() {
        return productsArrayLength;
    }

    public void setProductsArrayLength(int productsArrayLength) {
        this.productsArrayLength = productsArrayLength;
    }

    //User info  Method
    static User userInfo() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        User user = new User();

        System.out.println("ID: ");
        Long inputId = scanner.nextLong();
        user.setId(inputId);

        System.out.println("Register your name: ");
        String inputFirstName = scanner1.nextLine();
        user.setFirstName(inputFirstName);

        System.out.println("Last name: ");
        String inputLastName = scanner1.nextLine();
        user.setLastName(inputLastName);

        System.out.println("Email: ");
        String inputEmail = scanner1.nextLine();
        user.setEmail(inputEmail);

        System.out.println("Password: ");
        String inputPassword = scanner1.nextLine();
        user.setPassword(inputPassword);

        return user;

    }

    //Register Method

    public void register(){
        Scanner intScanner = new Scanner(System.in);
        int count = 1;

        for (int i = 0; i < usersArr.length; ) {
            System.out.println("Registering user #" + count);
            usersArr[i] = userInfo();
            usersArr[i].id= (long) count;
            System.out.println("User #" + count + " is registered. What do you want to do next:");
            count++;
            arrayLength++;
            System.out.println("(1)Register another user--------------------(0)MAIN");
            int input1 = intScanner.nextInt();
            switch (input1) {
                case 1:
                    arrayLength++;
                    break;
                case 0:
                    i= usersArr.length;
                    break;
                default:
                    check1=false;
                    break;
            }
        }
    }

    //Login method
    public void login() {
        Scanner scanner = new Scanner(System.in);
        int attemptCount=5;
        while (0 < attemptCount ) {
            System.out.println("You have "+attemptCount+" attempts left.");
            System.out.println("Write email:");
            String loginEmail = scanner.nextLine();
            System.out.println("Write password:");
            String loginPassword = scanner.nextLine();

            for (int i = 0; i < usersArr.length; i++) {
                if (usersArr[i].email.equals(loginEmail) && usersArr[i].password.equals(loginPassword)) {
                    System.out.println("Welcome "+usersArr[i].firstName+"!");
                    attemptCount=0;
                } else {
                    System.out.println("Incorrect email or password.");
                    attemptCount--;
                }
            }
        }
    }

    //Profile manipulation
    public void profileManipulation(){
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
        Product product=new Product();
        while(check4) {
            while (check3) {
                System.out.println("What do you want to do with your account:");
                System.out.println("(1)ADD NEW PRODUCT-------------------(2)GET ALL PRODUCTS");
                System.out.println("(3)GET ALL BOOKS------------------(4)GET ALL ELECTRONICS");
                System.out.println("--------------------------MAIN(0)-----------------------");
                System.out.println("----------------------FINISH CODE(99)-------------------");
                int profMan = intScanner.nextInt();
                switch (profMan) {
                    case 1:
                        product.addProduct();
                        break;
                    case 2:
                        product.getAllProducts();
                        break;
                    case 3:
                        product.getAllBooks();
                        break;
                    case 4:
                        product.getAllElectronics();
                        break;
                    case 0:
                        check3 = false;
                        break;
                    case 99:
                        check2 = false;
                        check3 = false;
                        break;
                }
            }
        }
    }


    //Start method
    public void start() {
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);

        while (check2) {
            while (check1) {
                System.out.println("What do you want to do:");
                System.out.println("(1)REGISTER A NEW USER---------------(2)LOGIN TO ACCOUNT");
                System.out.println("--------------------------MAIN(0)-----------------------");
                System.out.println("----------------------FINISH CODE(99)-------------------");
                int logReg = intScanner.nextInt();
                switch (logReg) {
                    case 0:
                        check1 = false;
                        break;
                    case 1:
                        register();
                        break;
                    case 2:
                        login();
                        check1=false;
                        break;
                    case 99:
                        check2=false;
                        check1=false;
                        break;
                    default:
                        System.out.println("Repeat...");
                        check1 = false;
                        break;
                }
            }

            profileManipulation();
            check1=true;
        }
    }

}

import java.time.LocalDate;
import java.util.Scanner;

public class Electronics extends Product {
    private String brand;
    private String color;
    private boolean isNew;
    private int memory;

    public Electronics (){}
    public Electronics(Long id, int productCount, String type, LocalDate createDate, int price, String description, String name, String brand, String color, boolean isNew, int memory) {
        super(id, productCount, type, createDate, price, description, name);
        this.brand = brand;
        this.color = color;
        this.isNew = isNew;
        this.memory = memory;
    }
    public Electronics(Long id,String type, String name, String brand) {
        super(id, 0, type, null, 0, null, name);
        this.brand = brand;
        this.color = color;
        this.isNew = isNew;
        this.memory = memory;
    }





    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public Product electronicInfo() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        Electronics electronics = new Electronics();

        System.out.println("Type name of the device:");
        setName(scanner.nextLine());

        System.out.println("Type brand of the device:");
        brand=scanner.nextLine();
        return electronics;
    }


}

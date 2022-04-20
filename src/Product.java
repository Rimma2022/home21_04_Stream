import java.util.Objects;

public class Product {
    private int year;
    private String name;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product(int year, String name) {
        this.year = year;
        this.name = name;
    }

    @Override
    public String toString() {
        return " year: " + year + ", name: " + name + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return year == product.year && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, name);
    }
}

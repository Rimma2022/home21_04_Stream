import java.util.Comparator;
import java.util.Objects;

public class Animal implements Comparable{
    private String name;
    private String month;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Animal(String name, String month, int age) {
        this.name = name;
        this.month = month;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age && Objects.equals(name, animal.name) && Objects.equals(month, animal.month);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, month, age);
    }


    @Override
    public int compareTo(Object o) {
        if(o.getClass() != getClass() || o == null) {
            throw new IllegalArgumentException("Объект не является типом Animal");
        }
        Animal animal1 = this;
        Animal animal2 = (Animal) o;
        return this.getName().compareTo(((Animal) o).getName());
    }

    @Override
    public String toString() {
        return "name: " + name + ", month: " + month + ", age=" + age + "\n";
    }
}

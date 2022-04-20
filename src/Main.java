import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // 0 Дан ArrayList<Integer>. C помощью Stream Api найдите среднее арифметическое
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(10);
        list1.add(15);
        list1.add(20);
        double avg = list1.stream().mapToDouble(x -> x.doubleValue()).average().getAsDouble();
        System.out.println(avg);

        // 1 Дан ArrayList<Double> с числами - 1 50 6 6 6 6 10 10 10. C помощью Stream Api найдите среднее
        //исключите повторяющиеся элементы из коллекции, отсортируйте и сохраните в Set
        ArrayList<Double> list2_double = new ArrayList<>();
        list2_double.add(1.0);
        list2_double.add(50.0);
        list2_double.add(6.0);
        list2_double.add(6.0);
        list2_double.add(6.0);
        list2_double.add(6.0);
        list2_double.add(10.0);
        list2_double.add(10.0);
        list2_double.add(10.0);
        list2_double.add(7.0);
        System.out.println(list2_double);
        Set <Double> set0 = list2_double.stream().distinct().mapToDouble(x -> x.doubleValue()).sorted().boxed().collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(set0);

//        2 Создать TreeSet содержащий класс Animal (поля - имя, кол-во лет, месяц рождения). Прибавить
//        всем животным, у которых месяц рождения апрель - 1 год. Распечатать содержимое с помощью for each.
        TreeSet<Animal> animalTreeSet = new TreeSet<>();
        animalTreeSet.add(new Animal("Барсик", "март", 1));
        animalTreeSet.add(new Animal("Леопольд", "июль", 1));
        animalTreeSet.add(new Animal("Мурзик", "апрель", 1));
        animalTreeSet.add(new Animal("Том", "январь", 1));
        animalTreeSet.add(new Animal("Карамелька", "апрель", 1));
        System.out.println(animalTreeSet);
        animalTreeSet.stream().filter(x -> x.getMonth().contains("апрель")).forEach(x ->
                System.out.println("name: " + x.getName() + ", month: " + x.getMonth() +", age: " + (x.getAge() + 1)));

        // 3 (выполнять не обязательно) Создайте HashMap, содержащий пары значений - имя игрушки и
        //объект игрушки (класс Product - поля: год выпуска, наименование). Исключить из коллекции
        //игрушки, произведенные до 2010 года. - любым способом, можно без stream.
        Product p1 = new Product(2002, "кукла");
        Product p2 = new Product(2005, "лото");
        Product p3 = new Product(2010, "домино");
        Product p4 = new Product(2012, "кубики");
        Product p5 = new Product(2015, "кукла");
        Product p6 = new Product(2020, "юла");
        Product p7 = new Product(2022, "конструктор");
        Product p8 = new Product(2004, "мягкая игрушка");
        HashMap<String, Product> toys = new HashMap<> ();

        toys.put("Маша", p1);
        toys.put("10 в одном", p2);
        toys.put("Зверята", p3);
        toys.put("Томмик", p4);
        toys.put("Даша", p5);
        toys.put("Юла", p6);
        toys.put("Стройка", p7);
        toys.put("Мишка", p8);
        System.out.println();
        System.out.println(toys);
        // 1 способ
//        toys.entrySet().removeIf(x -> x.getValue().getYear() < 2010);
//        System.out.println(toys);
        // 2 способ
//        toys.entrySet().stream().filter(x -> x.getValue().getYear() > 2010).forEach(x -> System.out.println(x.getKey() + x.getValue()));
        // 3 способ
        Map <String,Product> map1 = toys.entrySet().stream().filter(x -> x.getValue().getYear() > 2010).collect(Collectors.toMap(x -> x.getKey(), y -> y.getValue()));
        System.out.println(map1);

        // 4 (выполнять не обязательно) Добавить студентов в коллекцию. Создать класс Student,
        //содержащий следующие характеристики – имя, группа, курс, оценки по предметам.
        //Создать коллекцию, содержащую объекты класса Student.
        //Создать коллекцию с фио студентов, если средний балл>=3
        Map <String, Integer> marks1 = new HashMap<>();
        marks1.put("История", 2);
        marks1.put("Философия", 4);
        marks1.put("Высшая математика", 2);
        marks1.put("Теоретическая механика", 3);
        marks1.put("Экономика", 2);

        Map <String, Integer> marks2 = new HashMap<>();
        marks2.put("История", 5);
        marks2.put("Философия", 1);
        marks2.put("Высшая математика", 2);
        marks2.put("Теоретическая механика", 4);
        marks2.put("Экономика", 6);

        Map <String, Integer> marks3 = new HashMap<>();
        marks3.put("История", 8);
        marks3.put("Философия", 5);
        marks3.put("Высшая математика",10);
        marks3.put("Теоретическая механика", 4);
        marks3.put("Экономика", 9);

        Map <String, Integer> marks4 = new HashMap<>();
        marks4.put("История", 9);
        marks4.put("Философия", 10);
        marks4.put("Высшая математика",4);
        marks4.put("Теоретическая механика", 4);
        marks4.put("Экономика", 6);

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Иванов", "MA - 102", 2, marks1));
        studentList.add(new Student("Петров", "MA - 101", 1, marks2));
        studentList.add(new Student("Сидоров", "MA - 102", 2, marks3));
        studentList.add(new Student("Ермакова", "MA - 101", 1, marks4));
        System.out.println(studentList);
//        List list = studentList.stream().filter(x -> x.getAvg() >= 3).collect(Collectors.toList());
        List <String> l = new ArrayList<>();
        studentList.stream().filter(x -> x.getAvg() >= 3).forEach(x -> {
            l.add(x.getName());
        });
        System.out.println(l);


//        второй вариант поиска avg
//        double avg1 = avg(marks1);
        }
//         static double avg (Map <String, Integer> marks) {
//             marks.entrySet();
//             int sum = 0;
//             for (Map.Entry<String, Integer> entry : marks.entrySet()) {
//                 sum = sum + entry.getValue();
//             }
//             int avg = sum/ marks.size();
//             return avg;
//
//         }
    }




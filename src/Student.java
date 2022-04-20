import java.util.Map;
import java.util.Set;

public class Student {
    private String name;
    private String group;
    private int course;
    private Map<String, Integer> marks;
    private double avg;

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Map<String, Integer> getMarks() {
        return marks;
    }

    public void setMarks(Map<String, Integer> marks) {
        this.marks = marks;
    }

    public Student(String name, String group, int course, Map<String, Integer> marks) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.marks = marks;
        Set<Map.Entry <String, Integer>> entrySet = marks.entrySet();
        int sum = 0;
        for (Map.Entry<String, Integer> entry : marks.entrySet()) {
            sum = sum + entry.getValue();
        }
        this.avg = sum/ marks.size();


    }

    @Override
    public String toString() {
        return "Name: " + name + ", group: " + group + ", course: " + course + ", marks: " + marks + "avg: " + avg +"\n";
    }
}

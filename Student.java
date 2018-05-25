package CheckIdea;
import java.util.Arrays;
public class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
       // return String.format("Student(name:%s,score:%d)",name,score);

    }
    public static void main(String[] args) {
        Array<Student>array=new Array<>();
        array.addLast(new Student("a",100));
        array.addLast(new Student("b",99));
        array.addLast(new Student("c",88));
        System.out.println(array);
    }

}


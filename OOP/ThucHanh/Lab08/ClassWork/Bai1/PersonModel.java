package ClassWork.Bai1;

import java.util.ArrayList;
import java.util.List;

public class PersonModel <T>{
    private List<T> listTest = new ArrayList<>();

    public void add(T t){
        listTest.add(t);
    }

    public void remove(T t){
        listTest.remove(t);
    }

    public void display(){
        for (T t : listTest){
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        PersonModel<Student> studentModel = new PersonModel<>();
        Student student1 = new Student("John", 1990, 1, 4.0);
        Student student2 = new Student("Mary", 1991, 2, 3.5);
        Student student3 = new Student("Peter", 1992, 3, 3.0);
        Student student4 = new Student("Paul", 1993, 4, 2.5);
        studentModel.add(student1);
        studentModel.add(student2);
        studentModel.add(student3);
        studentModel.add(student4);
        studentModel.display();
    }
}

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<University> universities = new ArrayList<>();
        universities.add(new University("University of California, Berkeley", "Berkeley, CA", "123456789", 170, 5.0, 5.0, "Essay 1"));
        universities.add(new University("University of California, Los Angeles", "Los Angeles, CA", "987654321", 170, 5.0, 5.0, "Essay 2"));
        universities.add(new University("University of California, San Diego", "San Diego, CA", "111111111", 130, 5.0, 5.0, "Essay 3"));
    
        List<College> colleges = new ArrayList<>();
        colleges.add(new College("colleges of California, Berkeley", "Berkeley, CA", "123456789", 120, 5.0, 5.0));
        colleges.add(new College("colleges of California, Los Angeles", "Los Angeles, CA", "987654321", 100, 5.0, 5.0));
        colleges.add(new College("colleges of California, San Diego", "San Diego, CA", "111111111", 110, 5.0, 5.0));

        int count = 0;
        for (College college : colleges) {
            if(college.isGraduate()){
                System.out.println(college.toString());
                System.out.println("----------------------");
                count++;
            }
        }

        for (University university : universities) {
            if(university.isGraduate()){
                System.out.println(university.toString());
                System.out.println("----------------------");
                count++;
            }
        }
        System.out.println(count);
    }

    
}

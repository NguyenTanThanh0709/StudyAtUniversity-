public class Student {
    private String id;
    private String name;
    private String email;
    private int age;
 
    public Student(String id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }
 
    public String toString() {
        String studentInfo = "Student " + id;
        studentInfo += ": " + name;
        studentInfo += " - " + email;
        studentInfo += " - " + age;
        return studentInfo;
    }
     /*
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student another = (Student) obj;
            if (this.id.equals(another.id) &&
                this.name.equals(another.name) &&
                this.email.equals(another.email) &&
                this.age == another.age) {
                    return true;
            }
        }
        return false;
    }*/
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(this.getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if(this.email != other.email)
            return false;
        if(this.age != other.age)
            return false;
        if(this.id != other.id)
            return false;
        if(this.name != other.name)
            return false;
        return true;
    }
}
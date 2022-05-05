class Student{
     static String name = "thanh";
     static String address = "hanoi";
     static String sex = "male";
     static double score = 10;



    static class StudentOperator{
        Student student;
        String print(){
            return "Student [ " +  name + "," + address + "," + score + "," + sex;
        }

        String type(){
            String result = "";
            double socre = score;
            if(socre > 8){
                result=  "A";
            }else{
                result = "B";
            }
            return result;
        }
    }

}
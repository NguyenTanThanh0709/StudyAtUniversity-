
public class ReadString {

    public static String reverseString(String s){
        String result = "";
        MyStack<Character> list = new MyStack<>();
        int len = s.length();
        for(int i = 0; i < len; i++){
            list.push(s.charAt(i));
        }

        while(list.size() > 0){
            result +=  Character.toString(list.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverseString("okok"));
    }
}

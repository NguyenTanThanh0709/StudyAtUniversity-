public class Bai04 {
    public static void main(String[] args) {
        String name = "Nguyen Thi Thu Thao";
        
    }

    //Find the length of the string.
    public static void lengthOfString(String name){
        System.out.println(name.length());
    }

    public static int countNumberOfTheWordsInString(String name){
        String[] nameArr = name.split(" ");
        return nameArr.length;
    }

    public static String concatenateString(String name1, String Name2){
        return name1 + Name2;
    } 

    // Check if a string is palindrome or not.

    public static boolean isPalindrome(String name){
        String reverseName = "";
        for(int i = name.length() - 1; i >= 0; i--){
            reverseName += name.charAt(i);
        }
        if (name.equals(reverseName)){
            return true;
        }
        else{
            return false;
        }
    }
}

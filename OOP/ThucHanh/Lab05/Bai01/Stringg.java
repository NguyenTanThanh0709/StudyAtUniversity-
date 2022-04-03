public class Stringg {
    public static void main(String[] args) {
        String Name = "Nguyen Vo Trong Tin";
        System.out.println(shortName(Name));
        System.out.println(hashtagName(Name));
        System.out.println(upperCaseAllVowel(Name));
        System.out.println(upperCaseAllN(Name));
    }

    public static String shortName(String str){
        String[] arr = str.split(" ");
        String shortName = "";
        shortName =  arr[arr.length - 1] + " " + arr[0];
        return shortName;
    }

    public static String hashtagName(String str){
        String[] arr = str.split(" ");
        String shortName = "";
        shortName =  "#" + arr[arr.length - 1] + " " + arr[0];
        return shortName;
    }

    public static String upperCaseAllVowel(String str){
        int n = str.length();
        for(int i = 0; i < n; i ++){
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u'){
                str = str.substring(0, i) + Character.toUpperCase(str.charAt(i)) + str.substring(i + 1);
            }
        }
        return str;
    }

    public static String upperCaseAllN(String str){
        int n = str.length();
        for(int i = 0; i < n; i ++){
            if(str.charAt(i) == 'n'){
                str = str.substring(0, i) + Character.toUpperCase(str.charAt(i)) + str.substring(i + 1);
            }
        }
        return str;
    }

    

}
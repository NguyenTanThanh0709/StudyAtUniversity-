public class Bai03 {
    public static void main(String[] args) {
       String name = "Nguyen Thi Thu Thao";
       
    }

   public static void capitalName(String name){
       for(int i = 0; i < name.length(); i++){
           if(name.charAt(i) == ' '){
               System.out.println(name.substring(i + 1, i + 2).toUpperCase() + name.substring(i + 2));
           }
       }
   }

    public static void returnFirstAndLastName(String Name){
        
        String[] nameArr = Name.split(" ");
        System.out.println(nameArr[0]);
        System.out.println(nameArr[nameArr.length - 1]);
    }


    public static void returnMiddleName(String Name){
        
        String[] nameArr = Name.split(" ");
        for(int i = 1; i < nameArr.length - 1; i++){
            System.out.print(nameArr[i]);
        }
    }

    public static void capitalizeFullName(String Name){
        String[] nameArr = Name.split(" ");
        for(int i = 0; i < nameArr.length; i++){
            System.out.print(nameArr[i].substring(0, 1).toUpperCase() + nameArr[i].substring(1).toLowerCase());
        }
    }

    public static void uppercaseVowelsAndLowercaseConsonants(String Name){
        String[] nameArr = Name.split("");
        for(int i = 0; i < nameArr.length; i++){
            if(nameArr[i].equals("a") || nameArr[i].equals("e") || nameArr[i].equals("i") || nameArr[i].equals("o") || nameArr[i].equals("u")){
                System.out.print(nameArr[i].toUpperCase());
            }
            else{
                System.out.print(nameArr[i].toLowerCase());
            }
        }
    }
    
   

}

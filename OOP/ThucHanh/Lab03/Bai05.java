
public class Bai05{

    public static void main(String []args){
        String name = "Nguyen Thi Thu Thao Thi Thao Nguyen Tam Hien Nguyen   hong hanh  Thi  hong hung hanh hien duc nguyen";
        String NameText = name.toLowerCase();
        
        String []splitWord = NameText.split("\\s+");
        String[] splitParagraphTrung = new String[name.length()];

        splitParagraphTrung = tachChuoiTrung(NameText);

        countWord(splitWord, splitParagraphTrung);

    }

    public static void countWord(String[] splitWord, String[] splitParagraphTrung){
        for(int i = 0; i < splitParagraphTrung.length; i++){
            int count = 0;
            for(int j = 0; j < splitWord.length; j++){
                if(splitParagraphTrung[i].equals(splitWord[j])){
                    count++;
                }
            }
            if(count != 0){
                System.out.println(splitParagraphTrung[i] + ": " + count);
            }
        }
    }

    public static void printArr(String []arr, int h){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static String[] tachChuoiTrung(String Paragraph){
        String[] arr = Paragraph.split("\\s+");
        int lenght = arr.length;
        String[] arr2 = new String[lenght];
        int h = 0;
        for(int i = 0; i < lenght; i++){
            boolean check = true;
            for(int j = i-1; j >= 0; j--){
                if(arr[i].equals(arr[j])){
                    check = false;
                    break;
                }
            }
            if(check == true){
                arr2[h++] = arr[i];
            }
        }

        return arr2;

    }


}

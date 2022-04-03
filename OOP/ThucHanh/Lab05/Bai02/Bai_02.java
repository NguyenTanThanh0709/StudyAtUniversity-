public class Bai_02 {
    public static void main(String[] args) {
        String paragraph ="The   quick brown fox jumps over the lazy dog";
        String paragraph1 ="the    quick brown fox. jumps over the lazy dog";

        System.out.println(countWord(paragraph));
        System.out.println(countSentences(paragraph1));
        System.out.println(countAppear(paragraph1,"the"));
    }

    public static int countWord(String paragraph){
        int count = 0;
        String[] arr = paragraph.split("\\s+");
        for(int i = 0; i < arr.length; i ++){
            count ++;
        }
        return count;
    }

    public static int countSentences(String paragraph){
        int count = 0;
        String[] arr = paragraph.split("\\.");
        for(int i = 0; i < arr.length; i ++){
            count ++;
        }
        return count;
    }

    public static int countAppear(String paragraph, String word){
        int count = 0;
        String[] arr = paragraph.split("\\s+");
        for(int i = 0; i < arr.length; i ++){
            if(arr[i].equals(word)){
                count ++;
            }
        }
        return count;

    }
}

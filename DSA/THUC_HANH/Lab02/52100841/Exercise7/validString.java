
public class validString {

    public static boolean checkVaildReverse(String s){
        s = s.toLowerCase().trim();
        MyStack<Character > stack = new MyStack<Character >();
        MyQueue<Character > queue = new MyQueue<Character >();

        for(int i = 0; i < s.length();i++){
            
            if((s.charAt(i) >= 'a' && s.charAt(i) <='z')||(s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                queue.enQueue(s.charAt(i));
            }
        }

        int length = queue.size();
        if(length % 2 == 0){
            int chiaDo = length / 2;
            for(int i = 1; i <= chiaDo; i++){
                stack.push(queue.deQueue());
            }
        }else{
            int chiaDo = length / 2;
            for(int i = 1; i <= chiaDo; i++){
                stack.push(queue.deQueue());
            }
            queue.deQueue();
        }

        int chiaDo = length / 2;

        for(int i = 1; i < chiaDo; i++){
            if(stack.pop() != queue.deQueue()){
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkVaildReverse("A man, a plan, a canal: Panama"));
    }
}


public class CheckBalance {
    public static boolean checkBalance(String s){
        boolean check = true;
        MyStack<Character> list = new MyStack<>();
        int len = s.length();
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '['){
                list.push(s.charAt(i));
            }else{
                char test = 'o';
                if(s.charAt(i) == '}'){
                    test = '{';
                }else if(s.charAt(i) == ')'){
                    test = '(';
                }else if(s.charAt(i) == ']'){
                    test = '[';
                }

                if(test != list.pop() || list.isEmpty()){
                    return false;
                    
                }
            }
        }
        return check;
    }

    public static void main(String[] args) {
        System.out.println(checkBalance("()[(}]()"));
    }
}

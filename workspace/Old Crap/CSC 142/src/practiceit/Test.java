package practiceit;

public class Test {
    
    public static void main(String[] args){
        System.out.println(method("people"));
    }
    
    public static String method(String s){
        String result = s.substring(0,1);
        for (int i = 1; i  < s.length(); i++){
            result += ("-" + s.charAt(i));
        }
        return result;       
    }
}

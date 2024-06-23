
public class MyClass {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            System.out.println("ok");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}

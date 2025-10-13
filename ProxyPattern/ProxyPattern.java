package ProxyPattern;

public class ProxyPattern {
     public static void main(String[] args) {
        
        EmployeeInterface emp = new EmployeeProxy();
        try {
            emp.Create("Admin", "Soham");
            emp.Delete("Admin", 101);
            emp.Get("User", 101);
            emp.Create("User", "Ganesh");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
     }
}

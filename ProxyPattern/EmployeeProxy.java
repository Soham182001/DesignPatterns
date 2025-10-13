package ProxyPattern;

public class EmployeeProxy implements EmployeeInterface{
    
    EmployeeImpl emp;

    EmployeeProxy(){
        emp = new EmployeeImpl();
    }

    @Override
    public void Create(String Client, String Name) throws Exception {
        if(Client.equals("Admin")){
            emp.Create(Client, Name);
        }else{
            System.out.println("You don't have access to create employee");
        }
    }

    @Override
    public void Delete(String Client, int EmployeeId) throws Exception {
        if(Client.equals("Admin")){
            emp.Delete(Client, EmployeeId);
        }else{
            System.out.println("You don't have access to delete employee");
        }
    }

    @Override
    public EmployeeInterface Get(String Client, int EmployeeId) throws Exception {
        if(Client.equals("Admin") || Client.equals("User")){
            return emp.Get(Client, EmployeeId);
        }else{
            System.out.println("You don't have access to get employee details");
        }
        return null;
    }

}

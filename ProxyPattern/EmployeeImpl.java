package ProxyPattern;

public class EmployeeImpl implements EmployeeInterface {
    
    @Override
    public void Create(String Client, String Name) throws Exception {
        System.out.println("New Employee Row Created"+" With Name : "+Name);
    }

    @Override
    public void Delete(String Client, int EmployeeId) throws Exception {
        System.out.println("Employee Deleted With EmployeeId : "+EmployeeId);
    }

    @Override
    public EmployeeInterface Get(String Client, int EmployeeId) throws Exception {
        System.out.println("Fetching Employee Details For EmployeeId : "+EmployeeId);
        return new EmployeeImpl();
    }
}

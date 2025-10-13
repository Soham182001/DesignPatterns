package ProxyPattern;

public interface EmployeeInterface {

    public void Create(String Client, String Name) throws Exception;
    public void Delete(String Client, int EmployeeId) throws Exception;
    public EmployeeInterface Get(String Client, int EmployeeId) throws Exception;

}

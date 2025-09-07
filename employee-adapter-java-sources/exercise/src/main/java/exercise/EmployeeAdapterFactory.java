package exercise;

public class EmployeeAdapterFactory {
    public static Employee adapt(EmployeeCSV csv) {
        return new EmployeeCSVAdapter(csv);
    }
    public static Employee adapt(EmployeeDB db) {
        return new EmployeeDBAdapter(db);
    }
    public static Employee adapt(EmployeeLDAP ldap) {
        return new EmployeeLDAPAdapter(ldap);
    }
}
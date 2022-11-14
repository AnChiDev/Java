package ASM4.humanresource;
import java.util.*;
import java.lang.String;
import java.text.DecimalFormat;

public class Humanresource {
    //static ArrayList<Employee> employee = new ArrayList<>(); //List of Employee
    //static ArrayList<Manager> manager = new ArrayList<>(); //List of Manager
    static ArrayList<Department> dept = new ArrayList<>(); //List of departments
    static ArrayList<Staff> staff = new ArrayList<>(); //List of all staffs
    static Scanner sc = new Scanner(System.in);
    static boolean flag = true;



    /*---main---*/
    public static void main(String[] args)  {
        data();

        System.out.println("Welcome to the human resource database of our company");
        do {
            System.out.println("-----------------MENU-----------------");
            System.out.println("1. Display the list of staffs");
            System.out.println("2. Display the list of departments");
            System.out.println("3. Display staffs by department");
            System.out.println("4. Adding a new staff");
            System.out.println("5. Search staff by name or id");
            System.out.println("6. Display the payroll of all employees");
            System.out.println("7. Display the payroll in increasing order");
            System.out.println("8. Exit");
            System.out.print("Your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    allstaff();
                    break;
                case 2:
                    allDepartments();
                    break;
                case 3:
                    staffsByDepartments();
                    break;
                case 4:
                    addStaff();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    payroll();
                    break;
                case 7:
                    payrollascending();
                    break;
                case 8:
                    exit();
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid entry");
                    flag = false;
                    break;
            }
        } while (flag);

    }


    public static void data() {

        staff.add(new Employee("EHC101", "Duong Quynh Anh", 25, "2/7/2020", 3, 3, 8)); //Hc
        staff.add(new Employee("ESL403", "Tran Chi Hieu", 30, "1/6/2019", 4, 4, 7)); //sale
        staff.add(new Employee("EKT202", "Nguyen Thanh Linh", 40, "4/9/2018", 3, 3, 2)); //KT

        staff.add(new Manager("MSL105", "Chu Ngoc An", 37, "1/8/2018", 7, 7, "Business Leader")); //sale
        staff.add(new Manager("MKT111", "Nguyen Thu Trang", 28, "5/7/2019", 3, 7, "Project leader")); //KT
        staff.add(new Manager("MKT102", "Nguyen Ngoc Trung", 33, "5/9/2020", 4, 8, "Technical Leader")); //KT*/


        dept.add(new Department("HC", "Hanh chinh", 0));
        dept.add(new Department("SL", "Sale", 0));
        dept.add(new Department("KT", "Ky thuat", 0));

    }

    /*-----case 1: show all staff ------*/
    public static void allstaff() {
        System.out.println(String.format("%90s", "EMPLOYEE"));
        System.out.println();

        System.out.println(String.format("|%10s|%20s|%20s|%20s|%20s|%20s|%20s|", "Id", "Name", "Age", "Start date", "Day Off", "Salary coefficient", "TimeOT"));

        for (Employee emp : employee) {
            System.out.println(emp.toString());
        }
        System.out.println();

        System.out.println(String.format("%90s", "MANAGER"));
        System.out.println();
        System.out.println(String.format("|%10s|%20s|%20s|%20s|%20s|%20s|%20s|", "Id", "Name", "Age", "Start date", "Salary coefficient", "Day Off", "Position"));
        for (Manager mng : manager) {
            System.out.println(mng.toString());        }
        System.out.println();

    }

    /*----case 2: all department ---*/
    public static void allDepartments() {
        System.out.println(String.format("%90s", "LIST OF DEPARTMENTS"));
        System.out.println();
        System.out.println(String.format("|%20s|%20s|%30s|", "Department ID", "Department name", "Staffs in this department"));
        // đếm số nhân viên từng department: duyệt từng staff nếu id chứa mã bp -> +1
        int countdept1 = 0;
        int countdept2 = 0;
        int countdept3 = 0;

        for (Staff stf : staff) {
            if (stf.getId().contains("HC")) {
                countdept1++;

            } else if (stf.getId().contains("SL")) {
                countdept2++;
            } else {
                countdept3++;
            }
        }

        // add giá trị số nhân viên vào numberstaff

        for (Department d : dept) {
            if (d.getIddp().equalsIgnoreCase("HC")) {
                d.setNumberstaff(countdept1);
            } else if (d.getIddp().equalsIgnoreCase("SL")) {
                d.setNumberstaff(countdept2);
            } else {
                d.setNumberstaff(countdept3);
            }
        }
        // in ra kết quả
        for (Department d : dept) {
            System.out.println(d.toString());
        }
    }

    /*--- case 3: staffsByDepartments---*/
     public static void staffsByDepartments() {

        System.out.println("-----------------Staffs by department-----------------");
        System.out.println(String.format("|%20s|%20s|%20s|", "Department Id", "Department Name", "Employee Name"));

        for (Staff stf : staff) {
            if (stf.getId().contains("HC")) {
                System.out.println(String.format("|%20s|%20s|%20s|", "HC", "Hanh chinh", stf.getName()));
            }
        }
        for (Staff stf : staff) {
            if (stf.getId().contains("SL")) {
                System.out.println(String.format("|%20s|%20s|%20s|", "SL", "Sale", stf.getName()));
            }

        }
        for (Staff stf : staff) {
            if (stf.getId().contains("KT")) {
                System.out.println(String.format("|%20s|%20s|%20s|", "KT", "Ky thuat", stf.getName()));
            }
        }
    }

    /*--- case 4: addStaff()---*/
    public static void addStaff ()  {
        System.out.println("Enter information of the new employee below: ");
        System.out.println("Add: 1.employee. 2. Manager. Your choice: ");
        int a = sc.nextInt();
        switch (a) {
            case 1: // employee
                addEmployee();
                break;
            case 2: //manager
                addManager();
                break;
            default:
                System.out.println("Please try again (1 or 2). 1.employee - 2.Manager. ");
                return;
        }
    }
    public static boolean isIDExists(String id){
        for (Staff stf : staff) {
            if (stf.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }
    public static void addEmployee() {
            String employeeID;
        do{
            System.out.println("Id: ");
            employeeID = sc.next();

            if (isIDExists(employeeID)) {
                System.out.println("This employee ID was already exited. Please try a new one");
            }
        } while (isIDExists(employeeID));
            System.out.println("Name: ");
            String employeeName = sc.nextLine();
            employeeName+=sc.nextLine();
            System.out.println("Age: ");
            int employeeage = sc.nextInt();
            System.out.println("Start date: ");
            String employeestartdate = sc.next();
            System.out.println("Day off: ");
            int employeedayoff = sc.nextInt();
            System.out.println("Salary Coefficient: ");
            int employeecoefficient = sc.nextInt();
            System.out.println("TimeOT: ");
            int employeetimeot = sc.nextInt();
            Employee emp = new Employee(employeeID, employeeName, employeeage, employeestartdate, employeedayoff, employeecoefficient, employeetimeot);
            employee.add(emp);
            staff.add(emp);
        }

    public static void addManager(){
          String mngID;
        do{
               System.out.println("Id ");
               mngID = sc.next();

                if (isIDExists(mngID)) {
                    System.out.println("This staff ID was already exited. Please try a new one");
                }
            } while(isIDExists(mngID));

        System.out.println("Name: ");

        String mngName = sc.nextLine();
        mngName+=sc.nextLine();
        System.out.println("Age: ");
        int mngage = sc.nextInt();
        System.out.println("Start date: ");
        String mngstartdate = sc.next();
        System.out.println("Day off: ");
        int mngdayoff = sc.nextInt();
        System.out.println("Salary Coefficient: ");
        int mngcoefficient = sc.nextInt();
        System.out.println("Position: ");
        String mngposition = sc.nextLine();
        mngposition+=sc.nextLine();

        Manager newmng = new Manager(mngID, mngName, mngage, mngstartdate, mngdayoff, mngcoefficient, mngposition);
        System.out.println(newmng);
        manager.add(newmng);
        staff.add(newmng);
    }

    /*--- case 5: search()---*/
    public static void search() {
        System.out.println("You want find who? Please choose: 1. Search with ID - 2.Search with Name");
        int a = sc.nextInt();
        boolean check = false;

            if(a ==1) {
                System.out.print("Search staff with ID. ID? ");
                String b = sc.next();
                for (Staff stf : staff) {
                    if (!b.equalsIgnoreCase(stf.getId())) {
                        check =false;
                        continue;
                    } else {
                        check = true;
                        System.out.println(String.format("|%10s|%20s|%20s|%20s|%20s|%20s|%20s|%20s|", "Id", "Name", "Age", "Start date", "Day Off", "Salary coefficient", "TimeOT","Salary"));
                        System.out.println(stf.toString());
                        break;
                    }
                }
                if(check ==false){
                    System.out.println("Not found");
                }
            }
               else if(a==2) {
                   System.out.print("Search staff with name. Enter Staff Name to search: ");
                   String c = sc.next();

                for (Staff stf : staff) {
                    if (!(stf.getName().toLowerCase(Locale.ROOT)).contains(c.toLowerCase(Locale.ROOT))) {
                        check =false;

                    } else {
                       check = true;
                        System.out.println(String.format("|%10s|%20s|%20s|%20s|%20s|%20s|%20s|", "Id", "Name", "Age", "Start date", "Day Off", "Salary coefficient", "TimeOT"));
                        System.out.println(stf.toString());
                        //break;
                    }
                }
                if(check ==false){
                    System.out.println("Not found");
                }
            }
                else{
                    System.out.println("Try again");
            }
    }

    /*--- case 6: payroll()---*/
    public static void payroll(){
        System.out.println(String.format("%30s", "PAYROLL"));
        System.out.println(String.format("|%10s|%20s|%20s|%20s|", "Id", "Name", "Salary coefficient", "Salary"));
        DecimalFormat df = new DecimalFormat("#,###.#");
        for(Staff stf: staff){
            System.out.println(String.format("|%10s|%20s|%20s|%20s|", stf.getId(), stf.getName(), stf.getCoefficient(), df.format(stf.caculateSalary())));
        }
    }
    /*--- case 7: payrollascending---*/
    public static void payrollascending() {
        System.out.println(String.format("%30s", "PAYROLL   ASCENDING"));
        System.out.println(String.format("|%10s|%20s|%20s|%20s|", "Id", "Name", "Salary coefficient", "Salary"));
        Collections.sort(staff, (a, b)-> (int) a.caculateSalary() - b.caculateSalary());
        for (Staff stf: staff) {
            System.out.println(String.format("|%10s|%20s|%20s|%20s|", stf.getId(), stf.getName(), stf.getCoefficient(), stf.caculateSalary()));

        }
    }
    /*--- case 8: exit()---*/
    public static void exit() {
        System.out.println("You choose to exist the program. Goodbye!");
        flag = false;
    }
}




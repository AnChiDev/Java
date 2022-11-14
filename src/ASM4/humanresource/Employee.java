/*
 Employee.java: chứa thông tin chung về nhân viên, bao gồm các thuộc tính và phương thức sau.

 - Thuộc tính: số giờ làm thêm

 - Phương thức: calculateSalary() trả về lương nhân viên, displayInformation() hiển thị thông tin nhân viên.

- Employee kế thừa class Staff
 */
package ASM4.humanresource;

public class Employee extends Staff{
    private int timeOT;

    public Employee (String id, String name, int age, String startDate, int dayOff, int coefficient, int timeOT){
        super(id, name, age, startDate , dayOff, coefficient);
        this.timeOT=timeOT;
    }

    //getter and setter

    public int getTimeOT() {
        return timeOT;
    }

    public void setTimeOT(int timeOT) {
        this.timeOT = timeOT;
    }

    public int caculateSalary(){
        return getCoefficient()*3000000 + timeOT * 200000;
    }

    public String toString(){
        return String.format("|%10s|%20s|%20s|%20s|%20s|%20s|%20s|", getId(), getName(),  getAge(),getStartDate(),  getDayOff() ,getCoefficient(),getTimeOT()/*, df.format(caculateSalary()*/);
    }
}

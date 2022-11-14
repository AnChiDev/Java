
/*
 Manager.java: chứa thông tin chung về quản lý, bao gồm các thuộc tính và phương thức sau.

 -  Thừa kế: Manager cũng là nhân viên, nên sẽ thừa kế từ class Staff.

 - Thuộc tính: chức danh

 -  Phương thức: displayInformation() hiển thị thông tin bao gồm cả chức danh
 */
package ASM4.humanresource;

public class Manager extends Staff {
    private String position;

    public Manager(String id, String name, int age, String startDate, int dayOff, int coefficient, String position) {
        super(id, name, age, startDate, dayOff, coefficient);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int caculateSalary() {
        if (position.equalsIgnoreCase("Business Leader")) {
            return getCoefficient() * 5000000 + 8000000;
        } else if (position.equalsIgnoreCase("Project Leader")) {
            return getCoefficient() * 5000000 + 5000000;
        } else {
            return getCoefficient() * 5000000 + 6000000;
        }
    }

    public String toString() {
        return String.format("|%10s|%20s|%20s|%20s|%20s|%20s|%20s|", getId(), getName(), getAge(), getStartDate(), getDayOff(), getCoefficient(), getPosition()/*, df.format(caculateSalary() */);
    }

}
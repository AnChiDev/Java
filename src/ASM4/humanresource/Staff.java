
/*
 *Staff.java là class abstract chứa các thông tin cơ bản của nhân viên, hàm displayInformation() là hàm abstract,
các class kế thừa triển khai hiển thị thông tin phù hơp
Thuộc tính: mã nhân viên, tên nhân viên, tuổi nhân viên, hệ số lương, ngày vào làm, bộ phận làm việc, số ngày nghỉ phép
 */
package ASM4.humanresource;

public abstract class Staff implements ICaculator{

        private String id;
        private String name;
        private int age;
        private String startDate;
        private int dayOff;
        private int coefficient;

        public Staff(String id, String name, int age, String startDate, int dayOff, int coefficient) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.startDate = startDate;
            this.dayOff = dayOff;
            this.coefficient = coefficient;
        }

        //getter and setter

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public int getDayOff() {
            return dayOff;
        }

        public void setDayOff(int dayOff) {
            this.dayOff = dayOff;
        }


        public int getCoefficient() {
            return coefficient;
        }

        public void setCoefficient(int coefficient) {
            this.coefficient = coefficient;
        }

        public abstract String toString();
    }

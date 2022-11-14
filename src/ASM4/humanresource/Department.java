
/*
Department.java: chứa thông tin chung về bộ phận, bao gồm các thuộc tính và phương thức sau.

 - Thuộc tính: mã bộ phận, tên bộ phận, số lượng nhân viên hiện tại

 - Phương thức: toString() hiển thị thông tin về bộ phận.
 */
package ASM4.humanresource;

public class Department {
    private String iddp;
    private String namedp;
    private int numberstaff;

    public Department(String iddp, String namedp, int numberstaff){
        this.iddp=iddp;
        this.namedp=namedp;
        this.numberstaff = numberstaff;
    }

    public String getIddp() {
        return iddp;
    }

    public void setIddp(String iddp) {
        this.iddp = iddp;
    }

    public String getNamedp() {
        return namedp;
    }

    public void setNamedp(String namedp) {
        this.namedp = namedp;
    }

    public void setNumberstaff( int numberstaff){
        this.numberstaff=numberstaff;
    }

    public int getNumberstaff(){
        return numberstaff;
    }

    @Override
    public String toString(){

        return String.format("|%20s|%20s|%20s|", getIddp(),getNamedp(),getNumberstaff());
    }

    }


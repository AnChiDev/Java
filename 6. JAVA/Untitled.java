public class Untitled {public static void main(String args[])
  
        public static void main(String[] args) {
            Random rd = new
    
            ();   // khai báo 1 đối tượng Random
            int number = rd.nextInt();  // trả về 1 số nguyên bất kỳ
            System.out.println("Số vừa được sinh ra là " + number);
    
            int number1 = rd.nextInt(101);    // trả về 1 số nguyên nằm trong phạm vi [0...100)
            System.out.println("Số vừa được sinh ra là " + number1);
    
            // trả về 1 số nguyên nằm trong phạm vi [-4...-1]
            // đối với rd.nextInt(4) thì số lớn nhất là 3 và số nhỏ nhất là 0
            // ta có 3 - 4 = -1 và 0 - 4 = -4
            // nên các số được sinh ra sẽ nằm trong đoạn [-4...-1]
            int number2 = -101 + rd.nextInt(101);
            System.out.println("Số vừa được sinh ra là " + number2);
        }
    }
    
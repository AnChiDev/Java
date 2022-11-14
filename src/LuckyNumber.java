import java.util.Scanner;


public class LuckyNumber {
            public static void main (String[] args){
            System.out.println("Hello!");
            System.out.println("Let's play a game!");
            System.out.println("I'm thinking of a number between 0 and 100. What is it?");

            int Totalgame = 0;// tổng số lần chơi
            String rep1;// chơi tiếp không
            int Bestgame = 101;// lần chơi tốt nhất ????
            int guess; // số người chơi đoán
            int totalguess = 0;// tổng số lượt đoán

            do {
                int guessCount = 0;// đếm số lượt đoán
                // số ngâu nhiên từ 1-100
                int max = 100;
                int min = 1;
                int range = max - min + 1;
                // tạo các số ngẫu nhiên trong vòng 1 đến 100
                int random = (int) (Math.random() * range) + min;
                // ra số ngẫu nhiên
                //System.out.println(random);
                // nhập số bất kì
                System.out.print("Your guess?");
                Scanner sc = new Scanner(System.in);

                // vòng lặp cho người chơi đoán
                do {
                    guess = sc.nextInt();

                    // mỗi lần dự đoán sẽ tăng lên 1
                    totalguess++;
                    guessCount++;

                    if (guess == random) {
                        System.out.println("Congratulations, You got it right in " + guessCount + " guesses!");

                    } else if (guess > random) {
                        System.out.println("It\'s lower.");
                    } else if (guess < random) {
                        System.out.println("It\'s higher.");
                    }

                    System.out.print("Your guess? ");

                } while (guess != random);

                if (Bestgame > guessCount) {
                    Bestgame = guessCount;
                }

                System.out.println("Do you want to play again?");
                Scanner input = new Scanner(System.in);
                rep1 = input.next();
                // mỗi lần kết thúc game sẽ tăng 1
                Totalgame++;
            } while (rep1.equalsIgnoreCase("y") || rep1.equalsIgnoreCase("yes"));

            // tổng kết
            System.out.println("Overall results:");
            System.out.println("Total games     = " + Totalgame);
            System.out.println("Total guesses   = " + totalguess);
            System.out.println("Guesses/game    = " + (double) totalguess / Totalgame);
            System.out.println("Best game       = " + Bestgame);
        }
}


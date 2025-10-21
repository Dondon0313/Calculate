import java.util.ArrayList;
import java.util.Scanner;

public class Score {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> scores = new ArrayList<>();

        System.out.println("請輸入成績(輸入 -1 結束) : " );

        while(true){
            int score = scanner.nextInt();
            if(score == -1){
                break;
            }
            scores.add(score);
        }

        int sum = 0;
        for(Integer num : scores){
            sum+=num;
        }

        double average = (double) sum / scores.size();

        if(scores.size() == 0) {
            System.out.println("沒輸入任何成績");
            }else{
                System.out.println("總和:" + sum);
                System.out.println("平均" + average);
                System.out.println("共輸入了" + scores.size() + "個成績");
            }


    }

}

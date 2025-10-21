import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class StudentScoreSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> scores = new HashMap<>();

        while (true) {
            System.out.println("學生成績系統");
            System.out.println("1.新增成績");
            System.out.println("2.查詢成績");
            System.out.println("3.顯示所有成績");
            System.out.println("4.計算平均");
            System.out.println("0.離開");
            System.out.print("請選擇:");

            int choice = scanner.nextInt();
            switch (choice) {
                //新增成績
                case 1:
                    System.out.println("請輸入學號: ");
                    String id = scanner.next();
                    System.out.println("請輸入成績: ");
                    int score = scanner.nextInt();
                    scores.put(id, score);
                    System.out.println("新增成功");
                    break;
                //查詢成績
                case 2:
                    System.out.println("請輸入學號");
                    String searchId = scanner.next();
                    if (scores.containsKey(searchId)) {
                        int result = scores.get(searchId);
                        System.out.println("成績:" + result);
                    } else {
                        System.out.println("查無此學號");
                    }
                    break;
                //顯示所有成績
                case 3:
                    System.out.println("\n所有學生成績:");
                    if (scores.size() == 0) {
                        System.out.println("目前沒成績");
                    } else {
                        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
                            String studentId = entry.getKey();
                            int studentScore = entry.getValue();
                            System.out.println(studentId + ": " + studentScore);
                        }
                    }
                    break;

                //計算平均
                case 4:
                    if (scores.size() == 0) {
                        System.out.println("目前沒成績");
                    } else {
                        int sum = 0;
                        for (int avgScores : scores.values()) {
                            sum += avgScores;
                        }
                        double average = (double) sum / scores.size();
                        System.out.println("平均成績" + average);
                    }
                    break;

                case 0:
                    System.out.println("再見");
                    return;

                default:
                    System.out.println("無效");
            }

        }

    }
}
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class StudentManager {

    public static final String DEFAULT_FILENAME = "student.txt";

    private List<Student> students;
    private final Scanner scanner;

    public StudentManager() {
        students = new ArrayList<>();

        this.scanner = new Scanner(System.in);

        loadFromFile(DEFAULT_FILENAME);
        System.out.println("--- 系統啟動完畢 ---");
    }

    public void run() {
        boolean running = true;

        while (running) {
            showMenu();
            System.out.println("請選擇功能");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    findStudent();
                    break;
                case 3:
                    showAllStudent();
                    break;
                case 4:
                    updateScore();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    showStatistics();
                    break;
                case 7:
                    findStudentAndAddPublication();
                    break;
                case 8: {
                    System.out.println("請輸入要「儲存」的檔案名稱 (預設 " + DEFAULT_FILENAME + "): ");
                    String filename = scanner.nextLine();

                    if (filename.trim().isEmpty()) {
                        filename = DEFAULT_FILENAME;
                    }

                    saveFile(filename);
                    break;
                }
                    case 9: {
                        System.out.println("請輸入要「讀取」的檔案名稱 (");
                        String filename = scanner.nextLine();

                        if (filename.trim().isEmpty()) {
                            filename = DEFAULT_FILENAME;
                        }
                        loadFromFile(filename);
                        break;
                    }
                case 0:
                    System.out.println("關閉");
                    running = false;
                    break;
                default:
                    System.out.println("無此選項，請重選");
            }

            if (running) {
                System.out.println("\n按 Enter 繼續...");
                scanner.nextLine();
            }

        }
    }

    public void showMenu() {
        System.out.println("\n========== 學生管理系統 ==========");
        System.out.println("1. 新增學生");
        System.out.println("2. 查詢學生");
        System.out.println("3. 顯示所有學生");
        System.out.println("4. 修改學生成績");
        System.out.println("5. 刪除學生");
        System.out.println("6. 統計資訊");
        System.out.println("7. 論文系統");
        System.out.println("8. 儲存資料到檔案");
        System.out.println("9. 從檔案讀取資料");
        System.out.println("0. 離開系統");
        System.out.println("==================================");
    }

    public void addStudent() {
        System.out.println("\n========== 新增學生 ==========");
        System.out.println("請選擇學生類型");
        System.out.println("1. 一般學生 (Student)");
        System.out.println("2. 研究生 (GraduateStudent)");
        System.out.println("3. 交換學生 (ExchangeStudent)");
        System.out.println("4. 改良研究生 (ImprovedGraduateStudent)");
        System.out.println("請輸入選項 (1-4): ");

        String choice = scanner.nextLine();
        Student newStudent = null;

        System.out.println("輸入學號");
        String id = scanner.nextLine();
        System.out.println("輸入姓名");
        String name = scanner.nextLine();
        System.out.println("輸入成績");
        int score = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case "1":
                //一般學生
                newStudent = new Student(id, name, score);
                break;

            case "2":
                //研究生
                System.out.println("研究主題: ");
                String topic = scanner.nextLine();
                System.out.println("指導教授: ");
                String advisor = scanner.nextLine();

                newStudent = new GraduateStudent(id, name, score, topic, advisor);
                break;

            case "3":
                //交換學生
                System.out.println("交換國家: ");
                String country = scanner.nextLine();
                System.out.println("交換月數: ");
                int months = Integer.parseInt(scanner.nextLine());

                newStudent = new ExchangeStudent(id, name, score, country, months);
                break;

            case "4":
                //改良研究生
                System.out.println("研究主題: ");
                String topic2 = scanner.nextLine();
                System.out.println("指導教授: ");
                String advisor2 = scanner.nextLine();
                System.out.println(" 篇");
                int publicationCount = Integer.parseInt(scanner.nextLine());

                newStudent = new ImprovedGraduateStudent(id, name, score, topic2, advisor2, publicationCount);
                break;

            default:
                System.out.println("x 無效選項! 操作取消 ");
                return;
        }

        if (newStudent != null) {
            this.students.add(newStudent);
            System.out.println("學生新增成功");
        }
    }

    public void findStudent() {
        System.out.println("\n========== 查詢學生 ==========");
        System.out.println("請輸入學號: ");
        String id = scanner.nextLine();

        for (Student student : students) {
            if (student.getStudentId().equals(id)) {
                student.showInfo();
                return;
            }
        }
        System.out.println("查無此學號 " + id);


    }

    public void showAllStudent() {
        System.out.println("\n--- 學生清單 (共 " + students.size() + "人) ---");
        if (students.isEmpty()) {
            System.out.println("目前沒有學生資料");
            return;
        }

        for (Student student : students) {
            System.out.println("----------------------------------");

            student.showInfo();
        }

        System.out.println("----------------------------------");

    }

    public void updateScore() {
        System.out.println("\n========== 修改成績 ==========");
        System.out.println("請輸入學號: ");
        String id = scanner.nextLine();

        for (Student student : students) {
            if (student.getStudentId().equals(id)) {
                System.out.println("目前成績: " + student.getScore());
                System.out.println("請輸入新成績: ");
                int newScore = scanner.nextInt();
                scanner.nextLine();

                student.setScore(newScore);
                System.out.println("成績修改成功!");
                student.showInfo();
                return;
            }
        }

        System.out.println("查無此學號: " + id);

    }

    public void deleteStudent() {
        System.out.println("\n========== 刪除學生 ==========");
        System.out.println("請輸入學號: ");
        String id = scanner.nextLine();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(id)) {
                Student student = students.get(i);
                student.showInfo();

                System.out.println("確定要刪除嗎(y/n): ");
                String confirm = scanner.nextLine();

                if (confirm.equalsIgnoreCase("Y")) {
                    students.remove(i);
                    System.out.println("刪除成功");
                } else {
                    System.out.println("已取消刪除");
                }
                return;
            }
        }
        System.out.println("查無此學號: " + id);

    }

    private void showStatistics() {
        System.out.println("\n========== 統計資訊 ==========");

        // 1. (非靜態) 顯示「目前 List 中」有幾個學生
        //    這屬於 manager 物件，是「非靜態」的
        int currentCountInList = students.size();
        System.out.println("目前記憶體 (List) 中的學生數: " + currentCountInList);

        // 2. (靜態) 顯示「總共 new 過」幾個學生
        //    我們「直接」透過 Student 類別名稱呼叫 static 方法
        int totalCreated = Student.getTotalStudents(); //
        System.out.println("自程式啟動以來，總共建立過的學生數: " + totalCreated);


//        if (students.isEmpty()) {
//            System.out.println("目前沒有任何學生資料");
//            return;
//        }
//
//        //總分
//        int sum = 0;
//        for (Student student : students) {
//            sum += student.getScore();
//        }
//        double average = (double) sum / students.size();
//
//        //最高最低
//        int max = students.get(0).getScore();
//        int min = students.get(0).getScore();
//
//        for (Student student : students) {
//            if (student.getScore() > max) {
//                max = student.getScore();
//            }
//            if (student.getScore() < min) {
//                min = student.getScore();
//            }
//        }
//
//        //及格人數
//        int passCount = 0;
//        for (Student student : students) {
//            if (student.isPass()) {
//                passCount++;
//            }
//        }
//        double passRate = (double) passCount / students.size() * 100;
//
//        System.out.println("學生總數 : " + students.size());
//        System.out.println("平均分數: " + String.format("%.2f", average));
//        System.out.println("最高分" + max);
//        System.out.println("最低分" + min);
//        System.out.println("及格人數" + passCount + " / " + students.size());
//        System.out.println("及格率" + String.format("%.2f", passRate) + "%");
    }


    /**
     * 尋找學生+新增論文(實作 instanceof 和 Downcasting)
     */
    private void findStudentAndAddPublication() {
        System.out.println("--- 新增論文成果 ---");
        System.out.println("輸入要新增論文的學生學號: ");
        String id = scanner.nextLine();

        // 尋找學生
        Student targerStudent = null;
        for (Student student : students) {
            if (student.getStudentId().equals(id)) {
                targerStudent = student;
                break;
            }
        }
        if (targerStudent == null) {
            System.out.println("x 找不到學號為 " + id + " 的學生 ");
            return;
        }

        if (targerStudent instanceof ImprovedGraduateStudent) {
            System.out.println("√ 確認為研究生，準備新增論文...");


            ImprovedGraduateStudent improvedGrad = (ImprovedGraduateStudent) targerStudent;
            improvedGrad.addPublication();

            System.out.println("論文新增成功");
            improvedGrad.showInfo();
        } else {
            System.out.println("X 操作失敗: " + targerStudent.getName() + "不是研究生，無法新增論文");
        }

    }

    public void saveFile(String filename) {
        System.out.println(" ---- 儲存資料到 " + filename + " ----");

        // 將 BufferedWriter 和 FileWriter 宣告在 try(...) 中
        // 這樣 Java 會在使用完畢後自動幫我們 .close() 資源

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

            // 決定要用什麼格式儲存 (CSV 格式：逗號分隔)
            // 範例： A001,Alice,85
            for (Student student : students) {
                String line = student.getStudentId() + "," +
                        student.getName() + "," +
                        student.getScore();
                //資料字串寫入緩衝區
                writer.write(line);
                //寫入一個換行符號
                writer.newLine();
            }
            System.out.println(" 儲存成功 " + students.size() + " 筆資料");

        } catch (IOException e) {
            // 處理可能發生的錯誤，例如：
            // 1. 檔案路徑不存在
            // 2. 磁碟空間已滿
            // 3. 沒有寫入權限

            System.out.println(" 儲存失敗: " + e.getMessage());
        }

    }

    public void loadFromFile(String filename){
        System.out.println("--- 正在從 " + filename + " 讀取資料 ---");

        //在讀取前，先清空目前的學生清單(避免重複)
        this.students.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){

            String line;

            //讀取迴圈
            while ((line = reader.readLine()) !=null){

                //分割 csv
                String[] parts = line.split(",");

                //錯誤檢查，確保資料有 3 部分
                if (parts.length >= 3){
                    String id = parts[0];
                    String name = parts[1];
                    int score = Integer.parseInt(parts[2]);

                    //建立物件加回List
                    this.students.add(new Student(id,name,score));
                }else {
                    System.out.println("跳過格式錯誤的行: " + line);
                }
            }
            System.out.println(" 讀取成功，共載入 " + students.size() + " 筆資料");
        }catch (IOException e){
            // 處理錯誤，例如：
            // 1. 檔案不存在 (FileNotFoundException)
            // 2. 沒有讀取權限
            System.out.println("讀取失敗: " + e.getMessage());
        }catch (NumberFormatException e){
            // 處理型別轉換失敗，例如 "Alice" 無法轉成 int
            System.out.println("讀取失敗:資料格式錯誤(數字轉換失敗) " + e.getMessage());
        }
    }
}

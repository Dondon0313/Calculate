import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    private ArrayList<Student> students;
    private Scanner scanner;

    public StudentManager(){
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run(){
        boolean running = true;

        while(running){
            showMenu();
            System.out.println("請選擇功能");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
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
                    System.out.println("關閉");
                    running = false;
                    break;
                default:
                    System.out.println("無此選項，請重選");
            }

            if(running){
                System.out.println("\n按 Enter 繼續...");
                scanner.nextLine();
            }

        }
    }

    public void showMenu(){
        System.out.println("\n========== 學生管理系統 ==========");
        System.out.println("1. 新增學生");
        System.out.println("2. 查詢學生");
        System.out.println("3. 顯示所有學生");
        System.out.println("4. 修改學生成績");
        System.out.println("5. 刪除學生");
        System.out.println("6. 統計資訊");
        System.out.println("7. 離開系統");
        System.out.println("==================================");
    }

    public void addStudent(){
        System.out.println("\n========== 新增學生 ==========");
        System.out.println("請選擇學生類型");
        System.out.println("1. 一般學生 (Student)");
        System.out.println("2. 研究生 (GraduateStudent)");
        System.out.println("3. 交換學生 (ExchangeStudent)");
        System.out.println("請輸入選項 (1-3): ");

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

                newStudent = new GraduateStudent(id, name,score, topic, advisor);
                break;

            case "3":
                //交換學生
                System.out.println("交換國家: ");
                String country = scanner.nextLine();
                System.out.println("交換月數: ");
                int months = Integer.parseInt(scanner.nextLine());

                newStudent = new ExchangeStudent(id, name, score, country, months);
                break;

            default:
                System.out.println("x 無效選項! 操作取消 ");
                return;
        }

        if (newStudent !=null){
            this.students.add(newStudent);
            System.out.println("學生新增成功");
        }
    }

    public void findStudent(){
        System.out.println("\n========== 查詢學生 ==========");
        System.out.println("請輸入學號: ");
        String id = scanner.nextLine();

        for(Student student : students){
            if(student.getStudentId().equals(id)){
                student.showInfo();
                return;
            }
        }
        System.out.println("查無此學號 " + id);


    }

    public void showAllStudent(){
        System.out.println("\n--- 學生清單 (共 " + students.size() + "人) ---");
        if (students.isEmpty()){
            System.out.println("目前沒有學生資料");
            return;
        }

        for (Student student : students){
            System.out.println("----------------------------------");

            student.showInfo();
        }

        System.out.println("----------------------------------");

    }

    public void updateScore(){
        System.out.println("\n========== 修改成績 ==========");
        System.out.println("請輸入學號: ");
        String id = scanner.nextLine();

        for(Student student : students){
            if(student.getStudentId().equals(id)){
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

        System.out.println("查無此學號: "+ id);

    }

    public void deleteStudent(){
        System.out.println("\n========== 刪除學生 ==========");
        System.out.println("請輸入學號: ");
        String id = scanner.nextLine();

        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getStudentId().equals(id)){
                Student student = students.get(i);
                student.showInfo();

                System.out.println("確定要刪除嗎(y/n): ");
                String confirm = scanner.nextLine();

                if(confirm.equalsIgnoreCase("Y")){
                    students.remove(i);
                    System.out.println("刪除成功");
                }else{
                    System.out.println("已取消刪除");
                }
                return;
            }
        }
        System.out.println("查無此學號: "+ id);

    }

    private void showStatistics(){
        System.out.println("\n========== 統計資訊 ==========");
        if(students.isEmpty()){
            System.out.println("目前沒有任何學生資料");
            return;
        }

        //總分
        int sum = 0;
        for(Student student : students){
            sum+= student.getScore();
        }
        double average =  (double) sum / students.size();

        //最高最低
        int max = students.get(0).getScore();
        int min = students.get(0).getScore();

        for(Student student : students){
            if(student.getScore() > max){
                max = student.getScore();
            }
            if(student.getScore() < min){
                min = student.getScore();
            }
        }

        //及格人數
        int passCount = 0;
        for(Student student : students){
            if(student.isPass()){
                passCount++;
            }
        }
        double passRate = (double)passCount / students.size() * 100;

        System.out.println("學生總數 : " + students.size());
        System.out.println("平均分數: " + String.format("%.2f", average));
        System.out.println("最高分" + max);
        System.out.println("最低分" + min);
        System.out.println("及格人數" + passCount + " / " + students.size());
        System.out.println("及格率" + String.format("%.2f", passRate) + "%");
    }




}

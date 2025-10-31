public class TestInheritance {
    public static void main(String[] args){
        Student student = new Student(
                "114001",
                "Minnie",
                58);
        System.out.println("----一般學生----");
        student.showInfo();

        GraduateStudent grad = new GraduateStudent(
                "114001",
                "Bob",
                90,
                "AI主題",
                "王教授"
        );
        System.out.println("\n ---研究生---");
        grad.showInfo();

        ExchangeStudent exchange = new ExchangeStudent(
                "114005",
                "Cham",
                88,
                "美國",
                5
        );
        System.out.println("\n----交換學生----");
        exchange.showInfo();


//        System.out.println("學號: " + grad.getStudentId());
//        System.out.println("姓名: " + grad.getName());
//        System.out.println("成績: " + grad.getScore());
//        System.out.println("等第: " + grad.getGrade());
//        System.out.println("及格: " + grad.isPass());


//        System.out.println("研究主題: " + grad.getResearchTopic());
//        System.out.println("指導教授: " + grad.getAdvisor());

//        System.out.println("\n 使用繼承的 showInfo():");
//        grad.showInfo();
    }
}

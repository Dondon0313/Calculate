public class Student {
    private String studentId; //學號
    private String name; //名字

    private int score; //分數

    public Student(String studentId, String name, int score){
        this.studentId = studentId;
        this.name = name;
        setScore(score);

    }

    public Student(String studentId, String name){
        this(studentId,name,0);
    }


    public String getStudentId(){
        return studentId;
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }


    public void setName(String name){
        this.name = name;
    }

    public void setScore(int score){
        if(score>100 || score<0){
            System.out.println("錯誤：分數必須在 0-100 之間");
            return;
        }else {
            this.score = score;
        }
    }

    public boolean isPass(){
        return score >= 60;
    }

    public String getGrade(){
        if(score >= 90){
            return "A";
        } else if (score >=80) {
            return "B";
        } else if (score >=70) {
            return "C";
        } else if (score >=60) {
            return "D";
        }else{
            return "F";
        }

    }

    public void showInfo(){
        String passStatus = isPass() ? "及格" : "不及格";
        System.out.println("學號: " + studentId +
                           "| 姓名: " + name +
                           "| 成績: " + score +
                           "| 評級: " + getGrade() +
                           "| " + passStatus)  ;
    }

}

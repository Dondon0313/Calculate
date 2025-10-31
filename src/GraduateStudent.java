public class GraduateStudent extends Student{


    private String researchTopic;
    private String advisor;

    public GraduateStudent(String studentId, String name, int score, String researchTopic, String advisor){

        super(studentId,name,score);

        this.researchTopic = researchTopic;
        this.advisor = advisor;
    }

    public String getResearchTopic(){
        return researchTopic;
    }

    public String getAdvisor(){
        return advisor;
    }

    public void setResearchTopic(String researchTopic){
        this.researchTopic = researchTopic;
    }

    public void setAdvisor(String advisor){
        this.advisor = advisor;
    }

    @Override
    public void showInfo(){
        super.showInfo();
        System.out.println("研究主題: " + researchTopic);
        System.out.println("指導教授: " + advisor);
    }



}

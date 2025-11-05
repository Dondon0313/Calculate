public class ImprovedGraduateStudent extends Student{

    private String researchTopic;
    private String advisor;
    private int publicationCount;

    public ImprovedGraduateStudent(String studentId, String name, int score, String researchTopic, String advisor, int publicationCount ){
        super(studentId, name, score);
        this.researchTopic = researchTopic;
        this.advisor = advisor;
        this.publicationCount = publicationCount;

    }

    public void addPublication(){
        this.publicationCount++;
        System.out.println("新增論文，目前共 " + this.publicationCount + " 篇");
    }

    @Override
    public void showInfo(){
        super.showInfo();
        System.out.println("研究主題: " + researchTopic);
        System.out.println("指導教授: " + advisor);
        System.out.println("論文發表: " + publicationCount + " 篇");
    }

    @Override
    public int getScore(){
        int base = super.getScore();
        int bonus = publicationCount * 2;
        return Math.min(100, base + bonus);
    }

    public int getPublicationCount(){
        return publicationCount;
    }

    public void setPublicationCount(){
        this.publicationCount = publicationCount;
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


};

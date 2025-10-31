public class ExchangeStudent extends Student{
    private String country;
    private int exchangeMonths;

    public ExchangeStudent(String studentId, String name, int score, String country, int exchangeMonths){
        super(studentId,name,score);

        this.country = country;
        this.exchangeMonths = exchangeMonths;
    }

    public String getCountry() {
        return country;
    }

    public int getExchangeMonths() {
        return exchangeMonths;
    }

    public void setCountry(){
        this.country = country;
    }

    public void setExchangeMonths(){
        this.exchangeMonths = exchangeMonths;
    }

    @Override
    public void showInfo(){
        super.showInfo();
        System.out.println("國家: " + country);
        System.out.println("交換月數: " + exchangeMonths);
    }


}
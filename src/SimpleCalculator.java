public class SimpleCalculator {

    private int num1;
    private int num2;


    public SimpleCalculator(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getNum1(){
        return num1;
    }

    public int getNum2(){
        return num2;
    }

    public void setNum1(int num1){
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        if (num2 == 0) {
            System.out.println("不能為0");

            this.num2 = 1;
        } else {
            this.num2 = num2;
        }
    }

    public int add(){
        return num1 + num2;
    }

    public int subtract(){
        return num1 - num2;
    }

    public int multiply(){
        return num1 * num2;
    }

    public double divide(){
        if(num2 == 0){
            System.out.println("不能除以零");
            return 0;
        }
        return (double)num1 / num2;
    }

}


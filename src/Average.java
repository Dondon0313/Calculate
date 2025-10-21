
public class Average {

    public static void main(String[] args) {
        int[] number = {85, 92, 78, 90, 88};

        int sum = 0;
//        for(int i = 0; i < number.length; i++){
//            sum += number[i];
//        }

        for(int num : number){
            sum+= num;
        }


        double average =  (double) sum / number.length;

        System.out.println("總和:" + sum);
        System.out.println("平均" + average);

    }


}

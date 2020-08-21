package sample;

public class Add implements Calculation {
    @Override
    public int calculate(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }
}

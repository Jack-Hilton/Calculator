package sample;

public class Subtract implements Calculation {
    @Override
    public int calculate(int firstNum, int secondNum) {
        return firstNum - secondNum;
    }
}

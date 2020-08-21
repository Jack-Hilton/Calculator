package sample;

public class Multiply implements Calculation {
    @Override
    public int calculate(int firstNum, int secondNum) {
        return firstNum * secondNum;
    }
}

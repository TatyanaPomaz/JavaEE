package jmx_test;

public class Calculator implements CalculatorMBean {
    private int firstNumber = 10;
    private int secondNumber = 20;

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        System.out.println(this);
        this.secondNumber = secondNumber;
    }

    public int sum() {
        return firstNumber + secondNumber;
    }

    public String toString() {
        return "Calculator{" +
                "firstNumber=" + firstNumber +
                ", secondNumber=" + secondNumber +
                '}';
    }
}

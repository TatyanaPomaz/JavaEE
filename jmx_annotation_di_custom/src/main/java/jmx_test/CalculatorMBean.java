package jmx_test;

public interface CalculatorMBean {
    int getFirstNumber();

    void setFirstNumber(int firstNumber);

    int getSecondNumber();

    void setSecondNumber(int secondNumber);

    int sum();

    @Override
    String toString();
}

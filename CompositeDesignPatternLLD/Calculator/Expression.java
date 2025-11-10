package CompositeDesignPatternLLD.Calculator;

public class Expression implements ArithmeticExpression{
    ArithmeticExpression leftArithmeticException;
    ArithmeticExpression rightArithmeticException;
    Operation operation;

    public Expression(ArithmeticExpression l, ArithmeticExpression r, Operation o){
        this.leftArithmeticException = l;
        this.rightArithmeticException = r;
        this.operation = o;
    }


    public int calculate(){
        int value = 0;
        switch (this.operation) {
            case ADD:
                value = leftArithmeticException.calculate() + rightArithmeticException.calculate();
                break;
            case SUBTRACT:
                value = leftArithmeticException.calculate() - rightArithmeticException.calculate();
                break;
            case MULTIPLY:
                value = leftArithmeticException.calculate() * rightArithmeticException.calculate();
                break;
            case DIVIDE:
                value = leftArithmeticException.calculate() / rightArithmeticException.calculate();
                break;
            default:
                break;
        }
        return value;
    }
}

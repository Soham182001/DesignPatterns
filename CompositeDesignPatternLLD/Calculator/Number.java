package CompositeDesignPatternLLD.Calculator;

public class Number implements ArithmeticExpression {

    int number;

    public Number(int number){
        this.number = number;
    }

    @Override
    public int calculate(){
        return this.number;
    }
    
}

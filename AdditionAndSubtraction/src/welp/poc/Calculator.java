package welp.poc;

public class Calculator {
    public enum Operator {
        ADDITION,
        SUBTRACT
    }

    public BigNum calculate(BigNum num1, Operator op, BigNum num2) {
        BigNum result;

        switch (op) {
            case ADDITION:
                result = add(num1, num2);
                break;
            case SUBTRACT:
                result = subtract(num1, num2);
                break;
            default:
                throw new java.lang.UnsupportedOperationException("not implemented yet.");
        }

        return result;
    }

    public BigNum add(BigNum num1, BigNum num2){
        throw new java.lang.UnsupportedOperationException("not implemented yet.");
    }

    public BigNum subtract(BigNum num1, BigNum num2){
        throw new java.lang.UnsupportedOperationException("not implemented yet.");
    }
}

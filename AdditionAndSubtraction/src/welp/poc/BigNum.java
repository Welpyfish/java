package welp.poc;

public class BigNum {
    String numString;
    String numSign = "+";

    public BigNum(String num){
        if (num != null && num.trim().length() > 0) {
            boolean isValid = true;
            for(int i=0; i < num.length(); i++) {
                if (i == 0 && (num.charAt(i) == '+' || num.charAt(i) == '-')) {
                    continue;
                }
                if (num.charAt(i) > '9' || num.charAt(i) < '0' ) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                if (num.charAt(0) == '-') {
                    numSign = "-";
                    numString = num.substring(1);
                } else if (num.charAt(0) == '+') {
                    numSign = "+";
                    numString = num.substring(1);
                } else {
                    numString = num;
                }
            } else {
                throw new IllegalArgumentException("Invalid number: big number has invalid character.");
            }
        } else {
            throw new IllegalArgumentException("Invalid number: big number cannot be empty.");
        }
    }

    public void setValue(String sign, String num){
        numString = num;
        numSign = sign;
    }

    public void setValue(String num){
        if (num != null && num.trim().length() > 0) {
            boolean isValid = true;
            for(int i=0; i < num.length(); i++) {
                if (i == 0 && (num.charAt(i) == '+' || num.charAt(i) == '-')) {
                    continue;
                }
                if (num.charAt(i) > '9' || num.charAt(i) < '0' ) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                if (num.charAt(0) == '-') {
                    numSign = "-";
                    numString = num.substring(1);
                } else if (num.charAt(0) == '+') {
                    numSign = "+";
                    numString = num.substring(1);
                } else {
                    numString = num;
                }
            } else {
                throw new IllegalArgumentException("Invalid number: big number has invalid character.");
            }
        } else {
            throw new IllegalArgumentException("Invalid number: big number cannot be empty.");
        }
    }

    public String getNumSign(){
        return numSign;
    }

    public String getNumString() {
        return numString;
    }
    public void switchSign(){
        if(numSign == "+"){
            numSign = "-";
        } else {
            numSign = "+";
        }
    }

    public String getValue() {
        String result = (numSign == "-" ? numSign : "") + numString;
        return result;
    }

    public int compareAbsValue(BigNum num) {
        int result = numString.length() - num.numString.length();

        if (result == 0) {
            result = numString.compareTo(num.numString);
        }

        return result;
    }

    public String toString() {
        return getValue();
    }
}

package welp.poc;

public class BigNum {
    String numString;
    String numSign = "";

    public BigNum(String num){
        checkValidNum(num);
        trimZeros();
    }

    public BigNum(String sign, String num){
        numString = num;
        numSign = sign;
        trimZeros();
    }

    public void setValue(String sign, String num){
        numString = num;
        numSign = sign;
    }

    public void checkValidNum(String num){
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
                    numSign = "";
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

    public void setValue(String num){
        checkValidNum(num);
        trimZeros();
    }

    public String getNumSign(){
        return numSign;
    }

    public String getNumString() {
        return numString;
    }
    public void switchSign(){
        if(numSign == "-"){
            numSign = "";
        } else {
            numSign = "-";
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

    public void trimZeros(){
        for(int i=0; i<numString.length(); i++){
            if(numString.charAt(i) != '0'){
                numString = numString.substring(i);
                break;
            } else {
                if(i == numString.length()-1){
                    numString = "0";
                    numSign = "";
                }
            }
        }
    }

    public String formatNum(){
        String result;
        if(numSign == "-"){
            result = String.format("(%s%s)", numSign, numString);
        } else {
            result = numString;
        }
        return result;
    }

}

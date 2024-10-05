public class Equation {
    String equation;
    String inverted;
    double x;
    double y;

    public Equation(String equation) {
        this.equation = equation;
        this.inverted = "";
        boolean twoLetters = false;
        boolean oneLetter = false;
        String no = "";
        for(int i = 0; i < equation.length(); i++) {
            if(equation.substring(i, i+1).matches("[a-zA-Z]+")) {
                oneLetter = true;
                no = equation.substring(i, i+1);
            }
            if(equation.substring(i, i+1).matches("[a-zA-Z]+") && oneLetter && !(equation.substring(i, i+1).equals(no))) {
                twoLetters = true;
            }    
        }
        if(twoLetters) {
        for (int i = 0; i < equation.length(); i++) {
            if(equation.substring(i, i+1).equals("x")) {
                inverted += "y";
            } else if(equation.substring(i, i+1).equals("y")) {
                inverted += "x";
            } else {
                inverted += equation.substring(i, i+1);
            }
        }
    }
    
    }
    public double inputXOrY(boolean xydeterminer, double input) {
        if(xydeterminer) {
            //replaces x using equation
            return y;
        } else {
            //replaces y using inverted
            return x;
        }
    }

    public double input(double num) {

    }
}


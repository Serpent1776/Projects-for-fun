public class Calculus {
  public Equation derieve(Equation equation) {
        Equation derivative = equation;
        //applies derivative fromulas
        return derivative;
  } 
  public Equation integrate(Equation equation) {
    Equation integrated = equation;
    //applies integral fromulas
    return integrated;
  }
  public Equation piIntegrate(Equation equation) {
    Equation piIntegrated = equation;
    //applies integral fromulas
    return piIntegrated;
  }

  public double solveLimit(Equation limit) {
    double solution = 0;
    return solution;
  }   
  public double solveSigma(int times, double n, double number) {
    double solution = 0;
    return solution;
  }
  public Equation solveSigmaX(int times, double n, Equation equation) {
    Equation solution = equation;
    return solution;
  }
  public Equation breakEXPs(Equation equation) {
    Equation broken = equation;
    //Pascal's triangle bs
    return broken;
  }
    public Equation integralPerimeter(Equation equation) {
        Equation perimeter = equation;
        //applies integral & perimeter fromulas
        return perimeter;
    }
    public Equation integralArea(Equation equation) {
        Equation area = equation;
        //applies integral & area fromulas
        return area;
    }
    public Equation integralSurfaceArea(Equation equation) {
        Equation sufArea = equation;
        //applies integral & surface area fromulas
        return sufArea;
    }
    public Equation integralVolume(Equation equation) {
        Equation volume = equation;
        //applies integral & volume fromulas
        return volume;
    }
    public double Funct(Equation integrated, double start, double end) {
        return start - end;
    }
    public double integrateNFunct(Equation preIntegrated, double start, double end) {
        Equation integrated = integrate(preIntegrated);
        return start - end;
    }
}

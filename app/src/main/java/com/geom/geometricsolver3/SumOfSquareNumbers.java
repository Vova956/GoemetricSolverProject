package com.geom.geometricsolver3;
import java.util.ArrayList;

public class SumOfSquareNumbers {
    private ArrayList<SquareNumber> sum;

    public SumOfSquareNumbers(){
        sum = new ArrayList<>();
    }

    public SumOfSquareNumbers(SquareNumber squareNumber){
        sum = new ArrayList<>();
        sum.add(squareNumber);
    }

    public void addToSum(SquareNumber squareNumber){
        for (int i = 0; i < sum.size(); i++) {
            if(squareNumber.getSquareNumber() == sum.get(i).getSquareNumber()){
                sum.get(i).addToInt(squareNumber.getIntNumber());
                return;
            }
        }
        sum.add(squareNumber);

    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < sum.size(); i++) {
            if(i > 0 || sum.get(0).getIntNumber() < 0){
                if(sum.get(i).getIntNumber() > 0 )
                    stringBuilder.append(" + ");
                else{
                    stringBuilder.append(" - ");
                }
            }
            stringBuilder.append(sum.get(i).getAbsStr());
        }

        return stringBuilder.toString();
    }

    public double toDouble(){
        double buff = 0;
        for (int i = 0; i < sum.size(); i++) {
            buff += sum.get(i).toDouble();
        }
        return buff;
    }

    public boolean canDivide(double a){
        int amount = 0;
        for (int i = 0; i < sum.size(); i++) {
            if(sum.get(i).getIntNumber() % a != 0) {
                return false;
            }
        }


        return true;
    }

    public boolean canDivideSquare(double a){
        int amount = 0;
        for (int i = 0; i < sum.size(); i++) {
            if(sum.get(i).getSquareNumber() % a != 0)
                return false;
        }

        return true;
    }

    public double divide(double a){
        int multiply = 1;
        if(a < 0)
            multiply*=-1;
        for (int i = 2; i <= Math.abs(a); i++) {
            if(a % i == 0 && canDivide(i)){

                for (int j = 0; j < sum.size(); j++) {
                    sum.set(j,sum.get(j).getDivide(i*multiply));
                }

                a/=i;
                i = 1;
            }
        }

        return a*multiply;
    }

    public SquareNumber divide(SquareNumber squareNumber){
        double intNumber  = divide(squareNumber.getIntNumber());

        double sq = squareNumber.getSquareNumber();
        for (int i = 2; i <= sq; i++) {
            if(sq % i == 0 && canDivideSquare(i)){

                for (int j = 0; j < sum.size(); j++) {
                    sum.set(j,sum.get(j).getDivideSquare(i));
                }

                sq/=i;
                i = 1;
            }
        }

        return new SquareNumber(intNumber,sq);
    }

    public int getSize(){return sum.size();}

    public SquareNumber get(int index){return sum.get(index);}

    public SumOfSquareNumbers copy(){
        SumOfSquareNumbers sumOfSquareNumbers = new SumOfSquareNumbers();
        for (int i = 0; i < sum.size(); i++) {
            sumOfSquareNumbers.addToSum(sum.get(i));
        }
        return sumOfSquareNumbers;
    }

}
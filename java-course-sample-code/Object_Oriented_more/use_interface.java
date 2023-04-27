package Object_Oriented_more;
interface IFigure{
    double getArea();
    double getCircumference();
}
class Circle implements IFigure{
    private double r;
    Circle(double r){
        this.r=r;
    }
    @Override
    public double getArea() {
        return Math.PI*r*r;
    }

    @Override
    public double getCircumference() {
        return 2*Math.PI*r;
    }
}

public class use_interface {
}

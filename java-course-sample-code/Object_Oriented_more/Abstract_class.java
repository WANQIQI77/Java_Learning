package Object_Oriented_more;
abstract class Figure{
    private String name;
    Figure(String name){
        this.name=name;
    }
    String getName(){
        return name;
    }
    abstract double getArea();
}
class Rectangle extends Figure{
    private double width;
    private double height;

    Rectangle(String name,double width,double height) {
        super(name);
        this.height=height;
        this.width=width;
    }

    @Override
    double getArea() {
        return width*height;
    }
}


public class Abstract_class {
}

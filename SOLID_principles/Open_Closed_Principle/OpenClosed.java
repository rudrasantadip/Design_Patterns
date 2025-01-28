// we define an interface called Shape

interface Shape {
    Double findArea();
}

/*
now we can define shapes like rectangle and circle, 
implement the shape interface and modify it according to our requirement
*/ 

class Circle implements Shape
{
    private Integer radius;

    public Circle(Integer radius){
        this.radius=radius;
    }

    /*
     * We defined the find area method according to our needs
     */
    @Override
    public Double findArea() {
       return 3.14*radius*radius;
    }

}

class Rectangle implements Shape
{

    private Double height;
    private Double width;

    public Rectangle(Double height, Double width)
    {
        this.height=height;
        this.width=width;
    }

    @Override
    public Double findArea() {
        return height*width;
    }

}

public class OpenClosed {
    public static void main(String[] args) {
        
    }
}

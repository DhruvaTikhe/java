class Shapes
{
    double area;
    Shapes(){
        area = 0.0;
        //default constructor
    }

    //following are parameterised constructor
    Shapes(double side) //square
    {
        area = side*side;
        System.out.println("Area of Square: "+area);
    }

    Shapes(double l, double b)   //rectangle
    {
        area = l* b;
        System.out.println("Area of Rectangle: "+area);
    }

    Shapes(double radius, boolean circle) //circle (boolean needed to identify between square and circle)
    {
        area = 3.14 * (radius * radius);
        System.out.println("Area of Circlee: "+area);
    }

    //method overloading
    void calcAreaOfShapes(int side)    //square
    {
        System.out.println("Area of Square: " + (side * side));
    }

    void calcAreaOfShapes(int length, int breadth)     //rectangle
    {
        System.out.println("Area of Rectangle: " + (length * breadth));
    }

    void calcAreaOfShapes(double radius) //circle (parameter datatypes are diff so like we dont need boolean paramter)
    {
        System.out.println("Area of Circlee: " + (3.14 * (radius * radius)));
    }

    public static void main(String args[])
    {
        System.out.println("Using Constructors: ");
        Shapes sh1 = new Shapes(10);
        Shapes sh2 = new Shapes(6,2);
        Shapes sh3 = new Shapes(5,true);
        
        System.out.println("\nUsing Methods: ");

        Shapes shapeObj = new Shapes();
        shapeObj.calcAreaOfShapes(10);
        shapeObj.calcAreaOfShapes(6, 2);
        shapeObj.calcAreaOfShapes(5.0);
    }
}
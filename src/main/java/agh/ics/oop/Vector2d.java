package agh.ics.oop;

public class Vector2d {
    public final int x;
    public final int y;


    public Vector2d(int x,int y) {
        this.x = x;
        this.y = y;

    }


    public boolean precedes(Vector2d other){
        return (this.x <= other.x) && (this.y <= other.y);

    }
    public boolean follows(Vector2d other){
        return (this.x >= other.x) && (this.y >= other.y);

    }
    public Vector2d add(Vector2d other){
        return new Vector2d(this.x + other.x,this.y + other.y);
    }
    public Vector2d subtract(Vector2d other){
        return new Vector2d(this.x - other.x,this.y - other.y);
    }
    //Dodaj math
    public Vector2d upperRight(Vector2d other){
        int max_x = 0;
        int max_y = 0;
        if (this.x > other.x) max_x = this.x;
        else max_x = other.x;
        if (this.y > other.y) max_y = this.y;
        else max_y = other.y;

        return new Vector2d(max_x,max_y);
    }
    public Vector2d lowerLeft(Vector2d other)
    {
        int min_x = 0;
        int min_y = 0;
        if (this.x < other.x) min_x = this.x;
        else min_x = other.x;
        if (this.y < other.y) min_y = this.y;
        else min_y = other.y;

        return new Vector2d(min_x,min_y);
    }
    public Vector2d opposite()
    {
        return new Vector2d(-this.x,-this.y);
    }

    public boolean equals(Object other)
    {
        Vector2d that = (Vector2d) other;
        if (this.x == that.x && this.y == that.y)
            return true;
        return false;


    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")" ;
    }
}

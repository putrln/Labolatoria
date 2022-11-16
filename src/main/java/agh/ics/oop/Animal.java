package agh.ics.oop;

public class Animal {


    private MapDirection Orientation = MapDirection.NORTH;
    private Vector2d Position = new Vector2d(2,2);


    @Override
    public String toString() {
        return "Orientation: " + this.Orientation + " Position: " + this.Position;
    }

    public Boolean isAt(Vector2d position) {
        return this.Position.equals(position);

    }

    public MapDirection getOrientation() {
        return Orientation;
    }

    public void move(MoveDirection direction)
    {
        //zm
        if (direction == MoveDirection.RIGHT)
            this.Orientation = this.Orientation.next();
        else if (direction == MoveDirection.LEFT)
            this.Orientation = this.Orientation.previous();


        else  {
            this.Position = switch (this.Orientation) {
                case NORTH -> {
                    if (direction == MoveDirection.FOWARD) {
                        if (this.Position.y != 4) yield new Vector2d(this.Position.x, this.Position.y + 1);
                        else yield this.Position;
                    } else {
                        if (this.Position.y != 0) yield new Vector2d(this.Position.x, this.Position.y - 1);
                        else yield this.Position;
                    }
                }
                case SOUTH -> {
                    if (direction == MoveDirection.FOWARD) {
                        if (this.Position.y != 0) yield new Vector2d(this.Position.x, this.Position.y - 1);
                        else yield this.Position;
                    } else {
                        if (this.Position.y != 4) yield new Vector2d(this.Position.x, this.Position.y + 1);
                        else yield this.Position;
                    }
                }
                case WEST ->{
                if (direction == MoveDirection.FOWARD) {
                    if (this.Position.x != 0) yield new Vector2d(this.Position.x - 1, this.Position.y);
                    else yield this.Position;
                } else {
                    if (this.Position.x != 4) yield new Vector2d(this.Position.x + 1, this.Position.y);
                    else yield this.Position;
                }
            }
                case EAST -> {
                    if (direction == MoveDirection.FOWARD) {
                        if (this.Position.x != 4) yield new Vector2d(this.Position.x + 1, this.Position.y);
                        else yield this.Position;
                    } else {
                        if (this.Position.x != 0) yield new Vector2d(this.Position.x - 1, this.Position.y);
                        else yield this.Position;
                    }
                }
            };
        }
    }



}

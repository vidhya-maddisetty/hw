public class Person{
    private String name;
    private Turtle turtle;
    public Person (String n){
	name = n;
    }
    public void setTurtle(Turtle t){
	turtle = t;
    }
    public Turtle getPet(){
	return turtle;
    }
    public int getTurtleSpeed(){
	return turtle.getSpeed();
    }
}

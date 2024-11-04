class Ball{
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;
    private int speed;
    private int direction;

    public Ball(float x, float y, int radius,int speed, int direction){
        if(direction<=180||direction>=-180){
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.speed = speed;
            this.direction = direction;
        } else {
            System.out.println("Invalid direction");
        }
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    // Getter and Setter for y
    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    // Getter and Setter for radius
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    // Getter and Setter for xDelta
    public float getXDelta() {
        return this.xDelta = (float) (speed * Math.cos(direction));
    }

    public void setXDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    // Getter and Setter for yDelta
    public float getYDelta() {
        return this.yDelta = (float) (-speed * Math.sin(direction));
    }

    public void setYDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    public void move(){
        this.x += xDelta;
        this.y += yDelta;
    }

    public void reflectHorizontal(){
        this.xDelta = -xDelta;
    }

    public void reflectVertical(){
        this.yDelta = -yDelta;
    }

    public String toString(){
        return  "Ball at ("+x+","+ y+") of velocity ("+xDelta+","+yDelta+")";
    }
}
public class Ex3_06 {
        public static void main(String[] args) {
            // Test Case 1: Create a Ball with valid direction
            Ball ball = new Ball(10.0f, 20.0f, 5, 2, 45);
            System.out.println(ball);
            System.out.println("Test Case 1: Create a Ball with valid direction");
            System.out.println("Expected: ");
            System.out.println("    x = 10.0, y = 20.0, radius = 5, speed = 2, direction = 45");
            System.out.println("    xDelta = 1.4142135, yDelta = -1.4142135");
            System.out.println("Actual: ");
            System.out.println("    x = " + ball.getX() + ", y = " + ball.getY() + ", radius = " + ball.getRadius());
            System.out.println("    xDelta = " + ball.getXDelta() + ", yDelta = " + ball.getYDelta());
            System.out.println();

            // Test Case 2: Create a Ball with invalid direction
            Ball invalidBall = new Ball(10.0f, 20.0f, 5, 2, 190);
            System.out.println("Test Case 2: Create a Ball with invalid direction");
            System.out.println("Expected: ");
            System.out.println("    Invalid direction message printed");
            System.out.println("Actual: ");
            System.out.println("    x = " + invalidBall.getX() + ", y = " + invalidBall.getY() + ", radius = " + invalidBall.getRadius());
            System.out.println();

            // Test Case 3: Move the Ball
            float initialX = ball.getX();
            float initialY = ball.getY();
            ball.move();
            System.out.println("Test Case 3: Move the Ball");
            System.out.println("Expected: ");
            System.out.println("    Ball position updated");
            System.out.println("Actual: ");
            System.out.println("    Initial position: x = " + initialX + ", y = " + initialY);
            System.out.println("    Updated position: x = " + ball.getX() + ", y = " + ball.getY());
            System.out.println();

            // Test Case 4: Reflect the Ball horizontally
            float originalXDelta = ball.getXDelta();
            ball.reflectHorizontal();
            System.out.println("Test Case 4: Reflect the Ball horizontally");
            System.out.println("Expected: ");
            System.out.println("    Ball's horizontal velocity reversed");
            System.out.println("Actual: ");
            System.out.println("    Original xDelta: " + originalXDelta);
            System.out.println("    Updated xDelta: " + ball.getXDelta());
            System.out.println();

            // Test Case 5: Reflect the Ball vertically
            float originalYDelta = ball.getYDelta();
            ball.reflectVertical();
            System.out.println("Test Case 5: Reflect the Ball vertically");
            System.out.println("Expected: ");
            System.out.println("    Ball's vertical velocity reversed");
            System.out.println("Actual: ");
            System.out.println("    Original yDelta: " + originalYDelta);
            System.out.println("    Updated yDelta: " + ball.getYDelta());
            System.out.println();

            // Test Case 6: String representation of the Ball
            String ballString = ball.toString();
            System.out.println("Test Case 6: String representation of the Ball");
            System.out.println("Expected: ");
            System.out.println("    Ball at (x,y) of velocity (xDelta,yDelta)");
            System.out.println("Actual: ");
            System.out.println("    " + ballString);
            System.out.println();
        }
}

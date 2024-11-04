class theBall{
    private float x;
    private float y;
    private float z;

    public theBall( float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public void setXYZ(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String toString(){
        return "("+x+","+y+","+z+")";
    }
}

class Player{
    private int number;
    private float x;
    private float y;
    private float z = 0.0f;
    private float xDisp;
    private float yDisp;
    private float zDisp;

    public Player(int number, float x, float y){
        this.number = number;
        this.x = x;
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public float getY() {
        return y;
    }

    public float getX() {
        return x;
    }

    public void move(float xDisp, float yDisp){
        x += xDisp;
        y += yDisp;
    }

    public void jump(float zDisp){
        z += zDisp;
    }

    public boolean near(Ball ball){
        if (ball.getX() < 8){
            return true;
        }
        if (ball.getY() < 8) {
            return true;
        }
        else {
            return false;
        }
    }
}
public class Ex3_07 {
}

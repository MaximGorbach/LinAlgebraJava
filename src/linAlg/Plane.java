package linAlg;

public class Plane {
    public Vector p1;
    public Vector norm;

    public Plane(Vector p1, Vector norm){
        this.p1 = p1;
        this.norm = norm;
    }

    public String toString(){
        String res = "Plane at: " + p1.toString() + "with norm: " + norm.toString();
        return res;
    }
}
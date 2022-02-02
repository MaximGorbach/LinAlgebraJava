package linAlg;

public class Line {
    public Vector p1;
    public Vector p2;

    public Line(Vector p1, Vector p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public Vector intersect(Plane p){
        Vector u = p2.sub(p1);
        Vector w = p1.sub(p.p1);
        float D = p.norm.dot(u);
        float N = -p.norm.dot(w);
        
        if(Math.abs(D) < Float.MIN_VALUE){ return null;}
        float sI = N / D;
        if(sI < 0 || sI > 1){ return null;}
        return p1.add(u.mul(sI));
    }

    //used if you want to expose the sI value
    public VectorFloatPair intersectDetailed(Plane p){
        Vector u = p2.sub(p1);
        Vector w = p1.sub(p.p1);
        float D = p.norm.dot(u);
        float N = -p.norm.dot(w);
        
        if(Math.abs(D) < Float.MIN_VALUE){ return null;}
        float sI = N / D;
        if(sI < 0 || sI > 1){ return null;}
        VectorFloatPair res = new VectorFloatPair(p1.add(u.mul(sI)),sI);
        return res;
    }

    public String toString(){
        String res = "Line at: " + p1.toString() + ", " + p2.toString();
        return res;
    }
}

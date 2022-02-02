package linAlg;

public class Vector {
    public Float x;
    public Float y;
    public Float z;

    public Vector(Float x, Float y, Float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(Float x, Float y){
        this.x = x;
        this.y = y;
        this.z = 0f;
    }

    public Vector(Integer x, Integer y, Integer z){
        this.x = (float) x;
        this.y = (float) y;
        this.z = (float) z;
    }

    public Vector(Integer x, Integer y){
        this.x = (float) x;
        this.y = (float) y;
        this.z = 0.0f;
    }

    public Vector add(Vector other){
        Vector res = new Vector(x + other.x, y + other.y, z + other.z);
        return res;
    }

    public void addTo(Vector other){
        x = x + other.x;
        y = y + other.y;
        z = z + other.z;
    }

    public Vector sub(Vector other){
        return this.add(other.mul(-1));
    }

    public void subFrom(Vector other){
        x = x - other.x;
        y = y - other.y;
        z = z - other.z;
    }

    public Vector mul(int num){
        Vector res = new Vector(x * num, y * num, z * num);
        return res;
    }

    public void mulBy(int num){
        x = x*num;
        y = y*num;
        z = z*num;
    }

    public void mulBy(float num){
        x = x*num;
        y = y*num;
        z = z*num;
    }

    public Vector mul(Float num){
        Vector res = new Vector(x * num, y * num, z * num);
        return res;
    }

    public Float dot(Vector other){
        Float res = x*other.x + y*other.y + z*other.z;
        return res;
    }

    public Vector cross(Vector other){
        Float x = this.y*other.z - this.z*other.y;
        Float y = this.z*other.x - this.x*other.z;
        Float z = this.x*other.y - this.y*other.x;
        Vector res = new Vector(x,y,z);
        return res;
    }

    public Vector unit(){
        Float mag = (float) Math.pow(this.dot(this),0.5);
        return this.mul(1/mag);
    }

    public Vector copy(){
        return new Vector(this.x,this.y,this.z);
    }

    public String toString(){
        String res = String.format("(%f, %f, %f)",x,y,z);
        return res;
    }
}

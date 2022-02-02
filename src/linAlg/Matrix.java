package linAlg;

public class Matrix {
    public int rows;
    public int cols;
    public Float[][] data;

    public Matrix(Float[][] data){
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = data;
    }

    public Matrix mul(Float num){
        Matrix res = new Matrix(this.data);
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.cols; j++){
                res.data[i][j] *= num;
            }
        }
        return res;
    }

    public Matrix mul(int num){
        return this.mul((float) num);
    }

    public Matrix mul(Matrix other){
        Float[][] data = new Float[this.rows][other.cols];
        Float num;
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < other.cols; j++){
                num = 0.0f;
                for(int count = 0; count < this.cols; count++){
                    num += this.data[i][count]*other.data[count][j];
                }
                data[i][j] = num;
            }
        }
        Matrix res = new Matrix(data);
        return res;
    }

    public Matrix add(Matrix other){
        if(this.rows != other.rows || this.cols != other.cols){
            return null;
        }
        Matrix res = new Matrix(this.data);
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.cols;j++){
                res.data[i][j] += other.data[i][j];
            }
        }
        return res;
    }

    public Matrix sub(Matrix other){
        return this.add(other.mul(-1));
    }

    public Float minor(int row, int col){
        Float[][] tempData = new Float[this.rows-1][this.cols-1];
        Float[] tempRow = new Float[this.cols-1];
        int rowCount = 0;
        int dataCount = 0;
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.cols; j++){
                if(i != row && j != col){
                    tempRow[rowCount++] = this.data[i][j];
                    if(rowCount >= tempRow.length){
                        tempData[dataCount++] = tempRow;
                        tempRow = new Float[this.cols-1];
                        rowCount = 0;
                    }
                }
            }
        }
        Matrix minor = new Matrix(tempData);
        return minor.det();
    }

    public Float det(){
        if(this.rows != this.cols){ return 0.0f; }
        if(this.rows == 1){
            return this.data[0][0];
        }
        Float det = 0.0f;
        for(int i = 0; i < this.cols; i++){
            det += (float) Math.pow(-1,i) * this.data[0][i] * this.minor(0,i);
        }
        return det;
    }

    public Matrix transpose(){
        Float[][] data = new Float[this.cols][this.rows];
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.cols; j++){
                data[j][i] = this.data[i][j];
            }
        }
        Matrix res = new Matrix(data);
        return res;
    }

    public Matrix inverse(){
        Float det = this.det();
        if(det == 0){ return null; }
        Float[][] data = new Float[this.rows][this.cols];
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.cols; j++){
                data[i][j] = (float) Math.pow(-1,i+j) * this.minor(i,j);
            }
        }
        Matrix res = new Matrix(data);
        System.out.println(1/det);
        
        res = res.mul(1/det);
        return res.transpose();
    }

    public String toString(){
        String res = "";
        for(int i = 0; i < this.rows; i++){
            res += "[";
            for(int j = 0; j < this.cols; j++){
                res += " " + data[i][j].toString();
            }
            res += "]\r\n";
        }
        return res;
    }

    public static void main(String[] args){
        Matrix m;
        Float[][] data = new Float[][]{{1.0f,2.0f,3.0f},{4.0f,5.0f,4.0f},{3.0f,2.0f,1.0f}};
        m = new Matrix(data);
        System.out.println(m.inverse());
    }
}
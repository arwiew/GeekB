package Lesson_2;

public class MyArrayDataException extends Exception {
    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public void setA(int a) {
        this.i = a;
    }

    public void setB(int b) {
        this.j = b;
    }

    public int i;
    public int j;

    public MyArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;

    }

}


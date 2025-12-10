package step3;

public class Operand<T> {
    private T item;

    public Operand(T item){
        this.item = item;
    }

    public T getItem(){
        return item;
    }
}

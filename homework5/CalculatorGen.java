package HomeWork5;

public class CalculatorGen<T extends CalculatorWith> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

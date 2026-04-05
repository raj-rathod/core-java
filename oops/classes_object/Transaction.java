package oops.classes_object;

public class Transaction {
    String trader;
    int year;
    int value;

    public Transaction(String trader, int year, int value){
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public String getTrader() {
        return trader;
    }

    public int getValue() {
        return value;
    }
    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "Trader=" + trader +
                ", Year='" + year + '\'' +
                ", Value=" + value + '\'' +
                '}';
    }
}

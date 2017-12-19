package entity;

public class Car implements Comparable<Car> {

    private String model;
    private String brand;
    private int Id;
    private int serialNumber;
    private static int id=0;

    /**
     * Конструктор
     * @param model модель машины
     * @param serialNumber серийный номер
     */
    public Car(String brand, String model, int serialNumber){
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
        id++;
        this.Id = id;
    }

    public int getId(){
        return Id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public  void setModel(String model){
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setSerialNumber(int serialNumber){
        this.serialNumber = serialNumber;
    }

    public int getSerialNumber(){
        return serialNumber;
    }

    public String toString(){
        return "ID: "+getId() +"\nBrand: "+getBrand() +"\nModel: "+getModel() +"\nSerial number: "+getSerialNumber();
    }

    public int compareTo(Car o) {
        return 0;
    }

}


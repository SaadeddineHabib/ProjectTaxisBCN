package src.objects.carmodeldao;

public class CarModel {
    private int id;
    private int brand;
    private String name;

    public CarModel(int id, int brand, String name) {
        this.id = id;
        this.brand = brand;
        this.name = name;
    }

    public CarModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "carModel{" +
                "id=" + id +
                ", brand=" + brand +
                ", name='" + name + '\'' +
                '}';
    }
}

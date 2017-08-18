package udemy.masterOOdesign.ems.builder;

/**
 * Created by mayank.gupta on 19/05/17.
 */
public class Vehicle {

    private String color;
    private String modelName;
    private double price;
    private int doors;
    private String engineName;
    private String companyName;

    private Vehicle(Builder builder) {
        this.color = builder.color;
        this.companyName = builder.companyName;
        this.doors = builder.doors;
        this.engineName = builder.engineName;
        this.modelName = builder.modelName;
        this.price = builder.price;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "color='" + color + '\'' +
                ", modelName='" + modelName + '\'' +
                ", price=" + price +
                ", doors=" + doors +
                ", engineName='" + engineName + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }

    public static class Builder {
        private String color;
        private String modelName;
        private double price;
        private int doors;
        private String engineName;
        private String companyName;

        public Builder(String modelName, double price) {
            this.modelName = modelName;
            this.price = price;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder doors(int doors) {
            this.doors = doors;
            return this;
        }

        public Builder engineName(String engineName) {
            this.engineName = engineName;
            return this;
        }

        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(this);
        }

    }
}

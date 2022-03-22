package Entity;

import lombok.Builder;
import lombok.ToString;

@Builder(setterPrefix = "with", builderClassName = "CarIndustry", buildMethodName = "create")
@ToString
public class Car {
    private String brand;
    private String color;
    private String body;
    private Double v;

    public static class CarIndustry {
        public CarIndustry() {
        }
    }
}
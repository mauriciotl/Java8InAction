package lambdasinaction.chap2.mauPractice.domain;

public class Apple {

    // These are protected in order to not use the same
    // for the ones in another package, that can possible exist.
    protected int weight = 0;
    protected String color = "";


    public Apple(int weight, String color){
        this.weight = weight;
        this.color = color;
    }


    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }

}

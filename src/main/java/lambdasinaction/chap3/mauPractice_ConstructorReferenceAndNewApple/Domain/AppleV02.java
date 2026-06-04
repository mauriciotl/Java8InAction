package lambdasinaction.chap3.mauPractice_ConstructorReferenceAndNewApple.Domain;

public class AppleV02 {

  private int weight = 0;
  private Color color;

  //Using a predifined color, it would look like the following:
//  private Color color = Color.RED;

  public AppleV02(){
  }

  public AppleV02(int weight){
    this.weight = weight;
  }

  public AppleV02(int weight, Color color) {
    this.weight = weight;
    this.color = color;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  @SuppressWarnings("boxing")
  @Override
  public String toString() {
    return String.format("Apple{color=%s, weight=%d}", color, weight);
  }

}
public class Circulo extends Figura {
  private float radio;

  /**
   * Class Constructor
   * @pre radio > 0
   * @post creates a circle object
   */
  public Circulo(float radio) {
    if (radio <= 0)
      throw new IllegalArgumentException("radio must be > 0");

    this.radio = radio;
  }

  public float getRadio() {
    return this.radio;
  }

  /// Override abstract methods

  /**
   * Calcula el área del Circulo
   *  @pre true
   *  @returns area
   */
  @Override
  public float area() {
    // Pi * radio²
    return (float) (Math.PI * Math.pow(radio, 2));
  }

  /**
   * Calcula el perímetro del circulo
   *  @pre true
   *  @returns perimeter
   */
  @Override
  public float perimetro() {
    return (float) (2 * Math.PI * this.radio);
  }
}

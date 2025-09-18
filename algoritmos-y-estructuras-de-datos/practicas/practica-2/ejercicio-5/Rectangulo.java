public class Rectangulo extends Figura {
  private float ancho;
  private float alto;

  /**
   * Class Constructor
   * @pre alto > 0 && ancho > 0
   * @post creates a square object
   */
  public Rectangulo(float ancho, float alto) {
    if (ancho <= 0 || alto <= 0)
      throw new IllegalArgumentException("lado must be > 0");

    this.alto = alto;
    this.ancho = ancho;
  }

  public float getAncho() {
    return this.ancho;
  }

  public float getAlto() {
    return this.alto;
  }


  /// Override abstract methods

  /**
   * Calcula el área del Rectangulo
   *  @pre true
   *  @returns area
   */
  @Override
  public float area() {
    return (float) (this.alto * this.ancho);
  }

  /**
   * Calcula el perímetro del rectangulo
   *  @pre true
   *  @returns perimeter
   */
  @Override
  public float perimetro() {
    return (float) (2 * this.ancho + 2 * this.alto);
  }
}

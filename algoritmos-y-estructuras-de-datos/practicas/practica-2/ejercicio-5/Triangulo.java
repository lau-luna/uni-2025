public class Triangulo extends Figura {
  private float base;
  private float altura;
  private float lado1;
  private float lado2;
  private float lado3;

  /**
   * Class Constructor
   * @pre alto > 0 && altura > 0 && lado 1 > 0 && lado2 > 0 && lado3 > 0
   * @post creates a triangle object
   */
  public Triangulo(float base, float altura, float lado1, float lado2, float lado3) {
    if (base <= 0 || altura <= 0 || lado1 <= 0 || lado2 <= 0 || lado3 <= 0)
      throw new IllegalArgumentException("base && altura && lado1 && lado2 && lado3 must be > 0");

    this.base = base;
    this.altura = altura;
    this.lado1 = lado1;
    this.lado2 = lado2;
    this.lado3 = lado3;
  }

  public float getBase() {
    return this.base;
  }

  public float getAltura() {
    return this.altura;
  }

  public float getLado1() {
    return this.lado1;
  }

  public float getLado2() {
    return this.lado2;
  }
  
  public float getLado3() {
    return this.lado3;
  }

  /// Override abstract methods

  /**
   * Calcula el área del triangulo
   *  @pre true
   *  @returns area
   */
  @Override
  public float area() {
    // Pi * radio²
    return (float) ((this.base * this.altura) / 2);
  }

  /**
   * Calcula el perímetro del triangulo
   *  @pre true
   *  @returns perimeter
   */
  @Override
  public float perimetro() {
    return (float) (this.lado1 + this.lado2 + this.lado3);
  }
}

public class Main {
  public static void main(String[] args) {
    // Estudiante e1 = new Estudiante(46848650, "Lautaro", "Luna", true, 0, 0); 

    Persona[] arr = new Persona[] { 
      new Estudiante(46848650, "Lautaro", "Luna", true),
      new Estudiante(12398237, "Juan", "Pérez", true),
      new Persona(233434, "Jorge", "López"),
    };

    ((Estudiante) arr[0]).aproboMateria(10);
    ((Estudiante) arr[1]).aproboMateria(8);
    ((Estudiante) arr[1]).aproboMateria(4);
    
    
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i].getInfo());
    }
  }
}

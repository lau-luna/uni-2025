public Estudiante {
    private String nombre;
    private String apellido;
    private int id;
    private boolean esRegular;

    public Estudiante(String nombre, String apellido, int id, boolean esRegular) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("nombre nulo o vacio");
        
        if (apellido == null || apellido.trim().isEmpty())
            throw new IllegalArgumentException("apellido nulo o invalido");

        if (id <= 0)
            throw new IllegalArgumentException("id no puede ser <= 0");
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.esRegular = esRegular;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }
     
    public int getId(){
        return id;
    }

    public boolean getEsRegular(){
        return esRegular;
    }

    public void toString(){
    if (esRegular) {
        return id + ": " + apellido + ", " + nombre;
    } else {
        return id + ": " + apellido + ", " + nombre + " (aspirante)";
    }
}
}

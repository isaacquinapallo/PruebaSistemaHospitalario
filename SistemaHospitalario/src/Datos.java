public class Datos {
    String cedula;
    String n_historial_clinico;
    String nombre;
    String apellido;
    String telefono;
    String edad;
    String descripcion_enfermedad;

    public  Datos(){}
    public Datos(String cedula, String n_historial_clinico, String nombre, String apellido, String telefono, String edad, String descripcion_enfermedad) {
        this.cedula = cedula;
        this.n_historial_clinico = n_historial_clinico;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.edad = edad;
        this.descripcion_enfermedad = descripcion_enfermedad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getN_historial_clinico() {
        return n_historial_clinico;
    }

    public void setN_historial_clinico(String n_historial_clinico) {
        this.n_historial_clinico = n_historial_clinico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDescripcion_enfermedad() {
        return descripcion_enfermedad;
    }

    public void setDescripcion_enfermedad(String descripcion_enfermedad) {
        this.descripcion_enfermedad = descripcion_enfermedad;
    }
}

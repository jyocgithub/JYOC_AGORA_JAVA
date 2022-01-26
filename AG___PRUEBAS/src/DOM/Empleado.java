package DOM;

public class Empleado {
    String codigoEmpleado;
    String nombreEmpleado;
    String apellidoEmpleado;
    String codDpto;

    public Empleado() {    }

    public Empleado(String codigoEmpleado, String nombreEmpleado,
                    String apellidoEmpleado, String codDpto) {
        this.codigoEmpleado = codigoEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidoEmpleado = apellidoEmpleado;
        this.codDpto = codDpto;
    }

    public String getCodigoEmpleado() { return codigoEmpleado; }
    public String getNombreEmpleado() { return nombreEmpleado; }
    public String getApellidoEmpleado() {return apellidoEmpleado; }
    public String getCodDpto() { return codDpto; }
    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }
    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }
    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }
    public void setCodDpto(String codDpto) {
        this.codDpto = codDpto;
    }

}

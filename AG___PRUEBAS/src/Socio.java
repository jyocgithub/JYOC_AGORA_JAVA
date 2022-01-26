public class  Socio {
	private String nombre;

	public Socio() {

	}

	private int antiguedad;

	public Socio(String nombre, int antiguedad) {

		this.nombre = nombre;
		this.antiguedad = antiguedad;
	}

	@Override
	public  String toString() {
		return "Socio [nombre=" + nombre + ", antig�edad=" + antiguedad + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
}

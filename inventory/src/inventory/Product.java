package inventory;

public class Product {
	// Instance field declarations
	private int numeroElemento;
	private String nombreDelProducto;
	private int numeroDeUnidadesEnExistencia;
	private double precioDeCadaUnidad;

	// Constructor sin parametros
	public Product() {
		this.numeroElemento = 0;
		this.nombreDelProducto = "";
		this.numeroDeUnidadesEnExistencia = 0;
		this.precioDeCadaUnidad = 0.0;
	}

	// Constructor sobrecargado con parametros
	public Product(int number, String name, int qty, double price) {
		this.numeroElemento = number;
		this.nombreDelProducto = name;
		this.numeroDeUnidadesEnExistencia = qty;
		this.precioDeCadaUnidad = price;
	}
	// Getter y Setter

	// get and set numeroElemento
	// GET
	public int getNumeroElemento() {
		return numeroElemento;
	}

	// SET
	public void setNumeroElemento(int numeroElemento) {
		this.numeroElemento = numeroElemento;
	}

	// get and set nombreDelProducto
	// GET
	public String getNombreDelProducto() {
		return nombreDelProducto;
	}

	// SET
	public void setNombreDelProducto(String nombreDelProducto) {
		this.nombreDelProducto = nombreDelProducto;
	}

	// get and set numeroDeUnidadesEnExistencia
	// GET
	public int getNumeroDeUnidadesEnExistencia() {
		return numeroDeUnidadesEnExistencia;
	}

	// SET
	public void setNumeroDeUnidadesEnExistencia(int numeroDeUnidadesEnExistencia) {
		this.numeroDeUnidadesEnExistencia = numeroDeUnidadesEnExistencia;
	}

	// get and set precioDeCadaUnidad
	// GET
	public double getPrecioDeCadaUnidad() {
		return precioDeCadaUnidad;
	}

	// SET
	public void setPrecioDeCadaUnidad(double precioDeCadaUnidad) {
		this.precioDeCadaUnidad = precioDeCadaUnidad;
	}
	
	// Metodo toString
	public String toString() {
		return "Item del Producto: " + numeroElemento + "\n" +
				"Name: " + nombreDelProducto + "\n" +
				"Unidades Existentes: " + numeroDeUnidadesEnExistencia + "\n" +
				"Precio Unidad: " + String.format("%.2f", precioDeCadaUnidad); 
	}
}
package CapaLogica;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Vector;

public class Ejemplar {
	private int codigo;
	private String estadoFisico;
	private LocalDate fechaIngreso;
	private String condicionActual;
	// Atributos de relaciones
	private Libro libro;
	// Persistencia
	private String idLibro;
	
	public Ejemplar(String pidLibro, int pcodigo, String pestadoFisico, LocalDate pfechaIngreso, String pcondicionActual){
		setIdLibro(pidLibro);
		setCodigo(pcodigo);
		setEstadoFisico(pestadoFisico);
		setFechaIngreso(pfechaIngreso);
		setCondicionActual(pcondicionActual);
		
		libro = null;
	}

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the estado
	 */
	public String getEstadoFisico() {
		return estadoFisico;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstadoFisico(String estado) {
		this.estadoFisico = estado;
	}

	/**
	 * @return the fechaIngreso
	 */
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	/**
	 * @param fechaIngreso the fechaIngreso to set
	 */
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	/**
	 * @return the condicionActual
	 */
	public String getCondicionActual() {
		return condicionActual;
	}

	/**
	 * @param condicionActual the condicionActual to set
	 */
	public void setCondicionActual(String condicionActual) {
		this.condicionActual = condicionActual;
	}

	/**
	 * @return the idLibro
	 */
	public String getIdLibro() {
		return idLibro;
	}

	/**
	 * @param idLibro the idLibro to set
	 */
	public void setIdLibro(String idLibro) {
		this.idLibro = idLibro;
	}
	
	public Libro obtenerLibro() throws SQLException, Exception {
		libro = new MultiLibro().buscar(getIdLibro());
		return libro;
	}
	
	public String obtenerISBN() {
		return getIdLibro();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ejemplar [codigo=" + codigo + ", estadoFisico=" + estadoFisico
				+ ", fechaIngreso=" + fechaIngreso + ", condicionActual="
				+ condicionActual + ", libro=" + libro + ", idLibro=" + idLibro
				+ "]";
	}
	
	

}

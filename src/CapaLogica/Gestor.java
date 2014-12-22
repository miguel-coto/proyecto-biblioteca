package CapaLogica;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Vector;

public class Gestor {
	/* -------------------------- Autor -------------------------- */
	public void crearAutor(String pid, String pnombre, String papellido, String pdirElectronica, 
			String pnacionalidad, String ppaisOrigen) throws Exception {
		
		Autor autor;
		autor = (new MultiAutor()).crear(pid, pnombre, papellido, pdirElectronica, pnacionalidad, ppaisOrigen);
	}
	
	public void modificarAutor(String pid, String pnombre, String papellido, String pdirElectronica, 
			String pnacionalidad, String ppaisOrigen) throws Exception {
		
		Autor autor;
		autor = (new MultiAutor()).buscar(pid);

		autor.setNombre(pnombre);
		autor.setApellido(papellido);
		autor.setDirElectronica(pdirElectronica);
		autor.setNacionalidad(pnacionalidad);
		autor.setPaisOrigen(ppaisOrigen);
		
		(new MultiAutor()).modificar(autor);
	}
	
	public void eliminarAutor(String pid) throws Exception {
		Autor autor;
		autor = (new MultiAutor()).buscar(pid);
		
		(new MultiAutor()).eliminar(autor);
	}
	
	public Vector listarAutores() throws Exception {
		Autor autor;
		Vector listaAutores = new Vector();		
		Vector autores = (new MultiAutor()).listar();
		
		for (int i = 0; i < autores.size(); i++) {
			autor = ((Autor) autores.get(i));
			TreeMap datosAutor = new TreeMap();
			datosAutor.put("id", autor.getId());
			datosAutor.put("nombre", autor.getNombre());
			datosAutor.put("apellido", autor.getApellido());
			datosAutor.put("dirElectronica", autor.getDirElectronica());
			datosAutor.put("nacionalidad", autor.getNacionalidad());
			datosAutor.put("paisOrigen", autor.getPaisOrigen());
			
			listaAutores.add(datosAutor);
		}
		
		return listaAutores;
	}

	/* -------------------------- Descriptor -------------------------- */
	public void crearDescriptor(String pcodigo, String pdescripcion) throws Exception {
		
		Descriptor descriptor;
		descriptor = (new MultiDescriptor()).crear(pcodigo, pdescripcion);
	}
	
	public void modificarDescriptor(String pcodigo, String pdescripcion) throws Exception {
		
		Descriptor descriptor;
		descriptor = (new MultiDescriptor()).buscar(pcodigo);

		descriptor.setCodigo(pcodigo);
		descriptor.setDescripcion(pdescripcion);
		
		(new MultiDescriptor()).modificar(descriptor);
	}
	
	public void eliminarDescriptor(String pid) throws Exception {
		Descriptor descriptor;
		descriptor = (new MultiDescriptor()).buscar(pid);
		
		(new MultiDescriptor()).eliminar(descriptor);
	}
	
	public Vector listarDescriptores() throws Exception {
		Descriptor descriptor;
		Vector lista = new Vector();		
		Vector descriptores = (new MultiDescriptor()).listar();
		
		for (int i = 0; i < descriptores.size(); i++) {
			descriptor = ((Descriptor) descriptores.get(i));
			TreeMap datos = new TreeMap();
			
			datos.put("codigo", descriptor.getCodigo());
			datos.put("descripcion", descriptor.getDescripcion());
			
			lista.add(datos);
		}
		
		return lista;
	}
	
	/* -------------------------- Usuario -------------------------- */
	public void crearUsuario(String pid, String pnombre, String papellido, String pdirElectronica, 
			String pdireccion, String ptelefono) throws Exception {
		
		Usuario usuario;
		usuario = (new MultiUsuario()).crear(pid, pnombre, papellido, pdirElectronica, pdireccion, ptelefono, "normal");
	}
	
	public void modificarUsuario(String pid, String pnombre, String papellido, String pdirElectronica, 
			String pdireccion, String ptelefono) throws Exception {
		
		Usuario usuario;
		usuario = (new MultiUsuario()).buscar(pid);

		usuario.setNombre(pnombre);
		usuario.setApellido(papellido);
		usuario.setDirElectronica(pdirElectronica);
		usuario.setDireccion(pdireccion);
		usuario.setTelefono(ptelefono);
		
		(new MultiUsuario()).modificar(usuario);
	}
	
	public void eliminarUsuario(String pid) throws Exception {
		Usuario usuario;
		usuario = (new MultiUsuario()).buscar(pid);
		
		(new MultiUsuario()).eliminar(usuario);
	}
	
	public Vector listarUsuarios() throws Exception {
		Usuario usuario;
		Vector lista = new Vector();		
		Vector usuarios = (new MultiUsuario()).listar();
		
		for (int i = 0; i < usuarios.size(); i++) {
			usuario = ((Usuario) usuarios.get(i));
			TreeMap datos = new TreeMap();
			
			datos.put("id", usuario.getId());
			datos.put("nombre", usuario.getNombre());
			datos.put("apellido", usuario.getApellido());
			datos.put("dirElectronica", usuario.getDirElectronica());
			datos.put("direccion", usuario.getDireccion());
			datos.put("telefono", usuario.getTelefono());
			datos.put("estado", usuario.getEstado());
			
			lista.add(datos);
		}
		
		return lista;
	}
	
	public void cambiarEstadoUsuario(String pid, String pestado) throws SQLException, Exception {
		Usuario usuario;
		usuario = (new MultiUsuario()).buscar(pid);

		usuario.setEstado(pestado);
		
		(new MultiUsuario()).modificar(usuario);
	}

	/* -------------------------- Libro -------------------------- */
	
	public void crearLibro(String pisbn, String ptitulo, int pvolumen, String peditorial, 
			LocalDate pfechaPublicacion, String ptipo) throws Exception {
		Libro libro;
		libro = (new MultiLibro()).crear(pisbn, ptitulo, pvolumen, peditorial, pfechaPublicacion, ptipo);
	}
	
	public void modificarLibro(String pisbn, String ptitulo, int pvolumen, String peditorial, 
			LocalDate pfechaPublicacion, String ptipo) throws Exception {
		
		Libro libro;
		libro = (new MultiLibro()).buscar(pisbn);

		libro.setTitulo(ptitulo);
		libro.setVolumen(pvolumen);
		libro.setEditorial(peditorial);
		libro.setFechaPublicacion(pfechaPublicacion);
		libro.setTipo(ptipo);		
		
		(new MultiLibro()).modificar(libro);
	}
	
	public void eliminarLibro(String pisbn) throws Exception {
		Libro libro;
		libro = (new MultiLibro()).buscar(pisbn);
		
		(new MultiLibro()).eliminar(libro);
		
		// TODO: Eliminar ejemplares
	}
	
	public Vector listarLibros() throws Exception {
		Libro libro;
		Autor autor;
		Descriptor descriptor;
		Vector lista = new Vector();		
		Vector libros = (new MultiLibro()).listar();
		Vector autores;
		Vector descriptores;
		
		for (int i = 0; i < libros.size(); i++) {
			libro = ((Libro) libros.get(i));
			TreeMap datos = new TreeMap();
			
			datos.put("isbn", libro.getISBN());
			datos.put("titulo", libro.getTitulo());
			datos.put("volumen", libro.getVolumen());
			datos.put("editorial", libro.getEditorial());
			datos.put("fechaPublicacion", libro.getFechaPublicacion());
			datos.put("tipo", libro.getTipo());
			
			// Obtener los autores
			autores = libro.obtenerAutores();
			ArrayList<String> idsAutores = new ArrayList<String>();
			for (int j = 0; j < autores.size(); j++) {
				autor = (Autor) autores.get(j);
				idsAutores.add(autor.getNombre() + " " + autor.getApellido());
			}
			datos.put("idsAutores", idsAutores);
			
			// Obtener los descriptores
			descriptores = libro.obtenerDescriptores();
			ArrayList<String> idsDescriptores = new ArrayList<String>();
			for (int j = 0; j < descriptores.size(); j++) {
				descriptor = (Descriptor) descriptores.get(j);
				idsDescriptores.add(descriptor.getDescripcion());
			}
			datos.put("idsDescriptores", idsDescriptores);
			
			lista.add(datos);
		}
		
		return lista;
	}
	
	public String asociarAutorLibro(String pisbn, String pidAutor) throws Exception {
		String msg = "";
		Autor autor;
		Libro libro;
		
		autor = (new MultiAutor()).buscar(pidAutor);
		
		if (autor != null) {
			libro = (new MultiLibro()).buscar(pisbn);
			
			if (libro != null) {
				(new MultiLibro()).asociarAutor(pisbn, pidAutor);
				msg = "El autor se asocio con exito al libro " + libro.getTitulo();
			} else {
				msg = "El libro no se encuentra registrado.";
			}			
		} else {
			msg = "El autor no se encuentra registrado.";
		}
		
		return msg;
	}
	
	public String asociarDescriptorLibro(String pisbn, String pcodigoDescriptor) throws Exception {
		String msg = "";
		Descriptor descriptor;
		Libro libro;
		
		descriptor = (new MultiDescriptor()).buscar(pcodigoDescriptor);
		
		if (descriptor != null) {
			libro = (new MultiLibro()).buscar(pisbn);
			
			if (libro != null) {
				(new MultiLibro()).asociarDescriptor(pisbn, pcodigoDescriptor);
				msg = "El descriptor se asocio con exito al libro " + libro.getTitulo();
			} else {
				msg = "El libro no se encuentra registrado.";
			}			
		} else {
			msg = "El descriptor no se encuentra registrado.";
		}
		
		return msg;
	}
	
	public TreeMap buscarLibro(String pisbn) throws Exception {
		TreeMap datos = null;
		Libro libro=null;
		String nombre;
		
		datos = new TreeMap();
		libro = (new MultiLibro()).buscar(pisbn);
		
		datos.put("titulo", libro.getTitulo());
		datos.put("volumen", libro.getVolumen());
		datos.put("editorial", libro.getEditorial());
		datos.put("fechaPublicacion", libro.getFechaPublicacion());
		datos.put("tipo", libro.getTipo());
	
		return datos;
	}
	
	public Vector libroBuscarPorTitulo(String ptitulo) throws Exception {
		Vector libros=null;
		Vector datosLibros=null;
		Libro libro;
		libros = (new MultiLibro()).buscarPorNombre(ptitulo);
		datosLibros = new Vector();
		for (int i=0; i<libros.size(); i++) {
			libro = ((Libro) libros.get(i));
			TreeMap datosLibro = new TreeMap();
			datosLibro.put("titulo", libro.getTitulo());
			datosLibro.put("volumen", libro.getVolumen());
			datosLibro.put("editorial", libro.getEditorial());
			datosLibro.put("fechaPublicacion", libro.getFechaPublicacion());
			datosLibro.put("tipo", libro.getTipo());
			datosLibros.add(datosLibro);
		}
		return datosLibros;
	}
	
	/* -------------------------- Ejemplar -------------------------- */
	
	public void crearEjemplar(String pisbn, String pcodigo, String pestadoFisico, LocalDate pfechaIngreso, 
			String pcondicionActual) throws Exception {
		Ejemplar ejemplar;
		ejemplar = (new MultiEjemplar()).crear(pisbn, pcodigo, pestadoFisico, pfechaIngreso, pcondicionActual);
	}
	
	public void modificarEjemplar(String pisbn, String pcodigo, String pestadoFisico, LocalDate pfechaIngreso, 
			String pcondicionActual) throws Exception {
		
		Ejemplar ejemplar;
		ejemplar = (new MultiEjemplar()).buscar(pcodigo);

		ejemplar.setIdLibro(pisbn);
		ejemplar.setEstadoFisico(pestadoFisico);
		ejemplar.setFechaIngreso(pfechaIngreso);
		ejemplar.setCondicionActual(pcondicionActual);
		
		(new MultiEjemplar()).modificar(ejemplar);
	}
	
	public void eliminarEjemplar(String pcodigo) throws Exception {
		Ejemplar ejemplar;
		ejemplar = (new MultiEjemplar()).buscar(pcodigo);
		
		(new MultiEjemplar()).eliminar(ejemplar);
	}
	
	public Vector listarEjemplares() throws Exception {
		Ejemplar ejemplar = null;
		Libro libro = null;
		Autor autor = null;
		Descriptor descriptor = null;
		Vector autores;
		Vector descriptores;
		Vector ejemplares = (new MultiEjemplar()).listar();
		Vector lista = new Vector();	
		
		for (int i = 0; i < ejemplares.size(); i++) {
			ejemplar = ((Ejemplar) ejemplares.get(i));
			TreeMap datos = new TreeMap();
			
			datos.put("idLibro", ejemplar.getIdLibro());
			datos.put("codigo", ejemplar.getCodigo());
			datos.put("estadoFisico", ejemplar.getEstadoFisico());
			datos.put("fechaIngreso", ejemplar.getFechaIngreso());
			datos.put("condicionActual", ejemplar.getCondicionActual());			
			
			// Obtener el libro al que pertenece
			libro = ejemplar.obtenerLibro();
			datos.put("isbn", libro.getISBN());
			datos.put("titulo", libro.getTitulo());
			datos.put("volumen", libro.getVolumen());
			datos.put("editorial", libro.getEditorial());
			datos.put("fechaPublicacion", libro.getFechaPublicacion());
			datos.put("tipo", libro.getTipo());
			
			// Obtener los autores
			autores = libro.obtenerAutores();
			ArrayList<String> idsAutores = new ArrayList<String>();
			for (int j = 0; j < autores.size(); j++) {
				autor = (Autor) autores.get(j);
				idsAutores.add(autor.getNombre() + " " + autor.getApellido());
			}
			datos.put("idsAutores", idsAutores);

			// Obtener los descriptores
			descriptores = libro.obtenerDescriptores();
			ArrayList<String> idsDescriptores = new ArrayList<String>();
			for (int j = 0; j < descriptores.size(); j++) {
				descriptor = (Descriptor) descriptores.get(j);
				idsDescriptores.add(descriptor.getDescripcion());
			}
			datos.put("idsDescriptores", idsDescriptores);
			
			lista.add(datos);
		}
		
		return lista;
	}
	
	public TreeMap buscarEjemplar(String pcodigo) throws Exception {
		Ejemplar ejemplar = (new MultiEjemplar()).buscar(pcodigo);
		return obtenerDatosEjemplar(ejemplar);
	}
	
	public TreeMap buscarEjemplarPorISBN(String pisbn) throws Exception {
		Ejemplar ejemplar = (new MultiEjemplar()).buscarPorISBN(pisbn);
		return obtenerDatosEjemplar(ejemplar);
	}
	
	public Vector buscarEjemplarPorTitulo(String ptitulo) throws Exception {
		Vector<Ejemplar> ejemplares = (new MultiEjemplar()).buscarPorTitulo(ptitulo);
		Vector resultados = new Vector();

		for (int i = 0; i < ejemplares.size(); i++) {
			resultados.add(obtenerDatosEjemplar(ejemplares.get(i)));
		}
		
		return resultados;
	}
	
	public Vector buscarEjemplarPorAutor(String pautor) throws Exception {
		Vector<Ejemplar> ejemplares = (new MultiEjemplar()).buscarPorAutor(pautor);
		Vector resultados = new Vector();

		for (int i = 0; i < ejemplares.size(); i++) {
			resultados.add(obtenerDatosEjemplar(ejemplares.get(i)));
		}
		
		return resultados;
	}
	
	public Vector buscarEjemplarPorDescriptor(String pdescriptor) throws Exception {
		Vector<Ejemplar> ejemplares = (new MultiEjemplar()).buscarPorDescriptor(pdescriptor);
		Vector resultados = new Vector();

		for (int i = 0; i < ejemplares.size(); i++) {
			resultados.add(obtenerDatosEjemplar(ejemplares.get(i)));
		}
		
		return resultados;
	}
	
	private TreeMap obtenerDatosEjemplar(Ejemplar ejemplar) throws Exception {
		TreeMap datos = null;
		Libro libro = null;
		Autor autor = null;
		Descriptor descriptor = null;
		Vector autores;
		Vector descriptores;
		
		datos = new TreeMap();		
		datos.put("codigo", ejemplar.getCodigo());
		datos.put("estadoFisico", ejemplar.getEstadoFisico());
		datos.put("fechaIngreso", ejemplar.getFechaIngreso());
		datos.put("condicionActual", ejemplar.getCondicionActual());
		
		// Obtener el libro al que pertenece
		libro = ejemplar.obtenerLibro();
		datos.put("isbn", libro.getISBN());
		datos.put("titulo", libro.getTitulo());
		datos.put("volumen", libro.getVolumen());
		datos.put("editorial", libro.getEditorial());
		datos.put("fechaPublicacion", libro.getFechaPublicacion());
		datos.put("tipo", libro.getTipo());
		
		// Obtener los autores
		autores = libro.obtenerAutores();
		ArrayList<String> idsAutores = new ArrayList<String>();
		for (int j = 0; j < autores.size(); j++) {
			autor = (Autor) autores.get(j);
			idsAutores.add(autor.getNombre() + " " + autor.getApellido());
		}
		datos.put("idsAutores", idsAutores);
		
		// Obtener los descriptores
		descriptores = libro.obtenerDescriptores();
		ArrayList<String> idsDescriptores = new ArrayList<String>();
		for (int j = 0; j < descriptores.size(); j++) {
			descriptor = (Descriptor) descriptores.get(j);
			idsDescriptores.add(descriptor.getDescripcion());
		}
		datos.put("idsDescriptores", idsDescriptores);
		
		return datos;
	}
}

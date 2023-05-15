package com.nicolas.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nicolas.lookify.models.Cancion;

@Repository
public interface CancionRepo extends CrudRepository<Cancion,Long> {

	// Este método recupera todos los datos de la BD
			List<Cancion> findAll();

			// Este método encuentra un libro por su descripción
			List<Cancion> findTop10ByOrderByClasificacionDesc();
			
			//metodo que busca lista de canciones x nombre de artista
			List<Cancion> findByArtistaContaining(String search);

			/*// Este método cuenta cuántos libros contiene cierta cadena en el título
			Long countByTitleContaining(String search);

			// Este método borra un libro que empieza con un título específico
			Long deleteByTitleStartingWith(String search);
		*/
	
}

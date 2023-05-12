package com.nicolas.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.nicolas.lookify.models.Cancion;
import com.nicolas.lookify.repositories.CancionRepo;

@Service
public class CancionServ {

	@Autowired
	private CancionRepo cancRepo;

	// Devolviendo todos las canciones.
	public List<Cancion> allCanciones() {
		return cancRepo.findAll();
	}

	// Creando una cancion.
	public Cancion createCancion(Cancion c) {
		return cancRepo.save(c);
	}

	// Obteniendo la información de una cancion x id
	public Cancion findCancion(Long id) {
		Optional<Cancion> cancion = cancRepo.findById(id);
		if (cancion.isPresent()) {
			return cancion.get();
		} else {
			return null;
		}
	}

	// actualizar una cancion
	public Cancion updateCancion(Cancion c) {
		Cancion updateC = findCancion(c.getId());

		updateC.setArtista(c.getArtista());
		updateC.setTitulo(c.getTitulo());
		updateC.setClasificacion(c.getClasificacion());

		cancRepo.save(updateC);

		return updateC;
	}

	//eliminar cancion de base de datos
	public void deleteCancion(Long id) {
		cancRepo.deleteById(id);

	}

}

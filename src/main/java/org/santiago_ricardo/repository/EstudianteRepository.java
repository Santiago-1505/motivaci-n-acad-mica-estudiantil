package org.santiago_ricardo.repository;

import java.util.List;
import org.santiago_ricardo.model.Estudiante;

public interface EstudianteRepository {

  List<Estudiante> devolverInformacionEstudiantes();
  Estudiante anadirEstudiante(Estudiante nuevoEstudiante);
}


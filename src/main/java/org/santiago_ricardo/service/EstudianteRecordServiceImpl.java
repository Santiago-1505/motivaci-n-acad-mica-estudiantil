package org.santiago_ricardo.service;

import org.santiago_ricardo.repository.EstudianteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.santiago_ricardo.model.Estudiante;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class EstudianteRecordServiceImpl implements EstudianteRecordService {

  private static final Logger logger = LoggerFactory.getLogger(EstudianteRecordServiceImpl.class);
  private final EstudianteRepository estudianteRepository;

  public EstudianteRecordServiceImpl(EstudianteRepository estudianteRepository) {
    this.estudianteRepository = estudianteRepository;
  }


  @Override
  public double calcularPromedio() {
    Double suma = 0D;
    for ( Estudiante estudiante:this.estudianteRepository.devolverInformacionEstudiantes()) {
      suma+= estudiante.notaPromedio();
    }
    return suma/this.estudianteRepository.devolverInformacionEstudiantes().size();
  }

  @Override
  public int contarEstudiantes() {

    return this.estudianteRepository.devolverInformacionEstudiantes().size();
  }

  @Override
  public int contarEstudiantesSinRecursosYNoDeseanEstudiar() {
    int casosFavorables = 0;
    for (Estudiante estudiante:this.estudianteRepository.devolverInformacionEstudiantes()) {
      if (estudiante.faltaDeRecursos()&&estudiante.noLeGustaEstudiar())
        casosFavorables ++;
    }
    return casosFavorables;
  }

  @Override
  public int contarEstudiantesQueNoDeseanEstudiarYRecibenEsenanzasAntiguas() {
    int casosFavorables = 0;
    for (Estudiante estudiante:this.estudianteRepository.devolverInformacionEstudiantes()) {
      if (estudiante.seUsanTecnicasDeEnseñansaAntiguas() && estudiante.noLeGustaEstudiar())
        casosFavorables++;
    }
    return casosFavorables;
  }

  @Override
  public int contarEstudiantesSinRecursosYRecibenEsenanzasAntiguas() {
    int casosFavorables = 0;
    for (Estudiante estudiante:this.estudianteRepository.devolverInformacionEstudiantes()) {
      if (estudiante.seUsanTecnicasDeEnseñansaAntiguas() && estudiante.faltaDeRecursos())
        casosFavorables++;
    }
    return casosFavorables;
  }

  @Override
  public int contarEstudiantesSinRecursosYRecibenEsenanzasAntiguasYNoDeseanEstudiar() {
    int casosFavorables = 0;
    for (Estudiante estudiante:this.estudianteRepository.devolverInformacionEstudiantes()) {
      if (estudiante.seUsanTecnicasDeEnseñansaAntiguas() && estudiante.noLeGustaEstudiar() && estudiante.faltaDeRecursos())
        casosFavorables++;
    }
    return casosFavorables;
  }

  @Override
  public int calcularEdadQueMasSeRepite() {
    List<Integer> edades = new ArrayList<>();
    for (Estudiante estudiante : this.estudianteRepository.devolverInformacionEstudiantes()) {
      edades.add(estudiante.edad());
    }
    int moda = 0;
    int maxFrecuencia = 0;
    for (int edad : edades) {
      int frecuencia = Collections.frequency(edades, edad);
      if (frecuencia > maxFrecuencia) {
        moda = edad;
        maxFrecuencia = frecuencia;
      }
    }
    return moda;
  }

  @Override
  public int contarPromedioBajoYRecibenEsenanzasAntiguas() {
      int casosFavorables = 0;
      for (Estudiante estudiante:this.estudianteRepository.devolverInformacionEstudiantes()) {
        if (estudiante.seUsanTecnicasDeEnseñansaAntiguas() && estudiante.notaPromedio() < 3D)
          casosFavorables++;
      }
      return casosFavorables;
    }

  @Override
  public int contarPromedioBajoYNoDeseanEstudiar() {
    int casosFavorables = 0;
    for (Estudiante estudiante:this.estudianteRepository.devolverInformacionEstudiantes()) {
      if (estudiante.noLeGustaEstudiar() && estudiante.notaPromedio() < 3D)
        casosFavorables++;
    }
    return casosFavorables;
  }

  @Override
  public String[] encontrarMejores3PromediosDepartamentos() {
    for (Estudiante estudiante:this.estudianteRepository.devolverInformacionEstudiantes()){

    }
    return new String[0];
  }

  @Override
  public String[] encontrarPeores3PromediosDepartamentos() {
    return new String[0];
  }

  @Override
  public String encontrarDepartamentoConMayorIndiceEstudiantesNoDeseanEstudiar() {
    return null;
  }
}


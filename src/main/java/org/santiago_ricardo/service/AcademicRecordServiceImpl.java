package org.santiago_ricardo.service;

import java.util.List;
import org.santiago_ricardo.model.Estudiante;
import org.santiago_ricardo.repository.GradeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AcademicRecordServiceImpl implements AcademicRecordService {

  private static final Logger logger = LoggerFactory.getLogger(AcademicRecordServiceImpl.class);
  private final GradeRepository gradeRepository;

  public AcademicRecordServiceImpl(GradeRepository gradeRepository) {
    this.gradeRepository = gradeRepository;
  }


  @Override
  public double calcularPromedio() {
    return 0;
  }

  @Override
  public int contarEstudiantes() {
    return 0;
  }

  @Override
  public int contarEstudiantesSinRecursosYNoDeseanEstudiar() {
    return 0;
  }

  @Override
  public int contarEstudiantesQueNoDeseanEstudiarYRecibenEsenanzasAntiguas() {
    return 0;
  }

  @Override
  public int contarEstudiantesSinRecursosYRecibenEsenanzasAntiguas() {
    return 0;
  }

  @Override
  public int contarEstudiantesSinRecursosYRecibenEsenanzasAntiguasYNoDeseanEstudiar() {
    return 0;
  }

  @Override
  public int calcularEdadQueMasSeRepite() {
    return 0;
  }

  @Override
  public int contarPromedioBajoYRecibenEsenanzasAntiguas() {
    return 0;
  }

  @Override
  public int contarPromedioBajoYNoDeseanEstudiar() {
    return 0;
  }

  @Override
  public String[] encontrarMejores3PromediosDepartamentos() {
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


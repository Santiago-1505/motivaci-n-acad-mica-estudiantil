package org.santiago_ricardo.service;

import org.santiago_ricardo.model.Estudiante;

import java.util.List;
import java.util.OptionalDouble;

public interface EstudianteRecordService {
    Double calcularPromedio();
    int contarEstudiantes();
    double contarEstudiantesQueNoDeseanEstudiar();
    double contarEstudiantesSinRecursos();
    double contarEstudiantesQueRecibenEsenanzasAntiguas();
    double contarEstudiantesSinRecursosYNoDeseanEstudiar();
    double contarEstudiantesQueNoDeseanEstudiarYRecibenEsenanzasAntiguas();
    double contarEstudiantesSinRecursosYRecibenEsenanzasAntiguas();
    double contarEstudiantesSinRecursosYRecibenEsenanzasAntiguasYNoDeseanEstudiar();
    double calcularEdadQueMasSeRepite();
    //Promedio bajo se refiere a un promedio inferior a 3
    double contarPromedioBajoYRecibenEsenanzasAntiguas();
    double contarPromedioBajoYNoDeseanEstudiar();
    String[] encontrarMejores3PromediosDepartamentos();
    String[] encontrarPeores3PromediosDepartamentos();
    String encontrarDepartamentoConMayorCantidadEstudiantesNoDeseanEstudiar();

    List<Estudiante> listarEstudiantes();
    Estudiante agregarEstudiante(Estudiante nuevoEstudiante);


}

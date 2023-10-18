package org.santiago_ricardo.service;

public interface EstudianteRecordService {
    double calcularPromedio();
    int contarEstudiantes();
    int contarEstudiantesQueNoDeseanEstudiar();
    int contarEstudiantesSinRecursos();
    int contarEstudiantesQueRecibenEsenanzasAntiguas();
    int contarEstudiantesSinRecursosYNoDeseanEstudiar();
    int contarEstudiantesQueNoDeseanEstudiarYRecibenEsenanzasAntiguas();
    int contarEstudiantesSinRecursosYRecibenEsenanzasAntiguas();
    int contarEstudiantesSinRecursosYRecibenEsenanzasAntiguasYNoDeseanEstudiar();
    int calcularEdadQueMasSeRepite();
    //Promedio bajo se refiere a un promedio inferior a 3
    int contarPromedioBajoYRecibenEsenanzasAntiguas();
    int contarPromedioBajoYNoDeseanEstudiar();
    String[] encontrarMejores3PromediosDepartamentos();
    String[] encontrarPeores3PromediosDepartamentos();
    String encontrarDepartamentoConMayorCantidadEstudiantesNoDeseanEstudiar();


}

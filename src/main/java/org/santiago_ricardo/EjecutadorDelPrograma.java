package org.santiago_ricardo;

import org.santiago_ricardo.repository.EstudianteEnArchivoRepositoryImpl;
import org.santiago_ricardo.repository.EstudianteEnMemoriaRepositoryImpl;
import org.santiago_ricardo.service.EstudianteRecordService;
import org.santiago_ricardo.service.EstudianteRecordServiceImpl;


public class EjecutadorDelPrograma {
  public static void main(String[] args) {
    EstudianteRecordService estudianteRecordService = new EstudianteRecordServiceImpl(new EstudianteEnArchivoRepositoryImpl());
    // Imprimir resultados
    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    System.out.println("A continuación se presentarán los resultados de una encuesta realizada jóvenes estudiantes del país");
    System.out.println("El tema de la encuesta es el agrado hacia el estudio y las causas de este");
    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    System.out.println("La cantidad de encuestados es " + estudianteRecordService.contarEstudiantes());
    System.out.println("La edad promedio de los encuestados es de " + estudianteRecordService.calcularPromedio() +" años y la edad que mas se repite es "+ estudianteRecordService.calcularEdadQueMasSeRepite());
    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    System.out.println("La cantidad de estudiantes que se les sigue enseñando de maneras antiguas es: " + estudianteRecordService.contarEstudiantesQueRecibenEsenanzasAntiguas() );
    System.out.println("La cantidad de estudiantes que se les enseña de maneras modernas es: " + (estudianteRecordService.contarEstudiantes()-estudianteRecordService.contarEstudiantesQueRecibenEsenanzasAntiguas()) );
    System.out.println("La cantidad de estudiantes que tienen problemas económicos es: " + estudianteRecordService.contarEstudiantesSinRecursos());
    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    System.out.println("En porcentaje podemos observar que: ");
    System.out.println("El "+ (estudianteRecordService.contarEstudiantesSinRecursosYRecibenEsenanzasAntiguas()/estudianteRecordService.contarEstudiantes())*100+"% no tienen recursos económicos y se les enseña de manera antigua");
    System.out.println("El "+ ((estudianteRecordService.contarEstudiantesQueNoDeseanEstudiar())/estudianteRecordService.contarEstudiantes())*100+"% no desean estudiar");
    System.out.println("El "+ (estudianteRecordService.contarEstudiantesSinRecursosYNoDeseanEstudiar()/estudianteRecordService.contarEstudiantes())*100+"% no desean estudiar y tienen problemas económicos");
    System.out.println("El "+ (estudianteRecordService.contarEstudiantesQueNoDeseanEstudiarYRecibenEsenanzasAntiguas()/estudianteRecordService.contarEstudiantes())*100+"% no desean estudiar y se les enseña de manera antigua");
    System.out.println("El "+ (estudianteRecordService.contarEstudiantesSinRecursosYRecibenEsenanzasAntiguasYNoDeseanEstudiar()/estudianteRecordService.contarEstudiantes())*100+"% no desean estudiar, se les enseña de manera antigua y tienen problemas económicos");
    System.out.println("El "+ (estudianteRecordService.contarPromedioBajoYNoDeseanEstudiar()/estudianteRecordService.contarEstudiantes())*100 + "% tienen promedio bajo y no desean estudiar");
    System.out.println("El " +(estudianteRecordService.contarPromedioBajoYRecibenEsenanzasAntiguas()/estudianteRecordService.contarEstudiantes()*100 +"% tienen promedio bajo y se les enseña de manera antigua"));
    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    System.out.println("A continuación se presentarán primero los 3 mejores departamentos distinguidos por el promedio, iniciaremos desde el que cuenta con mejor promedio hasta el tercero con mejor promedio");
    System.out.println(estudianteRecordService.encontrarMejores3PromediosDepartamentos()[0]+" es el departamento con mejor promedio");
    System.out.println(estudianteRecordService.encontrarMejores3PromediosDepartamentos()[1]+" es el departamento con el segundo mejor promedio");
    System.out.println(estudianteRecordService.encontrarMejores3PromediosDepartamentos()[2]+" es el departamento con el tercer mejor promedio");
    System.out.println("Ahora se presentarán los últimos 3 departamentos distinguidos por el promedio, se iniciará desde que es que tenga el peor promedio, al tercer peor");
    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    System.out.println(estudianteRecordService.encontrarPeores3PromediosDepartamentos()[0]+" es el departamento con peor promedio");
    System.out.println(estudianteRecordService.encontrarPeores3PromediosDepartamentos()[1]+" es el departamento con el segundo peor promedio");
    System.out.println(estudianteRecordService.encontrarPeores3PromediosDepartamentos()[2]+" es el departamento con el tercer peor promedio");
    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    System.out.println("En conclusión se pudo observar una preocupante alta cifra de estudiantes que no desean estudiar, ya que los jóvenes deberían de tener una buena motivación y ser mejores tanto como personas como profesionalmente");
    System.out.println("También es preocupante el alto índice de personas de bajos recursos que casi ocupa la mitad de la encuesta y esto afecta directamente para que los estudiantes continúen con sus estudios");
    System.out.println("Y se observa una mayor cantidad de técnicas de enseñanza antiguas que modernas, lo cual indica la falta de crecimiento en cuento a la actualización de la enseñanza");
    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");


  }
}
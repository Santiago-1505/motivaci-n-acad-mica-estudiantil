package org.santiago_ricardo;

import java.text.MessageFormat;
import org.santiago_ricardo.repository.EstudianteInMemoryRepositoryImpl;
import org.santiago_ricardo.service.EstudianteRecordService;
import org.santiago_ricardo.service.EstudianteRecordServiceImpl;


public class ApplicationRunner {
  public static void main(String[] args) {
    EstudianteRecordService estudianteRecordService = new EstudianteRecordServiceImpl(new EstudianteInMemoryRepositoryImpl());

    // Imprimir resultados
    System.out.println("");
    System.out.println("A continuación se presentarán los resultados de una encuesta realizada jóvenes estudiantes del país");
    System.out.println("El tema de la encuesta es el agrado hacia el estudio y las causas de este");
    System.out.println("");
    System.out.println("La cantidad de encuestados es " + estudianteRecordService.contarEstudiantes());
    System.out.println("La edad promedio de los encuestados es de " + estudianteRecordService.calcularPromedio() +" años y la edad que mas se repite es "+ estudianteRecordService.calcularEdadQueMasSeRepite());
    System.out.println("");
    System.out.println("La cantidad de estudiantes que se les sigue enseñando de maneras antiguas es: " + );
    System.out.println("La cantidad de estudiantes que se les enseña de maneras modernas es: " + );
    System.out.println("La cantidad de estudiantes que tienen problemas económicos es: " + );
    System.out.println("");
    System.out.println("En porcentaje podemos observar que: ");
    System.out.println("El "+ (estudianteRecordService.contarEstudiantesSinRecursosYRecibenEsenanzasAntiguas()/estudianteRecordService.contarEstudiantes())*100+"% no tienen recursos económicos y se les enseña de manera antigua");
    System.out.println("El "+ ((Cantidad_De_Estudiantes_Que_No_Les_Gusta_Estudiar)/estudiantes.size())*100+"% no desean estudiar");
    System.out.println("El "+ (estudianteRecordService.contarEstudiantesSinRecursosYNoDeseanEstudiar()/estudianteRecordService.contarEstudiantes())*100+"% no desean estudiar y tienen problemas económicos");
    System.out.println("El "+ (estudianteRecordService.contarEstudiantesQueNoDeseanEstudiarYRecibenEsenanzasAntiguas()/estudianteRecordService.contarEstudiantes())*100+"% no desean estudiar y se les enseña de manera antigua");
    System.out.println("El "+ (estudianteRecordService.contarEstudiantesSinRecursosYRecibenEsenanzasAntiguasYNoDeseanEstudiar()/estudianteRecordService.contarEstudiantes())*100+"% no desean estudiar, se les enseña de manera antigua y tienen problemas económicos");
    System.out.println("");
    System.out.println("Con estos resultados podemos decir ");
    System.out.println("1- La mayoría de estudiantes tienen problemas económicos y se les enseña de manera ortodoxa ");
    System.out.println("2- La mayoría de estudiantes no desean estudiar y la principal causa es la forma en que se enseña");
    System.out.println("3- La situación económica también es un gran causante en cuanto al disgusto por estudiar ");
    System.out.println("");
    System.out.println("En conclusión:");
    System.out.println("Se debe implementar nuevas estrategias para captar la atención de los jóvenes");
    System.out.println("Y se debe realizar ayuda social para mejorar la carente situación económica de los jóvenes");

  }
}

package org.santiago_ricardo.service;
import java.util.stream.Collectors;
import org.santiago_ricardo.repository.EstudianteRepository;
import org.santiago_ricardo.model.Estudiante;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class EstudianteRecordServiceImpl implements EstudianteRecordService {


  private final EstudianteRepository estudianteRepository;

  public EstudianteRecordServiceImpl(EstudianteRepository estudianteRepository) {
    this.estudianteRepository = estudianteRepository;
  }


  @Override
  public double calcularPromedio() {
    double suma = 0D;
    for ( Estudiante estudiante:this.estudianteRepository.devolverInformacionEstudiantes()) {
      suma+= estudiante.edad();
    }
    return suma/this.estudianteRepository.devolverInformacionEstudiantes().size();
  }

  @Override
  public int contarEstudiantes() {

    return this.estudianteRepository.devolverInformacionEstudiantes().size();
  }

  @Override
  public double contarEstudiantesQueNoDeseanEstudiar() {
    return this.estudianteRepository.devolverInformacionEstudiantes().stream().filter(Estudiante::noLeGustaEstudiar).count();
  }

  @Override
  public double contarEstudiantesSinRecursos() {

    return this.estudianteRepository.devolverInformacionEstudiantes().stream().filter(Estudiante::faltaDeRecursos).count();
  }

  @Override
  public double contarEstudiantesQueRecibenEsenanzasAntiguas() {
    return this.estudianteRepository.devolverInformacionEstudiantes().stream().filter(Estudiante::seUsanTecnicasDeEnsenansaAntiguas).count();
  }

  @Override
  public double contarEstudiantesSinRecursosYNoDeseanEstudiar() {
    return this.estudianteRepository.devolverInformacionEstudiantes().stream().filter(Estudiante -> Estudiante.noLeGustaEstudiar() && Estudiante.faltaDeRecursos()).count();
  }

  @Override
  public double contarEstudiantesQueNoDeseanEstudiarYRecibenEsenanzasAntiguas() {
    return this.estudianteRepository.devolverInformacionEstudiantes().stream().filter(Estudiante -> Estudiante.noLeGustaEstudiar() && Estudiante.seUsanTecnicasDeEnsenansaAntiguas()).count();
  }

  @Override
  public double contarEstudiantesSinRecursosYRecibenEsenanzasAntiguas() {
    double casosFavorables = 0D;
    for (Estudiante estudiante:this.estudianteRepository.devolverInformacionEstudiantes()) {
      if (estudiante.seUsanTecnicasDeEnsenansaAntiguas() && estudiante.faltaDeRecursos())
        casosFavorables++;
    }
    return casosFavorables;
  }

  @Override
  public double contarEstudiantesSinRecursosYRecibenEsenanzasAntiguasYNoDeseanEstudiar() {
    double casosFavorables = 0D;
    for (Estudiante estudiante:this.estudianteRepository.devolverInformacionEstudiantes()) {
      if (estudiante.seUsanTecnicasDeEnsenansaAntiguas() && estudiante.noLeGustaEstudiar() && estudiante.faltaDeRecursos())
        casosFavorables++;
    }
    return casosFavorables;
  }

  @Override
  public double calcularEdadQueMasSeRepite() {
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
  public double contarPromedioBajoYRecibenEsenanzasAntiguas() {
      int casosFavorables = 0;
      for (Estudiante estudiante:this.estudianteRepository.devolverInformacionEstudiantes()) {
        if (estudiante.seUsanTecnicasDeEnsenansaAntiguas() && estudiante.notaPromedio() < 3D)
          casosFavorables++;
      }
      return casosFavorables;
    }

  @Override
  public double contarPromedioBajoYNoDeseanEstudiar() {
    int casosFavorables = 0;
    for (Estudiante estudiante:this.estudianteRepository.devolverInformacionEstudiantes()) {
      if (estudiante.noLeGustaEstudiar() && estudiante.notaPromedio() < 3D)
        casosFavorables++;
    }
    return casosFavorables;
  }

  @Override
  public String[] encontrarMejores3PromediosDepartamentos() {
    List<String> departamentos = new ArrayList<>();
    int [] cantidadDeNotasPorDepartamento = new int[32];
    List<Double> sumatoriaDeNotasPorDepartamento = new ArrayList<>();
    for (Estudiante estudiante:this.estudianteRepository.devolverInformacionEstudiantes()){
      if(!departamentos.contains(estudiante.departamento())){
        departamentos.add(estudiante.departamento());
        sumatoriaDeNotasPorDepartamento.add(0D);

      }
      cantidadDeNotasPorDepartamento[departamentos.indexOf(estudiante.departamento())]++ ;
      sumatoriaDeNotasPorDepartamento.set(departamentos.indexOf(estudiante.departamento()),sumatoriaDeNotasPorDepartamento.get(departamentos.indexOf(estudiante.departamento()))+estudiante.notaPromedio());
    }
    double mayorPromedio =0D;
    double tercermayorPromedio =0D;
    double segundomayorPromedio =0D;
    int posicionMayorPromedio = 0;
    int posicionSegundoMayorPromedio = 0;
    int posicionTercerMayorPromedio = 0;

    for (Double nota:sumatoriaDeNotasPorDepartamento){
      if ((nota)/cantidadDeNotasPorDepartamento[sumatoriaDeNotasPorDepartamento.indexOf(nota)] > mayorPromedio){
        tercermayorPromedio = segundomayorPromedio;
        posicionTercerMayorPromedio = posicionSegundoMayorPromedio;
        segundomayorPromedio = mayorPromedio;
        posicionSegundoMayorPromedio = posicionMayorPromedio;
        mayorPromedio = (nota)/cantidadDeNotasPorDepartamento[sumatoriaDeNotasPorDepartamento.indexOf(nota)];
        posicionMayorPromedio = sumatoriaDeNotasPorDepartamento.indexOf(nota);


      } else if ((nota)/cantidadDeNotasPorDepartamento[sumatoriaDeNotasPorDepartamento.indexOf(nota)] > segundomayorPromedio) {
        tercermayorPromedio = segundomayorPromedio;
        posicionTercerMayorPromedio = posicionSegundoMayorPromedio;
        segundomayorPromedio = (nota)/cantidadDeNotasPorDepartamento[sumatoriaDeNotasPorDepartamento.indexOf(nota)];
        posicionSegundoMayorPromedio = sumatoriaDeNotasPorDepartamento.indexOf(nota);

      } else if ((nota)/cantidadDeNotasPorDepartamento[sumatoriaDeNotasPorDepartamento.indexOf(nota)] > tercermayorPromedio) {
        tercermayorPromedio = (nota)/cantidadDeNotasPorDepartamento[sumatoriaDeNotasPorDepartamento.indexOf(nota)];
        posicionTercerMayorPromedio = sumatoriaDeNotasPorDepartamento.indexOf(nota);
      }
    }
    String[] top3MejoresDepartamentosPorNotas = new String[3] ;
    top3MejoresDepartamentosPorNotas[0] = departamentos.get(posicionMayorPromedio);
    top3MejoresDepartamentosPorNotas[1] = departamentos.get(posicionSegundoMayorPromedio);
    top3MejoresDepartamentosPorNotas[2] = departamentos.get(posicionTercerMayorPromedio);
    return top3MejoresDepartamentosPorNotas;
  }

  @Override
  public String[] encontrarPeores3PromediosDepartamentos() {
    List<String> departamentos = new ArrayList<>();
    int [] cantidadDeNotasPorDepartamento = new int[32];
    List<Double> sumatoriaDeNotasPorDepartamento = new ArrayList<>();
    for (Estudiante estudiante:this.estudianteRepository.devolverInformacionEstudiantes()){
      if(!departamentos.contains(estudiante.departamento())){
        departamentos.add(estudiante.departamento());
        sumatoriaDeNotasPorDepartamento.add(0D);
      }
      cantidadDeNotasPorDepartamento[departamentos.indexOf(estudiante.departamento())]++ ;
      sumatoriaDeNotasPorDepartamento.set(departamentos.indexOf(estudiante.departamento()),sumatoriaDeNotasPorDepartamento.get(departamentos.indexOf(estudiante.departamento()))+estudiante.notaPromedio());
    }
    double menorPromedio =5D;
    double segundomenorPromedio =5D;
    double tercermenorPromedio =5D;
    int posicionMenorPromedio = 0;
    int posicionSegundoMenorPromedio = 0;
    int posicionTercerMenorPromedio = 0;

    for (Double nota:sumatoriaDeNotasPorDepartamento){
      if ((nota)/cantidadDeNotasPorDepartamento[sumatoriaDeNotasPorDepartamento.indexOf(nota)] < menorPromedio){
        tercermenorPromedio = segundomenorPromedio;
        posicionTercerMenorPromedio = posicionSegundoMenorPromedio;
        segundomenorPromedio = menorPromedio;
        posicionSegundoMenorPromedio = posicionMenorPromedio;
        menorPromedio = (nota)/cantidadDeNotasPorDepartamento[sumatoriaDeNotasPorDepartamento.indexOf(nota)];
        posicionMenorPromedio = sumatoriaDeNotasPorDepartamento.indexOf(nota);
      } else if ((nota)/cantidadDeNotasPorDepartamento[sumatoriaDeNotasPorDepartamento.indexOf(nota)] < segundomenorPromedio) {
        tercermenorPromedio = segundomenorPromedio;
        posicionTercerMenorPromedio = posicionSegundoMenorPromedio;
        segundomenorPromedio = (nota)/cantidadDeNotasPorDepartamento[sumatoriaDeNotasPorDepartamento.indexOf(nota)];
        posicionSegundoMenorPromedio = sumatoriaDeNotasPorDepartamento.indexOf(nota);

      } else if ((nota)/cantidadDeNotasPorDepartamento[sumatoriaDeNotasPorDepartamento.indexOf(nota)] < tercermenorPromedio) {
        tercermenorPromedio = (nota)/cantidadDeNotasPorDepartamento[sumatoriaDeNotasPorDepartamento.indexOf(nota)];
        posicionTercerMenorPromedio=sumatoriaDeNotasPorDepartamento.indexOf(nota);

      }
    }
    String[] top3peoresDepartamentosPorNotas = new String[3] ;
    top3peoresDepartamentosPorNotas[0] = departamentos.get(posicionMenorPromedio);
    top3peoresDepartamentosPorNotas[1] = departamentos.get(posicionSegundoMenorPromedio);
    top3peoresDepartamentosPorNotas[2] = departamentos.get(posicionTercerMenorPromedio);
    return top3peoresDepartamentosPorNotas;

  }

  @Override
  public String encontrarDepartamentoConMayorCantidadEstudiantesNoDeseanEstudiar() {
    List<String> departamentos = new ArrayList<>();
    List<Integer> cantidadPorDepartamento = new ArrayList<>();
    for(Estudiante estudiante: this.estudianteRepository.devolverInformacionEstudiantes()){
      if(!departamentos.contains(estudiante.departamento())){
        departamentos.add(estudiante.departamento());
        cantidadPorDepartamento.add(0);
      }
      if(estudiante.noLeGustaEstudiar()){
        cantidadPorDepartamento.set(departamentos.indexOf(estudiante.departamento()),cantidadPorDepartamento.get(departamentos.indexOf(estudiante.departamento()))+1);
      }
    }
    int mayorCantidadDeNoDeseaEstudiar = 0;

    for (Integer cantidad: cantidadPorDepartamento){
      if (cantidad > mayorCantidadDeNoDeseaEstudiar)
        mayorCantidadDeNoDeseaEstudiar = cantidad;
    }
    return departamentos.get(cantidadPorDepartamento.indexOf(mayorCantidadDeNoDeseaEstudiar));
  }
}


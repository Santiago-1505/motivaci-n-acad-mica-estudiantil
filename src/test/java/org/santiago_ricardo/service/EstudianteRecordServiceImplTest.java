package org.santiago_ricardo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.santiago_ricardo.repository.EstudianteEnMemoriaRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstudianteRecordServiceImplTest {

  private EstudianteRecordService estudianteRecordService;

  @BeforeEach
  void setUp() {
    this.estudianteRecordService = new EstudianteRecordServiceImpl(new EstudianteEnMemoriaRepositoryImpl());
  }



  @Test
  void calcularPromedio() {
    Double promedio = this.estudianteRecordService.calcularPromedio();
    assertNotNull(promedio);
    assertEquals(17.15,promedio);
  }

  @Test
  void contarEstudiantes() {
    Integer cantidadEstudiantes = this.estudianteRecordService.contarEstudiantes();
    assertNotNull(cantidadEstudiantes);
    assertEquals(20,cantidadEstudiantes);
  }

  @Test
  void contarEstudiantesQueNoDeseanEstudiar() {
    Double cantidadEstudiantesQueNoDeseanEstudiar = this.estudianteRecordService.contarEstudiantesQueNoDeseanEstudiar();
    assertNotNull(cantidadEstudiantesQueNoDeseanEstudiar);
    assertEquals(10,cantidadEstudiantesQueNoDeseanEstudiar);
  }

  @Test
  void contarEstudiantesSinRecursosYNoDeseanEstudiar() {
    Double cantidadEstudiantesSinRecursosYNoDeseanEstudiar = this.estudianteRecordService.contarEstudiantesSinRecursosYNoDeseanEstudiar();
    assertNotNull(cantidadEstudiantesSinRecursosYNoDeseanEstudiar);
    assertEquals(5,cantidadEstudiantesSinRecursosYNoDeseanEstudiar);
  }

  @Test
  void contarEstudiantesQueNoDeseanEstudiarYRecibenEsenanzasAntiguas() {
    Double cantidadEstudiantesQueNoDeseanEstudiarYRecibenEsenanzasAntiguas = this.estudianteRecordService.contarEstudiantesQueNoDeseanEstudiarYRecibenEsenanzasAntiguas();
    assertNotNull(cantidadEstudiantesQueNoDeseanEstudiarYRecibenEsenanzasAntiguas);
    assertEquals(8,cantidadEstudiantesQueNoDeseanEstudiarYRecibenEsenanzasAntiguas);
  }

  @Test
  void contarEstudiantesSinRecursosYRecibenEsenanzasAntiguas() {
    Double cantidadEstudiantesSinRecursosYRecibenEsenanzasAntiguas = this.estudianteRecordService.contarEstudiantesSinRecursosYRecibenEsenanzasAntiguas();
    assertNotNull(cantidadEstudiantesSinRecursosYRecibenEsenanzasAntiguas);
    assertEquals(4,cantidadEstudiantesSinRecursosYRecibenEsenanzasAntiguas);
  }

  @Test
  void contarEstudiantesSinRecursosYRecibenEsenanzasAntiguasYNoDeseanEstudiar() {
    Double cantidadEstudiantesSinRecursosYRecibenEsenanzasAntiguasYNoDeseanEstudiar = this.estudianteRecordService.contarEstudiantesSinRecursosYRecibenEsenanzasAntiguasYNoDeseanEstudiar();
    assertNotNull(cantidadEstudiantesSinRecursosYRecibenEsenanzasAntiguasYNoDeseanEstudiar);
    assertEquals(3,cantidadEstudiantesSinRecursosYRecibenEsenanzasAntiguasYNoDeseanEstudiar);
  }

  @Test
  void calcularEdadQueMasSeRepite() {
    Double cantidadQueMasSeRepite = this.estudianteRecordService.calcularEdadQueMasSeRepite();
    assertNotNull(cantidadQueMasSeRepite);
    assertEquals(16,cantidadQueMasSeRepite);
  }

  @Test
  void contarPromedioBajoYRecibenEsenanzasAntiguas() {
    Double cantidadPromedioBajoYRecibenEsenanzasAntiguas = this.estudianteRecordService.contarPromedioBajoYRecibenEsenanzasAntiguas();
    assertNotNull(cantidadPromedioBajoYRecibenEsenanzasAntiguas);
    assertEquals(8,cantidadPromedioBajoYRecibenEsenanzasAntiguas);
  }

  @Test
  void contarPromedioBajoYNoDeseanEstudiar() {
    Double cantidadPromedioBajoYNoDeseanEstudiar = this.estudianteRecordService.contarPromedioBajoYNoDeseanEstudiar();
    assertNotNull(cantidadPromedioBajoYNoDeseanEstudiar);
    assertEquals(9,cantidadPromedioBajoYNoDeseanEstudiar);
  }

  @Test
  void encontrarMejores3PromediosDepartamentos() {
    String[] mejores3PromediosDepartamentos = new String[3];
    mejores3PromediosDepartamentos = this.estudianteRecordService.encontrarMejores3PromediosDepartamentos();
    assertEquals("Cundinamarca", mejores3PromediosDepartamentos[0]);
    assertEquals("Sucre", mejores3PromediosDepartamentos[1]);
    assertEquals("Meta", mejores3PromediosDepartamentos[2]);
  }

  @Test
  void encontrarPeores3PromediosDepartamentos() {
    String[] peores3PromediosDepartamentos = new String[3];
    peores3PromediosDepartamentos = this.estudianteRecordService.encontrarPeores3PromediosDepartamentos();
    assertEquals("Nariño", peores3PromediosDepartamentos[0]);
    assertEquals("Arauca", peores3PromediosDepartamentos[1]);
    assertEquals("Huila", peores3PromediosDepartamentos[2]);
  }

  @Test
  void encontrarDepartamentoConMayorCantidadEstudiantesNoDeseanEstudiar() {
    String departamentoConMayorCantidadEstudiantesNoDeseanEstudiar = this.estudianteRecordService.encontrarDepartamentoConMayorCantidadEstudiantesNoDeseanEstudiar();
    assertEquals("Vichada",departamentoConMayorCantidadEstudiantesNoDeseanEstudiar);
  }

  @Test
  void contarEstudiantesSinRecursos() {

  }

  @Test
  void contarEstudiantesQueRecibenEsenanzasAntiguas() {
  }
}

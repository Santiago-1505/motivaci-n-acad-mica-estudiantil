package org.santiago_ricardo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.santiago_ricardo.repository.EstudianteInMemoryRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstudianteRecordServiceImplTest {

  private EstudianteRecordService estudianteRecordService;

  @BeforeEach
  void setUp() {
    this.estudianteRecordService = new EstudianteRecordServiceImpl(new EstudianteInMemoryRepositoryImpl());
  }



  @Test
  void calcularPromedio() {
    Double promedio = this.estudianteRecordService.calcularPromedio();
    assertNotNull(promedio);
  }

  @Test
  void contarEstudiantes() {
    Integer cantidadEstudiantes = this.estudianteRecordService.contarEstudiantes();
    assertNotNull(cantidadEstudiantes);
    assertEquals(20,cantidadEstudiantes);
  }

  @Test
  void contarEstudiantesQueNoDeseanEstudiar() {
    Integer cantidadEstudiantesQueNoDeseanEstudiar = this.estudianteRecordService.contarEstudiantesQueNoDeseanEstudiar();
    assertNotNull(cantidadEstudiantesQueNoDeseanEstudiar);
    assertEquals(10,cantidadEstudiantesQueNoDeseanEstudiar);
  }

  @Test
  void contarEstudiantesSinRecursosYNoDeseanEstudiar() {
    Integer cantidadEstudiantesSinRecursosYNoDeseanEstudiar = this.estudianteRecordService.contarEstudiantesSinRecursosYNoDeseanEstudiar();
    assertNotNull(cantidadEstudiantesSinRecursosYNoDeseanEstudiar);
  }

  @Test
  void contarEstudiantesQueNoDeseanEstudiarYRecibenEsenanzasAntiguas() {
    Integer cantidadEstudiantesQueNoDeseanEstudiarYRecibenEsenanzasAntiguas = this.estudianteRecordService.contarEstudiantesQueNoDeseanEstudiarYRecibenEsenanzasAntiguas();
    assertNotNull(cantidadEstudiantesQueNoDeseanEstudiarYRecibenEsenanzasAntiguas);
  }

  @Test
  void contarEstudiantesSinRecursosYRecibenEsenanzasAntiguas() {
    Integer cantidadEstudiantesSinRecursosYRecibenEsenanzasAntiguas = this.estudianteRecordService.contarEstudiantesSinRecursosYRecibenEsenanzasAntiguas();
    assertNotNull(cantidadEstudiantesSinRecursosYRecibenEsenanzasAntiguas);
  }

  @Test
  void contarEstudiantesSinRecursosYRecibenEsenanzasAntiguasYNoDeseanEstudiar() {
    Integer cantidadEstudiantesSinRecursosYRecibenEsenanzasAntiguasYNoDeseanEstudiar = this.estudianteRecordService.contarEstudiantesSinRecursosYRecibenEsenanzasAntiguasYNoDeseanEstudiar();
    assertNotNull(cantidadEstudiantesSinRecursosYRecibenEsenanzasAntiguasYNoDeseanEstudiar);
  }

  @Test
  void calcularEdadQueMasSeRepite() {
    Integer cantidadQueMasSeRepite = this.estudianteRecordService.calcularEdadQueMasSeRepite();
    assertNotNull(cantidadQueMasSeRepite);
    assertEquals(16,cantidadQueMasSeRepite);
  }

  @Test
  void contarPromedioBajoYRecibenEsenanzasAntiguas() {
    Integer cantidadPromedioBajoYRecibenEsenanzasAntiguas = this.estudianteRecordService.contarPromedioBajoYRecibenEsenanzasAntiguas();
    assertNotNull(cantidadPromedioBajoYRecibenEsenanzasAntiguas);
    assertEquals(8,cantidadPromedioBajoYRecibenEsenanzasAntiguas);
  }

  @Test
  void contarPromedioBajoYNoDeseanEstudiar() {
    Integer cantidadPromedioBajoYNoDeseanEstudiar = this.estudianteRecordService.contarPromedioBajoYNoDeseanEstudiar();
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
}

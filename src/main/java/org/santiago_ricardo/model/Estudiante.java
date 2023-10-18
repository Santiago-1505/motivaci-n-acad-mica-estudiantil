package org.santiago_ricardo.model;

import java.time.LocalDate;

public record Estudiante(String nombre,
                         int edad,
                         boolean seUsanTecnicasDeEnseñansaAntiguas,
                         boolean faltaDeRecursos,
                         boolean noLeGustaEstudiar,
                         Double notaPromedio,
                         String departamento ) {}



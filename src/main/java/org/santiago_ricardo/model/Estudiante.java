package org.santiago_ricardo.model;

public record Estudiante(String nombre,
                         int edad,
                         boolean seUsanTecnicasDeEnsenansaAntiguas,
                         boolean faltaDeRecursos,
                         boolean noLeGustaEstudiar,
                         Double notaPromedio,
                         String departamento ) {}



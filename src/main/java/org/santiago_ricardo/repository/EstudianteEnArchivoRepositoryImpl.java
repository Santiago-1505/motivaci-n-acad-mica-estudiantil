package org.santiago_ricardo.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.santiago_ricardo.model.Estudiante;

public class EstudianteEnArchivoRepositoryImpl implements EstudianteRepository {
    private static final Logger logger = LoggerFactory.getLogger(EstudianteEnArchivoRepositoryImpl.class);
    private List<Estudiante> estudiantesList;

    public EstudianteEnArchivoRepositoryImpl() {
        this.estudiantesList = new ArrayList<>(cargarEstudiantes());
    }

    private List<Estudiante> cargarEstudiantes() {
        logger.info("Cargando los datos desde archivo");
        List<String> plainTextEstudiantesList = leerArchivoConEstudiantes();
        return plainTextEstudiantesList.stream()
                .map(this::construirEstudiante)
                .toList();
    }

    private List<String> leerArchivoConEstudiantes() {
        Path path = Paths.get("./src/main/resources/estudiantes.txt");
        try (Stream<String> stream = Files.lines(path)) {
            return stream.collect(Collectors.toList());
        } catch (IOException x) {
            logger.error("IOException: {}", x);
            return Collections.emptyList();
        }
    }

    private Estudiante construirEstudiante(String plainTextEstudiantes) {
        String[] studentArray = plainTextEstudiantes.split(",");
        return new Estudiante(studentArray[0], Integer.parseInt(studentArray[1]),
                Boolean.parseBoolean(studentArray[2]), Boolean.parseBoolean(studentArray[3]),
                Boolean.parseBoolean(studentArray[4]), Double.valueOf(studentArray[5]),
                studentArray[6]);
    }


    @Override
    public List<Estudiante> devolverInformacionEstudiantes() {
        return estudiantesList;
    }
}

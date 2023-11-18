package org.santiago_ricardo.repository;

import java.util.List;
import org.santiago_ricardo.model.Estudiante;

public class EstudianteEnMemoriaRepositoryImpl implements EstudianteRepository {
    @Override
    public List<Estudiante> devolverInformacionEstudiantes() {

        List<Estudiante> estudiantes =
                List.of(
                        new Estudiante("María García", 16, true, false, true, 2.3D, "Antioquia"),
                        new Estudiante("Juan Rodríguez", 17, false, true, false, 3.5D, "Vichada"),
                        new Estudiante("Laura López", 18, false, true, true, 1.3D, "Santander"),
                        new Estudiante("Andrés Pérez", 19, true, false, false, 4.0D, "Sucre"),
                        new Estudiante("Claudia Martínez", 16, true, true, true, 1.7D, "Amazonas"),
                        new Estudiante("Javier Fernández", 17, true, false, false, 3.8D, "Meta"),
                        new Estudiante("Paula Díaz", 18, true, false, true, 2.8D, "Vichada"),
                        new Estudiante("Miguel Torres", 17, true, false, true, 2.2D, "Arauca"),
                        new Estudiante("Elena Castro", 16, false, true, false, 4.5D, "Amazonas"),
                        new Estudiante("Carlos Ramírez", 17, true, false, false, 4.2D, "Antioquia"),
                        new Estudiante("Juan Pérez", 18, true, false, false, 3.9D, "Antioquia"),
                        new Estudiante("Ana González", 19, true, false, true, 2.9D, "Chocó"),
                        new Estudiante("Carlos Rodríguez", 16, false, false, false, 4.5D, "Santander"),
                        new Estudiante("María Ramírez", 17, false, false, false, 4.7D, "Cundinamarca"),
                        new Estudiante("Luis Torres", 16, false, false, false, 4.3D, "Antioquia"),
                        new Estudiante("Laura Sánchez", 19, true, false, true, 3.1, "Vichada"),
                        new Estudiante("Alejandro Mendoza", 16, false, true, true, 2.8D, "Putomayo"),
                        new Estudiante("Diana Castañeda", 17, true, true, false, 2.7D, "Huila"),
                        new Estudiante("Andrés Morales", 18, true, true, true, 2.0D, "Amazonas"),
                        new Estudiante("Claudia Gómez", 16, true, true, true, 2.1D, "Nariño"));

        return estudiantes;
    }

    @Override
    public Estudiante anadirEstudiante( Estudiante nuevoEstudiante) {
        return null;
    }
}


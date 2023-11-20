package org.santiago_ricardo.controlador;

import java.util.List;

import org.santiago_ricardo.model.Estudiante;
import org.santiago_ricardo.repository.EstudianteEnArchivoRepositoryImpl;
import org.santiago_ricardo.repository.EstudianteEnMemoriaRepositoryImpl;
import org.santiago_ricardo.service.EstudianteRecordService;
import org.santiago_ricardo.service.EstudianteRecordServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estudiantes/")
@CrossOrigin(origins = "*")
public class ControladorEstudiante {

    EstudianteRecordService estudianteRecordService = new EstudianteRecordServiceImpl(new EstudianteEnArchivoRepositoryImpl());
    @GetMapping
    public List<Estudiante> ListarEstudiantes(){
        System.out.println("Listando estudiantes");
        return estudianteRecordService.listarEstudiantes();
    }


    @PostMapping
    public ResponseEntity<Estudiante> agregarEstudiante(@RequestBody Estudiante nuevoEstudiente){
        System.out.println("Añadiendo un estudiante :)");
        Estudiante estudiante = estudianteRecordService.agregarEstudiante(nuevoEstudiente );

        return ResponseEntity.status( HttpStatus.OK).body(estudiante);
    }
}

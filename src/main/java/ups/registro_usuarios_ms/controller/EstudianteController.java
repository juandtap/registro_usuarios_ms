package ups.registro_usuarios_ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ups.registro_usuarios_ms.model.Estudiante;
import ups.registro_usuarios_ms.services.EstudianteService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/micro1/estudiante/")
public class EstudianteController {

    @Autowired
    public EstudianteService estudianteService;
    @PostMapping("/guardar")
    public ResponseEntity<Estudiante> save(@RequestBody Estudiante estudiante){
        Estudiante temp = estudianteService.create(estudiante);

        try {
            return ResponseEntity.created(new URI("/micro1/estudiante/guardar"+temp.getCedula())).body(temp);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<Estudiante>> listAll(){

        return ResponseEntity.ok(estudianteService.listEstudiantes());

    }

    @GetMapping("/buscar")
    public ResponseEntity<Estudiante> buscarEstudiante(@RequestParam String cedula) {
        Optional<Estudiante> estudianteEncontrado = estudianteService.buscarEstudiante(cedula);
        return estudianteEncontrado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }



    //pendiente el delete



}

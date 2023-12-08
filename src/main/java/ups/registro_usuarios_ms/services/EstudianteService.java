package ups.registro_usuarios_ms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.registro_usuarios_ms.model.Estudiante;
import ups.registro_usuarios_ms.repository.EstudianteRepository;

import java.util.List;
import java.util.Optional;


@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;

    public Estudiante create(Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }

    public List<Estudiante> listEstudiantes(){
        return estudianteRepository.findAll();
    }

    public void delete(Estudiante estudiante){
        estudianteRepository.delete(estudiante);
    }

    public Optional<Estudiante> buscarEstudiante(String cedula) {
        try {
            List<Estudiante> estudianteEncontrados = estudianteRepository.findByCedulaIgnoreCase(cedula);
            return estudianteEncontrados.isEmpty() ? Optional.empty() : Optional.of(estudianteEncontrados.get(0));
        } catch (Exception e) {
            System.err.println("Error al buscar estudiante por cédula: " + cedula + ", " + e.getMessage());
            return Optional.empty();
        }
    }

}

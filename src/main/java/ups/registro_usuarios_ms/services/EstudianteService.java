package ups.registro_usuarios_ms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.registro_usuarios_ms.model.Estudiante;
import ups.registro_usuarios_ms.repository.EstudianteRepository;

import java.util.List;


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
}

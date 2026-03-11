package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List; // Importá la lista de Java

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    // --- El método que ya tenías de registrar (POST) ---
    @PostMapping
    @Transactional
    public void registrar(@RequestBody @Valid DatosRegistroTopico datos) {
        var yaExiste = repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje());
        if (yaExiste) {
            throw new RuntimeException("Este tópico ya existe en el foro.");
        }
        repository.save(new Topico(datos));
    }

    // --- NUEVO MÉTODO PARA LA TARJETA 6 (GET) ---
    @GetMapping
    public List<DatosListadoTopico> listar() {
        return repository.findAll().stream()
                .map(DatosListadoTopico::new)
                .toList();

    }
    @PutMapping
    @Transactional
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizarTopico datosActualizar) {
        var topico = repository.getReferenceById(datosActualizar.id());
        topico.actualizarDatos(datosActualizar);

        return ResponseEntity.ok(new DatosListadoTopico(topico));
    }
    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DatosListadoTopico(topico));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminar(@PathVariable Long id) {
        // Regla de negocio: Verificar si el id existe antes de eliminar
        var topicoOptional = repository.findById(id);

        if (topicoOptional.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build(); // Devuelve un 204 No Content (éxito)
        }

        return ResponseEntity.notFound().build(); // Devuelve un 404 si no existe
    }
}
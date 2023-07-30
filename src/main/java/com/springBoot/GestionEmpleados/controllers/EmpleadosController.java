package com.springBoot.GestionEmpleados.controllers;

import com.springBoot.GestionEmpleados.models.Empleado;
import com.springBoot.GestionEmpleados.repositorys.EmpleadoRepository;
import com.springBoot.GestionEmpleados.services.IEmpleadoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/empleados")
public class EmpleadosController {

    @Autowired
    IEmpleadoService empleadoService;
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Empleado>> getEmpleados() {
        ArrayList<Empleado> empleados;
        empleados = empleadoService.getEmpleados();
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    @PostMapping(value = "/guardar", consumes = "application/json")
    public ResponseEntity<Empleado> saveEmpleado(@RequestBody Empleado empleado) {
        Empleado nuevoEmpleado = null;
        try {
            nuevoEmpleado = empleadoService.saveEmpleado(empleado);
            return new ResponseEntity<Empleado>(nuevoEmpleado, HttpStatus.CREATED);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<Empleado>(nuevoEmpleado, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Empleado>> getEmpleadoById(@PathVariable Long id) {
        Optional<Empleado> empleado = null;
        try {
            empleado = empleadoService.getEmpleadoById(id);
            return new ResponseEntity<Optional<Empleado>>(empleado, HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<Optional<Empleado>>(empleado, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable Long id, @RequestBody Empleado empleadoActualizado) {
        Optional<Empleado> empleado = null;
        Empleado empleadoExistente = null;
        try {
            empleado = empleadoService.getEmpleadoById(id);
            empleadoExistente = empleado.get();
            Empleado nuevo = empleadoService.updateEmpleado(empleadoExistente, empleadoActualizado);
            return new ResponseEntity<Empleado>(nuevo, HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<Empleado>(empleadoExistente, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> deleteEmpleado(@PathVariable Long id){
        try {
            empleadoService.deleteEmpleadoById(id);
            return new ResponseEntity<String>("Se elimino el empleado con id: " + id, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}

package com.springBoot.GestionEmpleados.services;

import com.springBoot.GestionEmpleados.models.Empleado;

import java.util.ArrayList;
import java.util.Optional;

public interface IEmpleadoService {

    public ArrayList<Empleado> getEmpleados();

    public Optional<Empleado> getEmpleadoById(Long id);

    public Empleado saveEmpleado(Empleado empleado);

    public Empleado updateEmpleado(Empleado empleadoExistente, Empleado empleadoActualizado);

    public void deleteEmpleadoById(Long id);



}

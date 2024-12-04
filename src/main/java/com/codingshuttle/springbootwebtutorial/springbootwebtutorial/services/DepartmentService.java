package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.services;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.DepartmentDTO;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.entities.Department;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.exceptions.ResourceNotFoundException;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public DepartmentService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    // Get all departments
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream()
                .map(department -> modelMapper.map(department, DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    // Create a new department
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        Department department = modelMapper.map(departmentDTO, Department.class);

        department = departmentRepository.save(department);
        return modelMapper.map(department, DepartmentDTO.class);
    }

    // Update an existing department
    public DepartmentDTO updateDepartment(DepartmentDTO departmentDTO) {
        isExistsByDepartmentId(departmentDTO.getId());
        Department department = modelMapper.map(departmentDTO, Department.class);
        department.setId(departmentDTO.getId());
        Department savedDepartment = departmentRepository.save(department);
        return modelMapper.map(savedDepartment, DepartmentDTO.class);
    }

    public void isExistsByDepartmentId(Long departmentId) {
        boolean exists = departmentRepository.existsById(departmentId);
        if(!exists) throw new ResourceNotFoundException("Department not found with id: "+departmentId);
    }
    // Delete a department by ID
    public boolean deleteDepartment(Long id) {
        isExistsByDepartmentId(id);
        departmentRepository.deleteById(id);
        return false;
    }

    // Get a department by ID
    public Optional<DepartmentDTO> getDepartmentById(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        return department.map(d -> modelMapper.map(d, DepartmentDTO.class));
    }
}

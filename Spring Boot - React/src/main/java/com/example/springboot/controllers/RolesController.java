package com.example.springboot.controllers;

import com.example.springboot.entities.Role;
import com.example.springboot.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RolesController {
    private final RoleRepository roleRepository;

    @Autowired
    public RolesController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping("/admin/roles")
    public String home(Model model) {
        Pageable pageable = PageRequest.of(1, 1);
        Page<Role> page = roleRepository.findAll(pageable);
        model.addAttribute("page", page);
        return "/admin/roles/index";
    }
}

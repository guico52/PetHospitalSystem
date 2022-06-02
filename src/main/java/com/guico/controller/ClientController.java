package com.guico.controller;

import com.guico.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ClientController {

    @Autowired
    private PetMapperImpl petMapper;
    @Autowired
    private PetOwnerMapperImpl petOwnerMapper;
    @Autowired
    private PetVisitMapperImpl petVisitMapper;
    @Autowired
    private SpecMapperImpl specMapper;
    @Autowired
    private VetMapperImpl vetMapper;




}

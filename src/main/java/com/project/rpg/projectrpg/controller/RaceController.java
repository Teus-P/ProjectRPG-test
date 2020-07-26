package com.project.rpg.projectrpg.controller;

import com.project.rpg.projectrpg.entity.Race;
import com.project.rpg.projectrpg.service.RaceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/race")
public class RaceController {

    RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping("/list")
    public String listRaces(Model model){
        List<Race> races = raceService.findAll();
        model.addAttribute("races", races);

        return "races/list-races";
    }
}

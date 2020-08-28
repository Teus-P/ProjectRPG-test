package com.project.rpg.projectrpg.controller;

import com.project.rpg.projectrpg.entity.RaceEntity;
import com.project.rpg.projectrpg.service.race.RaceService;
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
        List<RaceEntity> raceEntities = raceService.findAll();
        model.addAttribute("races", raceEntities);

        return "races/list-races";
    }
}

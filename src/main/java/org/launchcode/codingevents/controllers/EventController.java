package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {
    private static HashMap<String, String> events = new HashMap<>();


    @GetMapping
    public String displayAllEvents(Model model){
        events.put("Menteaship","A fun meetup for connecting with mentors");
        events.put("Code With Pride","A fun meetup sponsored by LaunchCode");
        events.put("Javascripty", "An imaginary meetup for Javascript developers");
        model.addAttribute("events", events);
        return "events/index";
    }

    //lives at /events/create (events is from requestMapping up top)
    @GetMapping("create")
    public String processCreateEventForm(){
        return "events/create";
    }

    //lives at /events/create (they handle different methods and can live at the same path.)
    @PostMapping("create")
    public String createEvent(@RequestParam String eventName, @RequestParam String eventDescription){
        events.put(eventName, eventDescription);
        return "redirect:/events";
    }



}

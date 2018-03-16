package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    ActorRepository actorRepository;

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/")
    public String  loadData(Model model) {

        Actor actor = new Actor();
        actor.setName("Sandra bullock");
        actor.setRealname("Sandra Mae Bullowski");
        actorRepository.save(actor);

        Movie movie = new Movie();
        movie.setTitle("Emoji Movie");
        movie.setYear(2017);
        movie.setDescription("About Emojis...");
        movieRepository.save(movie);

        actor.addMovie(movie);
        actorRepository.save(actor);

        model.addAttribute("actors", actorRepository.findAll());
        return "index";
    }
}

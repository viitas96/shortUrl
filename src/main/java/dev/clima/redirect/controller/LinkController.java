package dev.clima.redirect.controller;

import dev.clima.redirect.model.Link;
import dev.clima.redirect.service.impl.LinkServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.net.URI;

@Controller
public class LinkController {

    private final LinkServiceImpl linkService;

    public LinkController(LinkServiceImpl linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/")
    public String add(@ModelAttribute("link") Link link){
        return "add_link";
    }

    @GetMapping("links/{id}")
    public String redirectTo(@PathVariable (value = "id") long id, Model model){
        Link link = linkService.get(id).orElse(null);
        model.addAttribute("link", link);

        return "shortUrl";
    }

    @GetMapping("/notFound")
    public String notFound() {return "404";}

    @GetMapping("/{id}")
    ResponseEntity<Void> redirected(@PathVariable (value = "id") long id){
        Link link = linkService.get(id).orElse(null);

        if (link != null)
            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(URI.create(link.getPath()))
                    .build();
        else
            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(URI.create("http://localhost:8080/notFound"))
                    .build();
    }

    @PostMapping("links/new")
    public String addLink(@ModelAttribute("link") @Valid Link link,
                          BindingResult bindingResult){

        if (bindingResult.hasErrors())
            return "add_link";

        Link savedLink = linkService.save(link);

        return "redirect:/links/" + savedLink.getId();
    }
}

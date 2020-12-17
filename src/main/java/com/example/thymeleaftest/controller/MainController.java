package com.example.thymeleaftest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.thymeleaftest.model.Player;
import com.example.thymeleaftest.form.PlayerForm;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    public static List<Player> players = new ArrayList<>();

    static {
        players.add(new Player(1, "Merry", "Hobbit"));
        players.add(new Player(2, "Pippin", "Hobbit"));
    }

    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @Value("${BASE_URL}")
    private String BASE_URL;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = {"/", "/index"})
    public String home(Model model) {
        model.addAttribute("message", message);
        return "index";
    }

    @GetMapping(value = {"/playerList"})
    public String index(Model model) {
        ResponseEntity<Player[]> response = restTemplate.getForEntity(
                BASE_URL, Player[].class
        );
        Player[] players = response.getBody();
        model.addAttribute("players", players);
        return "playerList";
    }

    @GetMapping(value = {"/addPlayer"})
    public String showAddPlayerPage(Model model) {
        PlayerForm playerForm = new PlayerForm();
        model.addAttribute("playerForm", playerForm);
        return "addPlayer";
    }

    @PostMapping(value = {"/addPlayer"})
    public String create(Model model, //
                             @ModelAttribute("playerForm") PlayerForm playerForm) {

        String name = playerForm.getName();
        String type = playerForm.getType();

        if (name != null && name.length() > 0) {
            Player newPlayer = new Player(name, type);
            ResponseEntity<Player> response = restTemplate.postForEntity(
                    BASE_URL, newPlayer, Player.class
            );
            return "redirect:/playerList";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "addPlayer";
    }

    @RequestMapping(value = {"/playerList/{id}"}, method = RequestMethod.GET)
    public String showHeroPage(Model model, @PathVariable int id) {

        ResponseEntity<Player> response = restTemplate.getForEntity(BASE_URL + id, Player.class);

        Player player = response.getBody();
        model.addAttribute("player", player);

        return "player";
    }

    @GetMapping(value = "/updatePlayer/{id}")
    public String GetById(Model model, @PathVariable("id") Integer id) {
        ResponseEntity<Player> response = restTemplate.getForEntity(BASE_URL + id, Player.class);
        Player updatedPlayer = response.getBody();
        PlayerForm playerForm = new PlayerForm();

        model.addAttribute("playerForm", playerForm);
        model.addAttribute("player", updatedPlayer);
        return "updatePlayer";
    }

    @PostMapping(value = "/update/{id}")
    public String update(Model model, @ModelAttribute("playerForm") PlayerForm playerForm,
                         @PathVariable("id") Integer id) {
        String name = playerForm.getName();
        String type = playerForm.getType();

        if (name != null && name.length() > 0) {
            Player newPlayer = new Player(id,name,type);
            HttpEntity<Player> response = new HttpEntity<>(newPlayer);
            restTemplate.put(BASE_URL+id, response, Player.class);

            return "redirect:/playerList";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "updatePlayer";
    }

    @RequestMapping(value = {"/delete/{id}"}, method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id) {
        restTemplate.delete(BASE_URL+id);
        return "redirect:/playerList";
    }

}

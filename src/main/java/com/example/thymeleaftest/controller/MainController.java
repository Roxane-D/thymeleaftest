package com.example.thymeleaftest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.example.thymeleaftest.model.Player;
import com.example.thymeleaftest.form.PlayerForm;

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

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message", message);
        return "index";
    }

    @RequestMapping(value = {"/playerList"}, method = RequestMethod.GET)
    public String playerList(Model model) {
        model.addAttribute("players", players);
        return "playerList";
    }

    @RequestMapping(value = {"/addPlayer"}, method = RequestMethod.GET)
    public String showAddPlayerPage(Model model) {
        PlayerForm playerForm = new PlayerForm();
        model.addAttribute("playerForm", playerForm);
        return "addPlayer";
    }

    @RequestMapping(value = {"/addPlayer"}, method = RequestMethod.POST)
    public String savePlayer(Model model, //
                             @ModelAttribute("playerForm") PlayerForm playerForm) {

        int id = playerForm.getId();
        String name = playerForm.getName();
        String type = playerForm.getType();

        //
        if (name != null && name.length() > 0) {
            Player newPlayer = new Player(id, name, type);
            players.add(newPlayer);
            return "redirect:/playerList";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "addPlayer";
    }

}

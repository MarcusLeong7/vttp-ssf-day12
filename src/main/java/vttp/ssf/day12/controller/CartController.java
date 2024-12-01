package vttp.ssf.day12.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp.ssf.day12.models.LineItem;
import vttp.ssf.day12.models.Constants;

@Controller
@RequestMapping("/cart")
public class CartController {

    // Get /cart
    // defaultValue must always be in String
    // RequestParam is for queries
    @GetMapping
    public String getCart(@RequestParam(required = true) String name,
            /* @RequestParam(defaultValue = "4") int count , */
                          @RequestParam String count,
                          Model model) {

        // Perform manual conversion from String to int
        int itemCount = 4;
        try {
            itemCount = Integer.parseInt(count);
        } catch (Exception e) {
        }

        List<LineItem> items = Constants.generateLineItems(itemCount);

        model.addAttribute("name", name.toUpperCase());
        model.addAttribute("items", items);
        model.addAttribute("count", 9);
        return "cart";
    }

    @GetMapping("/map")
    public String getCart(
            @RequestParam MultiValueMap<String, String> form, Model model
    ) {
        String name = form.getFirst("name");
        String count = form.getFirst("count");

        System.out.printf(">>> get first: %s\n", form.getFirst("delivery"));
        System.out.printf(">>> get: %s\n", form.get("delivery"));

        int itemCount = Integer.parseInt(count);
        try {
            itemCount = Integer.parseInt(count);
        } catch (Exception e) {

        }

        List<LineItem> items = Constants.generateLineItems(itemCount);

        model.addAttribute("name", name.toUpperCase());
        model.addAttribute("items", items);
        model.addAttribute("count", 9);

        return "cart";

    }


}

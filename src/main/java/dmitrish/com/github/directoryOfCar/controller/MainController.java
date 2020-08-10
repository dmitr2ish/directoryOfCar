package dmitrish.com.github.directoryOfCar.controller;

import dmitrish.com.github.directoryOfCar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    final private CarService carService;

    @Autowired
    public MainController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/")
    public ModelAndView getMainPage() {
        return new ModelAndView("main");
    }
}

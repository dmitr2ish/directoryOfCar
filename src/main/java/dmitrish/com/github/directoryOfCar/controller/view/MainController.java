package dmitrish.com.github.directoryOfCar.controller.view;

import dmitrish.com.github.directoryOfCar.entity.Car;
import dmitrish.com.github.directoryOfCar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
public class MainController {

    final private CarService carService;

    @Autowired
    public MainController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/")
    public ModelAndView getMainPage() {
        ModelAndView mav = new ModelAndView("main");
        mav.addObject("countOfNotes", carService.countOfNotes());
        return mav.addObject("todayDate", LocalDate.now());
    }
}

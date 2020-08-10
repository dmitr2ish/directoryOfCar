package dmitrish.com.github.directoryOfCar.controller.rest;

import dmitrish.com.github.directoryOfCar.entity.Car;
import dmitrish.com.github.directoryOfCar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/car/")
public class RestControllerCar {

    final private CarService carService;

    @Autowired
    public RestControllerCar(CarService carService) {
        this.carService = carService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addCar(@RequestBody Car car) {
        carService.add(car);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Car>> getAllCars() {
        final List<Car> cars = carService.getAll();
        return cars != null && !cars.isEmpty()
                ? new ResponseEntity<>(cars, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable(name = "id") long id) {
        final Car car = carService.getById(id);

        return car != null
                ? new ResponseEntity<>(car, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCar (@RequestBody Car car) {
        carService.update(car);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCar(@RequestBody Car car) {
        carService.delete(car);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

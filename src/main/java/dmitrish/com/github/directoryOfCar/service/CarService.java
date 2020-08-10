package dmitrish.com.github.directoryOfCar.service;

import dmitrish.com.github.directoryOfCar.entity.Car;

import java.util.List;

public interface CarService {

    List<Car> getAll();

    List<Car> getAllByBrand(String brand);

    List<Car> getAllCheaperThenPrice(Integer price);

    List<Car> getAllMoreExpensiveThenPrice(Integer price);

    Car getById(Long id);

    void add(Car car);

    Car update(Car car);

    void delete(Car car);

    void deleteAll();

    int countOfNotes();

    int countOfCarOlderYear(Integer year);

    int countOfCarUntilYear(Integer year);

    boolean isExist(Car car);
}

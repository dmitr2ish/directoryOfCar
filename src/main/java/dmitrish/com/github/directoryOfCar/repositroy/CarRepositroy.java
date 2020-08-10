package dmitrish.com.github.directoryOfCar.repositroy;

import dmitrish.com.github.directoryOfCar.entity.Car;

import java.time.LocalDate;
import java.util.List;

public interface CarRepositroy {

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

    //Checking by license plate in base
    boolean isExist(Car car);
}

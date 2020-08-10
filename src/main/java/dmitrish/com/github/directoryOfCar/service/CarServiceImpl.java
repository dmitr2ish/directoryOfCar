package dmitrish.com.github.directoryOfCar.service;

import dmitrish.com.github.directoryOfCar.entity.Car;
import dmitrish.com.github.directoryOfCar.repositroy.CarRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    final private CarRepositroy carRepositroy;

    @Autowired
    public CarServiceImpl(CarRepositroy carRepositroy) {
        this.carRepositroy = carRepositroy;
    }

    @Override
    public List<Car> getAll() {
        return carRepositroy.getAll();
    }

    @Override
    public List<Car> getAllByBrand(String brand) {
        return carRepositroy.getAllByBrand(brand);
    }

    @Override
    public List<Car> getAllCheaperThenPrice(Integer price) {
        return carRepositroy.getAllCheaperThenPrice(price);
    }

    @Override
    public List<Car> getAllMoreExpensiveThenPrice(Integer price) {
        return carRepositroy.getAllMoreExpensiveThenPrice(price);
    }

    @Override
    public Car getById(Long id) {
        return carRepositroy.getById(id);
    }

    @Override
    public boolean add(Car car) {
        if (carRepositroy.isExist(car)) {
            return false;
        } else {
            carRepositroy.add(car);
            return true;
        }
    }

    @Override
    public Car update(Car car) {
        if (carRepositroy.isExist(car)) {
            return carRepositroy.update(car);

        } else {
            return null;
        }
    }

    @Override
    public void delete(Car car) {
        carRepositroy.delete(car);
    }

    @Override
    public void deleteAll() {
        carRepositroy.deleteAll();
    }

    @Override
    public int countOfNotes() {
        return carRepositroy.countOfNotes();
    }

    @Override
    public int countOfCarOlderYear(Integer year) {
        return carRepositroy.countOfCarOlderYear(year);
    }

    @Override
    public int countOfCarUnderYear(Integer year) {
        return carRepositroy.countOfCarUnderYear(year);
    }
}

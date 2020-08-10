package dmitrish.com.github.directoryOfCar.repositroy;

import dmitrish.com.github.directoryOfCar.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CarRepositoryImpl implements CarRepositroy {

    final private EntityManager entityManager;

    @Autowired
    public CarRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Car> getAll() {
        return entityManager.createQuery("select c from Car c")
                .getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> getAllByBrand(String brand) {
        return entityManager.createQuery("select c from Car c where c.brand = :brand")
                .setParameter("brand", brand)
                .getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> getAllCheaperThenPrice(Integer price) {
        return entityManager.createQuery("select c from Car c where c.price < :price")
                .setParameter(price, price)
                .getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> getAllMoreExpensiveThenPrice(Integer price) {
        return entityManager.createQuery("select c from Car c where c.price > :price")
                .setParameter(price, price)
                .getResultList();
    }

    @Override
    public Car getById(Long id) {
        return entityManager.find(Car.class, id);
    }

    @Override
    public void add(Car car) {
        entityManager.persist(car);
    }

    @Override
    public Car update(Car car) {
        return entityManager.merge(car);
    }

    @Override
    public void delete(Car car) {
        entityManager.remove(car);
    }

    @Override
    public void deleteAll() {
        entityManager.createQuery("delete from Car c")
                .executeUpdate();
    }

    @Override
    public int countOfNotes() {
        return entityManager.createQuery("select count(c) from Car c")
                .executeUpdate();
    }

    @Override
    public int countOfCarOlderYear(Integer year) {
        return entityManager.createQuery("select count(c) from Car c where c.yearOfManufacture < :year")
                .executeUpdate();
    }

    @Override
    public int countOfCarUnderYear(Integer year) {
        return entityManager.createQuery("select count(c) from Car c where c.yearOfManufacture > :year")
                .executeUpdate();
    }
}

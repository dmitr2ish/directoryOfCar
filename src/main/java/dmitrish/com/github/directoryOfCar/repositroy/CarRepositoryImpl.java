package dmitrish.com.github.directoryOfCar.repositroy;

import dmitrish.com.github.directoryOfCar.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class CarRepositoryImpl implements CarRepositroy {

    final private EntityManager entityManager;
    final private Logger log;

    @Autowired
    public CarRepositoryImpl(EntityManager entityManager) {
        this.log = Logger.getLogger(CarRepositoryImpl.class.getName());
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
    public boolean add(Car car){
        try {
            entityManager.persist(car);
            entityManager.flush();
            return true;
        } catch (Exception e) {
            log.warning("EXCEPTION IN ADD METHOD, GAME: " + car.getId() + ", " + e);
            return false;
        }
    }

    @Override
    public Car update(Car car) {
        try {
            entityManager.merge(car);
            entityManager.flush();
        } catch (Exception e) {
            log.warning("EXCEPTION IN UPDATE METHOD, GAME: " + car.getId() + ", " + e);
            return null;
        }
        return car;
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
    public Long countOfNotes() {
        return (Long) entityManager.createQuery("select count(c) from Car c")
                .getSingleResult();
    }

    @Override
    public boolean isExist(Car car) {
        return !entityManager.createQuery("select count(c) from Car c where c.licensePlate = :license")
                .setParameter("license", car.getLicensePlate())
                .getSingleResult()
                .equals(0L);
    }
}

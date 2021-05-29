package com.sda.weather_app.weather_app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class LocationRepositoryImpl implements LocationRepository {

    private final SessionFactory sessionFactory;

    public LocationRepositoryImpl() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }

    @Override
    public Location save(final Location location) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(location);

        transaction.commit();
        session.close();

        return location;
    }

    public void deleteById(Integer id) {
        sessionFactory.createEntityManager().createQuery("DELETE FROM Location l WHERE l.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public List<Location> findAll() {
        return sessionFactory.createEntityManager().createQuery("SELECT (l) FROM Location l", Location.class)
                .getResultList();
    }
}

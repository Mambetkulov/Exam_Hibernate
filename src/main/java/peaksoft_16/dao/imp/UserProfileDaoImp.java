package peaksoft_16.dao.imp;

import jakarta.persistence.EntityManager;
import peaksoft_16.config.Hibernate_config;
import peaksoft_16.dao.UserProfileDao;
import peaksoft_16.models.UserDetail;
import peaksoft_16.models.UserProfile;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

public class UserProfileDaoImp implements UserProfileDao {
    private final EntityManager entityManager = Hibernate_config.entityManagerFactory().createEntityManager();

    @Override
    public void save(UserProfile userProfile) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(userProfile);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }

    }

    @Override
    public Optional<UserProfile> findById(Long id) {
        return Optional.ofNullable(entityManager.find(UserProfile.class, id));
    }

    @Override
    public void deleteById(Long id) {
        try{
            entityManager.getTransaction().begin();
            UserProfile user = entityManager.createQuery("select u from UserProfile u where u.id = :id", UserProfile.class)
                    .setParameter("id", id)
                    .getSingleResult();
            entityManager.remove(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(UserProfile userProfile, Long id) {
        try{
            entityManager.getTransaction().begin();
            UserProfile  userProfile1 = entityManager.find(UserProfile.class, id);
            userProfile1.setUsername(userProfile.getUsername());
            userProfile1.setEmail(userProfile.getEmail());
            entityManager.merge(userProfile1);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<UserProfile> findByEmail(String email) {
        try{
            entityManager.getTransaction().begin();
            UserProfile userP = entityManager.createQuery("select u from UserProfile u where u.email = :email",UserProfile.class)
                    .setParameter("email",email).getSingleResult();
            entityManager.getTransaction().commit();
            return Optional.of(userP);
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserProfile> getUsersRegisteredAfterDate(LocalDate date) {
        List<UserProfile> userProfiles = new ArrayList<>();
        try{
            entityManager.getTransaction().begin();
            userProfiles = entityManager.createQuery("select u from UserProfile u where u.registrationDate < :date ",UserProfile.class)
                    .getResultList();

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return userProfiles;
    }
}

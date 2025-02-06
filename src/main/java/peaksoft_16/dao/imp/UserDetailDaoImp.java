package peaksoft_16.dao.imp;

import jakarta.persistence.EntityManager;
import peaksoft_16.config.Hibernate_config;
import peaksoft_16.dao.UserDetailDao;
import peaksoft_16.models.UserDetail;
import peaksoft_16.models.UserProfile;

import javax.security.auth.login.Configuration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDetailDaoImp implements UserDetailDao {
    private final EntityManager entityManager = Hibernate_config.entityManagerFactory().createEntityManager();

    @Override
    public void save(UserDetail userDetail, Long userId) {
        try{
            entityManager.getTransaction().begin();
            UserProfile userProfile = entityManager.find(UserProfile.class, userId);
            userProfile.setUserDetail(userDetail);
            entityManager.merge(userProfile);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }

    }

    @Override
    public Optional<UserDetail> findById(Long id) {
        try{
            entityManager.getTransaction().begin();
            UserProfile userP = entityManager.createQuery("select u from UserProfile u where u.userDetail.id = :id",UserProfile.class)
                    .setParameter("id",id).getSingleResult();
            entityManager.getTransaction().commit();
            return Optional.of(userP.getUserDetail());
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(String new_addres, Long id) {
        try{
            entityManager.getTransaction().begin();
            UserProfile userP = entityManager.createQuery("select u from UserProfile u where u.userDetail.id = :id",UserProfile.class)
                    .setParameter("id",id).getSingleResult();
            userP.getUserDetail().setAddress(new_addres);
            entityManager.merge(userP);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try{
            entityManager.getTransaction().begin();
            entityManager.createQuery("update UserProfile u set u.userDetail = null where u.userDetail.id = ?1")
                    .setParameter(1, id)
                    .executeUpdate();

            entityManager.remove(entityManager.find(UserDetail.class,id));
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }

    }

    @Override
    public Optional<UserDetail> findByAddress(String address) {
        try{
            entityManager.getTransaction().begin();
            UserProfile userP = entityManager.createQuery("select u from UserProfile u where u.userDetail.address = :address",UserProfile.class)
                    .setParameter("address",address).getSingleResult();
            entityManager.getTransaction().commit();
            return Optional.of(userP.getUserDetail());
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserDetail> sortByDateOfBirth() {
        List<UserProfile> userProfiles = new ArrayList<>();
        List<UserDetail> userDetails = new ArrayList<>();
        try{
            entityManager.getTransaction().begin();
             userProfiles = entityManager.createQuery("select u from UserProfile u order by u.userDetail.dateOfBirth asc ",UserProfile.class)
                            .getResultList();
             for(UserProfile userProfile : userProfiles){
                 userDetails.add(userProfile.getUserDetail());
             }
            entityManager.getTransaction().commit();
        }catch(Exception e){

            throw new RuntimeException(e);
        }
        return userDetails;
    }
}

package peaksoft_16.dao;

import peaksoft_16.models.UserProfile;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserProfileDao {

    void save(UserProfile userProfile);



    Optional<UserProfile> findById (Long id);


    void deleteById(Long id);


    void update(UserProfile userProfile,Long id);

    Optional<UserProfile> findByEmail(String email);

    List<UserProfile> getUsersRegisteredAfterDate(LocalDate date);


}

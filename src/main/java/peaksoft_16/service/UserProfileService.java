package peaksoft_16.service;

import peaksoft_16.models.UserProfile;

import java.time.LocalDate;
import java.util.List;

public interface UserProfileService {

    String save(UserProfile userProfile);

    UserProfile findById (Long id);

    String deleteById(Long id);

    String update(UserProfile userProfile,Long id);

    UserProfile findByEmail(String email);

    List<UserProfile> getUsersRegisteredAfterDate(LocalDate date);
}

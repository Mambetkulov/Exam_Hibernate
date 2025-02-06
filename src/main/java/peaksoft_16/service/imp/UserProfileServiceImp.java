package peaksoft_16.service.imp;

import peaksoft_16.dao.UserProfileDao;
import peaksoft_16.dao.imp.UserProfileDaoImp;
import peaksoft_16.models.UserProfile;
import peaksoft_16.service.UserProfileService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserProfileServiceImp implements UserProfileService {
    private final UserProfileDao userProfileDao = new UserProfileDaoImp();

    @Override
    public String save(UserProfile userProfile) {
        try{
            userProfileDao.save(userProfile);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return "success";
    }

    @Override
    public UserProfile findById(Long id) {
        return userProfileDao.findById(id).orElse(null);
    }

    @Override
    public String deleteById(Long id) {
        try{
            userProfileDao.deleteById(id);
        }catch(Exception e){
            return e.getMessage();
        }
        return "success";

    }

    @Override
    public String update(UserProfile userProfile, Long id) {
      try{
          userProfileDao.update(userProfile, id);
      }catch(Exception e){
          throw new RuntimeException(e);
      }
      return "success";
    }

    @Override
    public UserProfile findByEmail(String email) {
        return userProfileDao.findByEmail(email).orElse(null);
    }

    @Override
    public List<UserProfile> getUsersRegisteredAfterDate(LocalDate date) {
        try{
            return userProfileDao.getUsersRegisteredAfterDate(date);
        }catch(Exception e){
            throw new RuntimeException(e);

        }

    }
}

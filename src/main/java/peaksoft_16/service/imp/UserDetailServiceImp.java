package peaksoft_16.service.imp;

import peaksoft_16.dao.UserDetailDao;
import peaksoft_16.dao.imp.UserDetailDaoImp;
import peaksoft_16.models.UserDetail;
import peaksoft_16.service.UserDetailService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDetailServiceImp implements UserDetailService {
    private final UserDetailDao userDetailDao = new UserDetailDaoImp();

    @Override
    public String save(UserDetail userDetail, Long userId) {
     try{
     userDetailDao.save(userDetail, userId);
     }catch(Exception e){
         return e.getMessage();
     }
     return "success";
    }

    @Override
    public Optional<UserDetail> findById(Long id) {
        try{
            return userDetailDao.findById(id);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public String update(String new_addres, Long id) {
        try{
            userDetailDao.update(new_addres, id);
        }catch(Exception e){
            throw new RuntimeException();
        }
        return "success";
    }

    @Override
    public String deleteById(Long id) {
        try{
            userDetailDao.deleteById(id);
        }catch(Exception e){
            return e.getMessage();
        }
        return "success";
    }

    @Override
    public Optional<UserDetail> findByAddress(String address) {
        try{
           return userDetailDao.findByAddress(address);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<UserDetail> sortByDateOfBirth() {
        try{
            return userDetailDao.sortByDateOfBirth();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
}

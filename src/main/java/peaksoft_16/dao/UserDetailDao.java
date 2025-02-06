package peaksoft_16.dao;

import peaksoft_16.models.UserDetail;

import java.util.List;
import java.util.Optional;

public interface UserDetailDao {

    void save(UserDetail userDetail , Long userId);

    Optional<UserDetail> findById(Long id);

    void update(String new_addres , Long id);

    void deleteById(Long id);

    Optional<UserDetail> findByAddress(String address);

    List<UserDetail> sortByDateOfBirth ();

}

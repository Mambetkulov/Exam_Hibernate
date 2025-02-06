package peaksoft_16.service;

import peaksoft_16.models.UserDetail;

import java.util.List;
import java.util.Optional;

public interface UserDetailService {

    String save(UserDetail userDetail , Long userId);

    Optional<UserDetail> findById(Long id);

    String update(String new_addres , Long id);

    String deleteById(Long id);

    Optional<UserDetail> findByAddress(String address);

    List<UserDetail> sortByDateOfBirth ();

}

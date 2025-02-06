package peaksoft_16;

import peaksoft_16.models.UserDetail;
import peaksoft_16.models.UserProfile;
import peaksoft_16.service.UserDetailService;
import peaksoft_16.service.UserProfileService;
import peaksoft_16.service.imp.UserDetailServiceImp;
import peaksoft_16.service.imp.UserProfileServiceImp;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Scanner scan = new Scanner(System.in);
        UserProfileService userProfile = new UserProfileServiceImp();
        UserDetailService userDetail = new UserDetailServiceImp();

        while ( true ) {
            System.out.println("""
                    press 1 to  add user profile
                    press 2 to  delete user profile
                    press 3 to  update user profile
                    press 4 to  find user profile
                    press 5 to  find user profile by email
                    press 6 to  get users registered after data
                    press 7 to  add user detail
                    press 8 to  delete user detail
                    press 9 to  update user detail
                    press 10 to  find user detail 
                    press 11 to  find user detail by address
                    press 12 to  get sorted user details by date 
                    
                    """);
            int input = scan.nextInt();
            switch ( input ) {
                case 1 : {
                    System.out.println(userProfile.save(new UserProfile("baiel","baiel@gmail.com")));
                    break;
                }
                case 2 : {
                    System.out.println(userProfile.deleteById(1L));
                    break;
                }
                case 3 : {
                    System.out.println(userProfile.update(new UserProfile("bro","bro@gmail.com"),1L));
                    break;
                }
                case 4 : {
                    System.out.println(userProfile.findById(1L));
                    break;
                }
                case 5 : {
                    System.out.println(userProfile.findByEmail("baiel@gmail.com"));
                    break;
                }
                case 6 : {
                    System.out.println(userProfile.getUsersRegisteredAfterDate(LocalDate.of(2023, 10, 10)));
                    break;
                }
                case 7 : {
                    System.out.println(userDetail.save(new UserDetail("hosh","vostok5"),1L));
                    break;
                }
                case 8 : {
                    System.out.println(userDetail.deleteById(1L));
                    break;
                }
                case 9 : {
                    System.out.println(userDetail.update("sum",3L));
                    break;
                }
                case 10 : {
                    System.out.println(userDetail.findById(2L));
                    break;
                }
                case 11 : {
                    System.out.println(userDetail.findByAddress("vostok5"));
                    break;
                }
                case 12 : {
                    System.out.println(userDetail.sortByDateOfBirth());
                    break;
                }

            }
        }


    }
}

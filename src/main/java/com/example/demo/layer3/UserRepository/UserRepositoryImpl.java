package com.example.demo.layer3.UserRepository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.example.demo.layer3.BaseRepository;
import com.example.demo.model.AirUser;



@Transactional
@Repository("userrepo")
public class UserRepositoryImpl extends BaseRepository implements UserRepository {

	public void insertUser(AirUser URef) {
		super.persist(URef);
		
	}

	public void updateUser(AirUser URef) {
		super.merge(URef);
		
	}

	public List<AirUser> selectUsersbyEmail(String emailId ) {
		System.out.println("email :"+emailId);
		List<AirUser> result= super.findAll("AirUser e where  e.emailId = '"+emailId +"'" );
		return result;
	}

	public List<AirUser> selectAllUsers() {
		return super.findAll("AirUser");
	}


	public void deleteUser(long id) {

			super.remove(AirUser.class,id);

		
	}

	
	public  AirUser SelectUserById(int userId) {
		return super.find(AirUser.class, userId);
	}

//	@Override
//	public AirUser findById(int userId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	

}

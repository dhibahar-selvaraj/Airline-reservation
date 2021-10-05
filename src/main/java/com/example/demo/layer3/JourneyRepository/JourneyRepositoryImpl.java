package com.example.demo.layer3.JourneyRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.example.demo.layer3.BaseRepository;
import com.example.demo.model.AirJourney;



@Repository("journeyrepo")
@Transactional
public class JourneyRepositoryImpl extends BaseRepository implements JourneyRepository {

	public void insertJourney(AirJourney Jref) {
		super.persist(Jref);
	}
	
	
	public List<AirJourney> findAllJourneys(String pojo) {
		return super.findAll(pojo);
	}


	public AirJourney findJourneyId(String source, String destination) {
		System.out.println("AirJourney j where lower(j.sourceLoc)=lower('"+source+"') and lower(j.destinationLoc)=lower('"+destination+"')");
		List<AirJourney> aj= super.findAll("AirJourney j where lower(j.sourceLoc)=lower('"+source+"') and lower(j.destinationLoc)=lower('"+destination+"')");
		if(aj.size()==0) {
			return null;
		}
		return aj.get(0);
	}
	
	
	public AirJourney findJourneyById(long Id) {
		return super.find(AirJourney.class, Id);
	}
	
	
	public void updateJourney(AirJourney Jref) {
		super.merge(Jref);
	}

	
	public void deleteJourney(long journeyToDelete) {
		super.remove(AirJourney.class,journeyToDelete);
		
	}

}

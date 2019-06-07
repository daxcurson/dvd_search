package ar.com.strellis.data_model_dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ar.com.strellis.data_model.Actor;
import ar.com.strellis.data_model.ActorDVD;
import ar.com.strellis.data_model.DVD;

@Dao
public interface ActorDVDDao
{
    @Insert
    public void insert(ActorDVD actorDVD);

    @Query("select * from dvd inner join actor_dvd on dvd.rowid=actor_dvd.dvdId where actor_dvd.actorId=:actorId")
    List<Actor> getDVDsforActor(final int actorId);

    @Query("select * from actor inner join actor_dvd on actor.id=actor_dvd.actorId where actor_dvd.dvdId=:dvdId")
    List<DVD> getActorsForDVD(final int dvdId);
}

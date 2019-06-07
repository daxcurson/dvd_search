package ar.com.strellis.data_model;

import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName="actor_dvd",primaryKeys={"dvdId","actorId"},
        foreignKeys = {
            @ForeignKey(entity=DVD.class,
                        parentColumns = "id",
                        childColumns = "dvdId"),
            @ForeignKey(entity = Actor.class,
                        parentColumns = "id",
                        childColumns = "actorId")
        }
)
public class ActorDVD
{
    public int actorId;
    public int dvdId;
}

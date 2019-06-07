package ar.com.strellis.data_model_dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ar.com.strellis.data_model.Actor;
import ar.com.strellis.data_model.DVD;
import ar.com.strellis.data_model.Director;
import ar.com.strellis.data_model.Publisher;

@Database(entities={DVD.class, Actor.class, Director.class, Publisher.class},version=1)
public abstract class DvdDatabase extends RoomDatabase
{
    public abstract DVDDao getDvdDao();
    public abstract ActorDao getActorDao();
    public abstract DirectorDao getDirectorDao();
    public abstract PublisherDao publisherDao();
    private static volatile DvdDatabase INSTANCE;

    static DvdDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DvdDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DvdDatabase.class, "dvd_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

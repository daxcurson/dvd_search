package ar.com.strellis.data_model_dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import ar.com.strellis.data_model.DVD;

@Dao
public interface DVDDao
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(DVD dvd);
    @Query("DELETE FROM dvd")
    public void deleteAll();
    @Query("SELECT * from dvd order by title")
    List<DVD> getAllDvds();
    @Query("select * from dvd where title=:title")
    List<DVD> getDVDByTitle(String title);
}

package ar.com.strellis.app_dvd_search;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import ar.com.strellis.data_model.DVD;
import ar.com.strellis.data_model_dao.DVDDao;
import ar.com.strellis.data_model_dao.DvdDatabase;

@RunWith(AndroidJUnit4.class)
public class DVDDaoTest
{
    private DVDDao dvdDao;
    private DvdDatabase db;

    @Before
    public void createDb()
    {
        Context context= ApplicationProvider.getApplicationContext();
        db= Room.inMemoryDatabaseBuilder(context,DvdDatabase.class).build();
        dvdDao=db.getDvdDao();
    }
    @After
    public void closeDb() throws IOException
    {
        db.close();
    }
    @Test
    public void createDvd()
    {
        DVD dvd=new DVD();
        dvd.setTitle("Terminator 2");
        dvdDao.insert(dvd);
        List<DVD> list=dvdDao.getDVDByTitle("Terminator 2");
        assertThat(list.get(0),equalTo(dvd));
    }
}

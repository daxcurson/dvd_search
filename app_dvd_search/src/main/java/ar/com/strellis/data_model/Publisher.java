package ar.com.strellis.data_model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Publisher
{
    @PrimaryKey
    private long id;
    private String name;

    public void setId(long id)
    {
        this.id=id;
    }
    public long getId()
    {
        return this.id;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return this.name;
    }
}

package ar.com.strellis.data_model;

import androidx.room.PrimaryKey;

public class Person
{
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;

    public void setName(String name) {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public void setId(long id)
    {
        this.id=id;
    }
    public long getId()
    {
        return this.id;
    }
}

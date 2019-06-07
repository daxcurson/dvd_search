package ar.com.strellis.data_model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.LinkedList;
import java.util.List;

@Entity
public class DVD
{
    @PrimaryKey
    @ColumnInfo(name="rowid")
    public int id;
    @ColumnInfo(name="title")
    public String title;
    @ColumnInfo(name="upc")
    public String UPC;

    public DVD()
    {
        this.id=0;
        this.title="";
        this.UPC="";
    }
    public void setTitle(String title)
    {
        this.title=title;
    }
    public String getTitle()
    {
        return this.title;
    }
    public void setUPC(String UPC) {
        this.UPC = UPC;
    }
    public String getUPC() {
        return UPC;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DVD dvd=(DVD)o;
        return this.id==dvd.id && this.title.equals(dvd.title) && this.UPC.equals(dvd.UPC);
    }
}

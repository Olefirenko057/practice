package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class Singer implements Serializable {
    private long id;
    private String firstName;
    private String lastName;
    private Date date;
    private List<Album> albums;

    public boolean addAlbum(Album album) {
        if(albums == null) {
            albums = new ArrayList<>();
            albums.add(album);
            return true;
        } else {
            if(albums.contains(album)) {
                return false;
            }
        }
        albums.add(album);
        return true;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", date=" + date +
                ", albums=" + albums +
                '}';
    }
}

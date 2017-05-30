package beginner.iak.com.simplelistview.model;

/**
 * Created by awidiyadew on 5/30/17.
 */

public class User {

    /* nama field harus sesuai dengan api response json */
    private int id;
    private String email;
    private String name;
    private String photo;

    public User() {
    }

    public User(int id, String email, String name, String photo) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

}

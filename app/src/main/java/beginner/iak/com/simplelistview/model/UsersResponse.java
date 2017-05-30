package beginner.iak.com.simplelistview.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by awidiyadew on 5/30/17.
 */

public class UsersResponse {

    private List<User> users;

    public UsersResponse(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

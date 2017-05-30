package beginner.iak.com.simplelistview.model;

/**
 * Created by SasserNetsky on 5/25/17.
 */

public class Note {
    private  String id;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private  String email;
    private  String note;
    private  Long date;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
}

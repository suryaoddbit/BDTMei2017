package beginner.iak.com.simplelistview.model;

import java.util.List;



public class APIResponse {


    private List<Note> notes;



    public List<Note> getList() {
        return notes;
    }

    public void setList(List<Note> list) {
        this.notes = list;
    }
}

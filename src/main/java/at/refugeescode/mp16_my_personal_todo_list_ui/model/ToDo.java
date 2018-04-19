package at.refugeescode.mp16_my_personal_todo_list_ui.model;

import lombok.Data;

@Data
public class ToDo {

    private String id;
    private String task;
    private boolean done;

    @Override
    public String toString() {
        return "Todo{" +
                "id='" + id + '\'' +
                ", task='" + task + '\'' +
                ", done=" + done +
                '}';
    }

}


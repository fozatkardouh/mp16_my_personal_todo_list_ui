package at.refugeescode.mp16_my_personal_todo_list_ui.endpoint;

import at.refugeescode.mp16_my_personal_todo_list_ui.model.ToDo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/todos")
public class ToDoEndpoint {

    private final RestTemplate restTemplate;

    @Value("${server.url}")
    private String url;

    @ModelAttribute("todos")
    public List<ToDo> getTodos() {
        return Arrays.asList(restTemplate.getForObject(url + "/todos", ToDo[].class));
    }

    @ModelAttribute("newTodo")
    public ToDo getNewTodo() {
        return new ToDo();
    }

    @GetMapping
    public String home() {
        return "home";
    }

    @PostMapping
    public String addNewTodo(ToDo toDo) {
        restTemplate.postForObject(url + "/todos", toDo, ToDo.class);
        return "redirect:/todos";
    }

    @PostMapping("/done")
    public String setToDoAsDone(ToDo toDo) {
        restTemplate.postForObject(url + "/todos/" + toDo.getId() + "/done", toDo, ToDo.class);
        return "redirect:/todos";
    }

    /*@PostMapping("/done/{id}")
    public String setToDoAsDone(@PathVariable String id) {
        restTemplate.put(url + "/todos/" + id + "/done", ToDo.class);
        return "redirect:/todos";
    }*/

    @PostMapping("/delete")
    public String deleteOneTodo(ToDo toDo) {
        restTemplate.delete(url + "/todos/" + toDo.getId());
        return "redirect:/todos";
    }

}

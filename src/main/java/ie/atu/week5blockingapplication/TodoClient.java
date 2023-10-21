package ie.atu.week5blockingapplication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "jsonplaceholder", url = "https://jsonplaceholder.typicode.com")
public interface TodoClient {

    @GetMapping("/todos/1")
    TodoResponse fetchData();

    @GetMapping("/todos/{id}")
    TodoResponse fetchAllData(@PathVariable int id);
}

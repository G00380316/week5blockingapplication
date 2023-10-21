package ie.atu.week5blockingapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FeignController {
    
    private final FeignService feignService;

    public FeignController(FeignService feignService){
        this.feignService =  feignService;
    }

    @GetMapping("/feign")
    public String getFeignData() throws Exception, InterruptedException {
        long startTime = System.currentTimeMillis();

        List<CompletableFuture<TodoResponse>> futures = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            CompletableFuture<TodoResponse> future = CompletableFuture.supplyAsync(() -> feignService.fetchData());
            futures.add(future);
        }

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allOf.get();
        long endTime = System.currentTimeMillis();

        return "Total execution time: " + (endTime - startTime) + " ms";

    }

    @GetMapping("/getalldata")
    public List<TodoResponse> getalldata() {
        List<TodoResponse> dataList = new ArrayList<>();

        for (int i = 1; i <= 200; i++) {
            TodoResponse data = feignService.fetchAllData(i);
            dataList.add(data);
        }
        
    return dataList;
}
}

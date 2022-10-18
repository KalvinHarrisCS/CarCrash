package KalvinHarrisCS.AccdientReportTracker.services;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
// make this a service. so spring can inject it

@Service
public class CarAccdientDataService {

    private static String Car_Data_URL = "https://raw.githubusercontent.com/YBI-Foundation/Dataset/main/Car%20Crashes.csv";

    // we need an Exception to handle if the client fails.
    @PostConstruct //This is here so it executes after it starts. so it can get the data
    public void fetchAllAccdients() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request =HttpRequest.newBuilder()
                .uri(URI.create(Car_Data_URL))
                .build();
        // make it sync if i need to access the response of the request.
        // only use asynconce if i dont care about the response.
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse.body());

    }
}

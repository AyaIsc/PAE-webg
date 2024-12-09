package _4.web5.pae.client;

import org.springframework.web.client.RestTemplate;

import _4.web5.pae.model.Cours;

import java.util.Arrays;


public class CourseClient {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/courses";

       
        Cours[] courses = restTemplate.getForObject(url, Cours[].class);

    
        System.out.println(Arrays.toString(courses));
    }
}

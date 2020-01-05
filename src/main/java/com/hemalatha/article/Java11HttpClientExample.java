package com.hemalatha.article;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Java11HttpClientExample {


    private final HttpClient basicHttpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2).build();

    private final ExecutorService executorService = Executors.newFixedThreadPool(4);

    private final HttpClient asyncHttpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .executor(executorService).build();

    public static void main(String[] args) throws Exception {
        Java11HttpClientExample example = new Java11HttpClientExample();
        //example.sendGet();
        //example.sendGetAsync();
        //example.sendPostFormData();
        //example.sendPostJson();
        example.sendWithAuthentication();

    }

    private void sendGet() {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://httpbin.org/get"))
                .setHeader("User-Agent","Java11 client test")
                .build();

        try {
            HttpResponse<String> response = basicHttpClient.send(request, HttpResponse.BodyHandlers.ofString());
            HttpHeaders headers = response.headers();
            headers.map().forEach((k,v)->{
                System.out.println(k +" , "+ v);
            });

            System.out.println(response.statusCode());
            System.out.println(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void sendGetAsync() throws URISyntaxException, ExecutionException, InterruptedException {

        List<URI> targets = Arrays.asList(
                new URI("https://httpbin.org/get?name=hla1"),
                new URI("https://httpbin.org/get?name=hla2"),
                new URI("https://httpbin.org/get?name=hla3"),
                new URI("https://httpbin.org/get?name=hla4")
        );

        List<CompletableFuture<String>> result = targets.stream().map(url-> asyncHttpClient.sendAsync(HttpRequest.newBuilder().uri(url)
                .setHeader("User-Agent","Java11 client test")
                .build(), HttpResponse.BodyHandlers.ofString()).thenApply(r-> r.body())).collect(Collectors.toList());

        for(CompletableFuture<String> future: result){
            System.out.println(future.get());
        }
    }

    private HttpRequest.BodyPublisher formData(Map<Object, Object> data){
        StringBuilder sb = new StringBuilder();
        StringJoiner joiner = new StringJoiner("&");
        for(Map.Entry<Object, Object> entry: data.entrySet()){
            joiner.add(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8)+"="+URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
        }
        return HttpRequest.BodyPublishers.ofString(joiner.toString());
    }

    private void sendPostFormData() throws IOException, InterruptedException {
         Map<Object, Object> data = new HashMap<>();
         data.put("username", "god");
         data.put("password", "test");
         data.put("ts", System.currentTimeMillis());

         HttpRequest request = HttpRequest.newBuilder()
                 .POST(formData(data))
                 .uri(URI.create("https://httpbin.org/post"))
                 .setHeader("User-Agent","Java11 client test")
                 .build();

         HttpResponse<String> response = basicHttpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());

    }

    private void sendPostJson() throws IOException, InterruptedException {
        String json = new StringBuilder()
                .append("{")
                .append("\"name\":\"hla\",")
                .append("\"message\":\"hello\",").append("}").toString();

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("https://httpbin.org/post"))
                .setHeader("User-Agent","Java11 client test")
                .setHeader("Content-type","application/json")
                .build();

        HttpResponse<String> response = basicHttpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());

    }

    private void sendWithAuthentication() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .authenticator(new Authenticator() {
                    @Overridex
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                "god",
                                "test".toCharArray()
                        );
                    }
                })
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(5))
                .build();

        HttpRequest request = HttpRequest.newBuilder().setHeader("User-Agent","Java11 HttpClient test")
                .uri(URI.create("http://localhost:8080/"))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }


}

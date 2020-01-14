package br.com.backend.desafio04.Desafio04;


import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientTeste {

    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();


    private final HttpClient httpClientBearer = HttpClient.newBuilder()
            .authenticator(new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(
                            "user",
                            "password".toCharArray());
                }
            })
            .build();


    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClientTeste obj = new HttpClientTeste();
         obj.sendPOST();
         obj.sendDelete();
         obj.sendBearer();
    }

    private void sendPOST() throws IOException, InterruptedException {
        String requestBody = new StringBuilder()
                .append("{")
                .append("\"id\":\"123\",")
                .append("\"field\":\"testing\"")
                .append("}").toString();

        // HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/post"))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .setHeader("User-Agent", "Java 11 HttpClient testing") // add request header
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.print("POST Request:");
        // print status code
        System.out.println(response.statusCode());

        // print response body
        System.out.println(response.body());
    }


    public void sendDelete() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .DELETE()
                .uri(URI.create("https://httpbin.org/delete"))
                .setHeader("User-Agent", "Java 11 HttpClient testing")
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.print("DELETE Request:");
        // print status code
        System.out.println(response.statusCode());

        // print response body
        System.out.println(response.body());
        }

        public  void sendBearer() throws IOException, InterruptedException {

            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("https://httpbin.org/bearer"))
                    .header("Authorization", "Bearer my secret-token")
                    .build();
        java.net.http.HttpResponse<String> response = httpClientBearer.send(request, java.net.http.HttpResponse.BodyHandlers.ofString());

        System.out.print("Bearer Request:");
        // print status code
        System.out.println(response.statusCode());

        // print response body
        System.out.println(response.body());

        }


    }

package com.study.Study.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class ClientService implements IClientService{
    @Override
    public void getGetCall() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("lo que sea"))
                .GET().build();
    }
}

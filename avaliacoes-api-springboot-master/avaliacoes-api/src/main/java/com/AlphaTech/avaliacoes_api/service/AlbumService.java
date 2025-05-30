package com.AlphaTech.avaliacoes_api.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Base64;
import java.util.Map;

@Service
public class AlbumService {

    private String clientId = "3dc17cfaa0154f9491840fb373825809";
    private String clientSecret = "56e4485b1c234e4d97c4e0f9f9b32f22";
    private String tokenUrl = "https://accounts.spotify.com/api/token";
    private String albumUrl = "https://api.spotify.com/v1/albums/";

    // Pega o token de acesso
    private String getAccessToken() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        String auth = clientId + ":" + clientSecret;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
        headers.set("Authorization", "Basic " + encodedAuth);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("grant_type", "client_credentials");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(form, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(tokenUrl, request, Map.class);
        return response.getBody().get("access_token").toString();
    }

    // Busca os dados do álbum pelo ID
    public Map getAlbumById(String albumId) {
        String token = getAccessToken();

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Map> response = restTemplate.exchange(
                albumUrl + albumId,
                HttpMethod.GET,
                entity,
                Map.class
        );

        return response.getBody(); // retorna os dados do álbum como um Map
    }
}
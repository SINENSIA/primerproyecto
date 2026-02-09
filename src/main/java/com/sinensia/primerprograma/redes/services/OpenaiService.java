package com.sinensia.primerprograma.redes.services;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class OpenaiService {

    private final String apiKey;
    private final String apiUrl;

    public OpenaiService(String apiKey) {
        this.apiKey = apiKey;
        this.apiUrl = "https://api.openai.com/v1/chat/completions";
    }

    public String enviarMensaje(String mensajeUsuario) {
        try {
            URL url = new URI(apiUrl).toURL();
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + apiKey);

            String body = """
                    {
                      "model": "gpt-5-mini",
                      "messages": [{"role": "user", "content": "%s"}]
                    }
                    """.formatted(mensajeUsuario.replace("\"", "\\\""));

            try (OutputStream os = connection.getOutputStream()) {
                os.write(body.getBytes());
            }

            InputStream responseStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(responseStream));
            StringBuilder responseBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }

            JsonObject root = JsonParser.parseString(responseBuilder.toString()).getAsJsonObject();
            JsonArray choices = root.getAsJsonArray("choices");
            if (choices != null && choices.size() > 0) {
                JsonObject msg = choices.get(0).getAsJsonObject().getAsJsonObject("message");
                if (msg != null && msg.has("content")) {
                    return msg.get("content").getAsString().trim();
                }
            }
            return "[Respuesta vacía]";

        } catch (Exception e) {
            e.printStackTrace();
            return "[Error al conectar con OpenAI]";
        }
    }
}

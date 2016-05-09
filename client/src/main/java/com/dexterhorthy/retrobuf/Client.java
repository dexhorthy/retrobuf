package com.dexterhorthy.retrobuf;

import com.google.common.collect.Sets;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.protobuf.ProtoConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.io.IOException;
import java.util.Set;

/**
 * Created on 5/8/16.
 */
public interface Client {

    @POST("/events")
    Call<Models.Event> create(@Body Models.Event request);

    @GET("/events")
    Call<Models.Events> list();

    static Client create(String url) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(ProtoConverterFactory.create())
                .build()
                .create(Client.class);
    }

    static void main(String[] args) throws IOException {

        Client client = Client.create("http://localhost:8080");


        Set<String> names = Sets.newHashSet(
                "Who am I, you ask?",
                "My name is MacGruber",
                "Remember. That. Name."
        );


        for (String name : names) {
            client.create(
                    Models.Event.newBuilder()
                            .setName(name)
                            .build()
            ).execute();
        }

        Models.Events listBody = client.list().execute().body();

        System.out.println(listBody);
    }
}


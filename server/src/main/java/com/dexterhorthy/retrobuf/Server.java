package com.dexterhorthy.retrobuf;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.jersey.protobuf.InvalidProtocolBufferExceptionMapper;
import io.dropwizard.jersey.protobuf.ProtocolBufferMessageBodyProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created on 5/8/16.
 */
public class Server extends Application<Configuration> {


    public void initialize(Bootstrap<Configuration> bootstrap) {}

    public void run(Configuration retrobufConfiguration, Environment environment) throws Exception {
        environment.jersey().register(new EventsResource());
        environment.jersey().register(new ProtocolBufferMessageBodyProvider());
        environment.jersey().register(new InvalidProtocolBufferExceptionMapper());
    }

    public static void main(String[] args) throws Exception {
        new Server().run(args);
    }
}

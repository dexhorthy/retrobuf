package com.dexterhorthy.retrobuf;

import com.google.common.collect.Sets;
import io.dropwizard.jersey.protobuf.ProtocolBufferMediaType;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Set;

/**
 * Created on 5/8/16.
 */
@Path("/events")
@Consumes(ProtocolBufferMediaType.APPLICATION_PROTOBUF)
@Produces(ProtocolBufferMediaType.APPLICATION_PROTOBUF)
public class EventsResource {

    private final Set<Models.Event> events;

    public EventsResource() {
        events = Sets.newConcurrentHashSet();
    }

    @GET
    public Models.Events list() {
        return Models.Events.newBuilder()
                .addAllEvents(events)
                .build();
    }

    @POST
    public Models.Event create(Models.Event request) {
        events.add(request);
        return request;
    }

}

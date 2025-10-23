package com.labseq;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import java.math.BigInteger;

@Path("/labseq")
public class LabseqResource {
    
    @Inject
    LabseqService service;

    @GET
    @Path("/{n}")
    public BigInteger getLabseq(@PathParam("n") long n)
    {
        return service.calculateLabseq(n);
    }
}

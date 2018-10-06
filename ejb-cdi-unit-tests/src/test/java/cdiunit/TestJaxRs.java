package cdiunit;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Providers;

import com.oneandone.ejbcdiunit.jaxrs.SupportJaxRsEjbCdiUnit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.oneandone.ejbcdiunit.EjbUnitRunner;

@RunWith(EjbUnitRunner.class)
@SupportJaxRsEjbCdiUnit
public class TestJaxRs {

    @Inject
    private WebService webService;

    @Test
    public void testJaxRs() {
        Assert.assertNotNull(webService.request);
        Assert.assertNotNull(webService.response);
        Assert.assertNotNull(webService.context);
        Assert.assertNotNull(webService.uriInfo);
        Assert.assertNotNull(webService.jaxRsRequest);
        Assert.assertNotNull(webService.securityContext);
        Assert.assertNotNull(webService.providers);
        Assert.assertNotNull(webService.headers);
    }

    public static class WebService {
        @Context
        HttpServletRequest request;

        @Context
        HttpServletResponse response;

        @Context
        ServletContext context;

        @Context
        UriInfo uriInfo;

        @Context
        Request jaxRsRequest;

        @Context
        SecurityContext securityContext;

        @Context
        Providers providers;


        @Context
        HttpHeaders headers;

    }
}

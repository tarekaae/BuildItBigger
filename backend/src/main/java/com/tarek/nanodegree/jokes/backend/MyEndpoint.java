/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.tarek.nanodegree.jokes.backend;

import com.example.JokeTeller;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.jokes.nanodegree.tarek.com",
                ownerName = "backend.jokes.nanodegree.tarek.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
  /*  @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {*/
    @ApiMethod(name = "getAjoke")
    public MyBean getAjoke() {

        JokeTeller jokeTeller = new JokeTeller();
        String joke = jokeTeller.tellAjkoe();

        MyBean response = new MyBean();
        response.setData(joke);

        return response;
    }

}

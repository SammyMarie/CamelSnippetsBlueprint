
package com.sammy.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.ehcache.EhcacheConstants;


public class ReadingFromCache extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:next")
            .setHeader("CamelCacheOperation", constant("CamelCacheGet"))
            .setHeader("CamelCacheKey", constant("Custom_key"))
            .to("ehcache://cache1")
            .choice()
           .when(header(EhcacheConstants.VALUE).isNotNull())
                .process(exchange -> {
                    Object body = exchange.getIn().getBody();
                    System.out.println("Cache body - " + body);
                })
           .otherwise()
                .process(exchange -> {
                    Object body = exchange.getIn().getBody();
                    System.out.println("Cache body when not found - " + body);
                })
           .end()
           .to("activemq:outCache");
    }
}
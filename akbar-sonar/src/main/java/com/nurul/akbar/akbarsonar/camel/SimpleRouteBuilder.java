package com.nurul.akbar.akbarsonar.camel;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:D:/AKBAR/SONAR TEST/Source Code/inbound?noop=true").split().tokenize("\n").to("jms:queue:sonar");
    }
}

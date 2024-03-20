package com.capone.decrypto.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;

import com.capone.decrypto.service.ComitenteService;

public class ComitenteRoute extends RouteBuilder {

    private final Environment env;

    public ComitenteRoute(Environment env) {
        this.env = env;
    }

    @Override
    public void configure() throws Exception {
        restConfiguration()
            .contextPath(env.getProperty("camel.component.servlet.mapping.contextPath", "/api/*"))
            .apiContextPath("/api-doc")
            .apiProperty("api.title", "API REST. CRUD operations for: Comitente, Mercado, Pais.")
            .apiProperty("api.version", "1.0.0")
            .apiProperty("cors", "true")
            .apiContextRouteId("doc-api")
            .port(env.getProperty("server.port", "8080"))
            .bindingMode(RestBindingMode.json);

        rest("/comitente").description("Comitente route")
            .post("/")
                .consumes(MediaType.APPLICATION_JSON_VALUE)
                .produces(MediaType.APPLICATION_JSON_VALUE)
                    .to("{{route.createComitente}}")
            .get("/{comitenteId}")
                .produces(MediaType.APPLICATION_JSON_VALUE)
                    .to("{{route.retrieveComitenteById}}")
            .get("/")
                .produces(MediaType.APPLICATION_JSON_VALUE)
                    .to("{{route.retrieveAllComitentes}}")
            .put("/{comitenteId}")
                .consumes(MediaType.APPLICATION_JSON_VALUE)
                .produces(MediaType.APPLICATION_JSON_VALUE)
                    .to("{{route.updateComitente}}")
            .delete("/{comitenteId}")
                .produces(MediaType.APPLICATION_JSON_VALUE)
                    .to("{{route.deleteComitente}}");

        from("{{route.retrieveComitenteById}}")
            .log("Received header : ${header.comitenteId}")
            .bean(ComitenteService.class, "retrieveById(${header.comitenteId})");

        from("{{route.retrieveAllComitentes}}")
            .bean(ComitenteService.class, "retrieveAll");

        from("{{route.createComitente}}")
            .log("Received Body ${body}")
            .bean(ComitenteService.class, "create(${body})");

        from("{{route.updateComitente}}")
            .log("Received Body ${body}")
            .bean(ComitenteService.class, "update(${body}, ${header.comitenteId})");

        from("{{route.deleteComitente}}")
            .log("Received header : ${header.bookId}")
            .bean(ComitenteService.class, "delete(${header.comitenteId})");
    }

}

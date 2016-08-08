package com.home.portfolio;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {


    public static void main(String[] args) {

        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        setPort(port);

        staticFileLocation("/public");
        //ne pip!!!
        /*before((request, response) -> {
            if (request.attribute("username") != null) {
                request.attribute("username", request.attribute("username"));
            }
        });

        before("/sign-in", ((request, response) -> {
            if (request.attribute("username") == null) {
                response.redirect("/");
                halt();
            }
        }));*/
        get("/", (req, res) -> {
            Map<String, String> model = new HashMap<>();
            model.put("username", req.cookie("username"));
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

       /* post("/sign-in", ((request, response) -> {
            Map<String, String> model = new HashMap<>();
            String username = request.queryParams("username");
            response.cookie("username", username);
            return new ModelAndView(model, "sign-in.hbs");
        }), new HandlebarsTemplateEngine());*/

        get("/projects", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "projects.hbs");
        }, new HandlebarsTemplateEngine());

        get("/about", (request, response) -> {
            Map<String, String> model = new HashMap<>();
            return new ModelAndView(model, "about.hbs");
        }, new HandlebarsTemplateEngine());


    }
}

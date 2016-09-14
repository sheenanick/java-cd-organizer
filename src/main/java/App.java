import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {

    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     model.put("template", "templates/index.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   get("artists/:id/cds/new", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     Artist artist = Artist.find(Integer.parseInt(request.params(":id")));
     model.put("artist", artist);
     model.put("template", "templates/artist-cds-form.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   get("/cds", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("cds", Cd.all());
    model.put("template", "templates/cds.vtl");
    return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   post("/cds", (request,response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     Artist artist = Artist.find(Integer.parseInt(request.queryParams("artistId")));
     String title = request.queryParams("title");
     Cd newCd = new Cd(title, artist.getName());
     artist.addCd(newCd);
     model.put("artist", artist);
     model.put("template", "templates/artist-cd-success.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   get("/cds/:id", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    Cd cd = Cd.find(Integer.parseInt(request.params(":id")));
    model.put("cd", cd);
    model.put("template", "templates/cd.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("artists/new", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/artist-form.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  post("/artists", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    String name = request.queryParams("name");
    Artist newArtist = new Artist(name);
    model.put("template", "templates/artist-success.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/artists", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("artists", Artist.all());
    model.put("template", "templates/artists.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/artists/:id", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    Artist artist = Artist.find(Integer.parseInt(request.params(":id")));
    model.put("artist", artist);
    model.put("template", "templates/artist.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  post("/cd/search", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    String searchParam = request.queryParams("search");
    model.put("artist", Artist.all());
    model.put("search", searchParam);
    model.put("template", "templates/search-success.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  }
}

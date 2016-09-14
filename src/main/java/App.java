import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    String search = new String("album3");
    Artist myArtist = new Artist("artist1");
    Cd myCd1 = new Cd("album1",myArtist.getName());
    Cd myCd2 = new Cd("album2",myArtist.getName());
    myArtist.addCd(myCd1);
    myArtist.addCd(myCd2);

    Artist myArtist2 = new Artist("artist2");
    Cd myCd3 = new Cd("album3",myArtist2.getName());
    Cd myCd4 = new Cd("album4",myArtist2.getName());
    myArtist2.addCd(myCd3);
    myArtist2.addCd(myCd4);
    for( Artist findArtist: Artist.all()){
      for(Cd findCd : findArtist.getCds()){
        if(search.equals(findCd.getTitle())){
          System.out.println(findCd.getArtist());
        }
      }
    }



  //   staticFileLocation("/public");
  //   String layout = "templates/layout.vtl";
  //
  //   get("/", (request, response) -> {
  //    Map<String, Object> model = new HashMap<String, Object>();
  //    model.put("template", "templates/index.vtl");
  //    return new ModelAndView(model, layout);
  //  }, new VelocityTemplateEngine());
  //
  //  get("artists/:id/cds/new", (request, response) -> {
  //    Map<String, Object> model = new HashMap<String, Object>();
  //    Artist artist = Artist.find(Integer.parseInt(request.params(":id")));
  //    model.put("artist", artist);
  //    model.put("template", "templates/artist-cds-form.vtl");
  //    return new ModelAndView(model, layout);
  //  }, new VelocityTemplateEngine());
  //
  //  get("/cds", (request, response) -> {
  //   Map<String, Object> model = new HashMap<String, Object>();
  //   model.put("cds", Cd.all());
  //   model.put("template", "templates/cds.vtl");
  //   return new ModelAndView(model, layout);
  //  }, new VelocityTemplateEngine());
  //
  //  post("/cds", (request,response) -> {
  //    Map<String, Object> model = new HashMap<String, Object>();
  //    Artist artist = Artist.find(Integer.parseInt(request.queryParams("artistId")));
  //    String title = request.queryParams("title");
  //    Cd newCd = new Cd(title);
  //    artist.addCd(newCd);
  //    model.put("artist", artist);
  //    model.put("template", "templates/artist-cd-success.vtl");
  //    return new ModelAndView(model, layout);
  //  }, new VelocityTemplateEngine());
  //
  //  get("/cds/:id", (request, response) -> {
  //   Map<String, Object> model = new HashMap<String, Object>();
  //   Cd cd = Cd.find(Integer.parseInt(request.params(":id")));
  //   model.put("cd", cd);
  //   model.put("template", "templates/cd.vtl");
  //   return new ModelAndView(model, layout);
  // }, new VelocityTemplateEngine());
  //
  // get("artists/new", (request, response) -> {
  //   Map<String, Object> model = new HashMap<String, Object>();
  //   model.put("template", "templates/artist-form.vtl");
  //   return new ModelAndView(model, layout);
  // }, new VelocityTemplateEngine());
  //
  // post("/artists", (request, response) -> {
  //   Map<String, Object> model = new HashMap<String, Object>();
  //   String name = request.queryParams("name");
  //   Artist newArtist = new Artist(name);
  //   model.put("template", "templates/artist-success.vtl");
  //   return new ModelAndView(model, layout);
  // }, new VelocityTemplateEngine());
  //
  // get("/artists", (request, response) -> {
  //   Map<String, Object> model = new HashMap<String, Object>();
  //   model.put("artists", Artist.all());
  //   model.put("template", "templates/artists.vtl");
  //   return new ModelAndView(model, layout);
  // }, new VelocityTemplateEngine());
  //
  // get("/artists/:id", (request, response) -> {
  //   Map<String, Object> model = new HashMap<String, Object>();
  //   Artist artist = Artist.find(Integer.parseInt(request.params(":id")));
  //   model.put("artist", artist);
  //   model.put("template", "templates/artist.vtl");
  //   return new ModelAndView(model, layout);
  // }, new VelocityTemplateEngine());

  }
}

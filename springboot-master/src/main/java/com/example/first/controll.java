package com.example.first;

import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class controll {
    public String json;

    @GetMapping ("course")
    public String start(Model model)
    {
        model.addAttribute("great","omar");
        return  "pagegreet";
    }
    @PostMapping(value = "course")

    @ResponseBody
    @CrossOrigin(origins = "http://localhost:3000")
    public String second_page(@RequestParam("name") String name,
                              @RequestParam("brand") String brand ,
                              @RequestParam("file") MultipartFile file,
                              @RequestParam("perhour") Double perhour) throws IOException
    {

        //save the image
        byte[] bytes= file.getBytes();
        Path path= Paths.get(System.getProperty("user.dir")+"\\src\\main\\webapp\\image\\"+ file.getOriginalFilename());
        Files.write(path, bytes);
        //insert into datbase
        User user=new User();
        user.insertDataBike(name,brand,perhour,file);
        //translate to json
        userData userdata =new userData(name,brand,perhour,file);
        Gson gson= new Gson();
        json = gson.toJson(userdata);
        return json;
    }
    @RequestMapping ("data")
    public String datasend(Model model){

        return "get";
    }
    @GetMapping("senddata")
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    public String senddata(){
        System.out.println(json);
        return json;
    }
}

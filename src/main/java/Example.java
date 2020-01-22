/*import com.capgemini.Roomcapgemini.Room;
import com.capgemini.Room.RoomController;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@ComponentScan("com.capgemini.Room.Room")
public class Example {

    RoomController roomController = new RoomController();



    public static void main(String[] args) {
        SpringApplication.run(Example.class, args);
    }

    @RequestMapping("/showRooms")
    List<com.capgemini.Room.Room> showRooms() {
        return roomController.showRooms();
    }

    @RequestMapping("/addRoom/{id}")
    public String addRoom(@PathVariable String id) {
        roomController.addRoom(id);
        return "com.capgemini.Room.Room added with id: " + id;
    }

}*/
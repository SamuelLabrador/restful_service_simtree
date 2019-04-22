package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {
	private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/file")
    public Change[] change(@RequestParam(value="file", defaultValue="None") MultipartFile file) {
        // Save file for proof of concept
        Change sampleFile;
    	try{
    		String content = new String(file.getBytes());
    		sampleFile = new Change("CAN READ FILE", content);
    	}
    	catch (Exception e){
    		sampleFile = new Change("COULD NOT READ FILE", "");
    	}
        // Process File
    	//

        // Return Changes in the form of json
    	Change sampleDeletion = new Change("ROS::TARGET::DELETE", "");
    	Change sampleModification = new Change("ROS:TARGET::MODIFIY", "ROS2::TARGET2::MODIFY");
    	Change changes [] = {sampleDeletion, sampleModification, sampleFile};

        return changes;
    }
}
package pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.dto.UserDto;
import pro.model.entity.TraceFile;
import pro.model.entity.User;
import pro.service.TraceFileService;
import pro.service.UserService;

import java.io.*;

@RestController
public class TraceFileController {

    @Autowired
    private UserService userService;

    @Autowired
    private TraceFileService traceFileService;

    @RequestMapping(value = "/saveFile")
    public String saveFile(@RequestParam String filename, @RequestParam String fileData) {
        String filePath = "C:/Users/Public/Documents/" + filename;
        System.out.println(fileData);
        byte[] decodedBytes = Base64.decode(fileData.getBytes());

        try {
            File file = new File(filePath);
            BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(file));
            writer.write(decodedBytes);
            writer.flush();
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "error";
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        UserDto userDto = userService.getUserByUsername(username);
        User user = userService.mapUserFromDto(userDto);

        TraceFile traceFile = new TraceFile();
        traceFile.setFilename(filename);
        traceFile.setFilePath(filePath);
        traceFile.setUser(user);

        traceFileService.insertFileToDatabase(traceFile);

        return "success";

    }
}

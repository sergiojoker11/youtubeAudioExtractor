package sj11.youtubeaudioextractor.endpoints;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class YoutubeAudioExtractorController {

    @RequestMapping(value = "youtube/{id}", method = GET)
    public ResponseEntity<?> getAudioFromYoutubeLink(@PathVariable String id) {
        String videoUrl = "https://www.youtube.com/watch?v=" + id;
        ProcessBuilder pb = new ProcessBuilder("youtube-dl", "--extract-audio", "--audio-quality", "0", videoUrl);
        pb.directory(new File("/home"));
        File log = new File("info");
        pb.redirectErrorStream(true);
        pb.redirectOutput(ProcessBuilder.Redirect.appendTo(log));
        Process p;
        try {
            p = pb.start();
            assert pb.redirectInput() == ProcessBuilder.Redirect.PIPE;
            assert pb.redirectOutput().file() == log;
            assert p.getInputStream().read() == -1;
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
//Command
//    youtube-dl --extract-audio --audio-quality 0 https://www.youtube.com/watch?v=4qJXTR7SyBQ&list=RD4qJXTR7SyBQ

//        Map<String, String> env = pb.environment();
//        env.put("VAR1", "myValue");
//        env.remove("OTHERVAR");
//        env.put("VAR2", env.get("VAR1") + "suffix");
}

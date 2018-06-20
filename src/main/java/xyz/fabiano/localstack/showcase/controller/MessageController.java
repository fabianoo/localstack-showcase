package xyz.fabiano.localstack.showcase.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.fabiano.localstack.showcase.sqs.MessageReader;

import java.util.Collection;

@Controller
public class MessageController {

    private MessageReader reader;

    public MessageController(MessageReader reader) {
        this.reader = reader;
    }

    @RequestMapping(value = "/read")
    public ResponseEntity<Collection> read() {
        return ResponseEntity.ok(reader.readMessages());
    }
}

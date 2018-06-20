package xyz.fabiano.localstack.showcase.sqs;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageReader {

    @Autowired
    private AmazonSQS amazonSQS;

    @Value("${showcase.sqs.integration-queue}")
    private String integrationQueue;

    public List<String> readMessages() {
        return amazonSQS.receiveMessage(integrationQueue).getMessages()
            .stream().map(Message::getBody).collect(Collectors.toList());
    }
}

package org.example.Controller;

import lombok.RequiredArgsConstructor;
import org.example.Produser.TopicProduser;
import org.example.Repository.ServiceFilePars_Reliz;
import org.example.util.Measurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping(value = "/kafka")
@RestController
public class TopicController {
    @Autowired
    private ServiceFilePars_Reliz repo;
    private final TopicProduser topicProducer;

    @PostMapping("/data")
    public Measurement sendData(@RequestBody Measurement measurement) {
        topicProducer.sendData(measurement);
        return measurement;
    }

    @GetMapping("/get")
    public List<Measurement> get() {
        return repo.findAll();
    }
}

package org.example.Controller;

import lombok.RequiredArgsConstructor;
import org.example.Produser.TopicProduser;
import org.example.Repository.ServiceFilePars_Reliz;
import org.example.Dto.Measurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping(value = "/kafka")
@RestController
public class TopicController {
    @Autowired
    private ServiceFilePars_Reliz repo;
    private final TopicProduser topicProduser;

    @PostMapping("/data")
    public org.example.util.Measurement sendMea(@RequestBody org.example.util.Measurement measurement) {
        topicProduser.sendMea(measurement);
        return measurement;
    }

    @GetMapping("/get")
    public List<Measurement> get() {
        return repo.findAll();
    }
}

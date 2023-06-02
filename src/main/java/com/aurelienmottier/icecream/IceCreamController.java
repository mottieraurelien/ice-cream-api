package com.aurelienmottier.icecream;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/ice-cream")
public class IceCreamController {

    private final IceCreamManager manager;

    @Autowired
    public IceCreamController(final IceCreamManager manager) {
        this.manager = manager;
    }

    @PostMapping
    @JsonView(IceCream.ResponseBody.class)
    public ResponseEntity<IceCream> create(@RequestBody @JsonView(IceCream.RequestBody.class) IceCream iceCreamToCreate) {
        return new ResponseEntity<>(this.manager.create(iceCreamToCreate), CREATED);
    }

    @GetMapping
    @JsonView(IceCream.ResponseBody.class)
    public ResponseEntity<Collection<IceCream>> get() {
        return ResponseEntity.ok(this.manager.get());
    }

}

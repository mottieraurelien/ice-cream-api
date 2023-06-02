package com.aurelienmottier.icecream;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class IceCream {

    @JsonView(ResponseBody.class)
    private Long id;

    @JsonView({ResponseBody.class, RequestBody.class})
    private String name;

    @JsonView({ResponseBody.class, RequestBody.class})
    private String flavor;

    public interface ResponseBody {

    }

    public interface RequestBody {

    }

    public String name() {
        return this.name;
    }

    public String flavor() {
        return this.flavor;
    }

}
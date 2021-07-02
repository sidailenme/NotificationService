package com.yalta.model;

import com.yalta.config.Channel;
import lombok.Data;

import java.util.List;

@Data
public class Message {

    private Long id;
    private List<Channel> channels;
    private String payload;

}

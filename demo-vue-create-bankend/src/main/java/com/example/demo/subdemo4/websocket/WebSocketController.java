package com.example.demo.subdemo4.websocket;

import com.example.demo.subdemo4.shoputils.ResultUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo/websocket")
public class WebSocketController {
    @PostMapping("/query")
    public ResultUtil<Object> webSocketQuery(@RequestBody SocketParams socketParams ){
        System.out.println(socketParams);
            return ResultUtil.resultSuccessful("websocket");
    }
}

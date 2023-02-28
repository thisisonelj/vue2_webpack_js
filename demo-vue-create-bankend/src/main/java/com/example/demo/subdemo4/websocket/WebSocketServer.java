package com.example.demo.subdemo4.websocket;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/websocket/{sid}")
@Component
public class WebSocketServer {
    static Log log = LogFactory.getLog(WebSocketServer.class);
    // 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
    //concurrent 包的线程安全 Set ，用来存放每个客户端对应的 MyWebSocket 对象。
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();

    // 与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    // 接收 sid
    private String sid = "";

    // 创建一个数组用来存放所有需要向客户端发送消息的窗口号
    private static List<String> list = new ArrayList();

    public static List<String> getList() {
        return list;
    }


    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid){
        this.session = session;
        this.sid = sid;
        list.add(sid);
        webSocketSet.add(this);
        addOnlineCount();   //在线数加1
        try {
            sendMessage("WebSocket连接成功！");
            log.info("有新窗口开始监听:" + sid + ",当前在线人数为:" + getOnlineCount());
        } catch (IOException e) {
            log.error("websocket IO Exception");
        }

        /*if (!list.contains(sid)){
            list.add(sid);
            webSocketSet.add(this);  //加入set中
            addOnlineCount();   //在线数加1
            try {
                sendMessage("连接成功！");
                log.info("有新窗口开始监听:" + sid + ",当前在线人数为:" + getOnlineCount());
            } catch (IOException e) {
                log.error("websocket IO Exception");
            }
        }else {
            try {
                list.add(sid);
                sendMessage("连接失败！已经有该窗口连接了！");
                log.error("有一个重复的窗口开始监听：" + sid +" 未将它添加至客户端");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this); // 从 set 中删除
        list.remove(sid);
        subOnlineCount(); // 在线数减 1
        log.info(" 有一连接关闭,窗口为：" + sid + "！当前在线人数为 " + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
//        log.info(" 收到来自窗口 " + sid + " 的信息 :" + message);
//        // 群发消息
//        for (WebSocketServer item : webSocketSet) {
//            try {
//                item.sendMessage(message);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        log.info(" 收到来自窗口 " + sid + " 的信息 :" + message);
        log.info(JSON.parseObject(message,SocketParams.class));
        String returnMessage = "你刚才说：" + message;
        try {
            session.getBasicRemote().sendText(returnMessage);
        } catch (IOException e) {
            System.out.println("返回数据失败");
        }



    }

    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error(" 发生错误 ");
        error.printStackTrace();
    }

    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

//    public static void sendInfo(String message){
//        // 对list进行遍历 对其里边的sid进行推送消息
//        for (String sid : list ) {
//            log.info(" 推送消息到窗口 " + sid + " ，推送内容 :" + message);
//            sendMessage(message);
//        }
//    }


    /**
     * 群发自定义消息
     */
    public static void sendInfo(String message, @PathParam("sid") String sid) throws IOException {
        log.info(" 推送消息到窗口 " + sid + " ，推送内容 :" + message);
        for (WebSocketServer item : webSocketSet) {
            try {
                // 这里可以设定只推送给这个 sid 的，为 null 则全部推送
                if (sid == null) {
                    item.sendMessage(message);
                } else if (item.sid.equals(sid)) {
                    item.sendMessage(message);
                }
            } catch (IOException e) {
                continue;
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }



}

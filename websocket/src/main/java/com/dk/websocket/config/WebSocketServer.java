package com.dk.websocket.config;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @autor kevin.dai
 * @Date 2018/7/22
 */

@Component
@ServerEndpoint("/ws/{userId}")
//ServerEndpoint定义websocket的服务端，及用户链接服务端匹配的URL
public class WebSocketServer {

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //在线人数 线程安全
    private static AtomicInteger onlineCount = new AtomicInteger(0);

    //concurrent包的线程安全Set，用来存放每个客户端对应的WebSocketServer对象。
    // 若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
   // private static  CopyOnWriteArraySet<WebSocketServer> webSocketServers = new CopyOnWriteArraySet<>();
    private static ConcurrentHashMap<String,WebSocketServer> webSocketServers = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Session,String> sessionMap = new ConcurrentHashMap<>();


    @OnOpen
    public void openConnect(Session session, @PathParam("userId") String userId){
        this.session = session;
        if(webSocketServers.get(userId) == null){
            sessionMap.put(session,userId);
            webSocketServers.put(userId,this);
            onlineCount.getAndIncrement();
            System.err.println("用户："+userId+"进入聊天系统，当前用户数:"+onlineCount.get());
        }
    }



    @OnClose
    public void closeConnect(){
        webSocketServers.remove(this);
        onlineCount.getAndDecrement();
        System.err.println("当前用户数:"+onlineCount.get());
    }


    @OnMessage
    public void onMessage(Session session, String message){
        String sender = sessionMap.get(session);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(new Date());
        sendAllOnlineUser(sender+"于"+time+"发送消息："+message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }



    public void sendMessage(String message,String userId){
        WebSocketServer socketServer = webSocketServers.get(userId);
        if(socketServer != null){
            try {
                socketServer.session.getBasicRemote().sendText(message);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    public void sendAllOnlineUser(String message){
        for(Map.Entry<String,WebSocketServer> entry:webSocketServers.entrySet()){
            sendMessage(message,entry.getKey());
        }
    }


    public void sendUsers(String message,String[] userIds){
        for(String userId:userIds){
            sendMessage(message,userId);
        }
    }






}

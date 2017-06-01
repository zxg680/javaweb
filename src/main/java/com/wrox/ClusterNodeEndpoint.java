/**   
* @Title: ClusterNodeEndpoint.java 
* @Package com.wrox 
* @Description: TODO  
* @author Xiaogang.Zhang   
* @date 2017年5月31日 下午10:07:27 
* @version V1.0   
*/
package com.wrox;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/** 
* @ClassName: ClusterNodeEndpoint 
* @Description: TODO  
* @author Xiaogang.Zhang
* @date 2017年5月31日 下午10:07:27 
*  
*/
@ServerEndpoint("/clusterNodeSocket/{nodeId}")
public class ClusterNodeEndpoint {
    private static final List<Session> nodes = new ArrayList<>(2);

    @OnOpen
    public void onOpen(Session session, @PathParam("nodeId") String nodeId) {
        System.out.println("INFO: Node [" + nodeId + "] connected to cluster.");
        ClusterMessage message = new ClusterMessage(nodeId, "Joined the cluster.");
        try {
            byte[] bytes = toByteArray(message);
            for (Session node : nodes) {
                node.getBasicRemote().sendBinary(ByteBuffer.wrap(bytes));
            }
        } catch (IOException e) {
            System.err.println("Error: Exception when notifying of new node");
            e.printStackTrace();
        }
        nodes.add(session);
    }

    @OnMessage
    public void onMessage(Session session, byte[] message) {
        try {
            for (Session node : nodes) {
                if (node != session) {
                    node.getBasicRemote().sendBinary(ByteBuffer.wrap(message));
                }
            }
        } catch (IOException e) {
            System.err.println("Error: Exception when handling message on server");
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(Session session, @PathParam("nodeId") String nodeId) {
        System.out.println("INFO: Node [" + nodeId + "] disconnected.");
        nodes.remove(session);
        ClusterMessage message = new ClusterMessage(nodeId, "Left the cluster");
        try {
            byte[] bytes = toByteArray(message);
            for (Session node : nodes) {
                node.getBasicRemote().sendBinary(ByteBuffer.wrap(bytes));
            }
        } catch (IOException e) {
            System.err.println("Error: Exception when notifying of left node");
            e.printStackTrace();
        }
    }

    private static byte[] toByteArray(ClusterMessage message) throws IOException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ObjectOutputStream stream = new ObjectOutputStream(outputStream)) {
            stream.writeObject(message);
            return outputStream.toByteArray();
        }
    }
}

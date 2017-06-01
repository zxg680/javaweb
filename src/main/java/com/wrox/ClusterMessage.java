/**   
* @Title: ClusterMessage.java 
* @Package com.wrox 
* @Description: TODO  
* @author Xiaogang.Zhang   
* @date 2017年5月31日 下午9:25:45 
* @version V1.0   
*/
package com.wrox;

import java.io.Serializable;

/** 
* @ClassName: ClusterMessage 
* @Description: TODO  
* @author Xiaogang.Zhang 
* @date 2017年5月31日 下午9:25:45 
*  
*/
public class ClusterMessage implements Serializable {
    /** 
    * @Fields serialVersionUID : TODO 
    */
    private static final long serialVersionUID = 1L;
    private String nodeId;
    private String message;

    public ClusterMessage() {
    }

    public ClusterMessage(String nodeId, String message) {
        this.nodeId = nodeId;
        this.message = message;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

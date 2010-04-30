/*
 * Created on Apr 12, 2010 by Aubrey
 * 
 * Copyright(c) 2000-2010 Hannon Hill Corporation.  All rights reserved.
 */
package com.hannonhill.loadtester.ant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.Task;

/**
 * 
 * @author  Aubrey Rhodes
 * @version $Id: $
 * @since   6.7
 */
public class RunTestTask extends Task
{
    private String testHost;
    private String host;
    private int port;
    private String username;
    private String password;
    private String assetId;
    private String group;
    private int numUsers;
    
    public void execute()
    {
        StringBuilder url = new StringBuilder();        
        url.append(testHost);
        url.append("/ws/");
        url.append(host);
        url.append("/");
        url.append(port);
        url.append("/");
        url.append(username);
        url.append("/");
        url.append(password);
        url.append("/");
        url.append(assetId);
        url.append("/");
        url.append(group);
        url.append("/");
        url.append(numUsers);
        StringBuilder result = new StringBuilder();
        log("Starting to run tests.", Project.MSG_INFO);
        try
        {
            URL endpoint = new URL(url.toString());
            URLConnection conn = endpoint.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while((line = in.readLine()) != null)
            {
                result.append(line);
            }
            in.close();
        }
        catch (MalformedURLException e)
        {
            log(e, Project.MSG_ERR);
            e.printStackTrace();
        }
        catch (IOException e)
        {
            log(e, Project.MSG_ERR);
            e.printStackTrace();
        }       
        
        
        log("Result: " + result, Project.MSG_INFO);
        log("Visit " + testHost + "/results.html" + " for results.", Project.MSG_INFO);
    }
    
    /**
     * @return Returns the testHost.
     */
    public String getTestHost()
    {
        return testHost;
    }
    /**
     * @param testHost the testHost to set
     */
    public void setTestHost(String testHost)
    {
        this.testHost = testHost;
    }
    /**
     * @return Returns the host.
     */
    public String getHost()
    {
        return host;
    }
    /**
     * @param host the host to set
     */
    public void setHost(String host)
    {
        this.host = host;
    }
    /**
     * @return Returns the port.
     */
    public int getPort()
    {
        return port;
    }
    /**
     * @param port the port to set
     */
    public void setPort(int port)
    {
        this.port = port;
    }
    /**
     * @return Returns the username.
     */
    public String getUsername()
    {
        return username;
    }
    /**
     * @param username the username to set
     */
    public void setUsername(String username)
    {
        this.username = username;
    }
    /**
     * @return Returns the password.
     */
    public String getPassword()
    {
        return password;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    /**
     * @return Returns the assetId.
     */
    public String getAssetId()
    {
        return assetId;
    }
    /**
     * @param assetId the assetId to set
     */
    public void setAssetId(String assetId)
    {
        this.assetId = assetId;
    }
    /**
     * @return Returns the group.
     */
    public String getGroup()
    {
        return group;
    }
    /**
     * @param group the group to set
     */
    public void setGroup(String group)
    {
        this.group = group;
    }
    /**
     * @return Returns the numUsers.
     */
    public int getNumUsers()
    {
        return numUsers;
    }
    /**
     * @param numUsers the numUsers to set
     */
    public void setNumUsers(int numUsers)
    {
        this.numUsers = numUsers;
    }
    
    public static void main(String[] args)
    {
        RunTestTask task = new RunTestTask();
        task.setTestHost("http://localhost:8081/LoadTester");
        task.setHost("localhost");
        task.setPort(8080);
        task.setUsername("admin");
        task.setPassword("admin");
        task.setAssetId("282d5d1bc0a8001e0065a6865a1cc8ef");
        task.setGroup("administration");
        task.setNumUsers(1);
        task.execute();
    }
}

package com.mpp.lab3;

import java.util.ArrayList;
import java.util.List;

public class ChannelLoadBalancer {

    private List<Channel> channels;

    public  ChannelLoadBalancer(){
        channels = new ArrayList<>();
    }

    public void addChannel(Channel c){
        channels.add(c);
    }

    public UpStreamChannel getUpStreamChannelsForCM(){
        return new UpStreamChannel();
    }

    public DownStreamChannel getDownStreamChannelsForCM(){
        return new DownStreamChannel();
    }
}

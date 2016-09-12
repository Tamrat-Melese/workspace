package com.mpp.lab3;

public class CM {
    private int ID;
    private String version;
    private int upStreamBandwidth;
    private int downStreamBandwidth;
    private ChannelLoadBalancer channelLoadBalancer;
    private UpStreamChannel upStreamChannel;
    private DownStreamChannel downStreamChannel;

    public void initialChannels(){
        ChannelLoadBalancer loadBalancer = new ChannelLoadBalancer();
        upStreamChannel = loadBalancer.getUpStreamChannelsForCM();
        downStreamChannel = loadBalancer.getDownStreamChannelsForCM();
    }
}

package com.example.newrelicdemo.newrelic.customevents;

import jdk.jfr.*;

@Name("jdk.CPUInformation")
@Category({"Operating System", "Processor"})
@Label("CPU Information")
public
class CPUInformation extends Event {
    @Label("Start Time")
    @Timestamp("TICKS")
    public long startTime;

    @Label("Type")
    public String cpu;

    @Label("Description")
    public String description;

    @Unsigned
    @Label("Sockets")
    public int sockets;

    @Unsigned
    @Label("Cores")
    public int cores;

    @Unsigned
    @Label("Hardware Threads")
    public int hwThreads;
}

package org.helgestenstrom.xr3UsageExamples;

import com.jezhumble.javasysmon.CpuTimes;
import com.jezhumble.javasysmon.JavaSysMon;
import com.jezhumble.javasysmon.MemoryStats;

public class SysMonStuff {

    public SysMonStuff() {

        JavaSysMon javaSysMon = new JavaSysMon();
        final CpuTimes cpuTimes = javaSysMon.cpuTimes();
        final MemoryStats memoryStats = javaSysMon.physical();
    }
}

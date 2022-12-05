def response = '''powershell -NoLogo -ExecutionPolicy Unrestricted -File  infile_pool_6_thread_8169_76b56c32b32e432fbd788e0d0a5cac53.ps1
Repetition 1 ... counting to 3...
	 Percent Disk Idle Time is 0.20
	 Percent Disk Time is 99.58
Repetition 2 ... counting to 3...
	 Percent Disk Idle Time is 0.75
	 Percent Disk Time is 99.19
Repetition 3 ... counting to 3...
	 Percent Disk Idle Time is 0.00
	 Percent Disk Time is 99.98
'''
def success = "";
def diskPercTime = "";
def diskList = [];
def commandCPU;

def diskAverage = []

response.eachLine{
	if (it.contains("Percent Disk Time")) {
	 //println it
	 //diskPercTime += it  + "\n"	
	 diskPercTime = it
	 //diskPercTime = it.replaceAll("\\s", "")
	 diskList.add(diskPercTime)
	}

}
//println diskList

diskList.each {
	//println "Count: " + it

	
	if (it.contains("Percent Disk Time is")) {
		String[] cpuState = it.split("Percent Disk Time is ");
		commandCPU = cpuState[1];
		 //println commandCPU
		/*String[] message = commandCPU.split(": ");
		success = message[1];	*/
	}
	
	float cpu_usage = Float.parseFloat(commandCPU);
	//println cpu_usage
	diskAverage.add(cpu_usage)
	
	
	if(cpu_usage>80.0) {
		println "CPU Usage is High " + cpu_usage + "\n"
	}
	else {
		println "CPU Usage is at optimal level " + cpu_usage + "\n"
	}
	
}
println "Disk Perceent Time average is " + diskAverage.average()

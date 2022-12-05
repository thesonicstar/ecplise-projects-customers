def response = "CPU states: 99.6% idle,  0.3% user,  0.1% kernel,  0.0% iowait,  0.0% swap"
def success = "";

if (response.contains("idle")) {
	String[] cpuState = response.split("% idle");
	String commandCPU = cpuState[0];
	 
	String[] message = commandCPU.split(": ");
	success = message[1];	
}

float cpu_usage = Float.parseFloat(success);
println cpu_usage

if(cpu_usage<=20.0) {
	println "CPU Idle is High"	
}
else {
	println "CPU Idle is at optimal level"
}
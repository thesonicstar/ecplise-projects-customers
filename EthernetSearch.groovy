def response = '''powershell -NoLogo -ExecutionPolicy Unrestricted -File  infile_pool_6_thread_13128_8730fe2cc9664fdf9a7974ac59f53322.ps1
name,description,mac,ipv4,ipv6,localipv6,gateway,BytesSentPersec,BytesReceivedPersec,PacketsSentPersec,PacketsReceivedPersec
"Ethernet adapter Ethernet1","Intel(R) 82574L Gigabit Network Connection #2","00-0C-29-0B-63-3C","192.168.254.183(Preferred)","","fe80::2177:3b15:f386:fe83%15(Preferred)","","N/a","N/a","N/a","N/a"
"Ethernet adapter Ethernet0","Intel(R) 82574L Gigabit Network Connection","00-0C-29-0B-63-32","10.70.100.183(Preferred)","","fe80::eb:c627:2c0f:702e%3(Preferred)","10.70.100.1","N/a","N/a","N/a","N/a"
'''
def ethNetLine = "";
def licList = [];
def ethNetName;
def defIpAdd;

//////////////////////
/*def countLines(s) { s.split('\\n').size() }
linesCount = countLines(ethNetLine)
println "Number of Ethernet Ports: " + linesCount*/
////////////////////

response.eachLine{
	if (it.contains("Ethernet")) {
		//println it
		//ethNetLine += it
		ethNetLine = it  + "\n"
		licList.add(ethNetLine)
	}
}

println "Number of Ethernet Ports: " + licList.size()

licList.each {
	//println "Item: $it"
	
	String[] ethName = it.split('\\"');
	String ethAdaptor = ethName[1];
	
	String[] mesiD = ethAdaptor.split('\\"');
	ethNetName = mesiD[0];
	//println ethNetName
	////IP Address//////
	String[] csv = it.split('Preferred');
	String commandCSV = csv[0];
	
	String[] message = commandCSV.split(',"');
	String success = message[3];
	
	String[] ip_ad = success.split('\\(');
	defIpAdd = ip_ad[0];
	//println defIpAdd
	//////////////////////
	println ethNetName + " - IP Address: " + defIpAdd;
}





//println  ethNetLine
//println licList
//////////////////////////
/*String[] csv = ethNetLine.split('Pref');
String commandCSV = csv[0];

String[] message = commandCSV.split(',"');
String success = message[3];

println success*/
///////////////////////////
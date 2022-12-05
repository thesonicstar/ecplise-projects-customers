def response =  '''powershell -NoLogo -ExecutionPolicy Unrestricted -File  infile_pool_6_thread_12206_c6c78dbd615f47089c7f0bb17bf9bbae.ps1
PSComputerName           : 10.76.51.18
RunspaceId               : b75b02ce-b8f5-4d4f-a67f-4153cbf769b1
ComputerName             : 192.168.152.100
RemoteAddress            : 192.168.152.100
PingSucceeded            : True
PingReplyDetails         : System.Net.NetworkInformation.PingReply
TcpClientSocket          : System.Net.Sockets.Socket
TcpTestSucceeded         : True
RemotePort               : 3303
TraceRoute               : 
Detailed                 : False
InterfaceAlias           : Ethernet
InterfaceIndex           : 3
InterfaceDescription     : Realtek PCIe GBE Family Controller
NetAdapter               : MSFT_NetAdapter (CreationClassName = "MSFT_NetAdapter", DeviceID = 
                           "{53C7F1DD-3AE9-451D-AAF8-5635B5805B8F}", SystemCreationClassName = "CIM_NetworkPort", 
                           SystemName = "59pc01-iid-044.meanet.mea.or.th")
NetRoute                 : MSFT_NetRoute (InstanceID = ":8:8:8:9:55?55;:8A@8?;8;55;")
SourceAddress            : MSFT_NetIPAddress (Name = ";:8A@8?;8;B55?55;55;", CreationClassName = "", 
                           SystemCreationClassName = "", SystemName = "")
NameResolutionSucceeded  : True
BasicNameResolution      : {Microsoft.DnsClient.Commands.DnsRecord_A}
LLMNRNetbiosRecords      : {}
DNSOnlyRecords           : {Microsoft.DnsClient.Commands.DnsRecord_A}
AllNameResolutionResults : Microsoft.DnsClient.Commands.DnsRecord_A
IsAdmin                  : True
NetworkIsolationContext  : Internet
MatchingIPsecRules       : 
'''

def countLines(s) { s.split('\\n').size() }
linesCount = countLines(response)
//println "Number of Lines: " + linesCount // 2

def tcpstatusresult = ""
def status = ""
def testSummary = ""
def portNumber = "3303"

response.eachLine{
	if (it.contains("TcpTestSucceeded")) {
		//println it
		tcpstatusresult = it;
	}	
}
println tcpstatusresult
if (tcpstatusresult.contains("true") || (tcpstatusresult.contains("True"))) {
	status = "GOOD"
	testSummary = "Successfully connected to port " + portNumber
	println testSummary
	println status
}
else {
	status = "BAD"
	testSummary = "Failed to connect to port " + portNumber
	println testSummary
	println status
}
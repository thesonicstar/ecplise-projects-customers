	def response = '''lo0: flags=2001000849<UP,LOOPBACK,RUNNING,MULTICAST,IPv4,VIRTUAL> mtu 8232 index 1
	        inet 127.0.0.1 netmask ff000000 
	adm_ecp_ci_00_lh_1: flags=100001000843<UP,BROADCAST,RUNNING,MULTICAST,IPv4,PHYSRUNNING> mtu 1500 index 2
	        inet 192.168.222.40 netmask ffffff00 broadcast 192.168.222.255
	user152_ecp_ci_00_lh_1: flags=100201000843<UP,BROADCAST,RUNNING,MULTICAST,IPv4,CoS,PHYSRUNNING> mtu 1500 index 3
	        inet 192.168.152.100 netmask fffffe00 broadcast 192.168.153.255
	ipmp0: flags=108001000843<UP,BROADCAST,RUNNING,MULTICAST,IPv4,IPMP,PHYSRUNNING> mtu 1500 index 4
	        inet 192.168.150.100 netmask ffffff00 broadcast 192.168.150.255
	        groupname ipmp0
	data_ecp_ci_00_lh_actv1: flags=100001000843<UP,BROADCAST,RUNNING,MULTICAST,IPv4,PHYSRUNNING> mtu 1500 index 5
	        inet 0.0.0.0 netmask ff000000 broadcast 0.255.255.255
	        groupname ipmp0
	data_ecp_ci_00_lh_stdby1: flags=100061000843<UP,BROADCAST,RUNNING,MULTICAST,IPv4,STANDBY,INACTIVE,PHYSRUNNING> mtu 1500 index 6
	        inet 0.0.0.0 netmask ff000000 broadcast 0.255.255.255
	        groupname ipmp0
	lo0: flags=2002000849<UP,LOOPBACK,RUNNING,MULTICAST,IPv6,VIRTUAL> mtu 8252 index 1
	        inet6 ::1/128 
	adm_ecp_ci_00_lh_1: flags=120002000840<RUNNING,MULTICAST,IPv6,PHYSRUNNING> mtu 1500 index 2
	        inet6 ::/0 
	user152_ecp_ci_00_lh_1: flags=120202000840<RUNNING,MULTICAST,IPv6,CoS,PHYSRUNNING> mtu 1500 index 3
	        inet6 ::/0 
	ipmp0: flags=128002000840<RUNNING,MULTICAST,IPv6,IPMP,PHYSRUNNING> mtu 1500 index 4
	        inet6 ::/0 
	        groupname ipmp0
	data_ecp_ci_00_lh_actv1: flags=120002000841<UP,RUNNING,MULTICAST,IPv6,PHYSRUNNING> mtu 1500 index 5
	        inet6 ::/0 
	        groupname ipmp0
	data_ecp_ci_00_lh_stdby1: flags=120062000841<UP,RUNNING,MULTICAST,IPv6,STANDBY,INACTIVE,PHYSRUNNING> mtu 1500 index 6
	        inet6 ::/0 
	        groupname ipmp0
 '''

 def ethNetLine = "";
 def interList = [];
 def interfDetails = ""
 
 response.eachLine{
	 if (it.contains("flags=")) {
		 //println it
		 ethNetLine += it  + "\n"
		 
	 }
	 /*String[] csv = it.split(':');
	 String commandCSV = csv[0];
	 
	 String[] message = commandCSV.split('\\n');
	 String success = message[1];*/
	 
	 //println commandCSV
	 //println "Message: " + success
 }
 
 //println  ethNetLine
 ethNetLine.eachLine{
	 if (it.contains("UP")) {
	 String[] csv = it.split(':');
	 String commandCSV = csv[0];
	 interfDetails = "Interface name: "+ commandCSV + " with STATUS:UP"
	 println interfDetails
	 ethNetLine = interfDetails
	 interList.add(ethNetLine)
	 //println commandCSV.unique();
	 }
 }
 println interList.unique()

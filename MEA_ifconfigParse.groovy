/*def response = '''13665 prdadm     42G 6044M cpu178    0    0   1:52:04 1.0% disp+work/1
ZONEID    NPROC  SWAP   RSS MEMORY      TIME  CPU ZONE                        
     4      161   68G   49G    49%  80:14:53 3.8% ecprb082                    
sccadm@ecprb082:~$ ifconfig -a
lo0: flags=2001000849<UP,LOOPBACK,RUNNING,MULTICAST,IPv4,VIRTUAL> mtu 8232 index 1
        inet 127.0.0.1 netmask ff000000 
adm_ecprb082_1: flags=100001000843<UP,BROADCAST,RUNNING,MULTICAST,IPv4,PHYSRUNNING> mtu 1500 index 2
        inet 192.168.222.232 netmask ffffff00 broadcast 192.168.222.255
user152_ecprb082_1: flags=100201000843<UP,BROADCAST,RUNNING,MULTICAST,IPv4,CoS,PHYSRUNNING> mtu 1500 index 3
        inet 192.168.152.110 netmask fffffe00 broadcast 192.168.153.255
user242_ecprb082_1: flags=100201000843<UP,BROADCAST,RUNNING,MULTICAST,IPv4,CoS,PHYSRUNNING> mtu 1500 index 4
        inet 192.168.242.110 netmask fffffe00 broadcast 192.168.243.255
ipmp0: flags=108001000843<UP,BROADCAST,RUNNING,MULTICAST,IPv4,IPMP,PHYSRUNNING> mtu 1500 index 5
        inet 192.168.150.110 netmask ffffff00 broadcast 192.168.150.255
        groupname ipmp0
data_ecprb082_actv1: flags=100001000843<UP,BROADCAST,RUNNING,MULTICAST,IPv4,PHYSRUNNING> mtu 1500 index 6
        inet 0.0.0.0 netmask ff000000 broadcast 0.255.255.255
        groupname ipmp0
data_ecprb082_stdby1: flags=100061000843<UP,BROADCAST,RUNNING,MULTICAST,IPv4,STANDBY,INACTIVE,PHYSRUNNING> mtu 1500 index 7
        inet 0.0.0.0 netmask ff000000 broadcast 0.255.255.255
        groupname ipmp0
lo0: flags=2002000849<UP,LOOPBACK,RUNNING,MULTICAST,IPv6,VIRTUAL> mtu 8252 index 1
        inet6 ::1/128 
adm_ecprb082_1: flags=120002000840<RUNNING,MULTICAST,IPv6,PHYSRUNNING> mtu 1500 index 2
        inet6 ::/0 
user152_ecprb082_1: flags=120202000840<RUNNING,MULTICAST,IPv6,CoS,PHYSRUNNING> mtu 1500 index 3
        inet6 ::/0 
user242_ecprb082_1: flags=120202000840<RUNNING,MULTICAST,IPv6,CoS,PHYSRUNNING> mtu 1500 index 4
        inet6 ::/0 
ipmp0: flags=128002000840<RUNNING,MULTICAST,IPv6,IPMP,PHYSRUNNING> mtu 1500 index 5
        inet6 ::/0 
        groupname ipmp0
data_ecprb082_actv1: flags=120002000841<UP,RUNNING,MULTICAST,IPv6,PHYSRUNNING> mtu 1500 index 6
        inet6 ::/0 
        groupname ipmp0
data_ecprb082_stdby1: flags=120062000841<UP,RUNNING,MULTICAST,IPv6,STANDBY,INACTIVE,PHYSRUNNING> mtu 1500 index 7
        inet6 ::/0 
        groupname ipmp0

'''*/

	def response = '''MemTotal:       131762824 kB
	MemFree:        102146188 kB
	MemAvailable:   103522352 kB
	Buffers:            5532 kB
	Cached:          2753276 kB
'''

def memusage
def newID
def memValue

//println response.readLines().get(1)	
memusage = response.readLines().get(2)
//println memusage

String[] str;
str = memusage.split(':');
//println str


for( String values : str ) {
	//println(values);
	if (values.contains("kB")) {
		println "GOOD"
		//println values
		newID = values.replaceAll(" ","");
		//println newID
		memValue = newID.replaceAll("kB","");
		//println memValue
	}

}
int size_kb = memValue.toInteger()
//double size_kb = size_bytes /1024;
double size_mb = size_kb / 1024;
double size_gb = size_mb / 1024 ;
println "Memory Available: " + size_gb + " GB"
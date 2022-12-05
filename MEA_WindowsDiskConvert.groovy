def diskPercentage = '''C: Total disk space:	321467244544
D: Total disk space:	2190618972160
'''

def status = "";
String spaceDisk = "";
float percentDisk
int pctThreshold = 90
float size_bytes;

def countLines(s) { s.split('\\n').size() }


linesCount = countLines(diskPercentage)
println "Number of disks: " + linesCount // 2
println "\n#############################################"

	diskPercentage.eachLine {
		
		String[] message = it.split('Total disk space:');
		String success = message[1];
		//println success
		clean_text = success.replaceAll("\\s", "")
		
		size_bytes = clean_text.toDouble();
		//println clean_text
		
		String[] diskid = it.split(':');
		String diskName = diskid[0];
		println diskName + ":" + size_bytes
		
		float size_kb = size_bytes/1024;
		float size_mb = size_kb / 1024;
		float size_gb = size_mb / 1024;
		
		//println size_kb + " KB"
		//println size_mb + " MB"
		println size_gb + " GB"
		
		/*String[] diskSp = success.split(' ');
		spaceDisk = diskSp[3];
		
		percentDisk = spaceDisk.toFloat();
	
		
		if (percentDisk >= pctThreshold){
			detail += "\nDisk is full"
			summary = "Disk is full"
			detail += "\n" + it
			status = "BAD"
		}
		else {
			detail += "\nDisk space is at adequate level"
			summary = "Disk space is at adequate level"
			detail += "\n" + it
			status = "GOOD"
		}*/
	
	}
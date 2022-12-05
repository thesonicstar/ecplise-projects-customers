import java.util.regex.Matcher
import java.util.regex.Pattern

def xmlContent = '{"type":"syslog","@timestamp":"2021-02-25T17:40:33.713Z","message":"<140>Feb 26 00:40:33 scc-rss-01 root[20657]: Number of SAP process = 2 on scc-rss-01.mea.or.th which is too high","@version":"1","host":"10.70.100.180"}';
def pattern = ','

/*def listxml = xmlContent.split(',').collect{it}
println "\n" + listxml*/
String NumEx;
String[] NumbMod;
//String typelog

try {
    /*String[] modeltype = xmlContent.split('"type":');
    NumEx = modeltype[1];
    NumbMod = NumEx.split(pattern);
    String typelog = NumbMod[0];
    println "\nType: " + typelog;*/
	
	String[] timeStamp = xmlContent.split('"@timestamp":');
	NumEx1 = timeStamp[1];
	NumbMod1 = NumEx1.split(pattern);
	String timestamplog = NumbMod1[0];
	println "\nTime Stamp: " + timestamplog;
	

}
catch(Exception ex)
{
		severity = "bad"
		//detail += "\nError: " + ex.getMessage();
		//detail += "\nError: " + ex.getStackTrace();
		//summary = "Action tasked failed";
		//detail += "\n" + map
		//status = "BAD";
}
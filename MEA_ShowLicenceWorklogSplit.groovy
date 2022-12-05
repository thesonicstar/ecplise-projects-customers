import java.util.regex.Pattern;
import java.util.regex.Matcher;

def response = ''''show license' command execution result
--------------------------------------------------------------------------------
[
    {
        "feature": "MACSec_Encryption",
        "periodLeft": "4  weeks 2  days",
        "licenseType": "Evaluation",
        "licenseState": "Active, Not in Use, EULA not accepted"
    },
    {
        "feature": "TEST_FEATURE_2",
        "periodLeft": "1  hour  0  minute",
        "licenseType": "Evaluation",
        "licenseState": "Active, Not in Use, EULA not accepted"
    }
]
'''

String licOne = "";
def licenceData = "";
def licList = [];

String[] csv = response.split("\\[");
String commandCSV = csv[1];
 
String[] message = commandCSV.split("\\]");
String success = message[0];


int i = 0;
Pattern p = Pattern.compile("feature");
Matcher m = p.matcher(response);
while (m.find()) {
	i++;
}

int featval = i
for (i = 0; i <featval; i++) {
		String[] licenseOne = success.split("\\},");
		licOne = licenseOne[i];
		licenceData = licOne + "}"
		licList.add(licenceData)	
}
println licList
 

 
